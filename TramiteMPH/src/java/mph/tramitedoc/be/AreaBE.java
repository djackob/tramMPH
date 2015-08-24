package mph.tramitedoc.be;


import java.util.Date;
//@autor Sergio Medina


public class AreaBE
 { 
private int IndOpSp;   private String edit;
    private String del;

 private int idarea;
 private String denominacion;
 private boolean estado;

public AreaBE(){
this.IndOpSp = 0;
this.idarea = 0;
this.denominacion = "";
this.estado = false;

}
public AreaBE(int pIndOpSp,int pidarea,String pdenominacion,boolean pestado)

{
this.IndOpSp = pIndOpSp;
this.idarea = pidarea;
this.denominacion = pdenominacion;
this.estado = pestado;
}
 public int getIndOpSp() {
    return IndOpSp;
    }

public int getIdarea() {
return idarea;

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

public void setIdarea(int idarea){

this.idarea = idarea;
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
