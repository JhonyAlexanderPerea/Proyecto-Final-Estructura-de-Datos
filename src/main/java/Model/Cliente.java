package Model;

import enums.ServicioViaje;
import enums.TipoRuta;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Cliente extends Persona{
    private String apellido;
    private String direccionResidencia;
    private boolean viajaMascota;
    private Mascota mascota;
    private Equipaje equipaje;
    private Tarjeta tarjeta;
    private Viaje viaje;
    private ServicioViaje clase;

    public Cliente(String id, String nombre, String direccion, String email, LocalDate fechaNacimiento, String apellido, String direccionResidencia, boolean viajaMascota, Mascota mascota, Equipaje equipaje, Tarjeta tarjeta) {
        super(id, nombre, direccion, email, fechaNacimiento);
        this.apellido = apellido;
        this.direccionResidencia = direccionResidencia;
        this.viajaMascota = viajaMascota;
        this.mascota = mascota;
        this.equipaje = equipaje;
        this.tarjeta = tarjeta;
    }

}