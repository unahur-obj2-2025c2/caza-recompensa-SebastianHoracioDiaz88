package ar.edu.unahur.obj2.Cazadores;

import java.util.ArrayList;
import java.util.List;


import ar.edu.unahur.obj2.Zona;
import ar.edu.unahur.obj2.Profugo.Iprofugo;

public abstract class Cazador {
   
    protected Integer experiencia;
    protected List<Iprofugo> profugo;

    public Cazador(Integer experiencia) {
        this.experiencia = experiencia;
        this.profugo = new ArrayList<>();
    }

    public void cazarEn(Zona zona){
        List<Iprofugo> intimidados = new ArrayList<>();
        zona.getProfugos().stream().forEach(p -> {
            if(puedeCapturar(p)){
                zona.agregarProfugo(p);
                zona.quitarProfugo(p);
            } else {
                intimidar(p);
                intimidados.add(p);
            }
        });

        sumarExperiencia(intimidados);
        
    }

    public Boolean puedeCapturarGeneral(Iprofugo p) {

        return experiencia > p.getInocencia();

    }

    public Boolean puedeCapturar(Iprofugo p) {

        return puedeCapturarGeneral(p) && puedeCapturarEspecifico (p) ;

    }

    public Boolean puedeCapturarEspecifico (Iprofugo p) {

        return doCapturarEspecifico(p);

    }
    
    public void intimidacionEspecifica (Iprofugo p) {
        doIntimidaciónEspecifica (p);
    }

    
    public void intimidar(Iprofugo p) {
        p.disminuirInocencia();
        intimidacionEspecifica(p);
    }

    private void sumarExperiencia(List<Iprofugo> intimidados) {
        Integer minimaHabilidad = Integer.valueOf(
        intimidados.stream()
                .mapToInt(Iprofugo::getHabilidad)
                .min()
                .orElse(0)
        );               // si la lista está vacía, devuelve 0

        experiencia += minimaHabilidad + 2 * intimidados.size();
    }
       
    protected abstract void doIntimidaciónEspecifica(Iprofugo p);

    protected abstract Boolean doCapturarEspecifico(Iprofugo p);


    
}
