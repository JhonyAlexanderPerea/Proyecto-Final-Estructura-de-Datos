package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class ControllerVentanaFlota {

    @FXML
    private Pane paneAsientos;
    @FXML
    private Label labelTipoAeronave;

    private String tipoAeronave; // Variable para definir el tipo de aeronave

    public void initialize() {
        tipoAeronave = "Airbus320";  // Dependiendo el tipoAeronave se mostrara la flota correspondiente
        crearAsientos();
    }

    private void crearAsientos() {
        actualizarTipoAeronave(tipoAeronave);
        if ("Boeing787".equals(tipoAeronave)) {
            crearAsientosBoeing787();
        } else if ("Airbus330".equals(tipoAeronave)) {
            crearAsientosA330();
        } else if ("Airbus320".equals(tipoAeronave)) {
            crearAsientosA320();
        }
    }

    private void crearAsientosA320() {
        int filasEjecutiva = 3; // 3 filas para clase ejecutiva (4 asientos por fila)
        int filasEconomica = 23; // 23 filas para clase económica (6 asientos por fila)
        int totalFilas = filasEjecutiva + filasEconomica;

        // Configuración inicial de coordenadas y espacio entre filas
        double xInicial = 20;
        double yInicialIzquierda = 10;
        double yInicialDerecha = 250;
        double espacioVertical = 60; // Espacio entre asientos en vertical
        double espacioHorizontal = 60; // Espacio entre filas en horizontal

        // Tamaño de los botones de asiento (ajustado para hacerlos más pequeños)
        double anchoAsiento = 45;
        double altoAsiento = 45;
        String estiloNormal = "-fx-background-color: #19c419; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: white; -fx-font-weight: bold;";
        String estiloSeleccionado = "-fx-background-color: #0000FF; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: white; -fx-font-weight: bold;";
        String estiloHover = "-fx-background-color: #FFFFFF; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: #19c419; -fx-font-weight: bold;";

        // Creación de los asientos de clase ejecutiva
        for (int fila = 1; fila <= filasEjecutiva; fila++) {
            for (int columna = 0; columna < 2; columna++) {
                String letraIzquierda = String.valueOf((char) ('A' + columna));
                Button asientoIzquierda = crearBotonAsiento(fila + letraIzquierda, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asientoIzquierda.setLayoutX(xInicial + (fila - 1) * espacioHorizontal);
                asientoIzquierda.setLayoutY(yInicialIzquierda + columna * espacioVertical);
                paneAsientos.getChildren().add(asientoIzquierda);

                String letraDerecha = String.valueOf((char) ('E' + columna));
                Button asientoDerecha = crearBotonAsiento(fila + letraDerecha, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asientoDerecha.setLayoutX(xInicial + (fila - 1) * espacioHorizontal);
                asientoDerecha.setLayoutY(yInicialDerecha + columna * espacioVertical);
                paneAsientos.getChildren().add(asientoDerecha);
            }
        }

        // Ajustar coordenada X para los asientos de clase económica
        xInicial += filasEjecutiva * espacioHorizontal + espacioHorizontal;

        // Creación de los asientos de clase económica
        for (int fila = filasEjecutiva + 1; fila <= totalFilas; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                String letraIzquierda = String.valueOf((char) ('A' + columna));
                Button asientoIzquierda = crearBotonAsiento(fila + letraIzquierda, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asientoIzquierda.setLayoutX(xInicial + (fila - filasEjecutiva - 1) * espacioHorizontal);
                asientoIzquierda.setLayoutY(yInicialIzquierda + columna * espacioVertical);
                paneAsientos.getChildren().add(asientoIzquierda);

                String letraDerecha = String.valueOf((char) ('D' + columna));
                Button asientoDerecha = crearBotonAsiento(fila + letraDerecha, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asientoDerecha.setLayoutX(xInicial + (fila - filasEjecutiva - 1) * espacioHorizontal);
                asientoDerecha.setLayoutY(yInicialDerecha + columna * espacioVertical);
                paneAsientos.getChildren().add(asientoDerecha);
            }
        }
    }

    private void crearAsientosBoeing787() {
        // Configuración para Boeing 787
        int filasEjecutiva = 5; // 5 filas para clase ejecutiva (6 asientos por fila)
        int filasEconomica = 25; // 25 filas para clase económica (9 asientos por fila)
        int totalFilas = filasEjecutiva + filasEconomica;

        double xInicial = 20;
        double yInicialIzquierda = 10;
        double yInicialCentro = 320; // Aumentado para dejar más espacio
        double yInicialDerecha = 620; // Aumentado para dejar más espacio
        double espacioVertical = 60;  // Espacio entre asientos en vertical (para evitar amontonamiento)
        double espacioHorizontal = 60; // Espacio entre filas (en horizontal)

        double anchoAsiento = 45;
        double altoAsiento = 45;
        String estiloNormal = "-fx-background-color: #19c419; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: white; -fx-font-weight: bold;";
        String estiloSeleccionado = "-fx-background-color: #0000FF; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: white; -fx-font-weight: bold;";
        String estiloHover = "-fx-background-color: #FFFFFF; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: #19c419; -fx-font-weight: bold;";

        // Creación de los asientos de clase ejecutiva (5 filas, 6 asientos por fila)
        for (int fila = 1; fila <= filasEjecutiva; fila++) {
            // Clase ejecutiva con asientos AB, DE, LK (6 asientos por fila)
            String[] letrasEjecutiva = {"A", "B", "D", "E", "L", "K"};

            // Excluimos las letras K y L en la fila 5
            if (fila == 5) {
                letrasEjecutiva = new String[] {"A", "B", "D", "E"};  // Fila 5 sin K y L
            }

            for (int columna = 0; columna < letrasEjecutiva.length; columna++) {
                String letra = letrasEjecutiva[columna];  // Usamos las letras específicas para Boeing 787
                Button asiento = crearBotonAsiento(fila + letra, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asiento.setLayoutX(xInicial + (fila - 1) * espacioHorizontal);
                asiento.setLayoutY(yInicialIzquierda + columna * espacioVertical);
                paneAsientos.getChildren().add(asiento);
            }
        }

        xInicial += filasEjecutiva * espacioHorizontal + espacioHorizontal;

        // Creación de los asientos de clase económica (25 filas, 9 asientos por fila)
        for (int fila = filasEjecutiva + 1; fila <= totalFilas; fila++) {
            // Clase económica con asientos ABC, DEF, JKL (9 asientos por fila)
            String[] letrasEconomica = {"A", "B", "C", "D", "E", "F", "J", "K", "L"};
            for (int columna = 0; columna < letrasEconomica.length; columna++) { // 9 asientos por fila (ABC, DEF, JKL)
                String letra = letrasEconomica[columna];  // Usamos las letras específicas para clase económica
                Button asiento = crearBotonAsiento(fila + letra, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asiento.setLayoutX(xInicial + (fila - filasEjecutiva - 1) * espacioHorizontal);
                asiento.setLayoutY(yInicialIzquierda + columna * espacioVertical);
                paneAsientos.getChildren().add(asiento);
            }
        }
    }

    private void crearAsientosA330() {
        // Configuración para Airbus A330
        int filasEjecutiva = 5; // 5 filas para clase ejecutiva (6 asientos por fila)
        int filasEconomica = 28; // 28 filas para clase económica (8 asientos por fila)
        int totalFilas = filasEjecutiva + filasEconomica;

        double xInicial = 20;
        double yInicialIzquierda = 10;
        double yInicialCentro = 320; // Aumentado para dejar más espacio
        double yInicialDerecha = 620; // Aumentado para dejar más espacio
        double espacioVertical = 60;  // Espacio entre asientos en vertical (para evitar amontonamiento)
        double espacioHorizontal = 60; // Espacio entre filas (en horizontal)

        double anchoAsiento = 45;
        double altoAsiento = 45;
        String estiloNormal = "-fx-background-color: #19c419; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: white; -fx-font-weight: bold;";
        String estiloSeleccionado = "-fx-background-color: #0000FF; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: white; -fx-font-weight: bold;";
        String estiloHover = "-fx-background-color: #FFFFFF; -fx-background-radius: 50%; -fx-font-size: 12px; -fx-text-fill: #19c419; -fx-font-weight: bold;";

        // Creación de los asientos de clase ejecutiva (5 filas, 6 asientos por fila)
        for (int fila = 1; fila <= filasEjecutiva; fila++) {
            for (int columna = 0; columna < 6; columna++) { // 6 asientos por fila
                String letra = String.valueOf((char) ('A' + columna));
                Button asiento = crearBotonAsiento(fila + letra, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asiento.setLayoutX(xInicial + (fila - 1) * espacioHorizontal);
                asiento.setLayoutY(yInicialIzquierda + columna * espacioVertical);
                paneAsientos.getChildren().add(asiento);
            }
        }

        xInicial += filasEjecutiva * espacioHorizontal + espacioHorizontal;

        // Creación de los asientos de clase económica (28 filas, 8 asientos por fila)
        for (int fila = filasEjecutiva + 1; fila <= totalFilas; fila++) {
            // Cambiamos la disposición de los asientos a AC, DEFG, HK
            String[] letrasEconomica;
            if (fila % 2 == 0) { // Si es fila par (ejemplo 6, 8, 10...):
                letrasEconomica = new String[] {"A", "C", "D", "E", "F", "G", "H", "K"};
            } else { // Si es fila impar (ejemplo 7, 9, 11...):
                letrasEconomica = new String[] {"A", "C", "D", "E", "F", "G", "H", "K"};
            }

            // Añadir los asientos según la disposición
            for (int columna = 0; columna < letrasEconomica.length; columna++) {
                String letra = letrasEconomica[columna];
                Button asiento = crearBotonAsiento(fila + letra, anchoAsiento, altoAsiento, estiloNormal, estiloSeleccionado, estiloHover);
                asiento.setLayoutX(xInicial + (fila - filasEjecutiva - 1) * espacioHorizontal);
                asiento.setLayoutY(yInicialIzquierda + columna * espacioVertical);
                paneAsientos.getChildren().add(asiento);
            }
        }
    }


    private Button crearBotonAsiento(String etiqueta, double ancho, double alto, String estiloNormal, String estiloSeleccionado, String estiloHover) {
        Button asiento = new Button(etiqueta);
        asiento.setPrefWidth(ancho);
        asiento.setPrefHeight(alto);
        asiento.setStyle(estiloNormal);

        asiento.setOnAction(event -> asiento.setStyle(asiento.getStyle().equals(estiloSeleccionado) ? estiloNormal : estiloSeleccionado));
        asiento.setOnMouseEntered(event -> {
            if (!asiento.getStyle().equals(estiloSeleccionado)) asiento.setStyle(estiloHover);
        });
        asiento.setOnMouseExited(event -> {
            if (!asiento.getStyle().equals(estiloSeleccionado)) asiento.setStyle(estiloNormal);
        });
        return asiento;
    }
    public void actualizarTipoAeronave(String tipoAeronave) {
        labelTipoAeronave.setText(tipoAeronave);  // Actualiza el texto del Label
    }

    public void abrirVentanaCompra(ActionEvent actionEvent) {
    }
}