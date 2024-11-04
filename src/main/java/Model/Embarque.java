package Model;

import util.BicolaUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PilaUtil;


public class Embarque {

    private static final Logger logger = LogManager.getLogger(Embarque.class);

    

    private void retirarCarro(BicolaUtil<carroEmbarque> colaCarrosEmbarque, String id) {
        if (id == null || colaCarrosEmbarque == null || colaCarrosEmbarque.estaVacia()) {
            logger.error("Parámetros inválidos o cola vacía");
            return;
        }

        if (colaCarrosEmbarque.getPrimero().getValorNodo().getId().equals(id)) {
            colaCarrosEmbarque.quitarFrente();
            logger.info("Carro retirado exitosamente desde el frente: {}", id);
        } else {
            PilaUtil<carroEmbarque> tempPilaUtil = new PilaUtil<>();
            boolean encontrado = false;

            while (!colaCarrosEmbarque.estaVacia()) {
                carroEmbarque carro = colaCarrosEmbarque.quitarFrente();
                if (carro.getId().equals(id)) {
                    encontrado = true;
                    logger.info("Carro encontrado y retirado: {}", id);
                    break;
                } else {
                    tempPilaUtil.push(carro);
                }
            }

            while (!tempPilaUtil.estaVacia()) {
                colaCarrosEmbarque.ponerFinal(tempPilaUtil.pop());
            }

            if (!encontrado) {
                logger.warn("El carro de embarque seleccionado no se encuentra en la cola: {}", id);
            }
        }
    }

}
