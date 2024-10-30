package Model;

import enums.TipoTarjeta;
import lombok.Data;

@Data
public class Tarjeta {
    private String codigoTarjeta;
    private int saldoDisponible;
    private TipoTarjeta tipoTarjeta;

    public Tarjeta(String codigoTarjeta, int saldoDisponible) {
        this.codigoTarjeta = codigoTarjeta;
        this.saldoDisponible = saldoDisponible;
    }
}
