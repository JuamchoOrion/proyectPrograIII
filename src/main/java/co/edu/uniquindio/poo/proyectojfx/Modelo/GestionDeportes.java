package co.edu.uniquindio.poo.proyectojfx.Modelo;
import java.util.List;

public interface GestionDeportes {
    Deporte crearDeporte(String nombre, String descripcion, Dificultad dificultad, List<Entrenador> entrenadores, List<Miembro> miembros);
    Deporte actualizarDeporte(String nombre, String descripcion, Dificultad dificultad, List<Entrenador> entrenadores, List<Miembro> miembros);
    void eliminarDeporte(Club club, Deporte deporte);
    String mostrarDeporte(Deporte deporte);
}
