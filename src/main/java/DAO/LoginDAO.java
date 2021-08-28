package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
    static Connection connection = null;
    static Statement statement = null;
    ResultSet rs = null;

    public Boolean checkLogin(String u, String p){
        try {
            DBConnection db = new DBConnection();
            connection = db.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery( "select*from users where username='"+u+"' and password='"+p+"'");
            if(rs.next()) {
                return true;
             }
             rs.close();
             statement.close();
             connection.close();
    
        } catch (Exception e) {
            //TODO: handle exception
        }
        return false;
    }
}
