package Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public  abstract class Persona {
    private String id;
    private String nombre;
    private String direccion;
    private String email;
    private Date fechaNacimiento;

    public Persona(String id, String nombre, String direccion, String email, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }


    public Persona(String nombre) {
        this.nombre = nombre;
    }
}
