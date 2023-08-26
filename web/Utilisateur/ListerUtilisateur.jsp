<%-- 
    Document   : ListerUtilisateur
    Created on : May 23, 2022, 8:20:05 PM
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
   <h1>Liste des utilisateurs</h1>
   <a href="/utilisateur?action=show"  class="btn btn-primary"> Nouvel Utilisateur</a>
     
     <table class="table table-bordered table-stripped">
     
         <thead>
            <tr>
               <th>ID</th>
               <th>Nom</th>
               <th>Email</th>
               <th>Profil</th>
               <th>Action</th>
            </tr>
           </thead>
           <tbody>
           <c:forEach items="${util}" var="p">
             <tr>
                 <td>${p.id}</td>
                 <td>${p.name}</td>
                 <td>${p.email}</td>
                 <td>${p.profil}</td>
                 <td>
                  <a href="/utilisateur?action=edit&id=${p.id}" class="btn btn-info" >Modifier</a>
                  <a href="/utilisateur?action=delete&id=${p.id}" class="btn btn-danger" >Supprimer</a>
                 </td>
             </tr>
          </c:forEach>     
      
          </tbody>
     </table>
    </div>
        <%@include file="/WEB-INF/Layout/footer.html" %>
    </body>
</html>
