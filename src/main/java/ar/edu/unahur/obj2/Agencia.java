package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Profugo.Iprofugo;


public class Agencia {
    private List<Cazador> cazadores;

    public Agencia() {
        this.cazadores = new ArrayList<>();
    }

    public Agencia(List<Cazador> cazadores) {
        this.cazadores = cazadores;
    }

    public void procesoCaptura(Cazador cazador, Zona zona) {
        cazador.cazarEn(zona);
    }

    public void agregarCazador(Cazador cazador) {
        cazadores.add(cazador);
    }

    public List<Iprofugo> todosLosProfugosCapturados() {
       return cazadores.stream()
               .flatMap(cazador -> cazador.getProfugosCapturados().stream())
               .collect(Collectors.toList());
    }

    public Optional<Iprofugo> profugoMasHabilCapturado() {
        return todosLosProfugosCapturados().stream()
            .reduce((p1, p2) -> p1.getHabilidad() >= p2.getHabilidad() ? p1 : p2);
    }

    public Cazador cazadorConMasCapturas() {
        return cazadores.stream()
                .filter(c -> !c.getProfugosCapturados().isEmpty())
                .max(Comparator.comparingInt(c -> c.getProfugosCapturados().size()))
                .orElseThrow(() -> new IllegalStateException("No hay cazadores con profugos capturados"));
    }
}