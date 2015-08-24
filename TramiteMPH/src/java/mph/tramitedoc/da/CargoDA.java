package mph.tramitedoc.da;


//@autor Sergio Medina


import mph.tramitedoc.be.CargoBE;
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
public class CargoDA extends BaseDA {
	String cadenaConexion;
	String DriverConnection;
	String user;
	String password;
public CargoDA(){
	cadenaConexion = super.getConnectionString();
	DriverConnection = super.getDriverConnection();
	user = super.getUser();
	password = super.getPassword();    
}
 public CargoBE listarCargoBE(CargoBE oCargoBE1) throws SQLException {
	CargoBE oCargoBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	oCargoBE=new CargoBE();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
if(oCargoBE1.getIndOpSp()==1){

	String sql = " SELECT idcargo,denominacion,estado FROM cargo WHERE idcargo=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oCargoBE1.getIdcargo());
rs = pst.executeQuery();
System.out.println("consulta :" + sql);

}	while(rs.next()){
		oCargoBE.setIdcargo(rs.getInt("idcargo"));
		oCargoBE.setDenominacion(rs.getString("denominacion"));
		oCargoBE.setEstado(rs.getBoolean("estado"));
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
return oCargoBE;
}



public ArrayList<CargoBE> listarRegistroCargoBE(CargoBE oCargoBE1) throws SQLException {
	ArrayList<CargoBE> listaCargoBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	listaCargoBE=new ArrayList<CargoBE>();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
	String sql="";
if (oCargoBE1.getIndOpSp() == 1) {
	sql = " SELECT '<i style=\"cursor:pointer;\" onclick=\"edit('||idcargo||')\" class=\"fa fa-pencil-square-o\"></i>','<i style=\"cursor:pointer;\" onclick=\"del('||idcargo||')\" class=\"fa fa-trash-o\"></i>',idcargo,denominacion,estado FROM cargo WHERE estado=true";
pst = cn.prepareStatement(sql);
rs = pst.executeQuery();
}
if (oCargoBE1.getIndOpSp() == 2) {
	sql = " SELECT idcargo,denominacion,estado FROM cargo WHERE idcargo=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oCargoBE1.getIdcargo());
rs = pst.executeQuery();
}

while(rs.next()){
	CargoBE oCargoBE=new CargoBE();
oCargoBE.setEdit(rs.getString(1));
oCargoBE.setDel(rs.getString(2));
		oCargoBE.setIdcargo(rs.getInt("idcargo"));
		oCargoBE.setDenominacion(rs.getString("denominacion"));
		oCargoBE.setEstado(rs.getBoolean("estado"));
	listaCargoBE.add(oCargoBE);}

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
	oCargoBE1 = null;
}
return listaCargoBE;
}


public  int insertarRegistrosCargoBE(ArrayList<CargoBE> oListaCargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

for(CargoBE oCargoBE : oListaCargoBE){
cs=cn.prepareCall("{call uspInsertarCargo(?,?,?)}");
	cs.setString(1, oCargoBE.getDenominacion());
	cs.setBoolean(2, oCargoBE.isEstado());
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


public  int insertarCargoBE(CargoBE oCargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspInsertarCargo(?,?,?)}");
	cs.setString(1, oCargoBE.getDenominacion());
	cs.setBoolean(2, oCargoBE.isEstado());
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


public  int actualizarCargoBE(CargoBE oCargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspActualizarCargo(?,?,?)}");
	cs.setInt(1, oCargoBE.getIdcargo());
	cs.setString(2, oCargoBE.getDenominacion());
	cs.setBoolean(3, oCargoBE.isEstado());
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





public  int eliminarCargoBE(CargoBE oCargoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspEliminarCargo(?)}");cs.setInt(1, oCargoBE.getIdcargo());	cs.registerOutParameter(1, java.sql.Types.INTEGER);
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
  public List listObjectCargoBE(CargoBE oCargoBE) throws SQLException {
        List list = new LinkedList();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "";

        try {

            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);

            if (oCargoBE.getIndOpSp() == 1) {
	 sql = " SELECT idcargo,denominacion,estado FROM cargo WHERE idcargo=? and estado=true";                pst = cn.prepareStatement(sql);
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
            oCargoBE = null;
        }
        return list;
    }
    
  }  
