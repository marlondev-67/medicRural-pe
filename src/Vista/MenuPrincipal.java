package Vista;

import servicio.GestorInventario;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal(GestorInventario gestor) {

        setTitle("MedicRural-PE - Menú principal");
        setSize(460, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new BorderLayout(0, 12));
        fondo.setBackground(Estilo.FONDO);
        fondo.setBorder(BorderFactory.createEmptyBorder(20, 40, 24, 40));

        fondo.add(Estilo.titulo("MENÚ PRINCIPAL"), BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(6, 1, 0, 10));
        botones.setOpaque(false);

        JButton b1 = Estilo.boton("1. Ver inventario");
        JButton b2 = Estilo.boton("2. Buscar medicamento");
        JButton b3 = Estilo.boton("3. Ver medicamentos en riesgo");
        JButton b4 = Estilo.boton("4. Registrar traslado");
        JButton b5 = Estilo.boton("5. Diagnóstico de establecimiento");
        JButton b6 = Estilo.boton("6. Salir");
        b6.setBackground(Estilo.ROJO);

        b1.addActionListener(e -> new Inventario(gestor).setVisible(true));
        b2.addActionListener(e -> new BuscarMedicamento(gestor).setVisible(true));
        b3.addActionListener(e -> new MedicamentosRiesgo(gestor).setVisible(true));
        b4.addActionListener(e -> new RegistrarTraslado(gestor).setVisible(true));
        b5.addActionListener(e -> new DiagnosticoEstablecimiento().setVisible(true));
        b6.addActionListener(e -> {
            Object[] opciones = {"Sí", "No"};
            int r = JOptionPane.showOptionDialog(this, "¿Seguro que deseas salir?",
                    "Salir de MedicRural-PE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opciones, opciones[1]);
            if (r == 0)
            {
                System.exit(0);

            }
        });

        for (JButton b : new JButton[]{b1, b2, b3, b4, b5, b6}) {
            botones.add(b);
        }

        fondo.add(botones, BorderLayout.CENTER);
        add(fondo);
    }
}
