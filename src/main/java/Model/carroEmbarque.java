package Model;


import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.BicolaUtil;

import java.util.ArrayList;
import java.util.List;

@Data
public class carroEmbarque {

    private List<Equipaje> listaEquipaje;
    private String id;
    private double pesoTransportado;
    private static final int capacidadMaxima = 500;
    private String tipoEquipaje ;
    private Aeronave aeronaveAsignada;
    private static final Logger logger = LogManager.getLogger(carroEmbarque.class);

    public carroEmbarque(String id) {
       this.listaEquipaje = new ArrayList<>();
       this.id = id;
       this.pesoTransportado = 0;
    }

    private void cargarEquipaje (Equipaje equipaje)
    {
        if (equipaje != null && equipaje.getPeso() + pesoTransportado < capacidadMaxima)
        {
            listaEquipaje.add(equipaje);
            pesoTransportado = equipaje.getPeso() + pesoTransportado;
        }
        else
        {
            logger.error("El equipaje excede el peso máximo.");
        }
    }

    private void decargarEquipaje(Equipaje equipaje)
    {
        listaEquipaje.clear();
        pesoTransportado = 0;
    }

    public String toString ()
    {
        return "Carro número: " + id + "\n" +
                "Peso transportado: " + pesoTransportado;
    }

}
