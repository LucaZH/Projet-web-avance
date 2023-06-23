<%@ page import="com.ops.stock_ops.ops.entities.Offre" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: j03
  Date: 6/18/23
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="./asset/css/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<form class="content-left" action="${pageContext.request.contextPath}/register_entreprise" method="post">
    <h1>Inscription</h1>
    <div class="content-info">
        <div class="info">
            <div class="input-box">
                <div class="input-label">
                    <i class="icon fa fa-building"></i>
                    <input type="text" name="nom_entreprise" required="">
                    <label>Nom de l'entreprise</label>
                </div>
            </div>
            <div class="input-box">
                <div class="input-label">
                    <i class="icon fa fa-scale-balanced"></i>
                    <input type="number" name="nif" required="">
                    <label>NIF</label>
                </div>
            </div>
            <div class="input-box">
                <div class="input-label">
                    <i class="icon fa fa-scale-balanced"></i>
                    <input type="number" name="stat" required="">
                    <label>STAT</label>
                </div>
            </div>
            <div class="input-box">
                <div class="input-label">
                    <i class="icon fa fa-phone"></i>
                    <input type="tel" name="phone" required="">
                    <label>Telephone</label>
                </div>
            </div>
        </div>
        <div class="insertimg">
            <div class="drag-file">
                <p>Inserer votre logo</p>
            </div>
            <label class="uploadbtn">
                <input type="file" name="logo" required="">
                Choisir le fichier
            </label>
        </div>
    </div>
    <div class="other">

        <div class="input-box">
            <div class="input-label">
                <i class="icon fa fa-envelope"></i>
                <input type="email" name="email" required="">
                <label>Email</label>
            </div>
        </div>
        <div class="input-box">
            <div class="input-label">
                <i class="icon fa fa-location-dot"></i>
                <input type="text" name="localisation" required="">
                <label>Localisation</label>
            </div>
        </div>
        <div class="input-box">
            <div class="input-label">
                <i class="icon fa fa-user"></i>
                <input type="text" name="proprio" required="">
                <label>Propriétaire</label>
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
    <div class="offer">
        <div class="register-offer">
            <%List<Offre> list_offre = (ArrayList<Offre>) request.getAttribute("list_offre");%>
            <i class="fa fa-user" aria-hidden="true"></i>
            <select name="id_offre" required="" id="offer-select" placeholder="Veuillez selectioner une offre">
                <option>Choisir une Offre</option>
                <% for (Offre offre : list_offre) { %>
                <option value="<%= offre.getId()%>"><%=offre.getNom() + " Prix: " + offre.getPrix() + " Stockage: " + offre.getEspace_stockage() %>
                </option>
                <% } %>
            </select>
            <a href="#">En savoir plus?</a>
        </div>
    </div>
    <div class="btn">
        <button type="submit" class="btnoutline">S'inscrire</button>
    </div>

</form>
<div class="content-right">
    <img src="./asset/img/black.png" alt="Logo" class="Logo">
    <label>Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita aspernatur adipisci architecto
        reprehenderit aut possimus sint natus placeat delectus</label>
    <img src="./asset/img/logiciel-planification-projet-pour-gestion-projets-entreprise-mode_31965-62879.avif"
         alt="illustration" class="illustration">
</div>
</body>
</html>
