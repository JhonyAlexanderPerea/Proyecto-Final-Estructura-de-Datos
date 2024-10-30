module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;
    requires java.logging;
    requires java.mail;
    requires jakarta.mail;

    exports app;
    exports controller;
}