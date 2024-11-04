package controller;

import javafx.scene.control.Hyperlink;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ControllerVentanaLogin {

    @FXML
    public TextField txtEmail; // Campo de texto para el email

    @FXML
    public TextField txtPassword; // Campo de texto para la contraseña

    @FXML
    private Button btnEntrar; // Botón para iniciar sesión

    @FXML
    private Button btnRegistrate; // Botón para registrarse

    @FXML
    private Hyperlink linkOlvideContrasena;

    @FXML
    void onBtnRegistrateClick(MouseEvent event) {
        try {
            // Carga la ventana de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VentanaRegistrar.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Registro"); // Título de la nueva ventana
            stage.show();

            // Cierra la ventana de inicio de sesión si es necesario
            ((Stage) btnRegistrate.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir errores en caso de fallar la carga
        }
    }
    // Método adicional para manejar el inicio de sesión
    @FXML
    void onBtnEntrarClick(MouseEvent event) {
    }

    @FXML
    void onLinkOlvideContrasenaClick(MouseEvent event) {
        try {
            // Carga la ventana de recuperación de contraseña
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VentanaRecuperarContrasenia.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Recuperar Contraseña"); // Título de la nueva ventana
            stage.show();

            // Cierra la ventana de inicio de sesión si es necesario
            ((Stage) linkOlvideContrasena.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir errores en caso de fallar la carga
        }
    }

}
