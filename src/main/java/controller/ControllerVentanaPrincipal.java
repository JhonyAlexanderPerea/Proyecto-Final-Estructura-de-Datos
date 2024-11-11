package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import util.manejoVentanasUtil;

public class ControllerVentanaPrincipal {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();
    @FXML
    private void abrirVentanaTripulante(MouseEvent event) {
        manejoVentanasUtil.cambiarVentana(event, "/view/VentanaTripulante.fxml", "Tripulante");
    }
}
