/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.LoginDao;
import Models.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/"})
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");   
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         this.getServletContext().getRequestDispatcher("/Utilisateur/Login.jsp").forward(request, response);
         
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         String username = request.getParameter("username");
         String password = request.getParameter("pass");
         
         HttpSession session = request.getSession();
         
        try {
                    Utilisateur util = LoginDao.Login(username, password);
                    System.out.println("L'utilisateur existe bien : "+util.getName());
                    if(util != null)
                    {      
                            session.setAttribute("nom", username);
                            response.sendRedirect("/client?action=list");
                     }
                    else
                    {
                        System.out.println("cet utilisateur n'existe pas");
                    }
                        
               } catch (ClassNotFoundException ex) {
                     Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                 Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

//    public void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//         HttpSession session = request.getSession();
//         session.invalidate();
//         doGet(request,response);
//    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
