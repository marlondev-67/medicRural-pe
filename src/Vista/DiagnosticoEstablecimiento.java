package Vista;

import modelo.EstablecimientoRural;

import javax.swing.*;
import java.awt.*;

public class DiagnosticoEstablecimiento extends JFrame {

    private final JTextField txtNombre = new JTextField(18);
    private final JTextField txtUbicacion = new JTextField(18);
    private final JTextField txtNecesario = new JTextField(18);
    private final JTextField txtDisponible = new JTextField(18);
    private final JLabel lblResultado = new JLabel(" ", SwingConstants.CENTER);

    public DiagnosticoEstablecimiento() {

        setTitle("MedicRural-PE - Diagnóstico de establecimiento");
        setSize(480, 470);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = Estilo.panelFormulario();
        Estilo.fila(form, 0, "Nombre del establecimiento:", txtNombre);
        Estilo.fila(form, 1, "Ubicación:", txtUbicacion);
        Estilo.fila(form, 2, "Stock necesario:", txtNecesario);
        Estilo.fila(form, 3, "Stock disponible:", txtDisponible);

        lblResultado.setFont(lblResultado.getFont().deriveFont(Font.BOLD, 20f));
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 4; c.gridx = 0; c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(16, 4, 4, 4);
        form.add(lblResultado, c);

        JButton btn = Estilo.boton("Diagnosticar");
        btn.addActionListener(e -> diagnosticar());

        JPanel abajo = new JPanel();
        abajo.setBackground(Color.WHITE);
        abajo.setBorder(BorderFactory.createEmptyBorder(0, 0, 18, 0));
        abajo.add(btn);

        add(Estilo.titulo("DIAGNÓSTICO DE ESTABLECIMIENTO"), BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
    }

    private void diagnosticar() {
        String nombre = txtNombre.getText().trim();
        String ubicacion = txtUbicacion.getText().trim();

        if (nombre.isEmpty() || ubicacion.isEmpty()) {
            Estilo.aviso(this, "Completa el nombre y la ubicación.", true);
            return;
        }

        int necesario, disponible;
        try {
            necesario = Integer.parseInt(txtNecesario.getText().trim());
            disponible = Integer.parseInt(txtDisponible.getText().trim());
        } catch (NumberFormatException ex) {
            Estilo.aviso(this, "Los stocks deben ser números enteros.", true);
            return;
        }

        EstablecimientoRural est = new EstablecimientoRural(nombre, ubicacion, necesario);
        String diag = est.diagnosticarRiesgo(disponible);

        lblResultado.setText(diag);
        if (diag.equals("Riesgo alto")) {
            lblResultado.setForeground(Estilo.ROJO);
        } else if (diag.equals("Riesgo medio")) {
            lblResultado.setForeground(Estilo.NARANJA);
        } else {
            lblResultado.setForeground(Estilo.VERDE);
        }
    }
}
