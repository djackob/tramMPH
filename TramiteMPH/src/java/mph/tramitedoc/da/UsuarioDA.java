package mph.tramitedoc.da;


//@autor Sergio Medina


import mph.tramitedoc.be.UsuarioBE;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class UsuarioDA extends BaseDA {
	String cadenaConexion;
	String DriverConnection;
	String user;
	String password;
public UsuarioDA(){
	cadenaConexion = super.getConnectionString();
	DriverConnection = super.getDriverConnection();
	user = super.getUser();
	password = super.getPassword();    
}
 public UsuarioBE listarUsuarioBE(UsuarioBE oUsuarioBE1) throws SQLException {
	UsuarioBE oUsuarioBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	oUsuarioBE=new UsuarioBE();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
if(oUsuarioBE1.getIndOpSp()==1){

	String sql = " SELECT idusuario,nombres,apellidos,dni,direccion,telefono,usuario,password,estado FROM usuario WHERE idusuario=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oUsuarioBE1.getIdusuario());
rs = pst.executeQuery();
System.out.println("consulta :" + sql);

}	while(rs.next()){
		oUsuarioBE.setIdusuario(rs.getInt("idusuario"));
		oUsuarioBE.setNombres(rs.getString("nombres"));
		oUsuarioBE.setApellidos(rs.getString("apellidos"));
		oUsuarioBE.setDni(rs.getString("dni"));
		oUsuarioBE.setDireccion(rs.getString("direccion"));
		oUsuarioBE.setTelefono(rs.getString("telefono"));
		oUsuarioBE.setUsuario(rs.getString("usuario"));
		oUsuarioBE.setPassword(rs.getString("password"));
		oUsuarioBE.setEstado(rs.getBoolean("estado"));
}

	cn.commit();
	cn.setAutoCommit(true);
}
catch (Exception ex) {
	cn.rollback();
	ex.printStackTrace();
}
finally {
	
	rs.close();
	rs = null;
	cn.close();
	cn = null;

}
return oUsuarioBE;
}



public ArrayList<UsuarioBE> listarRegistroUsuarioBE(UsuarioBE oUsuarioBE1) throws SQLException {
	ArrayList<UsuarioBE> listaUsuarioBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	listaUsuarioBE=new ArrayList<UsuarioBE>();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
	String sql="";
if (oUsuarioBE1.getIndOpSp() == 1) {
	sql = " SELECT '<i style=\"cursor:pointer;\" onclick=\"edit('||idusuario||')\" class=\"fa fa-pencil-square-o\"></i>','<i style=\"cursor:pointer;\" onclick=\"del('||idusuario||')\" class=\"fa fa-trash-o\"></i>',idusuario,nombres,apellidos,dni,direccion,telefono,usuario,password,estado FROM usuario WHERE estado=true";
pst = cn.prepareStatement(sql);
rs = pst.executeQuery();
}
if (oUsuarioBE1.getIndOpSp() == 2) {
	sql = " SELECT idusuario,nombres,apellidos,dni,direccion,telefono,usuario,password,estado FROM usuario WHERE idusuario=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oUsuarioBE1.getIdusuario());
rs = pst.executeQuery();
}

while(rs.next()){
	UsuarioBE oUsuarioBE=new UsuarioBE();
oUsuarioBE.setEdit(rs.getString(1));
oUsuarioBE.setDel(rs.getString(2));
		oUsuarioBE.setIdusuario(rs.getInt("idusuario"));
		oUsuarioBE.setNombres(rs.getString("nombres"));
		oUsuarioBE.setApellidos(rs.getString("apellidos"));
		oUsuarioBE.setDni(rs.getString("dni"));
		oUsuarioBE.setDireccion(rs.getString("direccion"));
		oUsuarioBE.setTelefono(rs.getString("telefono"));
		oUsuarioBE.setUsuario(rs.getString("usuario"));
		oUsuarioBE.setPassword(rs.getString("password"));
		oUsuarioBE.setEstado(rs.getBoolean("estado"));
	listaUsuarioBE.add(oUsuarioBE);}

	cn.commit();
	cn.setAutoCommit(true);
}
catch (Exception ex) {
	cn.rollback();
	ex.printStackTrace();
}finally {
	rs.close();
	rs = null;
	cn.close();
	cn = null;
	oUsuarioBE1 = null;
}
return listaUsuarioBE;
}


public  int insertarRegistrosUsuarioBE(ArrayList<UsuarioBE> oListaUsuarioBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

for(UsuarioBE oUsuarioBE : oListaUsuarioBE){
cs=cn.prepareCall("{call uspInsertarUsuario(?,?,?,?,?,?,?,?,?)}");
	cs.setString(1, oUsuarioBE.getNombres());
	cs.setString(2, oUsuarioBE.getApellidos());
	cs.setString(3, oUsuarioBE.getDni());
	cs.setString(4, oUsuarioBE.getDireccion());
	cs.setString(5, oUsuarioBE.getTelefono());
	cs.setString(6, oUsuarioBE.getUsuario());
	cs.setString(7, oUsuarioBE.getPassword());
	cs.setBoolean(8, oUsuarioBE.isEstado());
	cs.registerOutParameter(9, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(9);
	cs.close();
	cs=null;
}
	cn.commit();
	cn.setAutoCommit(true);
}
catch (Exception ex) {
	cn.rollback();
	ex.printStackTrace();
}
finally {
	cn.close();
	cn = null;
	
}
return resultado;
}


public  int insertarUsuarioBE(UsuarioBE oUsuarioBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspInsertarUsuario(?,?,?,?,?,?,?,?,?)}");
	cs.setString(1, oUsuarioBE.getNombres());
	cs.setString(2, oUsuarioBE.getApellidos());
	cs.setString(3, oUsuarioBE.getDni());
	cs.setString(4, oUsuarioBE.getDireccion());
	cs.setString(5, oUsuarioBE.getTelefono());
	cs.setString(6, oUsuarioBE.getUsuario());
	cs.setString(7, oUsuarioBE.getPassword());
	cs.setBoolean(8, oUsuarioBE.isEstado());
	cs.registerOutParameter(9, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(9);
	cs.close();
	cs=null;
	cn.commit();
	cn.setAutoCommit(true);
}
catch (Exception ex) {
	cn.rollback();
	ex.printStackTrace();
}
finally {
	cn.close();
	cn = null;
	
}
return resultado;
}


public  int actualizarUsuarioBE(UsuarioBE oUsuarioBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspActualizarUsuario(?,?,?,?,?,?,?,?,?)}");
	cs.setInt(1, oUsuarioBE.getIdusuario());
	cs.setString(2, oUsuarioBE.getNombres());
	cs.setString(3, oUsuarioBE.getApellidos());
	cs.setString(4, oUsuarioBE.getDni());
	cs.setString(5, oUsuarioBE.getDireccion());
	cs.setString(6, oUsuarioBE.getTelefono());
	cs.setString(7, oUsuarioBE.getUsuario());
	cs.setString(8, oUsuarioBE.getPassword());
	cs.setBoolean(9, oUsuarioBE.isEstado());
	cs.registerOutParameter(9, java.sql.Types.INTEGER);
	cs.executeUpdate();
	resultado = cs.getInt(9);
	cs.close();
	cs=null;
	cn.commit();
	cn.setAutoCommit(true);
}
catch (Exception ex) {
	cn.rollback();
	ex.printStackTrace();
}
finally {
	cn.close();
	cn = null;
	
}
return resultado;
}





public  int eliminarUsuarioBE(UsuarioBE oUsuarioBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspEliminarUsuario(?)}");cs.setInt(1, oUsuarioBE.getIdusuario());	cs.registerOutParameter(1, java.sql.Types.INTEGER);
	cs.executeUpdate();
	resultado = cs.getInt(1);
	cs.close();
	cs=null;
	cn.commit();
	cn.setAutoCommit(true);
}
catch (Exception ex) {
	cn.rollback();
	ex.printStackTrace();
}
finally {
	cn.close();
	cn = null;
	
}
return resultado;
}


 public ResultSet listarRS(String query) throws SQLException {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);
            String sql = query;
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            cn.commit();
            cn.setAutoCommit(true);
        } catch (Exception ex) {
            cn.rollback();
            ex.printStackTrace();
        } finally {
            cn.close();
            cn = null;
       }
        return rs;
    }
  public List listObjectUsuarioBE(UsuarioBE oUsuarioBE) throws SQLException {
        List list = new LinkedList();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "";

        try {

            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);

            if (oUsuarioBE.getIndOpSp() == 1) {
	 sql = " SELECT idusuario,nombres,apellidos,dni,direccion,telefono,usuario,password,estado FROM usuario WHERE idusuario=? and estado=true";                pst = cn.prepareStatement(sql);
                //pst.setString(1, oInformacionBE.getCodigocliente());
                rs = pst.executeQuery();
                System.out.println("sql: " + sql);

                while (rs.next()) {
                    Object[] obj = {rs.getString(1), rs.getString(2)};
                    list.add(obj);
                }

            }

            cn.commit();
            cn.setAutoCommit(true);
        } catch (Exception ex) {
            cn.rollback();
            ex.printStackTrace();
        } finally {
            rs.close();
            rs = null;
            cn.close();
            cn = null;
            oUsuarioBE = null;
        }
        return list;
    }
    
  }  
