/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.UtilisateurDao;
import Models.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ctombeau
 */


public class UtilisateurServlet extends HttpServlet {


    private UtilisateurDao util ;
    public UtilisateurServlet()
    {
        this.util = new UtilisateurDao();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
         
        
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
          String forward = "";
          HttpSession session = request.getSession();
          String nom = (String) session.getAttribute("nom");
         String action = request.getParameter("action");
         String idParams = request.getParameter("id");
        // System.out.println(action); 
        // System.out.println(idParams); 
         if(action.equalsIgnoreCase("show"))
         {
             if(nom!=null)
             {
                ShowAddForm(request,response);
             }
             else 
             {
                  response.sendRedirect("/login");
              }
             
         }
         else if(action.equalsIgnoreCase("list")){
             if(nom!=null)
             {
                    response.setContentType("text/html;charset=UTF-8");
                    request.setAttribute("util", UtilisateurDao.ListerUtilisateur());
                    RequestDispatcher rd = request.getRequestDispatcher("Utilisateur/ListerUtilisateur.jsp");
                    rd.forward(request, response);
             }
             else 
             {
                  response.sendRedirect("/login");
             }
         }
         else if(action.equalsIgnoreCase("add"))
         {
             AjouterUtilisateur(request,response);
         } 
         else if(action.equalsIgnoreCase("edit"))
         {
             if(nom!=null)
             {
                    int id = Integer.valueOf(request.getParameter("id"));
                    ShowEditForm(request, response,id);
             }
             else 
              {
                   response.sendRedirect("/login");
              }
         }
         else if(action.equalsIgnoreCase("update"))
         {
             int id = Integer.valueOf(request.getParameter("id"));
             System.out.println("Dans doGet: "+id);
             UpdateUtilisateur(request, response,id);
             
         }
         else if(action.equalsIgnoreCase("delete" ))
         {
             int id = Integer.valueOf(request.getParameter("id"));
             doDelete(request, response,id);
         }
         
    }
   
    protected void ListerUtilisateur(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException
    {
         response.setContentType("text/html;charset=UTF-8");
         request.setAttribute("util", UtilisateurDao.ListerUtilisateur());
         RequestDispatcher rd = request.getRequestDispatcher("Utilisateur/ListerUtilisateur.jsp");
         rd.forward(request, response);
    }

    protected void ShowAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
          this.getServletContext().getRequestDispatcher("/Utilisateur/AjouterUtilisateur.jsp").forward(request, response);
    }
 
     protected void AjouterUtilisateur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Utilisateur util = new Utilisateur();
        util.setName(request.getParameter("nom"));
        util.setPassword(request.getParameter("pass"));
        util.setEmail(request.getParameter("mail"));
        util.setProfil(request.getParameter("profil"));
        UtilisateurDao da = new UtilisateurDao();
        da.AjouterUtilisateur(util);
        
        // this.getServletContext().getRequestDispatcher("Utilisateur/ListerUtilisateur.jsp").forward(request, response);       
         response.sendRedirect("/utilisateur?action=list");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           doGet(request, response);
    }
    
      private void ShowEditForm(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          
          UtilisateurDao da = new UtilisateurDao();
          Utilisateur util = new Utilisateur();
          util = da.getUtilisateur(id);
           System.out.println(util);
          request.setAttribute("util", util);
          RequestDispatcher rd = request.getRequestDispatcher("/Utilisateur/ModifierUtilisateur.jsp");
          rd.forward(request, response);
    }
    
    
    protected void UpdateUtilisateur(HttpServletRequest request, HttpServletResponse response,int id)
            throws ServletException, IOException{
        
        String name = request.getParameter("nom");
        String password = request.getParameter("pass");
        String email = request.getParameter("mail");
        String profil = request.getParameter("profil");
        Utilisateur util = new Utilisateur(email,name,password,profil);
        UtilisateurDao da = new UtilisateurDao();
        da.updateUtilisateur(util,id);
        response.sendRedirect("/utilisateur?action=list");
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response,int id) throws IOException
    {
        
        try {
                UtilisateurDao da = new UtilisateurDao();
                da.deleteUtilisateur(id);
             } catch (SQLException ex) {
                Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        response.sendRedirect("/utilisateur?action=list");
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
  

}
