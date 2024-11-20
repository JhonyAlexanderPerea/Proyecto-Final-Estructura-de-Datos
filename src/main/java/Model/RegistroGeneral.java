package Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegistroGeneral {

    private static final String RUTA_DATOS = "src/main/resources/Almacenamiento/datosGenerales.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Registrar el módulo para manejar LocalDate y otros tipos de fechas de Java 8
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Activar "pretty print"
    }

    // Método para guardar una persona en el archivo JSON correspondiente
    public static <T> void registrarPersona(T persona) throws IOException {
        // Leer la lista de todas las personas existentes
        List<Map<String, Object>> listaPersonas;
        File archivo = new File(RUTA_DATOS);

        if (archivo.exists() && archivo.length() > 0) {
            // Leer personas si el archivo existe y no está vacío
            listaPersonas = mapper.readValue(archivo, new TypeReference<>() {});
        } else {
            // Crear una nueva lista si no existe el archivo o está vacío
            listaPersonas = new ArrayList<>();
        }

        // Crear un mapa para la nueva persona, con la categoría adecuada
        Map<String, Object> personaMap = crearMapaPersona(persona);

        // Agregar la nueva persona a la lista
        listaPersonas.add(personaMap);

        // Crear el archivo y sus directorios si no existen
        archivo.getParentFile().mkdirs();
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        // Escribir la lista actualizada en el archivo JSON
        mapper.writeValue(archivo, listaPersonas);
    }



    // Método genérico para leer personas desde el archivo JSON
    public static <T> List<T> leerPersonas(Class<T> clazz) throws IOException {
        File archivo = new File(RUTA_DATOS);

        // Si el archivo no existe, retorna una lista vacía
        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>();
        }

        // Leer la lista de personas del archivo JSON como un Map genérico
        List<Map<String, Object>> listaMapas = mapper.readValue(archivo, new TypeReference<>() {});

        // Convertir los Map<String, Object> a las instancias correspondientes
        List<T> listaPersonas = new ArrayList<>();
        for (Map<String, Object> mapa : listaMapas) {
            String categoria = (String) mapa.get("categoria");

            // Dependiendo de la categoría, se crea el objeto correspondiente
            if (clazz.equals(Tripulante.class) && "Tripulante".equals(categoria)) {
                T persona = mapper.convertValue(mapa, clazz);
                listaPersonas.add(persona);
            } else if (clazz.equals(Administrador.class) && "Administrador".equals(categoria)) {
                T persona = mapper.convertValue(mapa, clazz);
                listaPersonas.add(persona);
            } else if (clazz.equals(Cliente.class) && "Cliente".equals(categoria)) {
                T persona = mapper.convertValue(mapa, clazz);
                listaPersonas.add(persona);
            }
        }
        return listaPersonas;
    }



    // Método para crear un mapa con la información de la persona
    private static <T> Map<String, Object> crearMapaPersona(T persona) {
        Map<String, Object> personaMap = null;

        if (persona instanceof Administrador) {
            personaMap = Map.of(
                    "categoria", "Administrador",
                    "nombre", ((Administrador) persona).getNombre(),
                    "identificacion", ((Administrador) persona).getIdentificacion(),
                    "correo", ((Administrador) persona).getCorreo(),
                    "contrasenia", ((Administrador) persona).getContrasenia()
            );
        } else if (persona instanceof Tripulante) {
            personaMap = Map.of(
                    "categoria", "Tripulante",
                    "id", ((Tripulante) persona).getId(),
                    "nombre", ((Tripulante) persona).getNombre(),
                    "direccion", ((Tripulante) persona).getDireccion(),
                    "email", ((Tripulante) persona).getEmail(),
                    "fechaNacimiento", ((Tripulante) persona).getFechaNacimiento(),
                    "estudiosRealizados", ((Tripulante) persona).getEstudiosRealizados()
            );
        } else if (persona instanceof Cliente) {
            personaMap = Map.of(
                    "categoria", "Cliente",
                    "nombre", ((Cliente) persona).getNombre(),
                    "identificacion", ((Cliente) persona).getId(),
                    "correo", ((Cliente) persona).getEmail()
            );
        }

        return personaMap;
    }

    // Método para validar login de administradores
    public static boolean validarLoginAdministrador(String correo, String contrasenia) throws IOException {
        List<Administrador> listaAdministradores = leerPersonas(Administrador.class);

        // Buscar en la lista de administradores
        for (Administrador admin : listaAdministradores) {
            if (correo.equals(admin.getCorreo()) && contrasenia.equals(admin.getContrasenia())) {
                return true; // Login válido
            }
        }
        return false; // Login inválido
    }
}
