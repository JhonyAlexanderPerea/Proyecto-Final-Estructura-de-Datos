package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/VentanaFlotaAirbus320.fxml"));
        primaryStage.setTitle("Uniquindio Airlines");
        primaryStage.setScene(new Scene(root));
        primaryStage.show(); //Prueba2
    }
}
