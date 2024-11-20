package enums;

public enum RutaInternacional {
    BUENOS_AIRES(9, 5),
    LOS_ANGELES(3,25),
    BOGOTA(3,45),
    CIUDAD_PANAMA(2,55);

    private final int horas;
    private final int minutos;

    RutaInternacional(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

}


