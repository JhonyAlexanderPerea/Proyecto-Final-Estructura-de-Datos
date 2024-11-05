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
        this.dimension = largo + ancho + alto;
    }

    public boolean esValido(boolean esNacional, boolean esEjecutivo) {
        if (esNacional) {
            if (esEjecutivo) {
                return peso <= 34 && getDimension() <= 170;
            } else {
                return peso <= 24 && getDimension() <= 170;
            }
        } else {
            if (esEjecutivo) {
                return peso <= 34 && getDimension() <= 170;
            } else {
                return peso <= 24 && getDimension() <= 170;
            }
        }
    }

    public double calcularSobrepesoCosto(double limitePeso) {
        double sobrepeso = peso - limitePeso;
        if (sobrepeso > 0) {
            double costoBase = 8.0 * sobrepeso;
            double impuesto = costoBase * 0.0675;
            return  costoBase + impuesto;
        }
        return 0; 
    }
}
