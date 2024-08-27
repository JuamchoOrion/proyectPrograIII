package co.edu.uniquindio.poo.proyectojfx.Modelo;


import java.lang.reflect.Member;
import java.util.List;

public class Deporte {
    public Deporte(){
    }
    private String nombre;
    private String descripcion;
    private Dificultad dificultad;
    private List<Entrenador> entrenadores;
    private List<Miembro> miembros;

    public Deporte(String nombre, String descripcion, Dificultad dificultad, List<Entrenador> entrenadores, List<Miembro> miembros) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.entrenadores = entrenadores;
        this.miembros = miembros;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public void addMember(Miembro member){
        miembros.add(member);
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", dificultad=" + dificultad +
                ", cantidad de miembros=" + (miembros != null ? miembros.size() : 0) +
                ", cantidad de entrenadores=" + (entrenadores != null ? entrenadores.size() : 0) +
                '}';
    }
}

