
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Login</title>
        <style>
            #form{
                width: 30%;
                border-radius: 20px;
                border: 3px solid #33A2FF;
                text-align: center;
                justify-content: center;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                height: 300px;
            }
            
            h3{
                text-align: center;
                margin-bottom: 5%;
                margin-top: 5%;
                color : #33A2FF;
            }
        </style>
    </head>
    <body>
       <div class="container mt-6" id="form">
           <h3 >Connexion</h3>
   
           <form action="/login"  method="POST">
                <input type="text" name="username"   placeholder="nom d'utilisateur"
     			class="form-control mb-4 col-4"/>
                <input type="password" name="pass"  placeholder="mot de passe"
     			class="form-control mb-4 col-4"/>
     		           
            <button type="submit" class="btn" style="background-color:  #33A2FF; color: white">LOGIN</button>
           </form>
           
    </body>
 
</html>
