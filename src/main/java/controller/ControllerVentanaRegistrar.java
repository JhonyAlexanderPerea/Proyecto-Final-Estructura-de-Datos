package controller;

import javafx.scene.control.Hyperlink;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerVentanaRegistrar {

    @FXML
    private Hyperlink linkVolverLogin; // Hyperlink para volver a la ventana de inicio de sesión

    // Método que se ejecuta al hacer clic en el hyperlink "Inicia sesión aquí"
    @FXML
    void onLinkVolverLoginClick(MouseEvent event) {
        try {
            // Carga la ventana de inicio de sesión
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VentanaLogin.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Iniciar sesión"); // Título de la ventana de inicio de sesión
            stage.show();

            // Cierra la ventana de registro
            ((Stage) linkVolverLogin.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir errores en caso de fallar la carga
        }
    }
}
