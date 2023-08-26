/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.CompteDao;
import Models.Client;
import Models.Compte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ctombeau
 */
public class CompteServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
            HttpSession session = request.getSession();
           String nom = (String) session.getAttribute("nom");
           String action = request.getParameter("action");
                
                if(action.equalsIgnoreCase("show"))
                {  
                    if(nom!=null)
                    {
                        ShowCompteForm(request, response);
                        System.out.println("Test dans Session : "+nom);
                    }
                     else 
                    {
                        response.sendRedirect("/login");
                    }
                 
                }
                else if(action.equalsIgnoreCase("add"))
                {
                     AjouterCompte(request, response);
                }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void ShowCompteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         this.getServletContext().getRequestDispatcher("/Compte/AjouterCompte.jsp").forward(request, response);
    }
    
    public void AjouterCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         Random rand = new Random();
         String numcompte = String.valueOf(rand.nextInt(Integer.valueOf(request.getParameter("phone"))));
         Compte cpte = new Compte();
         cpte.setNumcompte(numcompte);
         cpte.setDevise(request.getParameter("devise"));
         cpte.setSolde(Double.valueOf(request.getParameter("solde")));
         
         Client client = new Client();
         client.setNom(request.getParameter("nom"));
         client.setPrenom(request.getParameter("prenom"));
         client.setPhone(request.getParameter("phone"));
         
         CompteDao.AddCompte(cpte, client);
         
         response.sendRedirect("/client?action=list"); 
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
