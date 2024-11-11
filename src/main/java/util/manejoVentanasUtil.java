package util;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.awt.event.ActionEvent;
import java.io.IOException;

import controller.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class manejoVentanasUtil {

    public void cambiarVentana(Event event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            if (fxmlPath.equals("/view/Aeronave.fxml")) {
                AeronaveController aeronaveController  = loader.getController();
            } else if (fxmlPath.equals("/view/VentanaCompra.fxml")) {
                ControllerVentanaCompra controllerVentanaCompra = loader.getController();
            } else if (fxmlPath.equals("/view/VentanaLogin.fxml")) {
                ControllerVentanaLogin controllerVentanaLogin = loader.getController();
            } else if (fxmlPath.equals("/view/VentanaPerfilTripulante.fxml")) {
                ControllerVentanaPerfilTripulante perfilTripulante = loader.getController();
            } else if (fxmlPath.equals("/view/VentanaPrincipal.fxml")) {
                ControllerVentanaPrincipal venanaPrincipal = loader.getController();
            } else if (fxmlPath.equals("/view/VentanaRecuperarContrasenia.fxml")) {
                ControllerVentanaRecupContrasenia recuperarContrasenia = loader.getController();
            } else if (fxmlPath.equals("/view/VentanaRegistrar.fxml")) {
                ControllerVentanaRegistrar registrar = loader.getController();
            } else if (fxmlPath.equals("/view/VentanaTripulante.fxml")) {
                ControllerVentanaTripulante tripulante = loader.getController();
            }

            Stage stage = new Stage();
            stage.setTitle(title);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
