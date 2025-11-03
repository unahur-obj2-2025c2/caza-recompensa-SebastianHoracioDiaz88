package ar.edu.unahur.obj2.Profugo;

public class ArteMarcialProfugoDecorator extends ProfugoDecorator {

    public ArteMarcialProfugoDecorator(Iprofugo profugo) {
        super(profugo);
    }

    @Override
    public Integer doGetHabilidad() {
        return Math.min(100, profugo.getHabilidad() * 2);
    }

    @Override
    public Boolean doEsNervioso() {
        return profugo.esNervioso();
    }

    @Override
    public Integer doGetInocencia() {
        return profugo.getInocencia();
    }
}
