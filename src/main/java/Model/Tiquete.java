package Model;

import  lombok.*;

import java.util.Date;
@Data

public  class Tiquete {
    private Viaje viaje;
    private Cliente cliente;
    private String id;
    private Date fechaInicio;
    private Date fechaRegreso;
    private int cantPersonas;
    private int costo;

    public double calcularCostoTotal() {
        double tasaAdicional = viaje.isEsInternacional() ? 0.97 : 0.8;
        return costo * (1 + tasaAdicional / 100);
    }

    public double costoViajaMascota() {
        if (cliente.isViajaMascota()) {
            if(cliente.getMascota().getPeso() < 3) {
                return 0;
            }
            return (cliente.getMascota().getPeso() >= 3 && cliente.getMascota().getPeso() <= 9 )
                    ? 48.0 : 48.0 + ((cliente.getMascota().getPeso() - 9) * 2.0);
        }
        return 0;
    }



}
