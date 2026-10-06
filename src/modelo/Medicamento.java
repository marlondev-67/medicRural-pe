package modelo;

public class Medicamento

{
    private String nombre;
    private int stock;
    private double  precio;

    public Medicamento(String nombre, int stock, double precio)
    {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getStock()
    {
        return stock;
    }

    public double getPrecio()
    {
        return precio;
    }

    public boolean estaEnRiesgo()
    {
        return stock <= 10;
    }

    public boolean reducirStock(int cantidad)
    {
        if (cantidad <= 0)
        {
            return false;
        }
        if (cantidad > stock)
        {
            return false;
        }

        stock = stock - cantidad;

        return true;


    }

}
