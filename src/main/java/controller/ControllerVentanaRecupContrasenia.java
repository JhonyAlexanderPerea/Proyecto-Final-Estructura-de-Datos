package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class ControllerVentanaRecupContrasenia {
    @FXML
    private Button btnCancelar; // El botón para cancelar y regresar

    @FXML
    public void onBtnCancelarClick() {
        try {
            // Cargar la ventana de inicio de sesión
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VentanaLogin.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena para la ventana de inicio de sesión
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Manejo básico de excepciones
        }
    }
}

