package mph.tramitedoc.be;


import java.util.Date;
//@autor Sergio Medina


public class UsuarioBE
 { 
private int IndOpSp;   private String edit;
    private String del;

 private int idusuario;
 private String nombres;
 private String apellidos;
 private String dni;
 private String direccion;
 private String telefono;
 private String usuario;
 private String password;
 private boolean estado;

public UsuarioBE(){
this.IndOpSp = 0;
this.idusuario = 0;
this.nombres = "";
this.apellidos = "";
this.dni = "";
this.direccion = "";
this.telefono = "";
this.usuario = "";
this.password = "";
this.estado = false;

}
public UsuarioBE(int pIndOpSp,int pidusuario,String pnombres,String papellidos,String pdni,String pdireccion,String ptelefono,String pusuario,String ppassword,boolean pestado)

{
this.IndOpSp = pIndOpSp;
this.idusuario = pidusuario;
this.nombres = pnombres;
this.apellidos = papellidos;
this.dni = pdni;
this.direccion = pdireccion;
this.telefono = ptelefono;
this.usuario = pusuario;
this.password = ppassword;
this.estado = pestado;
}
 public int getIndOpSp() {
    return IndOpSp;
    }

public int getIdusuario() {
return idusuario;

 }
public String getNombres() {
return nombres;

 }
public String getApellidos() {
return apellidos;

 }
public String getDni() {
return dni;

 }
public String getDireccion() {
return direccion;

 }
public String getTelefono() {
return telefono;

 }
public String getUsuario() {
return usuario;

 }
public String getPassword() {
return password;

 }
public boolean isEstado() {
return estado;

 }
 public void setIndOpSp(int IndOpSp) {
     this.IndOpSp = IndOpSp;
    }

public void setIdusuario(int idusuario){

this.idusuario = idusuario;
}

public void setNombres(String nombres){

this.nombres = nombres;
}

public void setApellidos(String apellidos){

this.apellidos = apellidos;
}

public void setDni(String dni){

this.dni = dni;
}

public void setDireccion(String direccion){

this.direccion = direccion;
}

public void setTelefono(String telefono){

this.telefono = telefono;
}

public void setUsuario(String usuario){

this.usuario = usuario;
}

public void setPassword(String password){

this.password = password;
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
