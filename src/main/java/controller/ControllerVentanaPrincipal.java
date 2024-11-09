package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ControllerVentanaPrincipal {

    @FXML
    private Hyperlink linkSalir;

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
    @FXML
    void onLinkSalirClick(MouseEvent event) {
        try {
            // Carga la ventana de recuperación de contraseña
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VentanaLogin.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login"); // Título de la nueva ventana
            stage.show();

            // Cierra la ventana de inicio de sesión si es necesario
            ((Stage) linkSalir.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir errores en caso de fallar la carga
        }
    }
}
