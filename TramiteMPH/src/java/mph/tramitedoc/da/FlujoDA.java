package mph.tramitedoc.da;


//@autor Sergio Medina


import mph.tramitedoc.be.FlujoBE;
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
public class FlujoDA extends BaseDA {
	String cadenaConexion;
	String DriverConnection;
	String user;
	String password;
public FlujoDA(){
	cadenaConexion = super.getConnectionString();
	DriverConnection = super.getDriverConnection();
	user = super.getUser();
	password = super.getPassword();    
}
 public FlujoBE listarFlujoBE(FlujoBE oFlujoBE1) throws SQLException {
	FlujoBE oFlujoBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	oFlujoBE=new FlujoBE();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
if(oFlujoBE1.getIndOpSp()==1){

	String sql = " SELECT idflujo,idexpediente,idestadoflujo,idusuario,idusuarioenvia,idusuariorecepciona,fechaenvio,fechalectura,asunto,descripcion,observacion,binderror,estado FROM flujo WHERE idflujo=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oFlujoBE1.getIdflujo());
rs = pst.executeQuery();
System.out.println("consulta :" + sql);

}	while(rs.next()){
		oFlujoBE.setIdflujo(rs.getInt("idflujo"));
		oFlujoBE.setIdexpediente(rs.getInt("idexpediente"));
		oFlujoBE.setIdestadoflujo(rs.getInt("idestadoflujo"));
		oFlujoBE.setIdusuario(rs.getInt("idusuario"));
		oFlujoBE.setIdusuarioenvia(rs.getInt("idusuarioenvia"));
		oFlujoBE.setIdusuariorecepciona(rs.getInt("idusuariorecepciona"));
		oFlujoBE.setFechaenvio(rs.getDate("fechaenvio"));
		oFlujoBE.setFechalectura(rs.getDate("fechalectura"));
		oFlujoBE.setAsunto(rs.getString("asunto"));
		oFlujoBE.setDescripcion(rs.getString("descripcion"));
		oFlujoBE.setObservacion(rs.getString("observacion"));
		oFlujoBE.setBinderror(rs.getBoolean("binderror"));
		oFlujoBE.setEstado(rs.getBoolean("estado"));
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
return oFlujoBE;
}



public ArrayList<FlujoBE> listarRegistroFlujoBE(FlujoBE oFlujoBE1) throws SQLException {
	ArrayList<FlujoBE> listaFlujoBE=null;
	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


try{
	listaFlujoBE=new ArrayList<FlujoBE>();
	Class.forName(DriverConnection);
	cn = DriverManager.getConnection(cadenaConexion, user, password);
	cn.setAutoCommit(false);
	String sql="";
if (oFlujoBE1.getIndOpSp() == 1) {
	sql = " SELECT '<i style=\"cursor:pointer;\" onclick=\"edit('||idflujo||')\" class=\"fa fa-pencil-square-o\"></i>','<i style=\"cursor:pointer;\" onclick=\"del('||idflujo||')\" class=\"fa fa-trash-o\"></i>',idflujo,idexpediente,idestadoflujo,idusuario,idusuarioenvia,idusuariorecepciona,fechaenvio,fechalectura,asunto,descripcion,observacion,binderror,estado FROM flujo WHERE estado=true";
pst = cn.prepareStatement(sql);
rs = pst.executeQuery();
}
if (oFlujoBE1.getIndOpSp() == 2) {
	sql = " SELECT idflujo,idexpediente,idestadoflujo,idusuario,idusuarioenvia,idusuariorecepciona,fechaenvio,fechalectura,asunto,descripcion,observacion,binderror,estado FROM flujo WHERE idflujo=? and estado=true";
pst = cn.prepareStatement(sql);
pst.setInt(1,oFlujoBE1.getIdflujo());
rs = pst.executeQuery();
}

while(rs.next()){
	FlujoBE oFlujoBE=new FlujoBE();
oFlujoBE.setEdit(rs.getString(1));
oFlujoBE.setDel(rs.getString(2));
		oFlujoBE.setIdflujo(rs.getInt("idflujo"));
		oFlujoBE.setIdexpediente(rs.getInt("idexpediente"));
		oFlujoBE.setIdestadoflujo(rs.getInt("idestadoflujo"));
		oFlujoBE.setIdusuario(rs.getInt("idusuario"));
		oFlujoBE.setIdusuarioenvia(rs.getInt("idusuarioenvia"));
		oFlujoBE.setIdusuariorecepciona(rs.getInt("idusuariorecepciona"));
		oFlujoBE.setFechaenvio(rs.getDate("fechaenvio"));
		oFlujoBE.setFechalectura(rs.getDate("fechalectura"));
		oFlujoBE.setAsunto(rs.getString("asunto"));
		oFlujoBE.setDescripcion(rs.getString("descripcion"));
		oFlujoBE.setObservacion(rs.getString("observacion"));
		oFlujoBE.setBinderror(rs.getBoolean("binderror"));
		oFlujoBE.setEstado(rs.getBoolean("estado"));
	listaFlujoBE.add(oFlujoBE);}

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
	oFlujoBE1 = null;
}
return listaFlujoBE;
}


public  int insertarRegistrosFlujoBE(ArrayList<FlujoBE> oListaFlujoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

for(FlujoBE oFlujoBE : oListaFlujoBE){
cs=cn.prepareCall("{call uspInsertarFlujo(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	cs.setInt(1, oFlujoBE.getIdexpediente());
	cs.setInt(2, oFlujoBE.getIdestadoflujo());
	cs.setInt(3, oFlujoBE.getIdusuario());
	cs.setInt(4, oFlujoBE.getIdusuarioenvia());
	cs.setInt(5, oFlujoBE.getIdusuariorecepciona());
	Date fechaenvio= new Date(oFlujoBE.getFechaenvio().getTime());
	cs.setDate(6,fechaenvio);
	Date fechalectura= new Date(oFlujoBE.getFechalectura().getTime());
	cs.setDate(7,fechalectura);
	cs.setString(8, oFlujoBE.getAsunto());
	cs.setString(9, oFlujoBE.getDescripcion());
	cs.setString(10, oFlujoBE.getObservacion());
	cs.setBoolean(11, oFlujoBE.isBinderror());
	cs.setBoolean(12, oFlujoBE.isEstado());
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


public  int insertarFlujoBE(FlujoBE oFlujoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion,user,password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspInsertarFlujo(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	cs.setInt(1, oFlujoBE.getIdexpediente());
	cs.setInt(2, oFlujoBE.getIdestadoflujo());
	cs.setInt(3, oFlujoBE.getIdusuario());
	cs.setInt(4, oFlujoBE.getIdusuarioenvia());
	cs.setInt(5, oFlujoBE.getIdusuariorecepciona());
	Date fechaenvio= new Date(oFlujoBE.getFechaenvio().getTime());
	cs.setDate(6,fechaenvio);
	Date fechalectura= new Date(oFlujoBE.getFechalectura().getTime());
	cs.setDate(7,fechalectura);
	cs.setString(8, oFlujoBE.getAsunto());
	cs.setString(9, oFlujoBE.getDescripcion());
	cs.setString(10, oFlujoBE.getObservacion());
	cs.setBoolean(11, oFlujoBE.isBinderror());
	cs.setBoolean(12, oFlujoBE.isEstado());
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


public  int actualizarFlujoBE(FlujoBE oFlujoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspActualizarFlujo(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	cs.setInt(1, oFlujoBE.getIdflujo());
	cs.setInt(2, oFlujoBE.getIdexpediente());
	cs.setInt(3, oFlujoBE.getIdestadoflujo());
	cs.setInt(4, oFlujoBE.getIdusuario());
	cs.setInt(5, oFlujoBE.getIdusuarioenvia());
	cs.setInt(6, oFlujoBE.getIdusuariorecepciona());
	Date fechaenvio= new Date(oFlujoBE.getFechaenvio().getTime());
	cs.setDate(7,fechaenvio);
	Date fechalectura= new Date(oFlujoBE.getFechalectura().getTime());
	cs.setDate(8,fechalectura);
	cs.setString(9, oFlujoBE.getAsunto());
	cs.setString(10, oFlujoBE.getDescripcion());
	cs.setString(11, oFlujoBE.getObservacion());
	cs.setBoolean(12, oFlujoBE.isBinderror());
	cs.setBoolean(13, oFlujoBE.isEstado());
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





public  int eliminarFlujoBE(FlujoBE oFlujoBE) throws SQLException {
	int resultado=0;
	Connection cn = null;
	CallableStatement cs = null;


try{
	Class.forName(DriverConnection);
	cn=DriverManager.getConnection(cadenaConexion, user, password);

	cn.setAutoCommit(false);

cs=cn.prepareCall("{call uspEliminarFlujo(?)}");cs.setInt(1, oFlujoBE.getIdflujo());	cs.registerOutParameter(1, java.sql.Types.INTEGER);
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
  public List listObjectFlujoBE(FlujoBE oFlujoBE) throws SQLException {
        List list = new LinkedList();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "";

        try {

            Class.forName(DriverConnection);
            cn = DriverManager.getConnection(cadenaConexion, user, password);
            cn.setAutoCommit(false);

            if (oFlujoBE.getIndOpSp() == 1) {
	 sql = " SELECT idflujo,idexpediente,idestadoflujo,idusuario,idusuarioenvia,idusuariorecepciona,fechaenvio,fechalectura,asunto,descripcion,observacion,binderror,estado FROM flujo WHERE idflujo=? and estado=true";                pst = cn.prepareStatement(sql);
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
            oFlujoBE = null;
        }
        return list;
    }
    
  }  
