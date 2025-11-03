package ar.edu.unahur.obj2.Profugo;

public class ProteccionLegalProfugoDecorator extends ProfugoDecorator {

    public ProteccionLegalProfugoDecorator(Iprofugo profugo) {
        super(profugo);
    }

    @Override
    public Boolean doEsNervioso() {
        return profugo.esNervioso();
    }

    @Override
    public Integer doGetHabilidad() {
        return profugo.getHabilidad();
    }

    @Override
    public Integer doGetInocencia() {
        return Math.max(profugo.getInocencia(), 40);
    }
}



