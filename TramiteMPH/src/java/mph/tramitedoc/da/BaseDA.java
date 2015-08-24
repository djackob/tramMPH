package mph.tramitedoc.da;
    public class BaseDA {
    private String connectionString;
    private String driverConnection;
    private String user;
    private String password;
    public BaseDA() {
        connectionString = "jdbc:postgresql://localhost:5432/bdtramite";
        driverConnection = "org.postgresql.Driver";
        user="postgres";
        password="1234";
   }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getConnectionString() {
        return connectionString;
    }
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    public String getDriverConnection() {
        return driverConnection;
    }
    public void setDriverConnection(String driverConnection) {
        this.driverConnection = driverConnection;
    }
}
