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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ctombeau
 */
public class UtilisateurDao {
    public void AjouterUtilisateur(Utilisateur util)
    { 
        System.out.print(util);
        try {
                PreparedStatement ps = DBUtils.getPreparedStatement("insert into utilisateur (name,password,email,profil) values(?,?,?,?)");
                ps.setString(1, util.getName());
                ps.setString(2, util.getPassword());
                ps.setString(3, util.getEmail());
                ps.setString(4, util.getProfil());
            
               ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Utilisateur> ListerUtilisateur()
    {
        List<Utilisateur> util = new  LinkedList<>();
        try {
            ResultSet rs = DBUtils.getPreparedStatement("select * from utilisateur").executeQuery();
            
            while(rs.next())
            {
                Utilisateur user = new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                util.add(user);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return util;
    }
    
    public Utilisateur getUtilisateur(int id) 
    {
        Utilisateur util = null;
        PreparedStatement ps;
        try {
                ps = DBUtils.getPreparedStatement("select id,name,password,email,profil from utilisateur where id =?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
        
                while(rs.next()){
                util = new Utilisateur();
                util.setId(rs.getInt("id"));
                util.setName(rs.getString("name"));
                util.setPassword(rs.getString("password"));
                util.setEmail(rs.getString("email"));
                util.setProfil(rs.getString("profil"));
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return util;
    }
    
    public boolean updateUtilisateur(Utilisateur util,int id){
        boolean rowUpdated = false;
        System.out.println("Dans update user: "+id);
        PreparedStatement ps;
        try {
              ps = DBUtils.getPreparedStatement("update utilisateur set name = ?, password=?, email= ?, profil =? where id = ?;");
              ps.setString(1, util.getName());
              ps.setString(2, util.getPassword());
              ps.setString(3, util.getEmail());
              ps.setString(4, util.getProfil());
              ps.setInt(5, id);
              rowUpdated = ps.executeUpdate()>0;
        
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowUpdated;
    }
    
    public boolean deleteUtilisateur(int id) throws SQLException, ClassNotFoundException{
        boolean rowDeleted;
        PreparedStatement ps = DBUtils.getPreparedStatement("delete from utilisateur where id = ?;");
        ps.setInt(1, id);
        rowDeleted = ps.executeUpdate()>0;
        return rowDeleted;
    }
}
