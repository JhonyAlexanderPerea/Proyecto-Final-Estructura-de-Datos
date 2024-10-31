package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.Persistencia;

import java.awt.image.TileObserver;
import java.util.ArrayList;
import java.util.Objects;

public class ControllerVentanaRegistrar {

    private Persistencia persistencia = new Persistencia();

    ArrayList<String> informacion = new ArrayList<>();

    @FXML
    private Button btnRegistrar;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    void registrarUsuario(ActionEvent event) {
        if (txtCorreo.getText() != "" && txtContrasenia.getText() != "" && txtId.getText() != "" && txtNombre.getText() != "")
        {
            /* TODO */
         System.out.println("Usuario registrado");
        }


    }

}
