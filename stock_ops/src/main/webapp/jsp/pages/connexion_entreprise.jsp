<%--
  Created by IntelliJ IDEA.
  User: j03
  Date: 6/22/23
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="./asset/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>

<div class="content-right">
    <img src="./asset/img/black.png" alt="Logo" class="Logo">
    <label>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita aspernatur adipisci architecto reprehenderit aut possimus sint natus placeat delectus</label>
    <img src="./asset/img/logiciel-planification-projet-pour-gestion-projets-entreprise-mode_31965-62879.avif" alt="illustration" class="illustration">
</div>
<form class="content-left" action="connexion_entreprise" method="post">
    <div class="img-content">
        <img class="img"src="./asset/img/wayne entreprise.jpeg" alt="Logo entreprise">
    </div>

    <h1>Se connecter</h1>
    <div class="form">
        <div class="input-box">
            <div class="input-label">
                <i class="icon fa fa-envelope"></i>
                <input type="email" name="email" required="">
                <label>Email</label>
            </div>
        </div>
        <div class="input-box">
            <div class="input-label">
                <i class="icon fa fa-lock"></i>
                <input type="password" name="mot_de_passe" required="">
                <label>Mot de passe</label>
            </div>
        </div>

    </div>
    <a href="#">Mot de passe oublier?</a>
    <div class="btn">
        <button class="btnoutline">Se connecter</button>
    </div>

</form>
</body>
</html>
