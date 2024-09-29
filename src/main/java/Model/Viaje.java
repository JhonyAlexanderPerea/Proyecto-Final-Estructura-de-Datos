package Model;

import lombok.Data;

import java.util.Date;
@Data
public class Viaje {
    private static final String ORIGEN = "CDMX";
    private static String destino;
    private Date duracion;
    private Date horaSalida;
}
