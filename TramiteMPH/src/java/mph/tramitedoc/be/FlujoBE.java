package mph.tramitedoc.be;


import java.util.Date;
//@autor Sergio Medina


public class FlujoBE
 { 
private int IndOpSp;   private String edit;
    private String del;

 private int idflujo;
 private int idexpediente;
 private int idestadoflujo;
 private int idusuario;
 private int idusuarioenvia;
 private int idusuariorecepciona;
 private Date fechaenvio;
 private Date fechalectura;
 private String asunto;
 private String descripcion;
 private String observacion;
 private boolean binderror;
 private boolean estado;

public FlujoBE(){
this.IndOpSp = 0;
this.idflujo = 0;
this.idexpediente = 0;
this.idestadoflujo = 0;
this.idusuario = 0;
this.idusuarioenvia = 0;
this.idusuariorecepciona = 0;
this.fechaenvio = new Date();
this.fechalectura = new Date();
this.asunto = "";
this.descripcion = "";
this.observacion = "";
this.binderror = false;
this.estado = false;

}
public FlujoBE(int pIndOpSp,int pidflujo,int pidexpediente,int pidestadoflujo,int pidusuario,int pidusuarioenvia,int pidusuariorecepciona,Date pfechaenvio,Date pfechalectura,String pasunto,String pdescripcion,String pobservacion,boolean pbinderror,boolean pestado)

{
this.IndOpSp = pIndOpSp;
this.idflujo = pidflujo;
this.idexpediente = pidexpediente;
this.idestadoflujo = pidestadoflujo;
this.idusuario = pidusuario;
this.idusuarioenvia = pidusuarioenvia;
this.idusuariorecepciona = pidusuariorecepciona;
this.fechaenvio = pfechaenvio;
this.fechalectura = pfechalectura;
this.asunto = pasunto;
this.descripcion = pdescripcion;
this.observacion = pobservacion;
this.binderror = pbinderror;
this.estado = pestado;
}
 public int getIndOpSp() {
    return IndOpSp;
    }

public int getIdflujo() {
return idflujo;

 }
public int getIdexpediente() {
return idexpediente;

 }
public int getIdestadoflujo() {
return idestadoflujo;

 }
public int getIdusuario() {
return idusuario;

 }
public int getIdusuarioenvia() {
return idusuarioenvia;

 }
public int getIdusuariorecepciona() {
return idusuariorecepciona;

 }
public Date  getFechaenvio() {
return fechaenvio;

 }
public Date  getFechalectura() {
return fechalectura;

 }
public String getAsunto() {
return asunto;

 }
public String getDescripcion() {
return descripcion;

 }
public String getObservacion() {
return observacion;

 }
public boolean isBinderror() {
return binderror;

 }
public boolean isEstado() {
return estado;

 }
 public void setIndOpSp(int IndOpSp) {
     this.IndOpSp = IndOpSp;
    }

public void setIdflujo(int idflujo){

this.idflujo = idflujo;
}

public void setIdexpediente(int idexpediente){

this.idexpediente = idexpediente;
}

public void setIdestadoflujo(int idestadoflujo){

this.idestadoflujo = idestadoflujo;
}

public void setIdusuario(int idusuario){

this.idusuario = idusuario;
}

public void setIdusuarioenvia(int idusuarioenvia){

this.idusuarioenvia = idusuarioenvia;
}

public void setIdusuariorecepciona(int idusuariorecepciona){

this.idusuariorecepciona = idusuariorecepciona;
}

public void setFechaenvio(Date  fechaenvio){

this.fechaenvio = fechaenvio;
}

public void setFechalectura(Date  fechalectura){

this.fechalectura = fechalectura;
}

public void setAsunto(String asunto){

this.asunto = asunto;
}

public void setDescripcion(String descripcion){

this.descripcion = descripcion;
}

public void setObservacion(String observacion){

this.observacion = observacion;
}

public void setBinderror(boolean binderror){

this.binderror = binderror;
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
