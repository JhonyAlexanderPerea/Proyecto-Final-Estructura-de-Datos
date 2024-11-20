package controller;

import Model.RegistroGeneral;
import Model.Tripulante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
import util.manejoVentanasUtil;
import static util.AlertasUtil.mostrarAlerta;


public class ControllerVentanaPerfilTripulante {

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEstudiosRealizados;

    @FXML
    private DatePicker txtFechaNacimiento;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombres;


    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();
    @FXML
    private void regresarVentanaTripulante(ActionEvent event) {
        manejoVentanasUtil.cambiarVentana(event,"/view/VentanaTripulante.fxml", "Gestión de Tripulación");
    }

    public void agregarNuevoTripulante(ActionEvent actionEvent) throws IOException {
        if (txtApellidos.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtEmail.getText().isEmpty() || txtEstudiosRealizados.getText().isEmpty() || txtId.getText().isEmpty() || txtNombres.getText().isEmpty() || txtFechaNacimiento == null)
        {
            mostrarAlerta("Por favor complete todos los campos");
        }
        else {
            String nombreCompleto = txtNombres.getText() + " " + txtApellidos.getText();
            Tripulante nuevoTripulante = new Tripulante(txtId.getText(),nombreCompleto, txtDireccion.getText(),txtEmail.getText(), txtFechaNacimiento.getValue(), txtEstudiosRealizados.getText());
            RegistroGeneral.registrarPersona(nuevoTripulante);
            mostrarAlerta("Tripulante agregado con exito");
        }

    }
}
