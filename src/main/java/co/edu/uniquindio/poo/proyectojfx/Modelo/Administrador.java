package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.time.LocalDate;
import java.util.List;

public class Administrador implements GestionSesiones, GestionEntrenadores, GestionMiembros, GestionDeportes {
    private String nombre;
    private int id;

    public Administrador() {
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Implementación de métodos de Gestión de Sesiones
    @Override
    public SesionEntrenamiento crearSesion(LocalDate fechaInicio, double duracion, Estado estado, Deporte deporte, Entrenador entrenador) {
        return new SesionEntrenamiento(fechaInicio, duracion, estado, deporte, entrenador);
    }

    @Override
    public SesionEntrenamiento editarSesion(SesionEntrenamiento sesion, LocalDate fechaInicio, double duracion, Estado estado, Deporte deporte, Entrenador entrenador) {
        sesion.setFechaInicio(fechaInicio);
        sesion.setDuracion(duracion);
        sesion.setEstado(estado);
        sesion.setDeporte(deporte);
        sesion.setEntrenador(entrenador);
        return sesion;
    }

    @Override
    public void eliminarSesion(Club club, SesionEntrenamiento sesionEntrenamiento) {
        if (club.getSesionesEntrenamiento().contains(sesionEntrenamiento)) {
            club.getSesionesEntrenamiento().remove(sesionEntrenamiento);
        } else {
            throw new IllegalArgumentException("La sesión no existe.");
        }
    }

    @Override
    public String mostrarSesion(SesionEntrenamiento sesion) {
        return sesion.toString();
    }

    // Método para inscribir a miembros
    public void inscribirMiembro(Miembro miembro, Deporte deporte) {
        if (miembro instanceof Joven && deporte.getDificultad().equals(Dificultad.ALTO)) {
            throw new IllegalArgumentException("Un joven no puede inscribirse en deportes de alta dificultad.");
        } else {
            deporte.addMember(miembro);
        }
    }

    // Implementación de métodos de Gestión de Deportes
    @Override
    public Deporte crearDeporte(String nombre, String descripcion, Dificultad dificultad, List<Entrenador> entrenadores, List<Miembro> miembros) {
        Deporte deporte = new Deporte(nombre,descripcion,dificultad,entrenadores,miembros);
        return  deporte;
    }

    @Override
    public Deporte actualizarDeporte(String nombre, String descripcion, Dificultad dificultad, List<Entrenador> entrenadores, List<Miembro> miembros) {
        Deporte deporte = new Deporte();
        deporte.setNombre(nombre);
        deporte.setDescripcion(descripcion);
        deporte.setDificultad(dificultad);
        deporte.setEntrenadores(entrenadores);
        return deporte;
    }

    @Override
    public void eliminarDeporte(Club club, Deporte deporte) {
        if (club.getDeportes().contains(deporte)) {
            club.getDeportes().remove(deporte);
        } else {
            throw new IllegalArgumentException("El deporte no existe.");
        }
    }

    @Override
    public String mostrarDeporte(Deporte deporte) {
        return deporte.toString();
    }

    // Implementación de métodos de Gestión de Entrenadores
    @Override
    public Entrenador crearEntrenador(String nombre, Deporte especialidad, List<SesionEntrenamiento> sesionesEntrenamiento, String id) {
        return new Entrenador(nombre, especialidad, sesionesEntrenamiento, id);
    }

    @Override
    public void eliminarEntrenador(Club club, String id) {
        Entrenador entrenador =club.buscarEntrenadorPorId(id);
        if (club.getEntrenadores().contains(entrenador)) {
            club.getEntrenadores().remove(entrenador);
        } else {
            throw new IllegalArgumentException("El Entrenador no existe.");
        }
    }

    @Override
    public Entrenador actualizarEntrenador(Entrenador entrenador,String nombre, Deporte especialidad, List<SesionEntrenamiento> sesionesEntrenamiento, String id) {
        entrenador.setNombre(nombre);
        entrenador.setEspecialidad(especialidad);
        entrenador.setSesionesEntrenamiento(sesionesEntrenamiento);
        entrenador.setId(id);
        return entrenador;
    }

    @Override
    public String  mostrarEntrenador(Entrenador entrenador) {
        return entrenador.toString();
    }

    // Implementación de métodos de Gestión de Miembros
    @Override
    public Miembro crearMiembro(String nombre, String direccionCorreo, int id, boolean esJoven) {
        if(esJoven){
            return new Joven(nombre,direccionCorreo,id);
        }
        else{
            return  new Adulto(nombre, direccionCorreo, id);
        }
    }

    @Override
    public Miembro actualizarMiembro(Miembro miembro, String nombre, String direccionCorreo, int id) {
        miembro.setNombre(nombre);
        miembro.setId(id);
        miembro.setDireccionCorreo(direccionCorreo);
        return miembro;
    }

    @Override
    public void eliminarMiembro(Club club, Miembro miembro) {
        if (club.getMiembros().contains(miembro)) {
            club.getMiembros().remove(miembro);
        } else {
            throw new IllegalArgumentException("El miembro no existe.");
        }
    }

    @Override
    public String mostrarMiembro(Miembro miembro) {
        // Implementar la lógica para mostrar un miembro
        return miembro.toString();
    }
}
