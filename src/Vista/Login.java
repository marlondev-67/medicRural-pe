package Vista;

import modelo.Usuario;
import servicio.GestorInventario;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private final Usuario usuario;
    private final GestorInventario gestor;

    private final JTextField txtUsuario = new JTextField(16);
    private final JPasswordField txtClave = new JPasswordField(16);
    private final JLabel lblError = new JLabel(" ", SwingConstants.CENTER);

    public Login(Usuario usuario, GestorInventario gestor) {
        this.usuario = usuario;
        this.gestor = gestor;

        setTitle("MedicRural-PE - Inicio de sesión");
        setSize(420, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel fondo = new JPanel(new GridBagLayout());
        fondo.setBackground(Estilo.FONDO);

        JPanel caja = Estilo.panelFormulario();
        caja.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(205, 215, 210)),
                BorderFactory.createEmptyBorder(24, 32, 24, 32)));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 4, 6, 4);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;

        JLabel marca = Estilo.titulo("MedicRural-PE");
        JLabel sub = new JLabel("Inicia sesión para continuar", SwingConstants.CENTER);
        sub.setForeground(Color.GRAY);

        lblError.setForeground(Estilo.ROJO);

        JButton btnIngresar = Estilo.boton("Ingresar");
        btnIngresar.addActionListener(e -> verificar());
        txtClave.addActionListener(e -> verificar());
        getRootPane().setDefaultButton(btnIngresar);

        c.gridy = 0; caja.add(marca, c);
        c.gridy = 1; caja.add(sub, c);
        c.gridy = 2; c.insets = new Insets(18, 4, 2, 4); caja.add(new JLabel("Usuario"), c);
        c.gridy = 3; c.insets = new Insets(2, 4, 6, 4); caja.add(txtUsuario, c);
        c.gridy = 4; caja.add(new JLabel("Contraseña"), c);
        c.gridy = 5; caja.add(txtClave, c);
        c.gridy = 6; caja.add(lblError, c);
        c.gridy = 7; caja.add(btnIngresar, c);

        fondo.add(caja);
        add(fondo);
    }

    private void verificar() {
        String nombre = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword());

        if (usuario.getNombreUsuario().equals(nombre) && usuario.validarContraseña(clave)) {
            new MenuPrincipal(gestor).setVisible(true);
            dispose();
        } else {
            lblError.setText("Credenciales incorrectas.");
            txtClave.setText("");
            txtClave.requestFocus();
        }
    }
}
