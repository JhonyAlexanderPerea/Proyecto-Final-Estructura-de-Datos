package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ControllerVentanaPrincipal {

    @FXML
    private void abrirVentanaTripulante(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VentanaTripulante.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Ventana Tripulante");
            stage.setScene(new Scene(root));
            stage.show();

            Stage stagePrincipal = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            stagePrincipal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
