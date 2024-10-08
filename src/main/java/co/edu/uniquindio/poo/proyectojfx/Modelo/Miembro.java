package co.edu.uniquindio.poo.proyectojfx.Modelo;


public abstract class Miembro {
    public Miembro() {
    }
    private String nombre;
    private String direccionCorreo;
    private int id;

    public Miembro(String nombre, String direccionCorreo, int id) {
        this.nombre = nombre;
        this.direccionCorreo = direccionCorreo;
        this.id =id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Miembro{" +
                "nombre='" + nombre + '\'' +
                ", direcciónCorreo='" + direccionCorreo + '\'' +
                ", id=" + id +
                '}';
    }
}
