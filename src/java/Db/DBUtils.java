/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author ctombeau
 */
public class DBUtils {
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException
    {
        PreparedStatement ps = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1400;databaseName=MaBanque";
        String user = "jedma";
        String pass = "Edma1995";
        
        Connection con = DriverManager.getConnection(url,user,pass);
        ps = con.prepareStatement(sql);
        return ps;
    }
    
//    public static void main(String[] args) throws ClassNotFoundException, SQLException
//    {
//        getPreparedStataement("select * from utilisateur");
//    }

   
}
