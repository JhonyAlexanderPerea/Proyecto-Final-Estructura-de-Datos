package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import util.manejoVentanasUtil;

public class ControllerVentanaRecupContrasenia {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

    @FXML
    private Button btnCancelar; // El botón para cancelar y regresar



    public void abrirVentanaLogin(MouseEvent mouseEvent) {
        manejoVentanasUtil.cambiarVentana(mouseEvent, "/view/VentanaLogin.fxml", "Login");
    }
}

