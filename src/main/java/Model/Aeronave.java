package Model;

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
        this.cantAsientosEconomica = cantAsientosEconomica;
        this.cantAsientosejecutiva = cantAsientosejecutiva;
        this.capacidadCarga = capacidadCarga;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.auxiliaresVuelos = auxiliaresVuelos;
    }
}
