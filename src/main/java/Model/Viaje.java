package Model;

import enums.RutaInternacional;
import enums.RutaNacional;
import lombok.Data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
public class Viaje {
    private static final String ORIGEN = "CDMX";
    private boolean esInternacional;
    private RutaInternacional destinoInternacional;
    private RutaNacional destinoNacional;
    private int duracionHoras;
    private int duracionMinutos;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;

    public Viaje(boolean esInternacional, RutaInternacional destinoInternacional, int duracionHoras, int duracionMinutos, LocalTime horaSalida) {
        this.esInternacional = true;
        this.destinoInternacional = destinoInternacional;
        this.duracionHoras = duracionHoras;
        this.duracionMinutos = duracionMinutos;
        this.horaSalida = horaSalida;
        this.horaLlegada = calcularHoraRetorno();
    }

    public Viaje(boolean esInternacional, RutaNacional destinoNacional, int duracionHoras, int duracionMinutos, LocalTime horaSalida) {
        this.esInternacional = false;
        this.destinoNacional = destinoNacional;
        this.duracionHoras = duracionHoras;
        this.duracionMinutos = duracionMinutos;
        this.horaSalida = horaSalida;
        this.horaLlegada = calcularHoraRetorno();
    }

    private LocalTime calcularHoraRetorno() {
        LocalTime horaLlegada = horaSalida.plusHours(duracionHoras).plusMinutes(duracionMinutos);
        return horaLlegada.plusHours(3);
    }

    public String getDestino() {
        return esInternacional ? destinoInternacional.name() : destinoNacional.name();
    }

}
