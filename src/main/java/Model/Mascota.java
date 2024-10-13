package Model;


import lombok.Data;

@Data
public class Mascota {
    private int peso;

    public Mascota(int peso) {
        this.peso = peso;
    }
}
