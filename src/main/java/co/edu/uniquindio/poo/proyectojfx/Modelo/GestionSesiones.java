package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.time.LocalDate;

public interface GestionSesiones {
    SesionEntrenamiento crearSesion(String fechaInicio, double duracion, Estado estado, Deporte deporte, Entrenador entrenador);
    SesionEntrenamiento editarSesion(SesionEntrenamiento sesion ,String fechaInicio, double duracion, Estado estado, Deporte deporte, Entrenador entrenador);
    void eliminarSesion(Club club, SesionEntrenamiento sesionEntrenamiento);
    String mostrarSesion(SesionEntrenamiento sesion);
}
