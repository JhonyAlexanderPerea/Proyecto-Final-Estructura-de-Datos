package Model;

import lombok.Data;

import java.util.Date;

@Data

public class Piloto extends Tripulante{
    public Piloto(String id, String nombre, String direccion, String email, Date fechaNacimiento, String estudiosRealizados) {
        super(id, nombre, direccion, email, fechaNacimiento, estudiosRealizados);
    }

}
