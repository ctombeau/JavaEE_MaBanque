/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.ClientDao;
import Dao.UtilisateurDao;
import Models.Client;
import Models.Compte;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
//import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.runtime.ParserException;

/**
 *
 * @author ctombeau
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/client"})
public class ClientServlet extends HttpServlet {
     // Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       // SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
           HttpSession session = request.getSession();
           String nom = (String) session.getAttribute("nom");
           String action = request.getParameter("action");
                
                if(action.equalsIgnoreCase("list"))
                {  
                    if(nom!=null)
                    {
                        ListerClient(request, response);
                        System.out.println("Test dans Session : "+nom);
                    }
                    else 
                    {
                        response.sendRedirect("/login");
                    }
                }
                else if(action.equalsIgnoreCase("show"))
                {   
                    if(nom!=null)
                    {
                         ShowClientForm(request, response);
                    }
                     else 
                    {
                        response.sendRedirect("/login");
                    }
                }
                else if(action.equalsIgnoreCase("add"))
                {    
                                AjouterClient(request, response);
                               
                }
                else if (action.equalsIgnoreCase("edit"))
                { 
                    if(nom!=null)
                    {
                         int id = Integer.valueOf(request.getParameter("id"));
                        ShowClient(request, response,id);
                    }
                     else 
                    {
                        response.sendRedirect("/login");
                    }
                }
                else if (action.equalsIgnoreCase("update"))
                {
                    int id = Integer.valueOf(request.getParameter("id"));
                    ModifierClient(request, response,id);
                }
                else if(action.equalsIgnoreCase("delete"))
                {
                    int id = Integer.valueOf(request.getParameter("id"));
                    SupprimerClient(request, response, id);
                }
    }
 
    protected void ListerClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         request.setAttribute("client", ClientDao.getAllClient());
         RequestDispatcher rd = request.getRequestDispatcher("Client/ListerClient.jsp");
         rd.forward(request, response);
    }
    
    protected void ShowClientForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher rd = request.getRequestDispatcher("Client/AjouterClient.jsp");
        rd.forward(request, response);
    }
    
    protected void AjouterClient(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException
    {   
            Random rand = new Random();     
            try {
                    
                    Client client = new Client();
                    client.setNom(request.getParameter("nom"));
                    client.setPrenom(request.getParameter("prenom"));
                  // client.setDate_naissance( request.getParameter("date"));
                    client.setDate_naissance(sdf.parse(request.getParameter("date")));
                    client.setPhone(request.getParameter("phone"));
                    client.setAdresse(request.getParameter("adresse"));
                    client.setCreele(new Date());
                
                    String numcompte = String.valueOf(rand.nextInt(Integer.valueOf(request.getParameter("phone"))));
                    Compte compte = new Compte();
                    compte.setNumcompte(numcompte);
                    compte.setSolde(Double.parseDouble(request.getParameter("solde")));
                    compte.setDevise(request.getParameter("devise"));
                
                    ClientDao cliDao = new ClientDao();
                    cliDao.AddClient(client, compte);
                  
            } catch (ParseException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
             response.sendRedirect("/client?action=list"); 
    }
    
    protected void ShowClient(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException
    {
         
          ClientDao da = new ClientDao();
           Client client = new Client();
           client = da.getClient(id);
          request.setAttribute("client", client);
          RequestDispatcher rd = request.getRequestDispatcher("/Client/ModifierClient.jsp");
          rd.forward(request, response);
    }
    
    protected void ModifierClient(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException
    {
         
            try {
                        Client client = new Client();
                        client.setNom(request.getParameter("nom"));
                        client.setPrenom(request.getParameter("prenom"));
                        client.setDate_naissance(sdf.parse(request.getParameter("date")));
                        client.setPhone(request.getParameter("phone"));
                        client.setAdresse(request.getParameter("adresse"));
                        client.setModifiele(new Date());
                        
                        ClientDao.updateClient(client, id);
            } catch (ParseException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
          response.sendRedirect("/client?action=list"); 
    }
    
    protected void SupprimerClient(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException
    {  
         ClientDao.SupprimerClientAvecCompte(id);
          response.sendRedirect("/client?action=list"); 
         System.out.println("L'id du client est: "+id);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
