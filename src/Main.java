import modelo.Medicamento;
import modelo.Usuario;
import servicio.GestorInventario;
import Vista.Login;

import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
        Usuario usuario = new Usuario("Admin", "1234");

        GestorInventario gestor = new GestorInventario();

        gestor.registrarMedicamento(new Medicamento("Paracetamol", 50, 2.50));
        gestor.registrarMedicamento(new Medicamento("Ibuprofeno", 30, 3.80));
        gestor.registrarMedicamento(new Medicamento("Amoxicilina", 10, 5.50));

        SwingUtilities.invokeLater(() -> new Login(usuario, gestor).setVisible(true));
    }
}