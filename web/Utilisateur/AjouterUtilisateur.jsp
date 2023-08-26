<%-- 
    Document   : AjouterUtilisateur
    Created on : May 23, 2022, 8:19:38 PM
    Author     : ctombeau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
           <div class="row">
                 <div class="col-md-8 col-md-offset-4 col-sm-10 col-sm-offset-2">
           <h2>Ajouter utilisateur</h2>
           <hr>
           <form action="utilisateur?action=add"  method="POST">
               <div class="form-group">
                   <label for="nom" class="control-label">Nom d'utilisateur</label>
                  <input type="text" name="nom"   class="form-control mb-4 col-4"/>
               </div>
               <div class="form-group">
                   <label for="password" class="control-label">Mot de passe</label>
                  <input type="password" name="pass"  class="form-control mb-4 col-4"/>
               </div>
               <div class="form-group">
                   <label for="mail" class="control-label">Email</label>
                   <input type="text" name="mail" class="form-control mb-4 col-4"/>
               </div>
               <div class="form-group">
                   <label for="profil" class="control-label">Profil</label>
                      <select type="text" name="profil" class="form-control mb-4 col-4">
                    <option value="Administrateur">Administrateur</option>
                    <option value="Caissier">Caissier</option>
                    <option value="Informaticien">Informaticien</option>
                    <option value="Superviseur">Superviseur</option>
                </select>
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
