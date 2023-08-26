<%-- 
    Document   : ModifierClient
    Created on : Jul 27, 2022, 3:24:21 PM
    Author     : ctombeau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            label{
                font-weight: bold;
            }
        </style>
    </head>
    <body>
       <%@include file="/WEB-INF/Layout/header.html" %>
        <div class="container">
             <div class="row">
                 <div class="col-md-8 col-md-offset-4 col-sm-10 col-sm-offset-2">
           <h2>Modifier Client</h2>
           <hr>
           <form action="client?action=update"  method="POST">
               <input type="hidden" name="id" value="${client.idclient}">
               <div class="form-group">
                   <label for="nom" class="control-label">Nom du client</label>
                   <input type="text" name="nom" class="form-control mb-4 col-4"  value="${client.nom}" required>
               </div>
                <div class="form-group">
                   <label for="prenom" class="control-label">Prénom du client</label>
                   <input type="text" name="prenom" class="form-control mb-4 col-4" value="${client.prenom}" required>
               </div>
               <div class="form-group">
                   <label for="date" class="control-label">Date de naissance</label>
                   <input type="date" name="date" class="form-control mb-4 col-4" value="${client.date_naissance}" required>
               </div>
               
                <div class="form-group">
                   <label for="adresse" class="control-label">Adresse du client</label>
                   <input type="text" name="adresse" class="form-control mb-4 col-4" value="${client.adresse}" required>
               </div>
             <div class="form-group">
                   <label for="phone" class="control-label">Téléphone du client</label>
                   <input type="text" name="phone" class="form-control mb-4 col-4" value="${client.phone}" required>
               </div>
                
                <div class="form-group">
                   <button type="submit" class="btn btn-primary btn-block">Modifier</button>
                </div>              
            
           </form>
     
                 </div>
             </div>
      </div>
       
           <%@include file="/WEB-INF/Layout/footer.html" %>
    </body>
</html>
