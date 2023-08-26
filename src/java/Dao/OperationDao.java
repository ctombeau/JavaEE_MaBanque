/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Db.DBUtils;
import Dto.OperationDto;
import Models.Operation;
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
public class OperationDao {
     
        public static List<OperationDto> getAlloperation()
        {
            List<OperationDto> operations = new LinkedList<>();
            try{
                   ResultSet rs =  DBUtils.getPreparedStatement("  select op.*, cli.nom,cli.prenom, cpte.numcompte,cpte.devise from operation op inner join client cli\n" +
"  on op.idclient = cli.idclient inner join compte cpte on cpte.idcompte = op.idcompte").executeQuery();
                   
                   while(rs.next())
                   {
                        OperationDto op = new OperationDto(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4),rs.getInt(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                        operations.add(op);
                   }
            }
             catch (ClassNotFoundException ex) {
                         Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                    Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return operations;
        }
        
        public static int getIdClientWithCompte(String numCompte) 
        {
                PreparedStatement ps;
                PreparedStatement ps2;
                int id = 0;
                int idClient = 0;
            try {
                         ps = DBUtils.getPreparedStatement("select idcompte from compte where numcompte = ?");
                         ps.setString(1, numCompte);
                         ResultSet rs = ps.executeQuery();
                         while(rs.next())
                         {
                               id = rs.getInt(1);
                         }
                         
                         ps2 = DBUtils.getPreparedStatement("select idclient from client_compte where idcompte = ?");
                         ps2.setInt(1, id);
                        ResultSet rs2 = ps2.executeQuery();
                        while(rs2.next())
                        {
                             idClient = rs2.getInt(1);
                        }
                       

               } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
              } catch (SQLException ex) {
                Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
             }
                
                 
           return idClient;
        }
        
        public static int getIdCompte(String numCompte) 
        {
                 PreparedStatement ps;
                 int id= 0;
            try {
                         ps = DBUtils.getPreparedStatement("select idcompte from compte where numcompte = ?");
                        ps.setString(1, numCompte);
                        ResultSet rs = ps.executeQuery();
                        while(rs.next())
                        {
                            id = rs.getInt(1);
                        }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
                 return id;
        }
        
        public static double getSolde(String numCompte)
        { 
              System.out.println("testons : "+numCompte);
               PreparedStatement ps;
                 double solde = 0;
            try {
                         ps = DBUtils.getPreparedStatement("select solde from compte where numcompte = ?");
                        ps.setString(1, numCompte);
                        ResultSet rs = ps.executeQuery();
                        while(rs.next())
                        {
                            solde = rs.getDouble(1);
                        }
                  } catch (ClassNotFoundException ex) {
                    Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (SQLException ex) {
                    Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
               }
                return solde;
        } 
        
        public static void AddOperation(String type, double montant, int idCompte, int idClient)
        {
            PreparedStatement ps;
            try {
                     ps = DBUtils.getPreparedStatement("insert into operation (type,montant,idcompte, idclient,dateop,validepar) values (?,?,?,?,?,?)");
                     ps.setString(1, type);
                     ps.setDouble(2, montant);
                     ps.setInt(3, idCompte);
                     ps.setInt(4, idClient);
                     ps.setDate(5, null);
                     ps.setString(6, "ctombeau");
                     ps.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public static boolean  updateCompte(String numCompte, double montant)
        {
             PreparedStatement ps;
             boolean rowUpdated= false;
            try {
                         ps = DBUtils.getPreparedStatement("update compte set solde=? where numcompte = ?");
                         ps.setDouble(1, montant);
                         ps.setString(2, numCompte);
                        rowUpdated = ps.executeUpdate()>0;
                                
                  } catch (ClassNotFoundException ex) {
                    Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (SQLException ex) {
                    Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
               }
               return rowUpdated; 
        }
        
        public static String getDevise(String numCompte)
        {
             PreparedStatement ps;
             String devise = "";
             try{
                   ps = DBUtils.getPreparedStatement("select devise from compte where numcompte = ?");
                   ps.setString(1, numCompte);
                   ResultSet rs = ps.executeQuery();
                   while(rs.next())
                   {
                        devise = rs.getString(1);
                   }
             }catch (ClassNotFoundException ex) {
                    Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (SQLException ex) {
                    Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
               }
              return devise;
        }
}
