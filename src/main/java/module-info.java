module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;
    requires jakarta.mail;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    exports app;
    exports controller;
    opens controller to javafx.fxml;

}