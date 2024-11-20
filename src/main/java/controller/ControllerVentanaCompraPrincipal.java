package controller;

import enums.RutaInternacional;
import enums.RutaNacional;
import enums.ServicioViaje;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import util.manejoVentanasUtil;

public class ControllerVentanaCompraPrincipal {

    @FXML
    ToggleGroup grupoIdaVuelta = new ToggleGroup();
    @FXML
    private ComboBox<String> comboBoxOrigen;
    @FXML
    private ComboBox<Object> comboBoxDestino;
    @FXML
    private ComboBox<ServicioViaje> comboBoxServicio;
    @FXML
    private RadioButton btnSoloIda;
    @FXML
    private RadioButton btnIdaVuelta;
    @FXML
    private DatePicker fechaIda;
    @FXML
    private DatePicker fechaVuelta;

    private ControllerVentanaFlota controllerVentanaFlota;

    manejoVentanasUtil manejoVentanasUtil = new manejoVentanasUtil();

    @FXML
    public void habilitarAmbas() {
        // Habilitar ambos DatePickers
        fechaIda.setDisable(false);
        fechaVuelta.setDisable(false);
        fechaIda.setValue(null);
        fechaVuelta.setValue(null);
    }

    @FXML
    public void habilitarSoloIda() {
        // Habilitar solo el primer DatePicker
        fechaIda.setDisable(false);
        fechaVuelta.setDisable(true);
        fechaIda.setValue(null);
    }


    // Este método se llama cuando la ventana FXML se ha cargado
    public void initialize() {
        fechaIda.setDisable(true);
        fechaVuelta.setDisable(true);

        ObservableList<Object> destino = FXCollections.observableArrayList();
        destino.addAll(RutaNacional.values());
        destino.addAll(RutaInternacional.values());


        comboBoxOrigen.getItems().addAll("CDMX");
        comboBoxDestino.setItems(destino);
        comboBoxDestino.setConverter(new StringConverter<>() {
                                         @Override
                                         public String toString(Object object) {
                                             if (object instanceof RutaNacional) {
                                                 // Personalizar la visualización de las categorías
                                                 RutaNacional rutaNacional = (RutaNacional) object;
                                                 switch (rutaNacional) {
                                                     case MONTERREY:
                                                         return "Monterrey";
                                                     case CANCUN:
                                                         return "Cancún";
                                                 }
                                             } else if (object instanceof RutaInternacional) {
                                                 // Personalizar la visualización de los tipos de servicio
                                                 RutaInternacional rutaInternacional = (RutaInternacional) object;
                                                 switch (rutaInternacional) {
                                                     case BUENOS_AIRES:
                                                         return "Buenos Aires";
                                                     case BOGOTA:
                                                         return "Bogotá";
                                                     case LOS_ANGELES:
                                                         return "Los Ángeles";
                                                     case CIUDAD_PANAMA:
                                                         return "Panamá";

                                                 }
                                             }
                                             return object.toString(); // Valor por defecto
                                         }

                                         @Override
                                         public Object fromString(String string) {
                                             return null;
                                         }

                                     });
        comboBoxDestino.setOnAction(event -> actualizarTextoEnVentanaSecundaria());
        comboBoxServicio.setItems(FXCollections.observableArrayList(ServicioViaje.values()));
        comboBoxServicio.setConverter(new StringConverter<>() {
            @Override
            public String toString(ServicioViaje servicioViaje) {
                if (servicioViaje == null) return "";
                // Personalizar la visualización de cada categoría
                switch (servicioViaje) {
                    case ECONOMICA: return "Clase Económica";
                    case EJECUTIVA: return "Clase Ejecutiva";

                    default: return servicioViaje.name();
                }
            }


            @Override
            public ServicioViaje fromString(String string) {
                // Convertir texto a un valor del enum si es necesario (rara vez usado aquí)
                return ServicioViaje.valueOf(string.toUpperCase());
            }
        });

    }

    public void actualizarTextoEnVentanaSecundaria() {
        String opcionSeleccionada = comboBoxDestino.getValue();

        if (opcionSeleccionada != null && controllerVentanaFlota != null) {
            controllerVentanaFlota.actualizarTexto(opcionSeleccionada);
        }
    }

    public void abrirVentanaSecundaria() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/VentanaFlota.fxml"));
        Parent root = loader.load();
        ControllerVentanaFlota controlador = loader.getController();

        controllerVentanaFlota = controlador;  // Guardamos la referencia del controlador de la ventana secundaria

        Stage stage = new Stage();
        stage.setTitle("Ventana Secundaria");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void abrirVentanaFlota(ActionEvent actionEvent) {
        manejoVentanasUtil.cambiarVentana(actionEvent, "/view/VentanaFlota.fxml", "Flota");
    }

    public void abrirVentanaLogin(ActionEvent actionEvent) {
        manejoVentanasUtil.cambiarVentana(actionEvent, "/view/VentanaLogin.fxml", "Login");
    }

}
