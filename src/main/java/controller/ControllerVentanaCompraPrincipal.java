package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;

public class ControllerVentanaCompraPrincipal {

    @FXML
    ToggleGroup grupoIdaVuelta = new ToggleGroup();
    @FXML
    private ComboBox<String> comboBoxOrigen;
    @FXML
    private ComboBox<String> comboBoxDestino;
    @FXML
    private ComboBox<String> comboBoxServicio;

    // Este método se llama cuando la ventana FXML se ha cargado
    public void initialize() {
        // Agregar opciones al ComboBox
        comboBoxOrigen.getItems().addAll("CDMX");
        comboBoxDestino.getItems().addAll("Monterrey", "Cancún","Buenos Aires","Los Ángeles","Bogotá","Panamá");
        comboBoxServicio.getItems().addAll("Clase Ejecutiva","Clase Económica");
    }


}
