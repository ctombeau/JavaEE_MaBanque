<%-- 
    Document   : AjouterClient
    Created on : Jul 27, 2022, 3:23:42 PM
    Author     : ctombeau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Nouvel Utilisateur</title>
        <style>
            label{
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <%@include file="/WEB-INF/Layout/header.html" %>
        <div class="container">
            <div class="container">
             <div class="row">
                 <div class="col-md-8 col-md-offset-4 col-sm-10 col-sm-offset-2">
           <h2>Nouveau Compte</h2>
           <hr>
           <form action="compte?action=add"  method="POST">
                <div class="form-group">
                   <label for="solde" class="control-label">Montant d'ouverture de compte</label>
                   <input type="number" name="solde" class="form-control mb-4 col-4" required/>
               </div>
               <div class="form-group">
                   <label for="devise" class="control-label">Devise</label>
                   <select type="text" name="devise" class="form-control mb-4 col-4" required>
                    <option value="Gourdes">Gourdes</option>
                    <option value="Dollars">Dollars</option>
                </select>
               </div>
               <div class="form-group">
                   <label for="nom" class="control-label">Nom du client</label>
                   <input type="text" name="nom"   class="form-control mb-4 col-4" required/>
               </div>
               <div class="form-group">
                   <label for="prenom" class="control-label">Prénom du client</label>
                   <input type="text" name="prenom"  class="form-control mb-4 col-4" required/>
               </div>
               <div class="form-group">
                   <label for="phone" class="control-label">Téléphone du client</label>
                   <input type="text" name="phone" class="form-control mb-4 col-4" required/>
               </div>
                
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                </div>	           
            
           </form>
                 </div>
               </div>
      </div>
        <%@include file="/WEB-INF/Layout/footer.html" %>
    </body>
</html>
