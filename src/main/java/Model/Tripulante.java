package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Tripulante extends Persona{
    private String estudiosRealizados;

    public Tripulante(String id, String nombre, String direccion, String email, LocalDate fechaNacimiento, String estudiosRealizados) {
        super(id, nombre, direccion, email, fechaNacimiento);
        this.estudiosRealizados = estudiosRealizados;
    }

    public Tripulante() {

    }
}
