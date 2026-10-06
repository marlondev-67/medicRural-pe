package modelo;

public class Usuario
{
    private String nombreUsuario;
    private String contraseña;

    public Usuario(String nombreUsuario, String contraseña)
    {
        this.nombreUsuario = nombreUsuario;
        this.contraseña =contraseña;
    }
    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public boolean validarContraseña(String contraseñaIngresada)
    {
        return contraseña.equals(contraseñaIngresada);
    }

}
