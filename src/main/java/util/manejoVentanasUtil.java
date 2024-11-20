package util;

import controller.*;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class manejoVentanasUtil {

    private final Map<String, Class<?>> controladorMap;

    public manejoVentanasUtil() {
        // Inicializar el mapa de rutas a controladores
        controladorMap = new HashMap<>();
        controladorMap.put("/view/Aeronave.fxml", AeronaveController.class);
        controladorMap.put("/view/VentanaCompra.fxml", ControllerVentanaCompra.class);
        controladorMap.put("/view/VentanaCompraPrincipal.fxml", ControllerVentanaCompraPrincipal.class);
        controladorMap.put("/view/VentanaFlota.fxml", ControllerVentanaFlota.class);
        controladorMap.put("/view/VentanaLogin.fxml", ControllerVentanaLogin.class);
        controladorMap.put("/view/VentanaPerfilTripulante.fxml", ControllerVentanaPerfilTripulante.class);
        controladorMap.put("/view/VentanaPrincipal.fxml", ControllerVentanaPrincipal.class);
        controladorMap.put("/view/VentanaRecuperarContrasenia.fxml", ControllerVentanaRecupContrasenia.class);
        controladorMap.put("/view/VentanaRegistrar.fxml", ControllerVentanaRegistrar.class);
        controladorMap.put("/view/VentanaTripulante.fxml", ControllerVentanaTripulante.class);
    }

    /**
     * Cambia la ventana actual por una nueva especificada por el FXML.
     *
     * @param event    El evento que dispara el cambio.
     * @param fxmlPath La ruta del archivo FXML.
     * @param title    El título de la ventana nueva.
     */
    public void cambiarVentana(Event event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            /*// Obtener y usar el controlador si es necesario
            Object controller = loader.getController();*/
            // Configurar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));

            // Cerrar la ventana actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
