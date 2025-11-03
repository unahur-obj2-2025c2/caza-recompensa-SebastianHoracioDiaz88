package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugo.Profugo;

public class CazadorSigiloso extends Cazador {

    @Override
    protected Boolean doCapturarEspecifico(Profugo profugo) {
        return profugo.getHabilidad() < 50;
    }

    @Override
    protected void doIntimidaciónEspecifica(Profugo profugo) {
        profugo.reducirHabilidad();
    }

}
