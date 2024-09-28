package Model;

import lombok.Data;

import java.util.LinkedList;
@Data
public class Aeronave {
    private int cantAsientosEconomica;
    private int cantAsientosejecutiva;
    private int capacidadCarga;
    private Piloto piloto;
    private Copiloto copiloto;
    private LinkedList<AuxiliarVuelo> auxiliaresVuelos;
}
