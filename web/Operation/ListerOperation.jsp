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
   <h1>Liste des opérations</h1>
   <a href="/operation?action=show"  class="btn btn-primary"> Nouvelle opération</a>
     
     <table class="table table-bordered table-stripped">
     
         <thead>
            <tr>
               <th>Client</th>
               <th>Numéro Compte</th>
               <th>Montant</th>
               <th>Devise</th>
               <th>Type</th>
               <th>Validé par</th>
            </tr>
           </thead>
           <tbody>
           <c:forEach items="${operation}" var="op">
             <tr>
                 <td>${op.NomComplet()}</td>
                 <td>${op.numcompte}</td>
                 <td>${op.montant}</td>
                 <td>${op.devise}</td>
                 <td>${op.type}</td>
                 <td>${op.validepar}</td>
             </tr>
          </c:forEach>     
      
          </tbody>
     </table>
    </div>
        <%@include file="/WEB-INF/Layout/footer.html" %>
    </body>
</html>

