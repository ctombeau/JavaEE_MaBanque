/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Db.DBUtils;
import Models.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ctombeau
 */
public class LoginDao {
    
      public static  Utilisateur Login(String username, String password) throws ClassNotFoundException, SQLException
      {    
            PreparedStatement ps = DBUtils.getPreparedStatement("select * from utilisateur where name = ? and password=? ");
            ps.setString(1, username);
            ps.setString(2, password);
           
            ResultSet rs = ps.executeQuery();
            Utilisateur util = new Utilisateur();
            
           while(rs.next())
           {
               util = new Utilisateur();
                util.setId(rs.getInt("id"));
                util.setName(rs.getString("name"));
                util.setPassword(rs.getString("password"));
                util.setEmail(rs.getString("email"));
                util.setProfil(rs.getString("profil"));
           }
           
           return util;
      }
    
}
