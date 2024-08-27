package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.util.List;

public interface GestionEntrenadores {
    Entrenador crearEntrenador(String Nombre, Deporte especialidad, List<SesionEntrenamiento> sesionesEntrenamiento, String id);
    void eliminarEntrenador(Club club, String id);
    Entrenador actualizarEntrenador(Entrenador entrenador,String Nombre, Deporte especialidad, List<SesionEntrenamiento> sesionesEntrenamiento, String id);
    String  mostrarEntrenador(Entrenador entrenador);
}
