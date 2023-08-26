/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Db.DBUtils;
import Dto.ClientCompte;
import Models.Client;
import Models.Compte;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import static java.lang.String.format;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ctombeau
 */
public class ClientDao {
    public static List<ClientCompte> getAllClient()
    {
        List<ClientCompte> clientCompte = new LinkedList<>();
        try
        {
            ResultSet rs = DBUtils.getPreparedStatement("select * from client cli\n" +
                                    "inner join client_compte clicpte\n" +
                                    "on cli.idclient = clicpte.idclient\n" +
                                    "inner join compte cpte\n" +
                                     "on cpte.idcompte = clicpte.Idcompte ").executeQuery();
            while(rs.next())
            {
                   ClientCompte clicpte = new ClientCompte(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9),rs.getDate(10),rs.getString(11),rs.getDate(12),rs.getInt(16),rs.getString(17),rs.getDouble(18),rs.getString(19));
                    clientCompte.add(clicpte);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return clientCompte;
    }
    
    public void AddClient(Client client, Compte compte) 
    {  
        
        PreparedStatement ps1;
        PreparedStatement ps2;
        PreparedStatement ps3;
      
        java.util.Date dateNaiss =  client.getDate_naissance();
        java.util.Date dateCreele = client.getCreele();
        java.sql.Date dateClient = new java.sql.Date(dateNaiss.getTime());
        java.sql.Date dateCre = new java.sql.Date(dateCreele.getTime());
        
        try {
                 ps1 = DBUtils.getPreparedStatement("insert into client(nom,prenom,date_naissance,adresse,phone,creepar,creele,modifiepar,modifiele,supprimepar,supprimele) values(?,?,?,?,?,?,?,?,?,?,?) ");
                 ps2 = DBUtils.getPreparedStatement("insert into compte(numcompte,solde,devise) values(?,?,?)");
                 ps3 = DBUtils.getPreparedStatement("insert into client_compte (idclient, idcompte) values(?,?)");
                 
                 ps1.setString(1, client.getNom());
                 ps1.setString(2, client.getPrenom());
                 ps1.setDate(3, dateClient);
                 ps1.setString(4, client.getAdresse());
                 ps1.setString(5, client.getPhone());
                 ps1.setString(6, null);
                 ps1.setDate(7, dateCre);
                 ps1.setString(8, null);
                 ps1.setDate(9, null);
                 ps1.setString(10, null);
                 ps1.setDate(11, null);
                int saveCli = ps1.executeUpdate();
            
                ps2.setString(1, compte.getNumcompte());
                ps2.setDouble(2, compte.getSolde());
                ps2.setString(3, compte.getDevise());
               int saveCpte = ps2.executeUpdate();
            
                ps3.setInt(1, this.getIdClient(client));
                ps3.setInt(2, OperationDao.getIdCompte(compte.getNumcompte()));
               int saveCliCpte =  ps3.executeUpdate();
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
      }
    
    public int getIdClient(Client client)
    {   
        int idClient=0;
        PreparedStatement ps;
        try{
                 ps = DBUtils.getPreparedStatement("select idclient from client where nom = ? and prenom = ? and phone = ?");
                         ps.setString(1, client.getNom());
                         ps.setString(2, client.getPrenom());
                         ps.setString(3, client.getPhone());
                         ResultSet rs = ps.executeQuery();
                         while(rs.next())
                         {
                               idClient = rs.getInt(1);
                         }
        }
        catch (ClassNotFoundException ex) {
                 Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        return idClient;
    }
    
    public Client getClient(int id) 
    { 
        System.out.println("Voici l'id: "+id);
        Client client = null;
        PreparedStatement ps;
        try {
                ps = DBUtils.getPreparedStatement("select * from client where idclient =?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
        
                while(rs.next()){
                client = new Client();
                client.setIdclient(rs.getInt("idclient"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setDate_naissance(rs.getDate("date_naissance"));
                client.setAdresse(rs.getString("adresse"));
               client.setPhone(rs.getString("phone"));
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return client;
    }
    
    public static boolean updateClient(Client client, int id)
    {
         PreparedStatement ps;
          boolean rowUpdated = false;
          java.util.Date dateNaiss =  client.getDate_naissance();
          java.util.Date dateModifiele = client.getModifiele();
          java.sql.Date dateClient = new java.sql.Date(dateNaiss.getTime());
          java.sql.Date dateMod = new java.sql.Date(dateModifiele.getTime());
        
         try{
                   ps = DBUtils.getPreparedStatement("update client set nom = ?, prenom = ?, date_naissance=?, adresse = ?, phone= ?, modifiepar=?, modifiele=? where id= ?;");
                   ps.setString(1, client.getNom());
                   ps.setString(2, client.getPrenom());
                   ps.setDate(3, dateClient);
                   ps.setString(4, client.getAdresse());
                   ps.setString(5, client.getPhone());
                   ps.setString(6, null);
                   ps.setDate(7, dateMod);
                   ps.setInt(7, id);
                    rowUpdated = ps.executeUpdate()>0;
                   
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return rowUpdated;
    }
    
    public static void  SupprimerClientAvecCompte(int idclient)
    {  
          List<Integer> idCompte = new ArrayList<>();
          boolean rowDeleted = false;
          PreparedStatement ps;
          PreparedStatement ps2;
          PreparedStatement ps3;
          try{  
                     idCompte =  CompteDao.getIdCompte(idclient);
                     
                      ps = DBUtils.getPreparedStatement("delete from client_compte where idclient = ?;");
                      ps.setInt(1, idclient);
                      ps.executeUpdate();
                     
                     for(int idC : idCompte)
                     {
                       ps2= DBUtils.getPreparedStatement("delete from compte where idcompte = ?;");
                       ps2.setInt(1, idC);
                       ps2.executeUpdate();
                     }
                   
                   
                   ps3 = DBUtils.getPreparedStatement("delete from client where idclient = ?;");
                   ps3.setInt(1, idclient);
                   ps3.executeUpdate();
                   
                  
                   
                  
                  System.out.println("Les id des comptes: " + idCompte);
               }catch (ClassNotFoundException ex) {
                     Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                    Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
               }
        //return rowDeleted;
    }
}
