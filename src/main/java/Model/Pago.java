package Model;

import enums.ServicioViaje;
import lombok.Data;

@Data
public class Pago {
    private Cliente cliente;
    private double monto;
    private Tiquete tiquete;
    private int cantTiquetes;
    private String medioPago;
    private String codigoPago;

    /*private double calcularTotalEquipaje() {
        double costoEquipaje = 0;
        for (Equipaje equipaje : cliente.getEquipajes()) {
            boolean esNacional = (!tiquete.getViaje().isEsInternacional());
            boolean esEjecutivo = (cliente.getServicioViaje() == ServicioViaje.EJECUTIVA);
            double limitePeso = esEjecutivo ? (esNacional ? 34 : 34) : (esNacional ? 24 : 24);
            costoEquipaje += equipaje.calcularSobrepesoCosto(limitePeso);
        }
        return costoEquipaje;
    }*/


}
