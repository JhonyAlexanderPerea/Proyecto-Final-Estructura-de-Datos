package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import util.manejoVentanasUtil;

public class ControllerVentanaPrincipal {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();
    @FXML
    private Hyperlink linkSalir;

    @FXML
    private void abrirVentanaTripulante(MouseEvent event) {
        manejoVentanasUtil.cambiarVentana(event, "/view/VentanaTripulante.fxml", "Tripulante");
    }

    public void abrirVentanaLogin(MouseEvent mouseEvent) {
        manejoVentanasUtil.cambiarVentana(mouseEvent, "/view/VentanaLogin.fxml", "Login");
    }
}
