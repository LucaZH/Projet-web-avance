<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="navigation-bar">
    <div class="first-navbar">
        <ul class="navbar">
            <li>
                <div class="logo-img">
                    <img src="${pageContext.request.contextPath}/asset/img/logo-w.png" class="logo-image">
                </div>
            </li>
            <li style="float:right">
                <div class="avatar-img">
                    <img src="${pageContext.request.contextPath}/asset/pdp/pexels-justin-shaifer-1222271.jpg" class="avatar-image">
                    <a href="#">Johnny</a>
                </div>
            </li>
            <li style="float:right">
                <a href="#"><i class="fa fa-cogs" aria-hidden="true"></i> Paramètre</a>
            </li>
            <li style="float:right">
                <a href="#"><i class="fa fa-user" aria-hidden="true"></i> Service Client</a>
            </li>
        </ul>
    </div>
    <div class="second-navbar">
        <ul class="navbar2">
            <li><a class="active" href="stock.html"><i class="fa fa-cubes" aria-hidden="true"></i> Gestion des
                stocks</a></li>
            <li><a href="user.html"><i class="fa fa-user-circle" aria-hidden="true"></i> Gestion des
                utilisateurs</a></li>
            <li><a href="vente.html"><i class="fa fa-book" aria-hidden="true"></i> Gestion des ventes</a></li>
            <li><a href="#"><i class="fa fa-desktop" aria-hidden="true"></i> Tableau de Bord</a></li>
        </ul>
    </div>
</div>