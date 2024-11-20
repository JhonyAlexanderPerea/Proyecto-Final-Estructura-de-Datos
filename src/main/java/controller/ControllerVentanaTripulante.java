package controller;

import Model.RegistroGeneral;
import Model.Tripulante;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import util.manejoVentanasUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerVentanaTripulante {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

    @FXML
    private ComboBox<String> aux1;

    @FXML
    private ComboBox<String> aux2;

    @FXML
    private ComboBox<String> aux3;

    @FXML
    private ComboBox<String> aux4;

    @FXML
    private ComboBox<String> aux5;

    @FXML
    private ComboBox<String> aux6;

    @FXML
    private ComboBox<String> aux7;

    @FXML
    private Button btnAgregarTripulante;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnContinuarCompra1;

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<String> comboBoxCopiloto;

    @FXML
    private ComboBox<String> comboBoxPiloto;

    @FXML
    private ComboBox<String> comboBoxTipoAeronave;

    @FXML
    private Text txtCantAuxiliaresVuelo;

    @FXML
    private Text txtTipoAeronave;

    // Este método se llama cuando la ventana FXML se ha cargado
    public void initialize() {
        // Agregar opciones al ComboBox de tipo de aeronave
        comboBoxTipoAeronave.getItems().addAll("Airbus320", "Airbus330", "Boeing787");
        llenarComboBoxesConTripulantes(); // Llamamos al método para agregar opciones a los demás ComboBox
    }

    @FXML
    public void abrirVentanaPrincipal(javafx.event.ActionEvent actionEvent) {
        manejoVentanasUtil.cambiarVentana(actionEvent, "/view/VentanaPrincipal.fxml", "");
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
        switch (tipoAeronave) {
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
        manejoVentanasUtil.cambiarVentana(actionEvent, "/view/VentanaPerfilTripulante.fxml", "Agregar tripulante");
    }

    @FXML
    public void guardarTripulacionAeronave(ActionEvent actionEvent) {
    }

    public void mostrarListaTripulantes(ActionEvent actionEvent) {
        llenarComboBoxesConTripulantes();
    }

    private void llenarComboBoxesConTripulantes() {
        try {
            // Ruta del archivo JSON con los tripulantes
            String rutaArchivoJson = "src/main/resources/ListaTripulaciones/listaTripulaciones.json";

            // Leer la lista de tripulantes desde el archivo
            List<Tripulante> listaTripulantes = RegistroGeneral.leerPersonas(Tripulante.class);

            // Crear una lista de nombres de tripulantes
            List<String> nombresTripulantes = new ArrayList<>();
            for (Tripulante tripulante : listaTripulantes) {
                // Agregar solo el nombre de cada tripulante a la lista
                nombresTripulantes.add(tripulante.getNombre());
            }

            // Lista de todos los ComboBox que deben llenarse con los nombres de los tripulantes
            List<ComboBox<String>> comboBoxes = List.of(
                    comboBoxPiloto,
                    comboBoxCopiloto,
                    aux1,
                    aux2,
                    aux3,
                    aux4,
                    aux5,
                    aux6,
                    aux7
            );

            // Limpiar y agregar los nombres de los tripulantes a cada ComboBox
            Platform.runLater(() -> {
                for (ComboBox<String> comboBox : comboBoxes) {
                    comboBox.getItems().clear(); // Limpiar elementos anteriores
                    comboBox.getItems().addAll(nombresTripulantes); // Agregar los nuevos elementos
                }
            });

        } catch (IOException e) {
            // Manejar posibles excepciones al leer el archivo JSON
            e.printStackTrace();
        }
    }



}
