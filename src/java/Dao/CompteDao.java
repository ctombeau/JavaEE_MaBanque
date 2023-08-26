/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Db.DBUtils;
import Models.Compte;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Dao.*;
import Models.Client;

/**
 *
 * @author ctombeau
 */
public class CompteDao {
     
     public static List<Integer> getIdCompte(int idClient)
     {
          List<Integer> idCompte = new ArrayList<>();
          PreparedStatement ps;
          try
          {
               ps = DBUtils.getPreparedStatement("select idcompte from client_compte where idclient=?");
               ps.setInt(1, idClient);
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                     idCompte.add(rs.getInt(1));
                     
               }
          }
         catch (ClassNotFoundException ex) {
                 Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
            }
         return idCompte;
     }
    
    public static void  AddCompte(Compte compte, Client client)
    {
        PreparedStatement ps;
        PreparedStatement ps2;
        
        try{
                 ps = DBUtils.getPreparedStatement("insert into compte (numcompte, solde, devise) values(?, ?, ?)");
                 ps.setString(1, compte.getNumcompte());
                 ps.setDouble(2, compte.getSolde());
                 ps.setString(3, compte.getDevise());
                 ps.executeUpdate();
                 
                 ClientDao cliDao = new ClientDao();
                 int idClient = cliDao.getIdClient(client);
                 
                int idCompte = OperationDao.getIdCompte(compte.getNumcompte());
                
                ps2 = DBUtils.getPreparedStatement("insert into client_compte (idclient, idcompte) values (?,?)");
                ps2.setInt(1, idClient);
                ps2.setInt(2, idCompte);
                ps2.executeUpdate();
                 
        }catch (ClassNotFoundException ex) {
                     Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                    Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
}
