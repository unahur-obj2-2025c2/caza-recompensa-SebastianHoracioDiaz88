package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugo.Profugo;

public abstract class Cazador {
   
    private Integer experiencia;


    public void cazar(Profugo profugo){
        if (puedeCapturar(profugo)){

         //   experiencia += (Mínimo valor de habilidad entre todos los intimidados ) + ( 2 * prófugos capturados)

        }
        else {
            profugo.disminuirInocencia();
            intimidacionEspecifica(profugo);
        }
    }

    public Boolean puedeCapturarGeneral(Profugo profugo) {

        return experiencia > profugo.getInocencia();

    }

    public Boolean puedeCapturar(Profugo profugo) {

        return puedeCapturarGeneral(profugo) && puedeCapturarEspecifico (profugo) ;

    }

    public Boolean puedeCapturarEspecifico (Profugo profugo) {

        return doCapturarEspecifico(profugo);

    }
    
    public void intimidacionEspecifica (Profugo profugo) {
        doIntimidaciónEspecifica (profugo);
    }

    protected abstract void doIntimidaciónEspecifica(Profugo profugo);

    protected abstract Boolean doCapturarEspecifico(Profugo profugo);
    
}
