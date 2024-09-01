package co.edu.uniquindio.poo.proyectojfx.Modelo;

import java.util.ArrayList;
import java.util.List;

public class DatosIniciales {

    public static Club crearClubConDatosIniciales() {
        List<Miembro> miembros = new ArrayList<>();
        miembros.add(new Joven("Juan","juan@",1234));
        miembros.add(new Adulto("David","david.com",5678));
        List<Deporte> deportes = new ArrayList<>();
        Deporte d1 = new Deporte("Volleybol","balon",Dificultad.MEDIO);
        deportes.add(d1);
        Deporte d2=new Deporte("Futbol","balon",Dificultad.MEDIO);
        deportes.add(d2);
        Deporte d3 = new Deporte("Box","Cuerpo a cuerpo",Dificultad.ALTO);
        deportes.add(d3);
        List<Entrenador> entrenadores = new ArrayList<>();
        Entrenador e1 = new Entrenador("Francisco","2468");
        entrenadores.add(e1);
        Entrenador e2 = new Entrenador("Gloria","1357");
        entrenadores.add(e2);

        List<SesionEntrenamiento> sesiones = new ArrayList<>();
        SesionEntrenamiento s1 = new SesionEntrenamiento("septiembre 1",60, Estado.PROGRAMADA,d1,e1);
        SesionEntrenamiento s2 = new SesionEntrenamiento("septiembre 1",60, Estado.PROGRAMADA,d1,e2);
        sesiones.add(s1);
        sesiones.add(s2);

        List<Administrador> administrativos = new ArrayList<>();
        Administrador a1 = new Administrador ("Pedro",2789);
        administrativos.add(a1);
        Administrador a2 = new Administrador("Laura", 8888);
        administrativos.add(a2);

        Club club = new Club(sesiones, "Club Deportivo", miembros, entrenadores, deportes, administrativos);
        club.setEntrenadores(entrenadores);
        club.setDeportes(deportes);
        club.setAdministrativos(administrativos);
        club.setSesiones(sesiones);
        club.setMiembros(miembros);
        club.setNombre("JavaDictos");
        d1.addMember(new Joven("jhon","juan@",1234));
        d2.addMember(new Joven("Lala","la@",1234));
        return club;
    }
}

