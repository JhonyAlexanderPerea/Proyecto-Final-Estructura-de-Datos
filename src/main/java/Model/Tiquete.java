package Model;

import  lombok.*;

import java.util.Date;
@Data

public  class Tiquete {
    private String id;
    private Date fechaInicio;
    private Date fechaRegreso;
    private int cantPersonas;
    private int costo;
}
