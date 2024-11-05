package enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum TipoAeronave {
    AIRBUS_A320(
            "Airbus A320",
            150,
            12, // Ejecutiva
            138, // Económica
            19000,
            Map.of(
                    "Ejecutiva", Arrays.asList("AC", "DF"),
                    "Económica", Arrays.asList("ABC", "DEF")
            )
    ),
    AIRBUS_A330(
            "Airbus A330",
            252,
            30, // Ejecutiva
            222, // Económica
            52000,
            Map.of(
                    "Ejecutiva", Arrays.asList("AC", "DF", "HK"),
                    "Económica", Arrays.asList("AC", "DEFG", "HK")
            )
    ),
    BOEING_787(
            "Boeing 787",
            250,
            28, // Ejecutiva
            222, // Económica
            50000,
            Map.of(
                    "Ejecutiva", Arrays.asList("AB", "DE", "LK"),
                    "Económica", Arrays.asList("ABC", "DEF", "JKL")
            )
    );

    private final String modelo;
    private final int capacidadTotal;
    private final int capacidadEjecutiva;
    private final int capacidadEconomica;
    private final int capacidadCargaKg;
    private final Map<String, List<String>> disposicionAsientos;

    TipoAeronave(String modelo, int capacidadTotal, int capacidadEjecutiva, int capacidadEconomica, int capacidadCargaKg, Map<String, List<String>> disposicionAsientos) {
        this.modelo = modelo;
        this.capacidadTotal = capacidadTotal;
        this.capacidadEjecutiva = capacidadEjecutiva;
        this.capacidadEconomica = capacidadEconomica;
        this.capacidadCargaKg = capacidadCargaKg;
        this.disposicionAsientos = disposicionAsientos;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public int getCapacidadEjecutiva() {
        return capacidadEjecutiva;
    }

    public int getCapacidadEconomica() {
        return capacidadEconomica;
    }

    public int getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public Map<String, List<String>> getDisposicionAsientos() {
        return disposicionAsientos;
    }
}
