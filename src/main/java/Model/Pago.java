package Model;

import lombok.Data;

@Data
public class Pago {
    private double monto;
    private Tiquete listaTiquetes;
    private int cantTiquetes;
    private String medioPago;
    private String codigoPago;

}
