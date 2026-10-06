package servicio;
import java.util.ArrayList;
import modelo.Medicamento;
import modelo.Traslado;

public class GestorInventario
{
    private ArrayList<Medicamento> inventario;
    private ArrayList<Traslado> traslados;

    public GestorInventario()
    {
        inventario = new ArrayList<>();
        traslados = new ArrayList<>();
    }

    public void registrarMedicamento (Medicamento medicamento)
    {
        inventario.add(medicamento);
    }
    public ArrayList<Medicamento> getInventario()
    {
        return inventario;
    }
    public ArrayList<Medicamento> obtenerMedicamentosEnRiesgo()
    {
        ArrayList<Medicamento> medicamentosRiesgo = new ArrayList<>();

        for (Medicamento medicamento : inventario)
        {
            if (medicamento.estaEnRiesgo())
            {
                medicamentosRiesgo.add(medicamento);
            }
        }
        return medicamentosRiesgo;
    }
    public Medicamento buscarMedicamento(String nombre)
    {
        for (Medicamento medicamento: inventario)
        {
            if (medicamento.getNombre().equalsIgnoreCase(nombre))
            {
                return medicamento;
            }
        }
        return null;
    }
    public boolean registrartraslados(Traslado traslado)
    {
        Medicamento medicamento = traslado.getMedicamento();
        if (medicamento.reducirStock(traslado.getCantidad()))
        {
            traslados.add(traslado);
            return true;
        }
        return false;
    }

}