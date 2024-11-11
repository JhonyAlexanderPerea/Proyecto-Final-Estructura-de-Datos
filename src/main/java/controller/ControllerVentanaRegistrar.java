package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.manejoVentanasUtil;

public class ControllerVentanaRegistrar {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

    @FXML
    private Hyperlink linkVolverLogin; // Hyperlink para volver a la ventana de inicio de sesión


    public void abrirVentanaLogin(MouseEvent mouseEvent) {
        manejoVentanasUtil.cambiarVentana(mouseEvent, "/view/VentanaLogin.fxml", "Login");
    }

    public void realizarRegistro(MouseEvent mouseEvent) {

    }
}
