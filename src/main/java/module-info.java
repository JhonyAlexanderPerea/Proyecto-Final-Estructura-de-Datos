module com.example.proyectofinalestructuradedatos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectofinalestructuradedatos to javafx.fxml;
    exports com.example.proyectofinalestructuradedatos;
}