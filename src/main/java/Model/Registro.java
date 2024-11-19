package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Registro {

    private static final String RUTA_ARCHIVO_JSON = "src/main/resources/ListaAdmins/listaAdmins.json";
    private static ObjectMapper mapper = new ObjectMapper();

    // Método para guardar un administrador en el archivo JSON
    public static void registrarAdmin(Administrador administrador) throws IOException {
        List<Administrador> listaAdmins = leerAdmins();

        // Agregar el nuevo administrador a la lista
        listaAdmins.add(administrador);

        // Verifica si el archivo o la carpeta no existen y los crea
        File archivo = new File(RUTA_ARCHIVO_JSON);
        archivo.getParentFile().mkdirs(); // Crea directorios si no existen
        archivo.createNewFile(); // Crea el archivo si no existe

        // Activar la opción de "pretty print" para formato con saltos de línea
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Escribir la lista actualizada en el archivo JSON
        mapper.writeValue(archivo, listaAdmins);
    }

    // Método para leer todos los administradores desde el archivo JSON
    public static List<Administrador> leerAdmins() throws IOException {
        File archivo = new File(RUTA_ARCHIVO_JSON);

        // Si el archivo no existe, retorna una lista vacía
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        // Leer la lista de administradores del archivo JSON
        return mapper.readValue(archivo, new TypeReference<List<Administrador>>() {
        });
    }

    public static boolean validarLogin(String correo, String contrasenia) throws IOException {
        List<Administrador> listaAdmins = leerAdmins();

        // Recorrer la lista de administradores para encontrar una coincidencia
        for (Administrador admin : listaAdmins) {
            if (admin.getCorreo().equals(correo) && admin.getContrasenia().equals(contrasenia)) {
                return true; // Si se encuentra el administrador, es un inicio de sesión válido
            }
        }

        return false; // Si no se encuentra una coincidencia, el login es incorrecto
    }
}
