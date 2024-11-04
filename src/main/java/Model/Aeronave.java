package Model;

import enums.TipoAeronave;
import lombok.Data;

import java.util.LinkedList;
@Data
public class Aeronave {
    private int cantAsientosEconomica;
    private int cantAsientosejecutiva;
    private int capacidadCarga;
    private TipoAeronave tipoAeronave;
    private Piloto piloto;
    private Copiloto copiloto;
    private LinkedList<AuxiliarVuelo> auxiliaresVuelos;

    public Aeronave(int cantAsientosEconomica, int cantAsientosejecutiva, int capacidadCarga, Piloto piloto, Copiloto copiloto, LinkedList<AuxiliarVuelo> auxiliaresVuelos) {
        switch (tipoAeronave){
            case AIRBUS_A320:
                this.cantAsientosEconomica = 12;
                this.cantAsientosejecutiva = 138;
                this.capacidadCarga = 19000;
                break;
            case AIRBUS_A330:
                this.cantAsientosEconomica = 30;
                this.cantAsientosejecutiva = 222;
                this.capacidadCarga = 52000;
                break;
            case BOEING_787:
                this.cantAsientosEconomica = 28;
                this.cantAsientosejecutiva = 222;
                this.capacidadCarga = 50000;
                break;
        }
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.auxiliaresVuelos = auxiliaresVuelos;
    }
}
