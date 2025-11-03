package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugo.Iprofugo;


public class CazadorSigiloso extends Cazador {

    public CazadorSigiloso(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean doCapturarEspecifico(Iprofugo p) {
        return p.getHabilidad() < 50;
    }

    @Override
    public void doIntimidacionEspecifica(Iprofugo p) {
        p.reducirHabilidad();
    }
}