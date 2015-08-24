package mph.tramitedoc.be;


import java.util.Date;
//@autor Sergio Medina


public class ExpedienteBE
 { 
private int IndOpSp;   private String edit;
    private String del;

 private int idexpediente;
 private int idusuariocargo;
 private int idprocedimiento;
 private int idarea;
 private String codigo;
 private String dni_ruc;
 private String nombre_razonsocial;
 private String apellidos;
 private String direccion;
 private String telefono;
 private String correo;
 private String asunto;
 private boolean estado;

public ExpedienteBE(){
this.IndOpSp = 0;
this.idexpediente = 0;
this.idusuariocargo = 0;
this.idprocedimiento = 0;
this.idarea = 0;
this.codigo = "";
this.dni_ruc = "";
this.nombre_razonsocial = "";
this.apellidos = "";
this.direccion = "";
this.telefono = "";
this.correo = "";
this.asunto = "";
this.estado = false;

}
public ExpedienteBE(int pIndOpSp,int pidexpediente,int pidusuariocargo,int pidprocedimiento,int pidarea,String pcodigo,String pdni_ruc,String pnombre_razonsocial,String papellidos,String pdireccion,String ptelefono,String pcorreo,String pasunto,boolean pestado)

{
this.IndOpSp = pIndOpSp;
this.idexpediente = pidexpediente;
this.idusuariocargo = pidusuariocargo;
this.idprocedimiento = pidprocedimiento;
this.idarea = pidarea;
this.codigo = pcodigo;
this.dni_ruc = pdni_ruc;
this.nombre_razonsocial = pnombre_razonsocial;
this.apellidos = papellidos;
this.direccion = pdireccion;
this.telefono = ptelefono;
this.correo = pcorreo;
this.asunto = pasunto;
this.estado = pestado;
}
 public int getIndOpSp() {
    return IndOpSp;
    }

public int getIdexpediente() {
return idexpediente;

 }
public int getIdusuariocargo() {
return idusuariocargo;

 }
public int getIdprocedimiento() {
return idprocedimiento;

 }
public int getIdarea() {
return idarea;

 }
public String getCodigo() {
return codigo;

 }
public String getDni_ruc() {
return dni_ruc;

 }
public String getNombre_razonsocial() {
return nombre_razonsocial;

 }
public String getApellidos() {
return apellidos;

 }
public String getDireccion() {
return direccion;

 }
public String getTelefono() {
return telefono;

 }
public String getCorreo() {
return correo;

 }
public String getAsunto() {
return asunto;

 }
public boolean isEstado() {
return estado;

 }
 public void setIndOpSp(int IndOpSp) {
     this.IndOpSp = IndOpSp;
    }

public void setIdexpediente(int idexpediente){

this.idexpediente = idexpediente;
}

public void setIdusuariocargo(int idusuariocargo){

this.idusuariocargo = idusuariocargo;
}

public void setIdprocedimiento(int idprocedimiento){

this.idprocedimiento = idprocedimiento;
}

public void setIdarea(int idarea){

this.idarea = idarea;
}

public void setCodigo(String codigo){

this.codigo = codigo;
}

public void setDni_ruc(String dni_ruc){

this.dni_ruc = dni_ruc;
}

public void setNombre_razonsocial(String nombre_razonsocial){

this.nombre_razonsocial = nombre_razonsocial;
}

public void setApellidos(String apellidos){

this.apellidos = apellidos;
}

public void setDireccion(String direccion){

this.direccion = direccion;
}

public void setTelefono(String telefono){

this.telefono = telefono;
}

public void setCorreo(String correo){

this.correo = correo;
}

public void setAsunto(String asunto){

this.asunto = asunto;
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
