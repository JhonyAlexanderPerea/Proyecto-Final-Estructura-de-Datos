package controller;

import Model.Administrador;
import Model.Registro;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import util.AlertasUtil;
import util.manejoVentanasUtil;

import java.io.IOException;

public class ControllerVentanaLogin {


    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

    @FXML
    public TextField txtEmail; // Campo de texto para el email


    @FXML
    private PasswordField txtPassword;// Campo de texto para la contraseña

    @FXML
    private Button btnEntrar; // Botón para iniciar sesión

    @FXML
    private Button btnRegistrate; // Botón para registrarse

    @FXML
    private Hyperlink linkOlvideContrasena;

    // Método adicional para manejar el inicio de sesión
    @FXML
    void abrirVentanaPrincipal(MouseEvent event) throws IOException {
        if (Registro.validarLogin(txtEmail.getText(),txtPassword.getText()))
        {
            manejoVentanasUtil.cambiarVentana(event, "/view/VentanaPrincipal.fxml", "Uniquindio Airlines");
        }
        else
        {
            if (txtPassword.getText().equals("")|| txtEmail.getText().equals("") )
            {
                AlertasUtil.mostrarAlerta("Nombre de usuario o contraseña incorrectas.");
            }
            AlertasUtil.mostrarAlerta("El usuario no se encuentra en la base de datos.");
        }
    }

    @FXML
    void abrirVentanaOlvideContrasenia(MouseEvent event) {
        manejoVentanasUtil.cambiarVentana(event, "/view/VentanaRecuperarContrasenia.fxml", "Recuperar Contraseña");
    }

    public void abrirVentanaRegistro(MouseEvent event) {
        manejoVentanasUtil.cambiarVentana(event, "/view/VentanaRegistrar.fxml", "Registro");
    }
}
