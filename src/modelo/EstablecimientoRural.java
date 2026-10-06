package modelo;

public class EstablecimientoRural
{
    private String nombre;
    private String ubicacion;
    private int stockNecesario;

    public EstablecimientoRural(String nombre, String ubicacion, int stockNecesario)
    {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.stockNecesario= stockNecesario;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getUbicacion()
    {
        return ubicacion;
    }
    public int getStockNecesario()
    {
        return stockNecesario;
    }
    public String diagnosticarRiesgo (int stockDisponible)
    {
        if (stockDisponible<=0)
        {
            return "Riesgo alto";
        }
        else if (stockDisponible<stockNecesario)
        {
            return "Riesgo medio";
        }
        else
        {
            return "Sin riesgo";
        }
    }
}
