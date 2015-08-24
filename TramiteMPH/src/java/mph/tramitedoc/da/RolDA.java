package mph.tramitedoc.da;


//@autor Sergio Medina


import mph.tramitedoc.be.RolBE;
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
public class RolDA extends BaseDA {
	String cadenaConexion;
	String DriverConnection;
	String user;
	String password;
public RolDA(){
	cadenaConexion = super.getConnectionString();
	DriverConnection = super.getDriverConnection();
	user = super.getUser();
	password = super.getPassword();    
}
 public RolBE listarRolBE(RolBE oRolBE1) throws SQLException {
	RolBE oRolBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	oRolBE=new RolBE();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
if(oRolBE1.getIndOpSp()==1){

	String sql = " SELECT idrol,denominacion,estado FROM rol WHERE idrol=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oRolBE1.getIdrol());
rs = pst.executeQuery();
System.out.println("consulta :" + sql);

}	while(rs.next()){
		oRolBE.setIdrol(rs.getInt("idrol"));
		oRolBE.setDenominacion(rs.getString("denominacion"));
		oRolBE.setEstado(rs.getBoolean("estado"));
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
return oRolBE;
}



public ArrayList<RolBE> listarRegistroRolBE(RolBE oRolBE1) throws SQLException {
	ArrayList<RolBE> listaRolBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	listaRolBE=new ArrayList<RolBE>();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
	String sql="";
if (oRolBE1.getIndOpSp() == 1) {
	sql = " SELECT '<i style=\"cursor:pointer;\" onclick=\"edit('||idrol||')\" class=\"fa fa-pencil-square-o\"></i>','<i style=\"cursor:pointer;\" onclick=\"del('||idrol||')\" class=\"fa fa-trash-o\"></i>',idrol,denominacion,estado FROM rol WHERE estado=true";
pst = cn.prepareStatement(sql);
rs = pst.executeQuery();
}
if (oRolBE1.getIndOpSp() == 2) {
	sql = " SELECT idrol,denominacion,estado FROM rol WHERE idrol=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oRolBE1.getIdrol());
rs = pst.executeQuery();
}

while(rs.next()){
	RolBE oRolBE=new RolBE();
oRolBE.setEdit(rs.getString(1));
oRolBE.setDel(rs.getString(2));
		oRolBE.setIdrol(rs.getInt("idrol"));
		oRolBE.setDenominacion(rs.getString("denominacion"));
		oRolBE.setEstado(rs.getBoolean("estado"));
	listaRolBE.add(oRolBE);}

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
	oRolBE1 = null;
}
return listaRolBE;
}


public  int insertarRegistrosRolBE(ArrayList<RolBE> oListaRolBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

for(RolBE oRolBE : oListaRolBE){
cs=cn.prepareCall("{call uspInsertarRol(?,?,?)}");
	cs.setString(1, oRolBE.getDenominacion());
	cs.setBoolean(2, oRolBE.isEstado());
	cs.registerOutParameter(3, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(3);
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


public  int insertarRolBE(RolBE oRolBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspInsertarRol(?,?,?)}");
	cs.setString(1, oRolBE.getDenominacion());
	cs.setBoolean(2, oRolBE.isEstado());
	cs.registerOutParameter(3, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(3);
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


public  int actualizarRolBE(RolBE oRolBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspActualizarRol(?,?,?)}");
	cs.setInt(1, oRolBE.getIdrol());
	cs.setString(2, oRolBE.getDenominacion());
	cs.setBoolean(3, oRolBE.isEstado());
	cs.registerOutParameter(3, java.sql.Types.INTEGER);
	cs.executeUpdate();
	resultado = cs.getInt(3);
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





public  int eliminarRolBE(RolBE oRolBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspEliminarRol(?)}");cs.setInt(1, oRolBE.getIdrol());	cs.registerOutParameter(1, java.sql.Types.INTEGER);
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
  public List listObjectRolBE(RolBE oRolBE) throws SQLException {
        List list = new LinkedList();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "";

        try {

            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);

            if (oRolBE.getIndOpSp() == 1) {
	 sql = " SELECT idrol,denominacion,estado FROM rol WHERE idrol=? and estado=true";                pst = cn.prepareStatement(sql);
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
            oRolBE = null;
        }
        return list;
    }
    
  }  
