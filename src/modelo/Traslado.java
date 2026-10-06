package modelo;

public class Traslado
{
    private String puntoPartida;
    private String puntoLlegada;
    private String motivo;
    private Medicamento medicamento;
    private int cantidad;

    public Traslado(String puntoPartida, String puntoLlegada, String motivo, Medicamento medicamento, int cantidad)
    {
        this.puntoPartida = puntoPartida;
        this.puntoLlegada = puntoLlegada;
        this.motivo = motivo;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
    }

    public String getPuntoPartida()
    {
        return puntoPartida;
    }

    public String getPuntoLlegada()
    {
        return puntoLlegada;
    }

    public String getMotivo()
    {
        return motivo;
    }

    public Medicamento getMedicamento()
    {
        return medicamento;
    }

    public int getCantidad()
    {
        return cantidad;
    }



}
