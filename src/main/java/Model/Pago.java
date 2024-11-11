package Model;

<<<<<<< Updated upstream
import enums.ServicioViaje;
=======
import enums.Clase;
import enums.TipoViaje;
>>>>>>> Stashed changes
import lombok.Data;

import java.util.List;

@Data
public class Pago {
<<<<<<< Updated upstream
    private Cliente cliente;
    private double monto;
    private Tiquete tiquete;
=======

    private String tipoViaje;
    private double monto;
    private List<Tiquete> listaTiquetes;
>>>>>>> Stashed changes
    private int cantTiquetes;
    private String medioPago;
    private String codigoPago;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String clase;


    public Pago(String tipoViaje, double monto, List<Tiquete> listaTiquetes, int cantTiquetes, String medioPago, String codigoPago, String ciudadOrigen, String ciudadDestino, String clase)
    {
        this.tipoViaje = tipoViaje;
        this.monto = monto;
        this.listaTiquetes = listaTiquetes;
        this.cantTiquetes = cantTiquetes;
        this.medioPago = medioPago;
        this.codigoPago = codigoPago;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.clase = clase;
    }

    public void agregarTiquete (Tiquete tiquete)
    {
        listaTiquetes.add(tiquete);
        this.cantTiquetes = listaTiquetes.size();
    }

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
