package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class ControllerVentanaTripulante {

    @FXML
    private ComboBox<String> comboBoxTipoAeronave;

    // Este método se llama cuando la ventana FXML se ha cargado
    public void initialize() {
        // Agregar opciones al ComboBox
        comboBoxTipoAeronave.getItems().addAll("Airbus320","Airbus330","Boeing787");

    }
}
