package Model;

import lombok.Data;

@Data
public class Equipaje {
    private double peso;
    private double ancho;
    private double alto;
    private double largo;
    private double dimension;
    private  boolean esEquipajeMano;

    public Equipaje(double peso, double ancho, double alto, double largo, boolean esEquipajeMano) {
        this.peso = peso;
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
        this.dimension = largo + ancho + alto;
        this.esEquipajeMano = esEquipajeMano;
    }

    public static boolean esEquipajeDeManoValido(double dimesion) {
        return dimesion <= 110; // Validación para el equipaje de mano
    }

    public boolean esValido(boolean esNacional, boolean esEjecutivo) {
        if (esEquipajeMano) {
            return esEquipajeDeManoValido(dimension);
        } else {
            double pesoLimite = (esNacional) ? (esEjecutivo ? 34 : 24) : (esEjecutivo ? 34 : 24);
            return peso <= pesoLimite && getDimension() <= 170;
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
