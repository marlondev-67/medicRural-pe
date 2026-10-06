package Vista;

import modelo.Medicamento;
import servicio.GestorInventario;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JFrame {

    public Inventario(GestorInventario gestor) {

        setTitle("MedicRural-PE - Inventario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        for (Medicamento medicamento : gestor.getInventario()) {

            area.append("Medicamento: " + medicamento.getNombre() + "\n");
            area.append("Stock: " + medicamento.getStock() + "\n");
            area.append("Precio: S/ " + medicamento.getPrecio() + "\n");

            if (medicamento.estaEnRiesgo()) {
                area.append("Estado: RIESGO\n");
            } else {
                area.append("Estado: DISPONIBLE\n");
            }

            area.append("-----------------------------\n");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}