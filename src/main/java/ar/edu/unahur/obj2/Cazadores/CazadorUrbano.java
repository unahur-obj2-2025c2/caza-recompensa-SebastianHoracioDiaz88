package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugo.Iprofugo;


public class CazadorUrbano extends Cazador {

    public CazadorUrbano(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean doCapturarEspecifico(Iprofugo p) {
        return !p.esNervioso();
    }

    @Override
    public void doIntimidacionEspecifica(Iprofugo p) {
        p.dejarDeEstarNervioso();
    }
}
