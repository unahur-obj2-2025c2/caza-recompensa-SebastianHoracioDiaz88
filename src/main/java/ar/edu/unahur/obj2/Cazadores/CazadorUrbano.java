package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugo.Iprofugo;


public class CazadorUrbano extends Cazador {

    public CazadorUrbano(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public void doIntimidaciónEspecifica(Iprofugo p) {
        p.dejarDeEstarNervioso();
    }

    @Override
    public Boolean doCapturarEspecifico(Iprofugo p) {
        return !p.esNervioso();
    }
}

