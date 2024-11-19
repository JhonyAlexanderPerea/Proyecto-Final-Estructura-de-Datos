package controller;

import Model.Administrador;
import Model.carroEmbarque;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.manejoVentanasUtil;
import Model.Registro;

import javax.swing.*;
import java.io.IOException;

import static util.AlertasUtil.mostrarAlerta;


public class ControllerVentanaRegistrar {

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

    private static final Logger logger = LogManager.getLogger(ControllerVentanaRegistrar.class);

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private Hyperlink linkVolverLogin; // Hyperlink para volver a la ventana de inicio de sesión


    public void abrirVentanaLogin(MouseEvent mouseEvent) {
        manejoVentanasUtil.cambiarVentana(mouseEvent, "/view/VentanaLogin.fxml", "Login");
    }

    public void registrarAdmin(MouseEvent mouseEvent) throws IOException {
        if (txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty() ||
                txtId.getText().isEmpty() || txtContrasenia.getText().isEmpty()) {

            mostrarAlerta("Por favor complete todos los campos");
            logger.warn("Campos incompletos, no se pudo registrar el administrador");
        } else {
            Administrador administrador = new Administrador(
                    txtNombre.getText(),
                    txtId.getText(),
                    txtCorreo.getText(),
                    txtContrasenia.getText()
            );

            Registro.registrarAdmin(administrador);
            mostrarAlerta("Administrador registrado exitosamente");
            logger.info("Administrador registrado exitosamente");
        }
    }
}
