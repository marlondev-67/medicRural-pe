package Vista;

import modelo.Medicamento;
import servicio.GestorInventario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MedicamentosRiesgo extends JFrame {

    public MedicamentosRiesgo(GestorInventario gestor) {

        setTitle("MedicRural-PE - Medicamentos en riesgo");
        setSize(460, 360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        ArrayList<Medicamento> lista = gestor.obtenerMedicamentosEnRiesgo();
        if (lista.isEmpty()) {
            area.setText("No hay medicamentos en riesgo.");
        } else {
            for (Medicamento m : lista) {
                area.append(m.getNombre() + " - Stock: " + m.getStock() + "\n");
            }
        }

        JLabel titulo = Estilo.titulo("MEDICAMENTOS EN RIESGO");
        titulo.setForeground(Estilo.ROJO);
        titulo.setBorder(BorderFactory.createEmptyBorder(12, 0, 4, 0));

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
