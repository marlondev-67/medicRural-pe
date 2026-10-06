package Vista;

import modelo.Medicamento;
import modelo.Traslado;
import servicio.GestorInventario;

import javax.swing.*;
import java.awt.*;

public class RegistrarTraslado extends JFrame {

    private final GestorInventario gestor;
    private final JTextField txtPartida = new JTextField(18);
    private final JTextField txtLlegada = new JTextField(18);
    private final JTextField txtMotivo = new JTextField(18);
    private final JComboBox<String> cmbMedicamento = new JComboBox<>();
    private final JTextField txtCantidad = new JTextField(18);
    private final JLabel lblStock = new JLabel(" ");

    public RegistrarTraslado(GestorInventario gestor) {
        this.gestor = gestor;

        setTitle("MedicRural-PE - Registrar traslado");
        setSize(480, 470);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cargarMedicamentos();
        cmbMedicamento.addActionListener(e -> mostrarStock());
        mostrarStock();

        JPanel form = Estilo.panelFormulario();
        Estilo.fila(form, 0, "Punto de partida:", txtPartida);
        Estilo.fila(form, 1, "Punto de llegada:", txtLlegada);
        Estilo.fila(form, 2, "Motivo del traslado:", txtMotivo);
        Estilo.fila(form, 3, "Medicamento:", cmbMedicamento);
        Estilo.fila(form, 4, "Stock actual:", lblStock);
        Estilo.fila(form, 5, "Cantidad:", txtCantidad);

        JButton btnRegistrar = Estilo.boton("Registrar traslado");
        btnRegistrar.addActionListener(e -> registrar());

        JPanel abajo = new JPanel();
        abajo.setBackground(Color.WHITE);
        abajo.setBorder(BorderFactory.createEmptyBorder(0, 0, 18, 0));
        abajo.add(btnRegistrar);

        add(Estilo.titulo("REGISTRAR TRASLADO"), BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
    }

    private void cargarMedicamentos() {
        cmbMedicamento.removeAllItems();
        for (Medicamento m : gestor.getInventario()) {
            cmbMedicamento.addItem(m.getNombre());
        }
    }

    private void mostrarStock() {
        String nombre = (String) cmbMedicamento.getSelectedItem();
        Medicamento m = nombre == null ? null : gestor.buscarMedicamento(nombre);
        lblStock.setText(m == null ? " " : m.getStock() + " unidades");
    }

    private void registrar() {
        String partida = txtPartida.getText().trim();
        String llegada = txtLlegada.getText().trim();
        String motivo = txtMotivo.getText().trim();
        String nombre = (String) cmbMedicamento.getSelectedItem();

        if (partida.isEmpty() || llegada.isEmpty() || motivo.isEmpty() || nombre == null) {
            Estilo.aviso(this, "Completa todos los campos.", true);
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText().trim());
        } catch (NumberFormatException ex) {
            Estilo.aviso(this, "La cantidad debe ser un número entero.", true);
            return;
        }

        Medicamento med = gestor.buscarMedicamento(nombre);
        if (med == null) {
            Estilo.aviso(this, "Medicamento no encontrado.", true);
            return;
        }

        Traslado traslado = new Traslado(partida, llegada, motivo, med, cantidad);

        if (gestor.registrartraslados(traslado)) {
            Estilo.aviso(this, "Traslado registrado correctamente.", false);
            txtCantidad.setText("");
            mostrarStock();
        } else {
            Estilo.aviso(this, "No hay suficiente stock (o la cantidad no es válida).", true);
        }
    }
}
