package Vista;

import modelo.Medicamento;
import servicio.GestorInventario;

import javax.swing.*;
import java.awt.*;

public class BuscarMedicamento extends JFrame {

    public BuscarMedicamento(GestorInventario gestor) {

        setTitle("MedicRural-PE - Buscar medicamento");
        setSize(460, 330);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField txtNombre = new JTextField(18);
        JButton btnBuscar = Estilo.boton("Buscar");
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        resultado.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel arriba = new JPanel(new BorderLayout(8, 0));
        arriba.setBorder(BorderFactory.createEmptyBorder(14, 14, 8, 14));
        arriba.add(new JLabel("Nombre:"), BorderLayout.WEST);
        arriba.add(txtNombre, BorderLayout.CENTER);
        arriba.add(btnBuscar, BorderLayout.EAST);

        Runnable buscar = () -> {
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) {
                Estilo.aviso(this, "Ingresa el nombre a buscar.", true);
                return;
            }
            Medicamento m = gestor.buscarMedicamento(nombre);
            if (m == null) {
                resultado.setText("Medicamento no encontrado.");
            } else {
                resultado.setText("Medicamento encontrado.\n\n"
                        + "Nombre: " + m.getNombre() + "\n"
                        + "Stock:  " + m.getStock() + "\n"
                        + "Precio: S/ " + m.getPrecio() + "\n"
                        + "Estado: " + (m.estaEnRiesgo() ? "RIESGO" : "DISPONIBLE"));
            }
        };
        btnBuscar.addActionListener(e -> buscar.run());
        txtNombre.addActionListener(e -> buscar.run());

        add(arriba, BorderLayout.NORTH);
        add(new JScrollPane(resultado), BorderLayout.CENTER);
    }
}
