package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugo.Iprofugo;

public class Zona {
    
    private final String nombre;
    private List<Iprofugo> profugos;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.profugos = new ArrayList<>();
    }

    public Zona(String nombre, List<Iprofugo> profugos) {
        this.nombre = nombre;
        this.profugos = profugos;
    }

    public void agregarProfugo(Iprofugo profugo) {
        profugos.add(profugo);
    }

    public void quitarProfugo(Iprofugo profugo) {
        this.profugos.remove(profugo);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Iprofugo> getProfugos() {
        return List.copyOf(profugos);
    }

    public void vaciarProfugos() {
        profugos.clear();
    }



}