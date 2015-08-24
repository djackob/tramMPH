package mph.tramitedoc.da;


//@autor Sergio Medina


import mph.tramitedoc.be.ExpedienteBE;
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
public class ExpedienteDA extends BaseDA {
	String cadenaConexion;
	String DriverConnection;
	String user;
	String password;
public ExpedienteDA(){
	cadenaConexion = super.getConnectionString();
	DriverConnection = super.getDriverConnection();
	user = super.getUser();
	password = super.getPassword();    
}
 public ExpedienteBE listarExpedienteBE(ExpedienteBE oExpedienteBE1) throws SQLException {
	ExpedienteBE oExpedienteBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	oExpedienteBE=new ExpedienteBE();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
if(oExpedienteBE1.getIndOpSp()==1){

	String sql = " SELECT idexpediente,idusuariocargo,idprocedimiento,idarea,codigo,dni_ruc,nombre_razonsocial,apellidos,direccion,telefono,correo,asunto,estado FROM expediente WHERE idexpediente=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oExpedienteBE1.getIdexpediente());
rs = pst.executeQuery();
System.out.println("consulta :" + sql);

}	while(rs.next()){
		oExpedienteBE.setIdexpediente(rs.getInt("idexpediente"));
		oExpedienteBE.setIdusuariocargo(rs.getInt("idusuariocargo"));
		oExpedienteBE.setIdprocedimiento(rs.getInt("idprocedimiento"));
		oExpedienteBE.setIdarea(rs.getInt("idarea"));
		oExpedienteBE.setCodigo(rs.getString("codigo"));
		oExpedienteBE.setDni_ruc(rs.getString("dni_ruc"));
		oExpedienteBE.setNombre_razonsocial(rs.getString("nombre_razonsocial"));
		oExpedienteBE.setApellidos(rs.getString("apellidos"));
		oExpedienteBE.setDireccion(rs.getString("direccion"));
		oExpedienteBE.setTelefono(rs.getString("telefono"));
		oExpedienteBE.setCorreo(rs.getString("correo"));
		oExpedienteBE.setAsunto(rs.getString("asunto"));
		oExpedienteBE.setEstado(rs.getBoolean("estado"));
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
return oExpedienteBE;
}



public ArrayList<ExpedienteBE> listarRegistroExpedienteBE(ExpedienteBE oExpedienteBE1) throws SQLException {
	ArrayList<ExpedienteBE> listaExpedienteBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	listaExpedienteBE=new ArrayList<ExpedienteBE>();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
	String sql="";
if (oExpedienteBE1.getIndOpSp() == 1) {
	sql = " SELECT '<i style=\"cursor:pointer;\" onclick=\"edit('||idexpediente||')\" class=\"fa fa-pencil-square-o\"></i>','<i style=\"cursor:pointer;\" onclick=\"del('||idexpediente||')\" class=\"fa fa-trash-o\"></i>',idexpediente,idusuariocargo,idprocedimiento,idarea,codigo,dni_ruc,nombre_razonsocial,apellidos,direccion,telefono,correo,asunto,estado FROM expediente WHERE estado=true";
pst = cn.prepareStatement(sql);
rs = pst.executeQuery();
}
if (oExpedienteBE1.getIndOpSp() == 2) {
	sql = " SELECT idexpediente,idusuariocargo,idprocedimiento,idarea,codigo,dni_ruc,nombre_razonsocial,apellidos,direccion,telefono,correo,asunto,estado FROM expediente WHERE idexpediente=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oExpedienteBE1.getIdexpediente());
rs = pst.executeQuery();
}

while(rs.next()){
	ExpedienteBE oExpedienteBE=new ExpedienteBE();
oExpedienteBE.setEdit(rs.getString(1));
oExpedienteBE.setDel(rs.getString(2));
		oExpedienteBE.setIdexpediente(rs.getInt("idexpediente"));
		oExpedienteBE.setIdusuariocargo(rs.getInt("idusuariocargo"));
		oExpedienteBE.setIdprocedimiento(rs.getInt("idprocedimiento"));
		oExpedienteBE.setIdarea(rs.getInt("idarea"));
		oExpedienteBE.setCodigo(rs.getString("codigo"));
		oExpedienteBE.setDni_ruc(rs.getString("dni_ruc"));
		oExpedienteBE.setNombre_razonsocial(rs.getString("nombre_razonsocial"));
		oExpedienteBE.setApellidos(rs.getString("apellidos"));
		oExpedienteBE.setDireccion(rs.getString("direccion"));
		oExpedienteBE.setTelefono(rs.getString("telefono"));
		oExpedienteBE.setCorreo(rs.getString("correo"));
		oExpedienteBE.setAsunto(rs.getString("asunto"));
		oExpedienteBE.setEstado(rs.getBoolean("estado"));
	listaExpedienteBE.add(oExpedienteBE);}

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
	oExpedienteBE1 = null;
}
return listaExpedienteBE;
}


public  int insertarRegistrosExpedienteBE(ArrayList<ExpedienteBE> oListaExpedienteBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

for(ExpedienteBE oExpedienteBE : oListaExpedienteBE){
cs=cn.prepareCall("{call uspInsertarExpediente(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	cs.setInt(1, oExpedienteBE.getIdusuariocargo());
	cs.setInt(2, oExpedienteBE.getIdprocedimiento());
	cs.setInt(3, oExpedienteBE.getIdarea());
	cs.setString(4, oExpedienteBE.getCodigo());
	cs.setString(5, oExpedienteBE.getDni_ruc());
	cs.setString(6, oExpedienteBE.getNombre_razonsocial());
	cs.setString(7, oExpedienteBE.getApellidos());
	cs.setString(8, oExpedienteBE.getDireccion());
	cs.setString(9, oExpedienteBE.getTelefono());
	cs.setString(10, oExpedienteBE.getCorreo());
	cs.setString(11, oExpedienteBE.getAsunto());
	cs.setBoolean(12, oExpedienteBE.isEstado());
	cs.registerOutParameter(13, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(13);
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


public  int insertarExpedienteBE(ExpedienteBE oExpedienteBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspInsertarExpediente(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	cs.setInt(1, oExpedienteBE.getIdusuariocargo());
	cs.setInt(2, oExpedienteBE.getIdprocedimiento());
	cs.setInt(3, oExpedienteBE.getIdarea());
	cs.setString(4, oExpedienteBE.getCodigo());
	cs.setString(5, oExpedienteBE.getDni_ruc());
	cs.setString(6, oExpedienteBE.getNombre_razonsocial());
	cs.setString(7, oExpedienteBE.getApellidos());
	cs.setString(8, oExpedienteBE.getDireccion());
	cs.setString(9, oExpedienteBE.getTelefono());
	cs.setString(10, oExpedienteBE.getCorreo());
	cs.setString(11, oExpedienteBE.getAsunto());
	cs.setBoolean(12, oExpedienteBE.isEstado());
	cs.registerOutParameter(13, java.sql.Types.INTEGER);
	cs.execute();
	resultado = cs.getInt(13);
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


public  int actualizarExpedienteBE(ExpedienteBE oExpedienteBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspActualizarExpediente(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	cs.setInt(1, oExpedienteBE.getIdexpediente());
	cs.setInt(2, oExpedienteBE.getIdusuariocargo());
	cs.setInt(3, oExpedienteBE.getIdprocedimiento());
	cs.setInt(4, oExpedienteBE.getIdarea());
	cs.setString(5, oExpedienteBE.getCodigo());
	cs.setString(6, oExpedienteBE.getDni_ruc());
	cs.setString(7, oExpedienteBE.getNombre_razonsocial());
	cs.setString(8, oExpedienteBE.getApellidos());
	cs.setString(9, oExpedienteBE.getDireccion());
	cs.setString(10, oExpedienteBE.getTelefono());
	cs.setString(11, oExpedienteBE.getCorreo());
	cs.setString(12, oExpedienteBE.getAsunto());
	cs.setBoolean(13, oExpedienteBE.isEstado());
	cs.registerOutParameter(13, java.sql.Types.INTEGER);
	cs.executeUpdate();
	resultado = cs.getInt(13);
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





public  int eliminarExpedienteBE(ExpedienteBE oExpedienteBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspEliminarExpediente(?)}");cs.setInt(1, oExpedienteBE.getIdexpediente());	cs.registerOutParameter(1, java.sql.Types.INTEGER);
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
  public List listObjectExpedienteBE(ExpedienteBE oExpedienteBE) throws SQLException {
        List list = new LinkedList();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "";

        try {

            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);

            if (oExpedienteBE.getIndOpSp() == 1) {
	 sql = " SELECT idexpediente,idusuariocargo,idprocedimiento,idarea,codigo,dni_ruc,nombre_razonsocial,apellidos,direccion,telefono,correo,asunto,estado FROM expediente WHERE idexpediente=? and estado=true";                pst = cn.prepareStatement(sql);
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
            oExpedienteBE = null;
        }
        return list;
    }
    
  }  
