<%-- 
    Document   : ListerClient
    Created on : Jul 27, 2022, 3:24:00 PM
    Author     : ctombeau
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/Layout/header.html" %>
        <div class="container">
   <h1>Liste des clients</h1>
   <a href="/client?action=show"  class="btn btn-primary"> Nouveau client</a>
     
     <table class="table table-bordered table-stripped">
     
         <thead>
            <tr>
               <th>Nom</th>
               <th>Prénom</th>
               <th>Adresse</th>
               <th>Phone</th>
               <th>Numéro Compte</th>
               <th>Solde</th>
               <th>Devise</th>
               <th>Action</th>
            </tr>
           </thead>
           <tbody>
           <c:forEach items="${client}" var="cli">
             <tr>
                 <td>${cli.nom}</td>
                 <td>${cli.prenom}</td>
                 <td>${cli.adresse}</td>
                 <td>${cli.phone}</td>
                 <td>${cli.numcompte}</td>
                 <td>${cli.solde}</td>
                 <td>${cli.devise}</td>
                 <td>
                     <a class="btn btn-info" href="/client?action=edit&id=${cli.idclient}">Modifier</a>
                     <a class="btn btn-danger" href="/client?action=delete&id=${cli.idclient}">Supprimer</a>
                 </td>
             </tr>
          </c:forEach>     
      
          </tbody>
     </table>
     
    </div>
        <%@include file="/WEB-INF/Layout/footer.html" %>
    </body>
</html>

