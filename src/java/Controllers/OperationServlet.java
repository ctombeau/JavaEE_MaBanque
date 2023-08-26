/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.ClientDao;
import Dao.OperationDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
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
@WebServlet(name = "OperationServlet", urlPatterns = {"/operation"})
public class OperationServlet extends HttpServlet {


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
                        ListerOperation(request, response);
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
                        ShowAddForm(request,response);
                    }
                    else 
                    {
                        response.sendRedirect("/login");
                    }
                }
                else if(action.equalsIgnoreCase("add"))
                {    
                     AjouterOperation(request, response);
                    
                }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           doGet(request, response);
    }
    
    protected void ListerOperation(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException
    {
            request.setAttribute("operation", OperationDao.getAlloperation());
           RequestDispatcher rd = request.getRequestDispatcher("Operation/ListerOperation.jsp");
           rd.forward(request, response);
    }
    
    protected void ShowAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
            RequestDispatcher rd = request.getRequestDispatcher("Operation/AjouterOperation.jsp");
            rd.forward(request, response);
    }
   
    protected void AjouterOperation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {       
            String type = request.getParameter("type");
            String devise = request.getParameter("devise");
            double montant = Double.valueOf(request.getParameter("montant"));
            String numCompte = request.getParameter("cpte");
            String numBene = request.getParameter("cpteBene");
            
            int idCompte = OperationDao.getIdCompte(numCompte);
            int idClient = OperationDao.getIdClientWithCompte(numCompte);
             
  
            if(type.equalsIgnoreCase("Dépot"))
            { 
                if(numCompte.equalsIgnoreCase(OperationDao.getDevise(numCompte)))
                {
                     OperationDao.AddOperation(type, montant, idCompte, idClient);
                    double solde = OperationDao.getSolde(numCompte) + montant;
                    OperationDao.updateCompte(numCompte, solde);
                }
                else
                {
                    System.out.println("Les devises ne sont pas les memes!!!");
                    request.setAttribute("devise", "Les comptes ne sont pas de meme devise");
                    RequestDispatcher rd = request.getRequestDispatcher("Operation/AjouterOperation.jsp");
                    rd.forward(request, response);
                }
                
            }
            else if (type.equalsIgnoreCase("Retrait"))
            {  
                 if(numCompte.equalsIgnoreCase(OperationDao.getDevise(numCompte)))
                {
                   OperationDao.AddOperation(type, montant, idCompte, idClient);
                   double solde = OperationDao.getSolde(numCompte) - montant;
                   OperationDao.updateCompte(numCompte, solde);
                }
                 else
                 {
                        System.out.println("Les devises ne sont pas les memes!!!");
                        request.setAttribute("devise", "Les comptes ne sont pas de meme devise");
                        RequestDispatcher rd = request.getRequestDispatcher("Operation/AjouterOperation.jsp");
                        rd.forward(request, response);
                 }
            }
            else if(type.equalsIgnoreCase("Virement"))
            {
                if(OperationDao.getDevise(numCompte).equalsIgnoreCase(OperationDao.getDevise(numBene)))
                {
                    OperationDao.AddOperation(type, montant, idCompte, idClient);
                    double solde = OperationDao.getSolde(numCompte) - montant;
                    OperationDao.updateCompte(numCompte, solde);
                  
                    double solde2 = OperationDao.getSolde(numBene) + montant;
                    OperationDao.updateCompte(numBene, solde2);
                }
                else
                {
                     System.out.println("Les devises ne sont pas les memes!!!");
                    request.setAttribute("devise", "Les comptes ne sont pas de meme devise");
                    RequestDispatcher rd = request.getRequestDispatcher("Operation/AjouterOperation.jsp");
                    rd.forward(request, response);
                }
            }
            response.sendRedirect("/operation?action=list");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
