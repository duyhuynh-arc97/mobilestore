package DAO;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection connection = null;
    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-35-170-85-206.compute-1.amazonaws.com:5432/dfhtkjasbutnuv","woffzxzmasdiea", "5888c1114a9dd3c6b65d55701538e220d41cdb8629b3f84e5ef8db0b76a6784f");
            connection.setAutoCommit(false);
        } catch (Exception e) {
            //TODO: handle exception
        }
        return connection;
    }
    
}
