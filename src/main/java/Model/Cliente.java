package Model;

import lombok.Data;

import java.util.Date;

@Data
public class Cliente extends Persona{
    private String apellido;
    private String direccionResidencia;
    private boolean viajaMascota;
    private Mascota mascota;
    private Equipaje equipaje;
    private Tarjeta tarjeta;


    public Cliente(String id, String nombre, String direccion, String email, Date fechaNacimiento, String apellido, String direccionResidencia, boolean viajaMascota, Mascota mascota, Equipaje equipaje, Tarjeta tarjeta) {
        super(id, nombre, direccion, email, fechaNacimiento);
        this.apellido = apellido;
        this.direccionResidencia = direccionResidencia;
        this.viajaMascota = viajaMascota;
        this.mascota = mascota;
        this.equipaje = equipaje;
        this.tarjeta = tarjeta;
    }
}
