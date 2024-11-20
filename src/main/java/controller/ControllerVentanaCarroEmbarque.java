package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ControllerVentanaCarroEmbarque {

    @FXML
    private HBox hboxBicola; // Representación gráfica de la bicola

    @FXML
    private ListView<String> listViewPila; // Representación de la pila

    @FXML
    private ListView<String> listViewCola; // Representación de la cola de espera

    @FXML
    private TextField textFieldCarga; // Campo para ingresar la carga del carro en el frente

    // Estructuras de datos
    private LinkedList<String> bicola = new LinkedList<>(); // Bicola que representa el estacionamiento
    private Stack<String> pila = new Stack<>(); // Pila para carros temporales
    private Queue<String> colaEspera = new LinkedList<>(); // Cola para carros en espera

    private final int CAPACIDAD_MAXIMA = 10; // Capacidad máxima de la bicola

    @FXML
    public void initialize() {
        // Inicialización de datos de prueba
        actualizarVistaBicola();
        actualizarVistaPila();
        actualizarVistaCola();
    }

    @FXML
    private void llegadaCarro() {
        // Lógica para la llegada de un carro (E)
        String nuevoCarro = "Carro " + (bicola.size() + colaEspera.size() + 1);
        if (bicola.size() < CAPACIDAD_MAXIMA) {
            bicola.addLast(nuevoCarro);
        } else {
            colaEspera.add(nuevoCarro);
        }
        actualizarVistaBicola();
        actualizarVistaCola();
    }

    @FXML
    private void salidaCarro() {
        // Lógica para la salida del carro del frente (S)
        if (!bicola.isEmpty()) {
            String carroSaliente = bicola.pollFirst();
            System.out.println("Salida del " + carroSaliente);

            // Asignar carga al carro
            if (!textFieldCarga.getText().isEmpty()) {
                int carga = Integer.parseInt(textFieldCarga.getText());
                if (carga <= 500) {
                    System.out.println("Carga asignada: " + carga + " kg");
                } else {
                    System.out.println("Error: Exceso de carga permitido (500 kg)");
                }
            }

            // Añadir un carro de la cola de espera si hay espacio
            if (!colaEspera.isEmpty()) {
                bicola.addLast(colaEspera.poll());
            }

            actualizarVistaBicola();
            actualizarVistaCola();
        } else {
            System.out.println("No hay carros en el estacionamiento.");
        }
    }

    @FXML
    private void retiradaCarro() {
        // Lógica para retirar un carro intermedio (T)
        if (!bicola.isEmpty()) {
            String carroARetirar = "Carro " + textFieldCarga.getText(); // Usar el TextField como identificador
            if (bicola.contains(carroARetirar)) {
                while (!bicola.peekFirst().equals(carroARetirar)) {
                    pila.push(bicola.pollFirst());
                }

                // Retirar el carro específico
                String retirado = bicola.pollFirst();
                System.out.println("Retirado: " + retirado);

                // Reintegrar los carros desde la pila a la bicola
                while (!pila.isEmpty()) {
                    bicola.addFirst(pila.pop());
                }
                actualizarVistaBicola();
                actualizarVistaPila();
            } else {
                System.out.println("El carro no está en el estacionamiento.");
            }
        } else {
            System.out.println("No hay carros en el estacionamiento.");
        }
    }

    private void actualizarVistaBicola() {
        // Limpia y actualiza la vista de la bicola
        hboxBicola.getChildren().clear();
        for (String carro : bicola) {
            Button btnCarro = new Button(carro);
            btnCarro.setStyle("-fx-background-color: white; -fx-border-color: black;");
            hboxBicola.getChildren().add(btnCarro);
        }
    }

    private void actualizarVistaPila() {
        // Actualiza la vista de la pila
        listViewPila.getItems().clear();
        for (String carro : pila) {
            listViewPila.getItems().add(carro);
        }
    }

    private void actualizarVistaCola() {
        // Actualiza la vista de la cola de espera
        listViewCola.getItems().clear();
        for (String carro : colaEspera) {
            listViewCola.getItems().add(carro);
        }
    }
}

