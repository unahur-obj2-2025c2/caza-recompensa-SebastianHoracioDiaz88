package ar.edu.unahur.obj2.Profugo;

public class Profugo implements Iprofugo{
  
    private Integer inocencia;
    private Integer habilidad;
    private Boolean esNervioso;

    public Profugo(Integer inocencia, Integer habilidad, Boolean esNervioso) {
        this.inocencia = inocencia;
        this.habilidad = habilidad;
        this.esNervioso = esNervioso;
    }

    @Override
    public Integer getInocencia() {
        return inocencia;
    }
    @Override
    public Integer getHabilidad() {
        return habilidad;
    }
    @Override
    public Boolean esNervioso() {
        return esNervioso;
    }
    @Override
    public void volverseNervioso() {
        esNervioso = Boolean.valueOf(true);
    }
    @Override
    public void dejarDeEstarNervioso() {
        esNervioso = Boolean.valueOf(false);
    }
    @Override
    public void reducirHabilidad() {
        habilidad  = Math.max(1, habilidad - 5);
    }
    @Override
    public void disminuirInocencia() {
        inocencia = Math.max(0, inocencia - 2);
    }

}


