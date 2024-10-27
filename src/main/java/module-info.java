module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;
    requires java.logging;

    opens controller to javafx.fxml;

    exports app;
    exports controller;
}