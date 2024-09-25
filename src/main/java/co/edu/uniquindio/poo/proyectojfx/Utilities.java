package co.edu.uniquindio.poo.proyectojfx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Utilities {

    // Instancia única de la clase (para Singleton)
    private static Utilities instanciaUnica = null;

    // Logger que manejará los mensajes
    private static final Logger logger = Logger.getLogger(Utilities.class.getName());

    // Ruta base para los archivos de reportes
    private static final String DIRECTORIO_BASE = "C://Reportes_Java/";

    // Constructor privado para evitar que se creen instancias externas
    private Utilities() {
        try {
            // Configura el FileHandler para que registre en un archivo .txt
            FileHandler fileHandler = new FileHandler("app_log.txt", true); // true para agregar al archivo existente
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.severe("Error al configurar el logger: " + e.getMessage());
        }
    }

    // Método estático para obtener la instancia única (Singleton)
    public static Utilities getInstance() {
        if (instanciaUnica == null) {
            synchronized (Utilities.class) {
                if (instanciaUnica == null) {
                    instanciaUnica = new Utilities();
                }
            }
        }
        return instanciaUnica;
    }

    // Métodos para escribir en el log con diferentes niveles de severidad

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logWarning(String message) {
        logger.warning(message);
    }

    public void logSevere(String message) {
        logger.severe(message);
    }

    // Método para verificar o crear el directorio "C://Reportes_Java"
    private void verificarOCrearDirectorio() throws IOException {
        File directorio = new File(DIRECTORIO_BASE);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                logInfo("Directorio creado: " + DIRECTORIO_BASE);
            } else {
                logSevere("No se pudo crear el directorio: " + DIRECTORIO_BASE);
                throw new IOException("No se pudo crear el directorio: " + DIRECTORIO_BASE);
            }
        } else {
            logInfo("El directorio ya existe: " + DIRECTORIO_BASE);
        }
    }

    // Método para escribir una lista en un archivo, cada 10 elementos
    public void escribirListaEnArchivo(String nombreArchivo, List<?> lista) throws IOException {
        verificarOCrearDirectorio();  // Asegura que el directorio exista

        File archivo = new File(DIRECTORIO_BASE + nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            int contador = 0;
            for (Object elemento : lista) {
                writer.write(elemento.toString());
                writer.newLine();
                contador++;

                if (contador == 10) {
                    writer.flush();    // Optimiza el uso de recursos
                    contador = 0;
                }
            }
            writer.flush(); // Escribe lo que queda si es menor a 10
            logInfo("Archivo escrito con éxito: " + nombreArchivo);
        } catch (IOException e) {
            logSevere("Error al escribir en el archivo: " + nombreArchivo + ". Error: " + e.getMessage());
            throw e;
        }
    }

    // Métodos adicionales para generar archivos específicos
    public void generarArchivoMiembros(List<?> miembros) throws IOException {
        escribirListaEnArchivo("miembros.txt", miembros);
    }

    public void generarArchivoDeportes(List<?> deportes) throws IOException {
        escribirListaEnArchivo("deportes.txt", deportes);
    }
}
