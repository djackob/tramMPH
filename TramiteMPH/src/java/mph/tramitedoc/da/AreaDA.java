package mph.tramitedoc.da;


//@autor Sergio Medina


import mph.tramitedoc.be.AreaBE;
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
public class AreaDA extends BaseDA {
	String cadenaConexion;
	String DriverConnection;
	String user;
	String password;
public AreaDA(){
	cadenaConexion = super.getConnectionString();
	DriverConnection = super.getDriverConnection();
	user = super.getUser();
	password = super.getPassword();    
}
 public AreaBE listarAreaBE(AreaBE oAreaBE1) throws SQLException {
	AreaBE oAreaBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	oAreaBE=new AreaBE();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
if(oAreaBE1.getIndOpSp()==1){

	String sql = " SELECT idarea,denominacion,estado FROM area WHERE idarea=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oAreaBE1.getIdarea());
rs = pst.executeQuery();
System.out.println("consulta :" + sql);

}	while(rs.next()){
		oAreaBE.setIdarea(rs.getInt("idarea"));
		oAreaBE.setDenominacion(rs.getString("denominacion"));
		oAreaBE.setEstado(rs.getBoolean("estado"));
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
return oAreaBE;
}



public ArrayList<AreaBE> listarRegistroAreaBE(AreaBE oAreaBE1) throws SQLException {
	ArrayList<AreaBE> listaAreaBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	listaAreaBE=new ArrayList<AreaBE>();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
	String sql="";
if (oAreaBE1.getIndOpSp() == 1) {
	sql = " SELECT '<i style=\"cursor:pointer;\" onclick=\"edit('||idarea||')\" class=\"fa fa-pencil-square-o\"></i>','<i style=\"cursor:pointer;\" onclick=\"del('||idarea||')\" class=\"fa fa-trash-o\"></i>',idarea,denominacion,estado FROM area WHERE estado=true";
pst = cn.prepareStatement(sql);
rs = pst.executeQuery();
}
if (oAreaBE1.getIndOpSp() == 2) {
	sql = " SELECT idarea,denominacion,estado FROM area WHERE idarea=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oAreaBE1.getIdarea());
rs = pst.executeQuery();
}

while(rs.next()){
	AreaBE oAreaBE=new AreaBE();
oAreaBE.setEdit(rs.getString(1));
oAreaBE.setDel(rs.getString(2));
		oAreaBE.setIdarea(rs.getInt("idarea"));
		oAreaBE.setDenominacion(rs.getString("denominacion"));
		oAreaBE.setEstado(rs.getBoolean("estado"));
	listaAreaBE.add(oAreaBE);}

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
	oAreaBE1 = null;
}
return listaAreaBE;
}


public  int insertarRegistrosAreaBE(ArrayList<AreaBE> oListaAreaBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

for(AreaBE oAreaBE : oListaAreaBE){
cs=cn.prepareCall("{call uspInsertarArea(?,?,?)}");
	cs.setString(1, oAreaBE.getDenominacion());
	cs.setBoolean(2, oAreaBE.isEstado());
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


public  int insertarAreaBE(AreaBE oAreaBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspInsertarArea(?,?,?)}");
	cs.setString(1, oAreaBE.getDenominacion());
	cs.setBoolean(2, oAreaBE.isEstado());
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


public  int actualizarAreaBE(AreaBE oAreaBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspActualizarArea(?,?,?)}");
	cs.setInt(1, oAreaBE.getIdarea());
	cs.setString(2, oAreaBE.getDenominacion());
	cs.setBoolean(3, oAreaBE.isEstado());
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





public  int eliminarAreaBE(AreaBE oAreaBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspEliminarArea(?)}");cs.setInt(1, oAreaBE.getIdarea());	cs.registerOutParameter(1, java.sql.Types.INTEGER);
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
  public List listObjectAreaBE(AreaBE oAreaBE) throws SQLException {
        List list = new LinkedList();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "";

        try {

            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);

            if (oAreaBE.getIndOpSp() == 1) {
	 sql = " SELECT idarea,denominacion,estado FROM area WHERE idarea=? and estado=true";                pst = cn.prepareStatement(sql);
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
            oAreaBE = null;
        }
        return list;
    }
    
  }  
