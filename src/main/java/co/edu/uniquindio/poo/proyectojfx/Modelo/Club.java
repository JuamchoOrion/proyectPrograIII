package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.util.List;

public class Club {
    private List<SesionEntrenamiento> sesionesEntrenamieno;
    private String nombre;
    private List<Miembro> miembros;
    private List<Entrenador> entrenadores;
    private List<Deporte> deportes;
    private List<Administrador> administrativos;

    public Club() {
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public Club(List<SesionEntrenamiento> sesionesEntrenamieno, String nombre, List<Miembro> miembros) {
        this.sesionesEntrenamieno = sesionesEntrenamieno;
        this.nombre = nombre;
        this.miembros = miembros;
    }

    public List<SesionEntrenamiento> getSesionesEntrenamieno() {
        return sesionesEntrenamieno;
    }

    public void setSesionesEntrenamieno(List<SesionEntrenamiento> sesionesEntrenamieno) {
        this.sesionesEntrenamieno = sesionesEntrenamieno;
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

    public Entrenador buscarEntrenadorPorNombre(String nombreEntrenador) {
        return entrenadores.stream()
                .filter(entrenador -> entrenador.getNombre().equals(nombreEntrenador))
                .findFirst() // Obtiene un Optional con el primer resultado coincidente
                .orElse(null); // Retorna null si no se encuentra ningún entrenador
    }
    public Entrenador buscarEntrenadorPorId(String id) {
        return entrenadores.stream()
                .filter(entrenador -> entrenador.getId().equals(id))
                .findFirst() // Obtiene un Optional con el primer resultado coincidente
                .orElse(null); // Retorna null si no se encuentra ningún entrenador
    }


    public boolean verificarAdministrador(String nombre, int id) {
        return administrativos.stream()
                .anyMatch(a -> a.getNombre().equals(nombre) && a.getId() == id);
    }


}
