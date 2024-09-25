package co.edu.uniquindio.poo.proyectojfx;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingExample {
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public LoggingExample() {
        try {
            // Configura el FileHandler para que registre en un archivo .txt
            FileHandler fileHandler = new FileHandler("app_log.txt", true); // true para agregar al archivo existente
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.severe("Error al configurar el logger: " + e.getMessage());
        }
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logWarning(String message) {
        logger.warning(message);
    }

    public void logSevere(String message) {
        logger.severe(message);
    }

}