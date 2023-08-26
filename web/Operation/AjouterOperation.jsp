<%-- 
    Document   : AjouterOperation
    Created on : Sep 7, 2022, 9:31:14 AM
    Author     : ctombeau
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Nouvelle operation</title>
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
           <h2>Ajouter operation</h2>
           <hr>
           <form action="operation?action=add"  method="POST">
              <c:if test="${not empty devise}">
                       <div class="alert alert-danger" >
                           ${devise}
                      </div>
              </c:if>
                <div class="form-group">
                   <label for="type" class="control-label">Type de compte</label>
                   <select type="text" name="type" id="type" class="form-control mb-4 col-4" onchange="makeOperation()" required>
                    <option value="Dépot">Dépot</option>
                    <option value="Retrait">Retrait</option>
                    <option value="Virement">Virement</option>
                </select>
               </div>
                <div class="form-group" id="devise">
                   <label for="devise" class="control-label">Devise</label>
                   <select type="text" name="devise"  class="form-control mb-4 col-4" required >
                    <option value="Gourdes">Gourdes</option>
                    <option value="Dollars">Dollars</option>
                 </select>
               </div>
               
                <div class="form-group">
                   <label for="montant" class="control-label">Montant</label>
                   <input type="number" name="montant"   class="form-control mb-4 col-4" required/>
                </div>
               
                <div class="form-group">
                   <label for="cpte" class="control-label">Numéro de compte du client</label>
                   <input type="text" name="cpte"  class="form-control mb-4 col-4" required/>
                </div>
               
                <div class="form-group" id="bene">
                   <label for="montant" class="control-label" >Numéro de compte bénéficiaire</label>
                   <input type="text" name="cpteBene"  class="form-control mb-4 col-4"/>
                </div>
               
                <div class="form-group">
                     <button type="submit" class="btn btn-primary">Enregistrer</button>
                </div>
                  
           </form>
          
                 </div>
            </div>
      </div>
     
         <script type="text/javascript">
                        var type = document.getElementById("type");
                        var bene = document.getElementById("bene");
                        var devise = document.getElementById("devise");
                        
                        bene.style.display ="none";
                        
                   function makeOperation()    
                   {
                        if(type.value == "Virement")
                        {
                            bene.style.display = "block";
                            devise.style.display="none";
                        }
                        else
                        {
                            bene.style.display = "none";
                             devise.style.display="block";
                        }
                   }
                   
                 
                </script>
        <%@include file="/WEB-INF/Layout/footer.html" %>
    </body>
</html>
