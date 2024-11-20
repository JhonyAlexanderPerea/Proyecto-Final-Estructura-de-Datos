package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; // Importa el módulo para fechas

public class RegistroGeneral {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Registrar el módulo para manejar LocalDate y otros tipos de fechas de Java 8
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Activar "pretty print"
    }

    // Método para guardar una persona en el archivo JSON correspondiente
    public static <T> void registrarPersona(T persona) throws IOException {
        // Determinar la ruta del archivo JSON según el tipo de persona
        String rutaArchivoJson = determinarRutaArchivo(persona);

        if (rutaArchivoJson == null) {
            throw new IllegalArgumentException("Tipo de persona no reconocido: " + persona.getClass().getName());
        }

        // Leer la lista de personas existente
        List<T> listaPersonas = leerPersonas(rutaArchivoJson, persona);

        // Agregar la nueva persona a la lista
        listaPersonas.add(persona);

        // Verifica si el archivo o la carpeta no existen y los crea
        File archivo = new File(rutaArchivoJson);
        archivo.getParentFile().mkdirs(); // Crea directorios si no existen
        archivo.createNewFile(); // Crea el archivo si no existe

        // Escribir la lista actualizada en el archivo JSON
        mapper.writeValue(archivo, listaPersonas);
    }

    // Método para leer personas desde el archivo JSON correspondiente
    public static <T> List<T> leerPersonas(String rutaArchivoJson, T referencia) throws IOException {
        File archivo = new File(rutaArchivoJson);

        // Si el archivo no existe, retorna una lista vacía
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        // Leer la lista de personas del archivo JSON
        return mapper.readValue(archivo, new TypeReference<List<T>>() {});
    }

    // Método para determinar la ruta del archivo JSON según el tipo de persona
    private static <T> String determinarRutaArchivo(T persona) {
        if (persona instanceof Administrador) {
            return "src/main/resources/ListaAdmins/listaAdmins.json";
        } else if (persona instanceof Tripulante) {
            return "src/main/resources/ListaTripulaciones/listaTripulaciones.json";
        } else {
            return null;
        }
    }

    public static boolean validarLoginAdministrador(String correo, String contrasenia) throws IOException {
        String rutaArchivoJson = "src/main/resources/ListaAdmins/listaAdmins.json";

        File archivo = new File(rutaArchivoJson);

        if (!archivo.exists()) {
            return false; // Si el archivo no existe, no hay administradores registrados
        }

        // Leer la lista de administradores
        List<Administrador> listaAdministradores = mapper.readValue(archivo, new TypeReference<List<Administrador>>() {});

        // Verificar si existe un administrador con el correo y contraseña dados
        for (Administrador admin : listaAdministradores) {
            if (admin.getCorreo().equals(correo) && admin.getContrasenia().equals(contrasenia)) {
                return true; // Login válido
            }
        }

        return false; // Login inválido
    }
}
