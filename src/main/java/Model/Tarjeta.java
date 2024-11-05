package Model;

import enums.TipoTarjeta;
import lombok.Data;
import java.util.regex.Pattern;

@Data
public class Tarjeta {
    private TipoTarjeta tipoTarjeta;
    private String codigoTarjeta;
    private int saldoDisponible;


    public Tarjeta(TipoTarjeta tipoTarjeta, String codigoTarjeta, int saldoDisponible) {
        if (!validarCodigoTarjeta(codigoTarjeta)) {
            throw new IllegalArgumentException("Número de tarjeta inválido.");
        }
        this.tipoTarjeta = tipoTarjeta;
        this.codigoTarjeta = codigoTarjeta;
        this.saldoDisponible = saldoDisponible;
    }

    private boolean validarCodigoTarjeta(String codigoTarjeta) {
        String regex = "\\d{16}"; // Formato simple para tarjetas de 16 dígitos
        return Pattern.matches(regex, codigoTarjeta);
    }
}
