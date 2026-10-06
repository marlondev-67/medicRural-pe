package Vista;

import javax.swing.*;
import java.awt.*;

/** Colores y componentes comunes para que todas las ventanas se vean iguales. */
public class Estilo {

    public static final Color VERDE = new Color(20, 49, 132);
    public static final Color VERDE_OSCURO = new Color(16, 33, 99);
    public static final Color FONDO = new Color(238, 243, 240);
    public static final Color ROJO = new Color(255, 0, 0);
    public static final Color NARANJA = new Color(246, 134, 2);

    public static JButton boton(String texto) {
        JButton b = new JButton(texto);
        b.setBackground(VERDE);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(b.getFont().deriveFont(Font.BOLD, 14f));
        b.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setOpaque(true);
        return b;
    }

    public static JLabel titulo(String texto) {
        JLabel l = new JLabel(texto, SwingConstants.CENTER);
        l.setFont(l.getFont().deriveFont(Font.BOLD, 22f));
        l.setForeground(VERDE_OSCURO);
        return l;
    }

    public static JPanel panelFormulario() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(20, 28, 20, 28));
        return p;
    }

    /** Agrega una fila "etiqueta + campo" al formulario. */
    public static void fila(JPanel p, int y, String etiqueta, JComponent campo) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 4, 6, 4);
        c.gridy = y;
        c.gridx = 0;
        c.anchor = GridBagConstraints.WEST;
        p.add(new JLabel(etiqueta), c);
        c.gridx = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        p.add(campo, c);
    }

    public static void aviso(Component padre, String msg, boolean error) {
        JOptionPane.showMessageDialog(padre, msg, "MedicRural-PE",
                error ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
    }
}
