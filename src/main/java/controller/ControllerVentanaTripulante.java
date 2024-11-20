package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import util.manejoVentanasUtil;



public class ControllerVentanaTripulante {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

    @FXML
    private Text txtCantAuxiliaresVuelo;

    @FXML
    private Text txtTipoAeronave;

    @FXML
    private ComboBox<String> comboBoxTipoAeronave;

    // Este método se llama cuando la ventana FXML se ha cargado
    public void initialize() {
        // Agregar opciones al ComboBox
        comboBoxTipoAeronave.getItems().addAll("Airbus320","Airbus330","Boeing787");
    }

    @FXML
    public void abrirVentanaPrincipal(javafx.event.ActionEvent actionEvent) {
        manejoVentanasUtil.cambiarVentana(actionEvent, "/view/VentanaPrincipal.fxml","");

    }

    @FXML
    public void abrirPerfilTripulante(ActionEvent actionEvent) {
    }

    @FXML
    public void continuaCompra1(ActionEvent actionEvent) {
    }

    @FXML
    public void guardar(ActionEvent actionEvent) {
    }

    @FXML
    public void cambiarInfoTripulacion(ActionEvent actionEvent) {
        String tipoAeronave = String.valueOf(comboBoxTipoAeronave.getSelectionModel().getSelectedItem());
        switch (tipoAeronave)
        {
            case "Airbus320":
                txtTipoAeronave.setText("Airbus320");
                txtCantAuxiliaresVuelo.setText("-3 Auxiliares de vuelo");
                break;
            case "Airbus330":
                txtTipoAeronave.setText("Airbus330");
                txtCantAuxiliaresVuelo.setText("-7 Auxiliares de vuelo");
                break;
            case "Boeing787":
                    txtTipoAeronave.setText("Boeing787");
                    txtCantAuxiliaresVuelo.setText("-7 Auxiliares de vuelo");
                    break;
        }
    }

    @FXML
    public void abrirVentanaAgregarTripulante(ActionEvent actionEvent) {
        manejoVentanasUtil.cambiarVentana(actionEvent, "/view/VentanaPerfilTripulante.fxml","Agregar tripulante");
    }

    @FXML
    public void guardarTripulacionAeronave(ActionEvent actionEvent) {

    }
}
