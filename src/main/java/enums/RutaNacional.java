package enums;

public enum RutaNacional {
    MONTERREY(2,45),
    CANCUN(3,12);

    private final int horas;
    private final int minutos;

    RutaNacional(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }
}
