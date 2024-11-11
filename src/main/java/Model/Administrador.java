package Model;


import lombok.Data;

@Data
public class Administrador {
    private String nombre;
    private String identificacion;
    private String correo;
    private String contrasenia;

    public Administrador() {}

    public Administrador(String nombre, String identificacion, String correo, String contrasenia) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
}
