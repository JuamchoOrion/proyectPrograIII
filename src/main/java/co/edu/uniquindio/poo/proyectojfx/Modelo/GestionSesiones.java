package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.time.LocalDate;

public interface GestionSesiones {
    SesionEntrenamiento crearSesion(LocalDate fechaInicio, double duracion, Estado estado, Deporte deporte, Entrenador entrenador);
    SesionEntrenamiento editarSesion(SesionEntrenamiento sesion ,LocalDate fechaInicio, double duracion, Estado estado, Deporte deporte, Entrenador entrenador);
    void eliminarSesion(Club club, SesionEntrenamiento sesionEntrenamiento);
    String mostrarSesion(SesionEntrenamiento sesion);
}
