package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Representa un club que gestiona sesiones de entrenamiento, miembros, entrenadores, deportes y administradores.
 */
public class Club {

    private List<SesionEntrenamiento> sesionesEntrenamiento;
    private String nombre;
    private List<Miembro> miembros;
    private List<Entrenador> entrenadores;
    private List<Deporte> deportes;
    private List<Administrador> administrativos;
    private List<SesionEntrenamiento> sesiones;

    /**
     * Constructor vacío.
     */
    public Club() {
    }

    /**
     * Constructor que inicializa el club con sesiones de entrenamiento, nombre y miembros.
     * @param sesionesEntrenamiento Listado de sesiones de entrenamiento.
     * @param nombre Nombre del club.
     * @param miembros Listado de miembros del club.
     */
    public Club(List<SesionEntrenamiento> sesionesEntrenamiento, String nombre, List<Miembro> miembros) {
        this.sesionesEntrenamiento = sesionesEntrenamiento;
        this.nombre = nombre;
        this.miembros = miembros;
    }

    public Club(List<SesionEntrenamiento> sesiones, String clubDeportivo, List<Miembro> miembros,
                List<Entrenador> entrenadores, List<Deporte> deportes, List<Administrador> administrativos) {
        this.sesiones = sesiones != null ? sesiones : new ArrayList<>();
        this.nombre = clubDeportivo != null ? clubDeportivo : "";
        this.miembros = miembros != null ? miembros : new ArrayList<>();
        this.entrenadores = entrenadores != null ? entrenadores : new ArrayList<>();
        this.deportes = deportes != null ? deportes : new ArrayList<>();
        this.administrativos = administrativos != null ? administrativos : new ArrayList<>();
    }

    // Getters y Setters

    public List<SesionEntrenamiento> getSesionesEntrenamiento() {
        return sesionesEntrenamiento;
    }

    public void setSesionesEntrenamiento(List<SesionEntrenamiento> sesionesEntrenamiento) {
        this.sesionesEntrenamiento = sesionesEntrenamiento;
    }

    public List<Administrador> getAdministrativos() {
        return administrativos;
    }

    public List<SesionEntrenamiento> getSesiones() {
        return sesiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    /**
     * Busca un entrenador por su nombre.
     * @param nombreEntrenador Nombre del entrenador a buscar.
     * @return El entrenador si se encuentra, o null si no existe.
     */
    public Entrenador buscarEntrenadorPorNombre(String nombreEntrenador) {
        return entrenadores.stream()
                .filter(entrenador -> entrenador.getNombre().equals(nombreEntrenador))
                .findFirst()
                .orElse(null);
    }

    /**
     * Busca un entrenador por su ID.
     * @param id ID del entrenador a buscar.
     * @return El entrenador si se encuentra, o null si no existe.
     */
    public Entrenador buscarEntrenadorPorId(String id) {
        return entrenadores.stream()
                .filter(entrenador -> entrenador.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene las sesiones de entrenamiento asociadas a un entrenador específico.
     * @param entrenador El entrenador cuyas sesiones se desean obtener.
     * @return Lista de sesiones de entrenamiento asociadas al entrenador.
     */
    public List<SesionEntrenamiento> sesionesEntrenamientoPorEntrenador(Entrenador entrenador) {
        return sesionesEntrenamiento.stream()
                .filter(sesion -> sesion.getEntrenador().equals(entrenador))
                .collect(Collectors.toList());
    }
    /**
     * Verifica si un administrador con el nombre y ID proporcionados existe en el club.
     * @param nombre Nombre del administrador.
     * @param id ID del administrador.
     * @return true si el administrador existe, false en caso contrario.
     */
    public boolean verificarAdministrador(String nombre, int id) {
        return administrativos.stream()
                .anyMatch(a -> a.getNombre().equals(nombre) && a.getId() == id);
    }

    public void setAdministrativos(List<Administrador> administrativos) {
        this.administrativos= administrativos;
    }

    public void setSesiones(List<SesionEntrenamiento> sesiones) {
        this.sesiones =sesiones;
    }
}
