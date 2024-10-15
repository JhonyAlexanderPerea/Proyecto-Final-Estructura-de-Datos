package Model;

import lombok.Data;

import java.util.Date;
@Data
public abstract class Tripulante extends Persona{
    private String estudiosRealizados;

    public Tripulante(String id, String nombre, String direccion, String email, Date fechaNacimiento, String estudiosRealizados) {
        super(id, nombre, direccion, email, fechaNacimiento);
        this.estudiosRealizados = estudiosRealizados;
    }
}
