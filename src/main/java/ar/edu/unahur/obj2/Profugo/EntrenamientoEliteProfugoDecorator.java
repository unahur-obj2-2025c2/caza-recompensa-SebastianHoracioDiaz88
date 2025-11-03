package ar.edu.unahur.obj2.Profugo;

public class EntrenamientoEliteProfugoDecorator extends ProfugoDecorator {

    public EntrenamientoEliteProfugoDecorator(Iprofugo profugo) {
        super(profugo);
    }

    @Override
    public Boolean doEsNervioso() {
        return Boolean.FALSE;
    }

    @Override
    public Integer doGetHabilidad() {
        return profugo.getHabilidad();
    }

    @Override
    public Integer doGetInocencia() {
        return profugo.getInocencia();
    }
}