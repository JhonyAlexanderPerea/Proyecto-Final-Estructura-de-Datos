package Model;

import  lombok.*;

import java.util.Date;
@Data

public  class Tiquete {
    private Viaje viaje;
    private String id;
    private Date fechaInicio;
    private Date fechaRegreso;
    private int cantPersonas;
    private int costo;

    public double calcularCostoTotal() {
        double tasaAdicional = viaje.isEsInternacional() ? 0.97 : 0.8;
        return costo * (1 + tasaAdicional / 100);
    }
}
