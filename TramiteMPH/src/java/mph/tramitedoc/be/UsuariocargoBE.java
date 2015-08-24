package mph.tramitedoc.be;


import java.util.Date;
//@autor Sergio Medina


public class UsuariocargoBE
 { 
private int IndOpSp;   private String edit;
    private String del;

 private int idusuariocargo;
 private int idusuario;
 private int idcargo;
 private Date fechaasignado;
 private boolean estado;

public UsuariocargoBE(){
this.IndOpSp = 0;
this.idusuariocargo = 0;
this.idusuario = 0;
this.idcargo = 0;
this.fechaasignado = new Date();
this.estado = false;

}
public UsuariocargoBE(int pIndOpSp,int pidusuariocargo,int pidusuario,int pidcargo,Date pfechaasignado,boolean pestado)

{
this.IndOpSp = pIndOpSp;
this.idusuariocargo = pidusuariocargo;
this.idusuario = pidusuario;
this.idcargo = pidcargo;
this.fechaasignado = pfechaasignado;
this.estado = pestado;
}
 public int getIndOpSp() {
    return IndOpSp;
    }

public int getIdusuariocargo() {
return idusuariocargo;

 }
public int getIdusuario() {
return idusuario;

 }
public int getIdcargo() {
return idcargo;

 }
public Date  getFechaasignado() {
return fechaasignado;

 }
public boolean isEstado() {
return estado;

 }
 public void setIndOpSp(int IndOpSp) {
     this.IndOpSp = IndOpSp;
    }

public void setIdusuariocargo(int idusuariocargo){

this.idusuariocargo = idusuariocargo;
}

public void setIdusuario(int idusuario){

this.idusuario = idusuario;
}

public void setIdcargo(int idcargo){

this.idcargo = idcargo;
}

public void setFechaasignado(Date  fechaasignado){

this.fechaasignado = fechaasignado;
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
