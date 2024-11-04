package Model;

import util.BicolaUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ColaUtil;
import util.PilaUtil;


public class Embarque {

    private static final Logger logger = LogManager.getLogger(Embarque.class);
    private static final int capacidadMaxima = 10;
    private BicolaUtil <carroEmbarque> colaCarrosEmbarque;
    private ColaUtil <carroEmbarque> colaEspera;

    public Embarque() {
        colaCarrosEmbarque = new BicolaUtil<>();
        colaEspera = new ColaUtil<>();
    }

    private void ingresarCarro (carroEmbarque carro, String opcion) {

        if (carro == null || opcion == null)
        {
            logger.error("El carro o la opción no pueden ser nulos");
            return;
        }

        if (colaCarrosEmbarque.getTamano() < capacidadMaxima)
        {
            if (carro != null && opcion.toLowerCase().equals("frente")) {
                colaCarrosEmbarque.ponerFrente(carro);
                logger.info("Carro agregado al frente con éxito");
            }
            else if (carro != null && opcion.toLowerCase().equals("final"))
            {
                colaCarrosEmbarque.ponerFinal(carro);
                logger.info("Carro agregado al final con éxito");
            }
        }
        else
        {
            agregarColaEspera (carro);
            logger.info("El carro se encuentra en espera porque la cola está llena.");
        }
    }

    private void agregarColaEspera(carroEmbarque carro)
    {
        colaEspera.encolar(carro);
        logger.info("Carro agregado a la cola de espera con éxito.");
    }

    private carroEmbarque retirarColaEspera ()
    {
        return colaEspera.desencolar();
    }

    private boolean colaLlena ()
    {
        return colaCarrosEmbarque.getTamano() == capacidadMaxima;
    }

    private void retirarCarro(String id) {
        if (id == null || colaCarrosEmbarque == null || colaCarrosEmbarque.estaVacia())
        {
            logger.error("Parámetros inválidos o cola vacía");
            return;
        }

        if (colaCarrosEmbarque.getPrimero().getValorNodo().getId().equals(id))
        {
            colaCarrosEmbarque.quitarFrente();
            logger.info("Carro número " + id + " retirado con éxito");
            colaCarrosEmbarque.ponerFinal(retirarColaEspera());
        }
        else
        {
            PilaUtil<carroEmbarque> pilaCarrosTemp = new PilaUtil<>();
            boolean encontrado = false;

            while (!colaCarrosEmbarque.estaVacia())
            {
                carroEmbarque carro = colaCarrosEmbarque.quitarFrente();
                if (carro.getId().equals(id))
                {
                    encontrado = true;
                    logger.info("Carro encontrado y retirado: {}", id);
                    break;
                } else
                {
                    pilaCarrosTemp.push(carro);
                }
            }
            while (!pilaCarrosTemp.estaVacia())
            {
                colaCarrosEmbarque.ponerFinal(pilaCarrosTemp.pop());
            }
            if (colaCarrosEmbarque.getTamano() < capacidadMaxima)
            {
                colaCarrosEmbarque.ponerFinal(retirarColaEspera());
            }
            if (!encontrado)
            {
                logger.warn("El carro de embarque seleccionado no se encuentra en la cola: {}", id);
            }
        }
    }

    public void confirmarSalida (carroEmbarque carro)
    {
        if (carro.getPesoTransportado() == 500)
        {
            retirarCarro(carro.getId());
        }
        else
        {
            logger.warn("El carro aún " + carro.getId() + "no está lleno.");
        }
    }

}
