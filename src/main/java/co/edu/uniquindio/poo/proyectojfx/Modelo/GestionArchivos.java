package co.edu.uniquindio.poo.proyectojfx.Modelo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class GestionArchivos {

        public static void main(String[] args) {
            // Definir la ruta del directorio
            String directorioBase = "C://Reportes_Java";

            // Crear el directorio si no existe
            File directorio = new File(directorioBase);
            if (!directorio.exists()) {
                boolean creado = directorio.mkdirs(); // Crear directorio
                if (creado) {
                    System.out.println("Directorio 'Reportes_Java' creado exitosamente.");
                } else {
                    System.out.println("Error al crear el directorio.");
                    return;
                }
            } else {
                System.out.println("El directorio ya existe.");
            }

            // Crear dos listas de entidades
            List<String> listaEntidades1 = new ArrayList<>();
            List<String> listaEntidades2 = new ArrayList<>();

            // Agregar elementos de ejemplo a las listas
            for (int i = 1; i <= 10; i++) {
                listaEntidades1.add("EntidadLista1-" + i);
                listaEntidades2.add("EntidadLista2-" + i);
            }

            // Crear los archivos y escribir las listas
            escribirListaEnArchivo(directorioBase + "/ListaEntidades1.txt", listaEntidades1);
            escribirListaEnArchivo(directorioBase + "/ListaEntidades2.txt", listaEntidades2);
        }

        public static void escribirListaEnArchivo(String nombreArchivo, List<String> lista) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(nombreArchivo));
                StringBuilder buffer = new StringBuilder();

                // Recorre la lista y escribe en el archivo cada 10 elementos
                for (int i = 0; i < lista.size(); i++) {
                    buffer.append(lista.get(i)).append("\n");

                    // Escribe en el archivo cada 10 elementos
                    if ((i + 1) % 10 == 0 || i == lista.size() - 1) {
                        writer.write(buffer.toString());
                        buffer.setLength(0);  // Limpiar el buffer
                    }
                }
                System.out.println("Archivo " + nombreArchivo + " escrito exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }


