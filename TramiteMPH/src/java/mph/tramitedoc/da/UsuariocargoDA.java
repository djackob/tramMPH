package mph.tramitedoc.da;


//@autor Sergio Medina


import mph.tramitedoc.be.UsuariocargoBE;
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
public class UsuariocargoDA extends BaseDA {
	String cadenaConexion;
	String DriverConnection;
	String user;
	String password;
public UsuariocargoDA(){
	cadenaConexion = super.getConnectionString();
	DriverConnection = super.getDriverConnection();
	user = super.getUser();
	password = super.getPassword();    
}
 public UsuariocargoBE listarUsuariocargoBE(UsuariocargoBE oUsuariocargoBE1) throws SQLException {
	UsuariocargoBE oUsuariocargoBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	oUsuariocargoBE=new UsuariocargoBE();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
if(oUsuariocargoBE1.getIndOpSp()==1){

	String sql = " SELECT idusuariocargo,idusuario,idcargo,fechaasignado,estado FROM usuariocargo WHERE idusuariocargo=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oUsuariocargoBE1.getIdusuariocargo());
rs = pst.executeQuery();
System.out.println("consulta :" + sql);

}	while(rs.next()){
		oUsuariocargoBE.setIdusuariocargo(rs.getInt("idusuariocargo"));
		oUsuariocargoBE.setIdusuario(rs.getInt("idusuario"));
		oUsuariocargoBE.setIdcargo(rs.getInt("idcargo"));
		oUsuariocargoBE.setFechaasignado(rs.getDate("fechaasignado"));
		oUsuariocargoBE.setEstado(rs.getBoolean("estado"));
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
return oUsuariocargoBE;
}



public ArrayList<UsuariocargoBE> listarRegistroUsuariocargoBE(UsuariocargoBE oUsuariocargoBE1) throws SQLException {
	ArrayList<UsuariocargoBE> listaUsuariocargoBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	listaUsuariocargoBE=new ArrayList<UsuariocargoBE>();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
	String sql="";
if (oUsuariocargoBE1.getIndOpSp() == 1) {
	sql = " SELECT '<i style=\"cursor:pointer;\" onclick=\"edit('||idusuariocargo||')\" class=\"fa fa-pencil-square-o\"></i>','<i style=\"cursor:pointer;\" onclick=\"del('||idusuariocargo||')\" class=\"fa fa-trash-o\"></i>',idusuariocargo,idusuario,idcargo,fechaasignado,estado FROM usuariocargo WHERE estado=true";
pst = cn.prepareStatement(sql);
rs = pst.executeQuery();
}
if (oUsuariocargoBE1.getIndOpSp() == 2) {
	sql = " SELECT idusuariocargo,idusuario,idcargo,fechaasignado,estado FROM usuariocargo WHERE idusuariocargo=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oUsuariocargoBE1.getIdusuariocargo());
rs = pst.executeQuery();
}

while(rs.next()){
	UsuariocargoBE oUsuariocargoBE=new UsuariocargoBE();
oUsuariocargoBE.setEdit(rs.getString(1));
oUsuariocargoBE.setDel(rs.getString(2));
		oUsuariocargoBE.setIdusuariocargo(rs.getInt("idusuariocargo"));
		oUsuariocargoBE.setIdusuario(rs.getInt("idusuario"));
		oUsuariocargoBE.setIdcargo(rs.getInt("idcargo"));
		oUsuariocargoBE.setFechaasignado(rs.getDate("fechaasignado"));
		oUsuariocargoBE.setEstado(rs.getBoolean("estado"));
	listaUsuariocargoBE.add(oUsuariocargoBE);}

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
	oUsuariocargoBE1 = null;
}
return listaUsuariocargoBE;
}


public  int insertarRegistrosUsuariocargoBE(ArrayList<UsuariocargoBE> oListaUsuariocargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

for(UsuariocargoBE oUsuariocargoBE : oListaUsuariocargoBE){
cs=cn.prepareCall("{call uspInsertarUsuariocargo(?,?,?,?,?)}");
	cs.setInt(1, oUsuariocargoBE.getIdusuario());
	cs.setInt(2, oUsuariocargoBE.getIdcargo());
	Date fechaasignado= new Date(oUsuariocargoBE.getFechaasignado().getTime());
	cs.setDate(3,fechaasignado);
	cs.setBoolean(4, oUsuariocargoBE.isEstado());
	cs.registerOutParameter(5, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(5);
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


public  int insertarUsuariocargoBE(UsuariocargoBE oUsuariocargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspInsertarUsuariocargo(?,?,?,?,?)}");
	cs.setInt(1, oUsuariocargoBE.getIdusuario());
	cs.setInt(2, oUsuariocargoBE.getIdcargo());
	Date fechaasignado= new Date(oUsuariocargoBE.getFechaasignado().getTime());
	cs.setDate(3,fechaasignado);
	cs.setBoolean(4, oUsuariocargoBE.isEstado());
	cs.registerOutParameter(5, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(5);
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


public  int actualizarUsuariocargoBE(UsuariocargoBE oUsuariocargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspActualizarUsuariocargo(?,?,?,?,?)}");
	cs.setInt(1, oUsuariocargoBE.getIdusuariocargo());
	cs.setInt(2, oUsuariocargoBE.getIdusuario());
	cs.setInt(3, oUsuariocargoBE.getIdcargo());
	Date fechaasignado= new Date(oUsuariocargoBE.getFechaasignado().getTime());
	cs.setDate(4,fechaasignado);
	cs.setBoolean(5, oUsuariocargoBE.isEstado());
	cs.registerOutParameter(5, java.sql.Types.INTEGER);
	cs.executeUpdate();
	resultado = cs.getInt(5);
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





public  int eliminarUsuariocargoBE(UsuariocargoBE oUsuariocargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspEliminarUsuariocargo(?)}");cs.setInt(1, oUsuariocargoBE.getIdusuariocargo());	cs.registerOutParameter(1, java.sql.Types.INTEGER);
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
  public List listObjectUsuariocargoBE(UsuariocargoBE oUsuariocargoBE) throws SQLException {
        List list = new LinkedList();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "";

        try {

            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);

            if (oUsuariocargoBE.getIndOpSp() == 1) {
	 sql = " SELECT idusuariocargo,idusuario,idcargo,fechaasignado,estado FROM usuariocargo WHERE idusuariocargo=? and estado=true";                pst = cn.prepareStatement(sql);
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
            oUsuariocargoBE = null;
        }
        return list;
    }
    
  }  
