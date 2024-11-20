module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.mail;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;

    exports app;
    exports controller;
    opens controller to javafx.fxml;
    opens Model to com.fasterxml.jackson.databind;
}