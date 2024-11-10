package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ControllerVentanaFlotaAirbus320 {

    @FXML
    private Pane paneAsientos;

    public void initialize() {
        crearAsientosA320();
    }

    private void crearAsientosA320() {
        int filasEjecutiva = 3; // 3 filas para clase ejecutiva (4 asientos por fila)
        int filasEconomica = 23; // 20 filas para clase económica (6 asientos por fila)
        int totalFilas = filasEjecutiva + filasEconomica;

        // Configuración inicial de coordenadas y espacio entre filas
        double xInicial = 20;
        double yInicialIzquierda = 20;
        double yInicialDerecha = 200;
        double espacioVertical = 45; // Espacio entre asientos en vertical (para las columnas)
        double espacioHorizontal = 45; // Espacio entre filas (en horizontal)

        // Tamaño de los botones de asiento
        double anchoAsiento = 39;
        double altoAsiento = 39;

        // Estilo base para los botones (color normal: verde, letra blanca)
        String estiloNormal = "-fx-background-color: #19c419; -fx-background-radius: 50%; -fx-font-size: 10px; -fx-text-fill: white; -fx-cursor: hand; -fx-border-color: transparent; -fx-border-width: 0px;";

        // Estilo de selección (cuando el botón es presionado: color azul y letra blanca)
        String estiloSeleccionado = "-fx-background-color: #0000FF; -fx-background-radius: 50%; -fx-font-size: 10px; -fx-text-fill: white; -fx-cursor: hand; -fx-border-color: transparent; -fx-border-width: 0px;";

        // Estilo cuando el cursor está sobre el botón (fondo blanco, letra verde)
        String estiloHover = "-fx-background-color: #FFFFFF; -fx-background-radius: 50%; -fx-font-size: 10px; -fx-text-fill: #19c419; -fx-cursor: hand; -fx-border-color: transparent; -fx-border-width: 0px;";

        // Creación de los asientos de clase ejecutiva (4 asientos por fila)
        for (int fila = 1; fila <= filasEjecutiva; fila++) {
            for (int columna = 0; columna < 2; columna++) {
                String letraIzquierda = String.valueOf((char) ('A' + columna));
                Button asientoIzquierda = new Button(fila + letraIzquierda);
                asientoIzquierda.setPrefWidth(anchoAsiento);
                asientoIzquierda.setPrefHeight(altoAsiento);
                asientoIzquierda.setStyle(estiloNormal);
                asientoIzquierda.setLayoutX(xInicial + (fila - 1) * espacioHorizontal);
                asientoIzquierda.setLayoutY(yInicialIzquierda + columna * espacioVertical);

                // Manejo del estado de selección (cambio de color al hacer clic)
                asientoIzquierda.setOnAction(event -> {
                    if (asientoIzquierda.getStyle().equals(estiloSeleccionado)) {
                        asientoIzquierda.setStyle(estiloNormal); // Desmarcarlo
                    } else {
                        asientoIzquierda.setStyle(estiloSeleccionado); // Marcarlo como seleccionado
                    }
                });

                // Cambios de estilo cuando el cursor pasa sobre el botón
                asientoIzquierda.setOnMouseEntered(event -> {
                    if (!asientoIzquierda.getStyle().equals(estiloSeleccionado)) {
                        asientoIzquierda.setStyle(estiloHover); // Solo cambiar hover si no está seleccionado
                    }
                });
                asientoIzquierda.setOnMouseExited(event -> {
                    if (!asientoIzquierda.getStyle().equals(estiloSeleccionado)) {
                        asientoIzquierda.setStyle(estiloNormal); // Volver al estilo normal si no está seleccionado
                    }
                });

                paneAsientos.getChildren().add(asientoIzquierda);

                String letraDerecha = String.valueOf((char) ('E' + columna));
                Button asientoDerecha = new Button(fila + letraDerecha);
                asientoDerecha.setPrefWidth(anchoAsiento);
                asientoDerecha.setPrefHeight(altoAsiento);
                asientoDerecha.setStyle(estiloNormal);
                asientoDerecha.setLayoutX(xInicial + (fila - 1) * espacioHorizontal);
                asientoDerecha.setLayoutY(yInicialDerecha + columna * espacioVertical);

                // Manejo del estado de selección (cambio de color al hacer clic)
                asientoDerecha.setOnAction(event -> {
                    if (asientoDerecha.getStyle().equals(estiloSeleccionado)) {
                        asientoDerecha.setStyle(estiloNormal); // Desmarcarlo
                    } else {
                        asientoDerecha.setStyle(estiloSeleccionado); // Marcarlo como seleccionado
                    }
                });

                // Cambios de estilo cuando el cursor pasa sobre el botón
                asientoDerecha.setOnMouseEntered(event -> {
                    if (!asientoDerecha.getStyle().equals(estiloSeleccionado)) {
                        asientoDerecha.setStyle(estiloHover); // Solo cambiar hover si no está seleccionado
                    }
                });
                asientoDerecha.setOnMouseExited(event -> {
                    if (!asientoDerecha.getStyle().equals(estiloSeleccionado)) {
                        asientoDerecha.setStyle(estiloNormal); // Volver al estilo normal si no está seleccionado
                    }
                });

                paneAsientos.getChildren().add(asientoDerecha);
            }
        }

        // Ajustar coordenada X para los asientos de clase económica
        xInicial += filasEjecutiva * espacioHorizontal + espacioHorizontal;

        // Creación de los asientos de clase económica (6 asientos por fila)
        for (int fila = filasEjecutiva + 1; fila <= totalFilas; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                String letraIzquierda = String.valueOf((char) ('A' + columna));
                Button asientoIzquierda = new Button(fila + letraIzquierda);
                asientoIzquierda.setPrefWidth(anchoAsiento);
                asientoIzquierda.setPrefHeight(altoAsiento);
                asientoIzquierda.setStyle(estiloNormal);
                asientoIzquierda.setLayoutX(xInicial + (fila - filasEjecutiva - 1) * espacioHorizontal);
                asientoIzquierda.setLayoutY(yInicialIzquierda + columna * espacioVertical);

                // Manejo del estado de selección (cambio de color al hacer clic)
                asientoIzquierda.setOnAction(event -> {
                    if (asientoIzquierda.getStyle().equals(estiloSeleccionado)) {
                        asientoIzquierda.setStyle(estiloNormal); // Desmarcarlo
                    } else {
                        asientoIzquierda.setStyle(estiloSeleccionado); // Marcarlo como seleccionado
                    }
                });

                // Cambios de estilo cuando el cursor pasa sobre el botón
                asientoIzquierda.setOnMouseEntered(event -> {
                    if (!asientoIzquierda.getStyle().equals(estiloSeleccionado)) {
                        asientoIzquierda.setStyle(estiloHover); // Solo cambiar hover si no está seleccionado
                    }
                });
                asientoIzquierda.setOnMouseExited(event -> {
                    if (!asientoIzquierda.getStyle().equals(estiloSeleccionado)) {
                        asientoIzquierda.setStyle(estiloNormal); // Volver al estilo normal si no está seleccionado
                    }
                });

                paneAsientos.getChildren().add(asientoIzquierda);

                String letraDerecha = String.valueOf((char) ('D' + columna));
                Button asientoDerecha = new Button(fila + letraDerecha);
                asientoDerecha.setPrefWidth(anchoAsiento);
                asientoDerecha.setPrefHeight(altoAsiento);
                asientoDerecha.setStyle(estiloNormal);
                asientoDerecha.setLayoutX(xInicial + (fila - filasEjecutiva - 1) * espacioHorizontal);
                asientoDerecha.setLayoutY(yInicialDerecha + columna * espacioVertical);

                // Manejo del estado de selección (cambio de color al hacer clic)
                asientoDerecha.setOnAction(event -> {
                    if (asientoDerecha.getStyle().equals(estiloSeleccionado)) {
                        asientoDerecha.setStyle(estiloNormal); // Desmarcarlo
                    } else {
                        asientoDerecha.setStyle(estiloSeleccionado); // Marcarlo como seleccionado
                    }
                });

                // Cambios de estilo cuando el cursor pasa sobre el botón
                asientoDerecha.setOnMouseEntered(event -> {
                    if (!asientoDerecha.getStyle().equals(estiloSeleccionado)) {
                        asientoDerecha.setStyle(estiloHover); // Solo cambiar hover si no está seleccionado
                    }
                });
                asientoDerecha.setOnMouseExited(event -> {
                    if (!asientoDerecha.getStyle().equals(estiloSeleccionado)) {
                        asientoDerecha.setStyle(estiloNormal); // Volver al estilo normal si no está seleccionado
                    }
                });

                paneAsientos.getChildren().add(asientoDerecha);
            }
        }
    }




}
