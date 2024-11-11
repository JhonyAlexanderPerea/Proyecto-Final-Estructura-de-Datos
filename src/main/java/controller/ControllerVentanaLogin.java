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
import util.manejoVentanasUtil;

public class ControllerVentanaLogin {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

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

    // Método adicional para manejar el inicio de sesión
    @FXML
    void abrirVentanaPrincipal(MouseEvent event) {
        manejoVentanasUtil.cambiarVentana(event, "/view/VentanaPrincipal.fxml", "Uniquindio Airlines");
    }

    @FXML
    void abrirVentanaOlvideContrasenia(MouseEvent event) {
        manejoVentanasUtil.cambiarVentana(event, "/view/VentanaRecuperarContrasenia.fxml", "Recuperar Contraseña");
    }

    public void abrirVentanaRegistro(MouseEvent event) {
        manejoVentanasUtil.cambiarVentana(event, "/view/VentanaRegistrar.fxml", "Registro");
    }
}
