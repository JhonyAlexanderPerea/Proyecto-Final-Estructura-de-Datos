module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;
    requires java.logging;

    exports app;
    exports controller;
}