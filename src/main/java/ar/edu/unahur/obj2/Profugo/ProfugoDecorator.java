package ar.edu.unahur.obj2.Profugo;

public abstract class ProfugoDecorator implements Iprofugo {

    protected Iprofugo profugo;

    public ProfugoDecorator(Iprofugo profugo) {
        this.profugo = profugo;
    }

    @Override
    public void dejarDeEstarNervioso() {
       profugo.dejarDeEstarNervioso();
    }
    
    @Override
    public void disminuirInocencia() {
        profugo.disminuirInocencia();    
    }

    @Override
    public Boolean esNervioso() {
        return doEsNervioso();
    }

    public abstract Boolean doEsNervioso();

    @Override
    public Integer getHabilidad() {
        return doGetHabilidad();
    }

    public abstract Integer doGetHabilidad();

    @Override
    public Integer getInocencia() {
        return doGetInocencia();
    }

    public abstract Integer doGetInocencia();

    @Override
    public void reducirHabilidad() {
       profugo.reducirHabilidad();    
    }

    @Override
    public void volverseNervioso() {
        profugo.volverseNervioso();       
    }
}