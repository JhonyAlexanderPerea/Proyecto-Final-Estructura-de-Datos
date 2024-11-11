package Model;

import enums.ServicioViaje;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Cliente extends Persona{
    private String apellido;
    private String direccionResidencia;
    private boolean viajaMascota;
    private Mascota mascota;
    private List<Equipaje> equipajes;
    private Tarjeta tarjeta;
    private ServicioViaje servicioViaje;

    public Cliente(String nombre, String apellido, String direccionResidencia, boolean viajaMascota,
                   Mascota mascota, List<Equipaje> equipaje, Tarjeta tarjeta, ServicioViaje servicioViaje) {
        super(nombre);
        this.apellido = apellido;
        this.direccionResidencia = direccionResidencia;
        this.viajaMascota = viajaMascota;
        this.mascota = mascota;
        this.equipajes = equipaje;
        this.tarjeta = tarjeta;
        this.servicioViaje = servicioViaje;
    }

<<<<<<< Updated upstream
    public void agregarEquipaje(Equipaje equipaje) {
        equipajes.add(equipaje);
    }



=======
    public void comprarTiquete ()
    {

    }


>>>>>>> Stashed changes
}
