package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugo.Profugo;

public class CazadorRural extends Cazador {

    @Override
    protected Boolean doCapturarEspecifico(Profugo profugo) {
        return profugo.esNervioso();
    }

    @Override
    protected void doIntimidaciónEspecifica(Profugo profugo) {
        profugo.volverseNervioso();
    }
   
}
