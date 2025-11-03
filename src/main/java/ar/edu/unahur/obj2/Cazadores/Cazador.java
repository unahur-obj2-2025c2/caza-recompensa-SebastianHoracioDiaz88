package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Zona;
import ar.edu.unahur.obj2.Profugo.Iprofugo;

public abstract class Cazador {

    protected Integer experiencia;
    protected List<Iprofugo> profugosCapturados;

    public Cazador(Integer experiencia) {
        this.experiencia = experiencia;
        this.profugosCapturados = new ArrayList<>();
    }

    public void cazarEn(Zona zona){
        List<Iprofugo> intimidados = new ArrayList<>();
        List<Iprofugo> capturados = new ArrayList<>();

        for(Iprofugo p : zona.getProfugos()) {
            if(puedeCapturar(p)) {
                capturados.add(p);
                profugosCapturados.add(p);
            } else {
                intimidar(p);
                intimidados.add(p);
            }
        }

        capturados.forEach(zona::quitarProfugo);

        sumarExperiencia(intimidados);
    }

    public Boolean puedeCapturarGeneral(Iprofugo p) {
        return experiencia > p.getInocencia();
    }

    public Boolean puedeCapturar(Iprofugo p) {
        return puedeCapturarGeneral(p) && puedeCapturarEspecifico(p);
    }

    public Boolean puedeCapturarEspecifico(Iprofugo p) {
        return doCapturarEspecifico(p);
    }

    public void intimidar(Iprofugo p) {
        p.disminuirInocencia();
        doIntimidacionEspecifica(p);
    }

    private void sumarExperiencia(List<Iprofugo> intimidados) {
        Integer minimaHabilidad = intimidados.stream()
                .mapToInt(Iprofugo::getHabilidad)
                .min()
                .orElse(0);

        experiencia += minimaHabilidad + 2 * intimidados.size();
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public List<Iprofugo> getProfugosCapturados() {
        return profugosCapturados;
    }

    // Métodos abstractos para cada tipo de cazador
    public abstract Boolean doCapturarEspecifico(Iprofugo p);

    public abstract void doIntimidacionEspecifica(Iprofugo p);
}