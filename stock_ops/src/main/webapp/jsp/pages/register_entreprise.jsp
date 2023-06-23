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
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">--%>
    <title>Login</title>
    <style>
        .container {
            margin: 0 auto;
            width: 55%;
            background: #FFFFFF;
            overflow: hidden;
            display: flex;
            border-top-right-radius: 15px;
            border-bottom-right-radius: 15px;
        }

        .container-left {
            align-items: center;
            text-align: center;
            justify-content: center;
            overflow: hidden;
            padding: 30px;
            width: 400px;
            height: 600px;
            background: #18ecec;
            overflow: hidden;
            box-sizing: border-box;
            border-top-right-radius: 15px;
            border-bottom-right-radius: 15px;
        }

        .container-right {
            overflow: hidden;
            padding: 30px;
            width: 400px;
            height: 600px;
            background: #ffff;
            overflow: hidden;
            box-sizing: border-box;
        }

        .form-wrapper {
            text-align: center;
        }

        .inputs {
            overflow: hidden;
        }

        .inputs input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: none;
            outline: none;
            border-bottom: 2px solid #B0B3B9;
        }

        .flex {
            display: flex;
            float: right;
            justify-content: space-between;
        }

        .flex > a {
            text-decoration: none;
            color: #21B2B2;
        }

        .login-form input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #21B2B2;
            border-radius: 5px;
            background-color: #ffffff;
            color: #21B2B2;
            cursor: pointer;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="container-right">

        <div class="form-wrapper">
            <div class="login-form">
                <h2>INSCRIPTION</h2>
                <form action="register_entreprise" method="post">
                    <div class="inputs">
                        <div style="display: flex; align-items: center; color: #21B2B2;">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <input id="nom_entreprise" name="nom_entreprise" style="color: #21B2B2;" type="text"
                                   placeholder="Nom de l'entrerprise">
                        </div>
                        <div style="display: flex; align-items: center;color: #21B2B2;">
                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                            <input id="nif_stat" name="nif_stat" style="color: #21B2B2;" type="text"
                                   placeholder="NIF STAT">
                        </div>
                        <div style="display: flex; align-items: center;color: #21B2B2;">
                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                            <input id="phone" name="phone" style="color: #21B2B2;" type="number"
                                   placeholder="Télephone">
                        </div>
                        <div style="display: flex; align-items: center; color: #21B2B2;">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <input id="email" name="mail" style="color: #21B2B2;" type="email" placeholder="Email">
                        </div>
                        <div style="display: flex; align-items: center;color: #21B2B2;">
                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                            <input id="localisation" name="localisation" style="color: #21B2B2;" type="text"
                                   placeholder="Localisation">
                        </div>
                        <div style="display: flex; align-items: center; color: #21B2B2;">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <input id="proprio" name="proprio" style="color: #21B2B2;" type="text"
                                   placeholder="Proprietaire">
                        </div>
                        <div style="display: flex; align-items: center;color: #21B2B2;">
                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                            <input id="mot_de_passe" name="mot_de_passe" style="color: #21B2B2;" type="password"
                                   placeholder="Mot de passe">
                        </div>
                        <div style="display: flex; align-items: center; color: #21B2B2;">
                            <%List<Offre> list_offre = (ArrayList<Offre>) request.getAttribute("list_offre");%>
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <select id="id_offre" name="id_offre" style="color: #21B2B2;" type="text"
                                    placeholder="Veuillez selectioner une offre">
                                <option>Choisir une Offre</option>
                                <% for (Offre offre : list_offre) { %>
                                <option value="<%= offre.getId()%>"><%=offre.getNom() + " Prix: " + offre.getPrix() + " Stockage: " + offre.getEspace_stockage() %>
                                </option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <br>
                    <div class="flex">
                        <a href="#">En savoir plus?</a>
                    </div>
                    <br><br><br>
                    <input type="submit" value="S'inscrire">
                </form>
            </div>
        </div>

    </div>

    <div class="container-left">

        <img src="assets/img/logo-w.png" alt="Logo" class="logo">
        <div class="form-wrapper">
            <div class="login-form">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    Curabitur et est sed felis aliquet sollicitudin</p>
            </div>
        </div>
        <div class="blank">

        </div>

    </div>
</div>
</body>
</html>
