package Model;

import lombok.Data;

@Data
public class Equipaje {
    private int peso;
    private int ancho;
    private int alto;
    private int largo;
    private int dimension;

    public Equipaje(int peso, int ancho, int alto, int largo) {
        this.peso = peso;
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
        this.dimension = peso * ancho * alto;
    }


}
