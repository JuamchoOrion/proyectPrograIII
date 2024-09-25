package co.edu.uniquindio.poo.proyectojfx.Modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//Agregar ID
public class Entrenador implements Serializable {
    private String nombre;
    private Deporte especialidad;
    private List<SesionEntrenamiento> sesionesEntrenamiento;
    private String id;
    private static final long serialVersionUID = 1L;

    public Entrenador() {
    }
    public Entrenador(String nombre, Deporte especialidad, List<SesionEntrenamiento> sesionesEntrenamiento, String id) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.sesionesEntrenamiento = sesionesEntrenamiento != null ? sesionesEntrenamiento : new ArrayList<>();
        this.id = id;
    }

    public Entrenador(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return  id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Deporte getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Deporte especialidad) {
        this.especialidad = especialidad;
    }

    public List<SesionEntrenamiento> getSesionesEntrenamiento() {
        return sesionesEntrenamiento;
    }

    public void setSesionesEntrenamiento(List<SesionEntrenamiento> sesionesEntrenamiento) {
        this.sesionesEntrenamiento = sesionesEntrenamiento;
    }

    public void addSesion(SesionEntrenamiento sesion){
        sesionesEntrenamiento.add(sesion);
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad +
                ", id='" + id + '\'' +
                '}';
    }

}