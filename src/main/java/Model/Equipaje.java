package Model;

import lombok.Data;

@Data
public class Equipaje {
    private int peso;
    private int ancho;
    private int alto;
    private int largo;
    private boolean esEquipajeMano;

    public Equipaje(int peso, int ancho, int alto, int largo,  boolean esEquipajeMano) {
        this.peso = peso;
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
        this.esEquipajeMano = esEquipajeMano;
    }

    public boolean validarDimensiones(int maxDimension) {
        return (largo+ ancho + alto) <= maxDimension;
    }

    public int calcularSobrepeso(int pesoMaximo) {
        return Math.max(0, peso - pesoMaximo);
    }


}