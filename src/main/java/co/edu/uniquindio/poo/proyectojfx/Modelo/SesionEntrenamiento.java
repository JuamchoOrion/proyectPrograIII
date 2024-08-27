package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.time.LocalDate;

public class SesionEntrenamiento {
    private LocalDate fechaInicio;
    private double duracion;
    private Estado estado;
    private Deporte deporte;
    private Entrenador entrenador;

    public SesionEntrenamiento(LocalDate fechaInicio, double duracion, Estado estado, Deporte deporte, Entrenador entrenador) {
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.estado = estado;
        this.deporte = deporte;
        this.entrenador = entrenador;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    @Override
    public String toString() {
        return "SesionEntrenamiento{" +
                "fechaInicio=" + fechaInicio +
                ", duracion=" + duracion +
                ", estado=" + estado +
                ", deporte=" + deporte +
                ", entrenador=" + entrenador +
                '}';
    }
}
