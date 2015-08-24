package mph.tramitedoc.be;


import java.util.Date;
//@autor Sergio Medina


public class CargoBE
 { 
private int IndOpSp;   private String edit;
    private String del;

 private int idcargo;
 private String denominacion;
 private boolean estado;

public CargoBE(){
this.IndOpSp = 0;
this.idcargo = 0;
this.denominacion = "";
this.estado = false;

}
public CargoBE(int pIndOpSp,int pidcargo,String pdenominacion,boolean pestado)

{
this.IndOpSp = pIndOpSp;
this.idcargo = pidcargo;
this.denominacion = pdenominacion;
this.estado = pestado;
}
 public int getIndOpSp() {
    return IndOpSp;
    }

public int getIdcargo() {
return idcargo;

 }
public String getDenominacion() {
return denominacion;

 }
public boolean isEstado() {
return estado;

 }
 public void setIndOpSp(int IndOpSp) {
     this.IndOpSp = IndOpSp;
    }

public void setIdcargo(int idcargo){

this.idcargo = idcargo;
}

public void setDenominacion(String denominacion){

this.denominacion = denominacion;
}

public void setEstado(boolean estado){

this.estado = estado;
}

   public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }}
