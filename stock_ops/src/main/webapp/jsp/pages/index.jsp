<%@ page import="com.ops.stock_ops.client.entities.Product" %>
<%@ page import="com.ops.stock_ops.ops.entities.Offre" %>
<%@ page import="com.ops.stock_ops.ops.daos.OffreDao" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.ops.stock_ops.DatabaseConnection" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ops.stock_ops.ops.daos.EntrepriseDao" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Platforme de gestion d'entreprise">
    <meta name="keywords" content="Gestion Entreprise, Gestion, entreprise">
    <title>StockOps</title>
    <link rel="stylesheet" href="../../asset/css/styles.css">
</head>
<body>
<header>
    <nav>
        <img src="../../asset/img/logo.png" alt="StockOps Logo">
        <div class="nav-menu">
            <ul>
                <li><a href="#apropos" class="active">À propos</a></li>
                <li><a href="#avantages">Avantages</a></li>
                <li><a href="#offres">Offre</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
        <a href="${pageContext.request.contextPath}/register_entreprise" class="button">S'inscrire</a>
        <!-- <div class="hamburger">
          <span class="bar"></span>
          <span class="bar"></span>
          <span class="bar"></span>
        </div> -->
    </nav>
</header>
<section class="home" id="apropos">
    <h1>Gérer votre stock plus facilement</h1>
    <p>Simplifiez votre gestion d'inventaire, optimisez vos opérations et gardez le contrôle total sur vos stocks. Avec
        StockOps, vous bénéficiez d'une plateforme conviviale offrant des fonctionnalités avancées telles que la gestion
        des produits, le suivi des stocks, la gestion des ventes et bien plus encore. Notre interface intuitive vous
        permet de démarrer rapidement, même sans expertise technique. Profitez d'une expérience utilisateur fluide et
        d'un support client dédié.</p>
    <a href="#" class="button">Transformez votre gestion de stock avec StockOps</a>
    <div class="images">
        <img src="../../asset/img/4062223-1024x683%201.png" alt="" style="margin-top: 12%;">
        <img src="../../asset/img/kpi-scaled-1-1024x723%201.png" alt="">
    </div>
</section>
<section class="avantages" id="avantages">
    <div>
        <h2>Pourquoi StockOps?</h2>
        <p>StockOps est votre choix idéal pour la gestion de stock, car nous offrons bien plus qu'une simple plateforme.
            Nous nous engageons à vous fournir une solution complète qui répond à tous vos besoins. Notre priorité est
            votre succès, c'est pourquoi nous mettons l'accent sur la facilité d'utilisation, la fiabilité et la
            sécurité de notre système. Avec StockOps, vous bénéficiez d'une expérience utilisateur conviviale, d'une
            interface intuitive et d'un support client réactif pour vous accompagner à chaque étape. Notre plateforme
            évolutive vous permet de faire face à la croissance de votre entreprise sans compromettre les performances.
            Ne vous contentez pas d'une simple gestion de stock, choisissez StockOps pour une solution complète et
            performante qui vous aidera à maximiser votre efficacité et votre rentabilité.</p>

        <% Connection connection = (Connection) request.getAttribute("connection");%>
        <%
            EntrepriseDao entrepriseDao = new EntrepriseDao(connection);
            int n_entreprise = entrepriseDao.get_all().size();
        %>

        <div class="container">
            <div class="avantages-cards">
                <strong>+<%=n_entreprise%>
                </strong>
                <p>Entreprise</p>
            </div>
            <div class="avantages-cards">
                <strong>+1000</strong>
                <p>Utilisateur</p>
            </div>
        </div>
    </div>
    <img src="../../asset/img/logiciel-planification-projet-pour-gestion-projets-entreprise-mode_31965-62879.avif"
         alt=""
         class="avantages-image">
</section>
<section class="entreprises">
    <h2>Plus de 1000 entreprises PME utilise StockOps</h2>
    <p>Rejoignez la communauté florissante de plus de 1000 entreprises PME qui font confiance à StockOps pour simplifier
        leur gestion de stock et booster leur productivité.</p>
    <div class="container">
        <div class="entreprise-card">
            <img src="../../asset/img/LexCorp_logo.webp" alt="" class="card-images">
            <p>Lex corps</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/LexCorp_logo.webp" alt="" class="card-images">
            <p>Lex corps</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/starlab.png" alt="" class="card-images">
            <p>starlab</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/starlab.png" alt="" class="card-images">
            <p>starlab</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
            <p>Wayne En.</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/LexCorp_logo.webp" alt="" class="card-images">
            <p>Lex corps</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/starlab.png" alt="" class="card-images">
            <p>starlab</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
            <p>Wayne En.</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/LexCorp_logo.webp" alt="" class="card-images">
            <p>Lex corps</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/starlab.png" alt="" class="card-images">
            <p>starlab</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
            <p>Wayne En.</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/starlab.png" alt="" class="card-images">
            <p>starlab</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
            <p>Wayne En.</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
            <p>Google</p>
        </div>
        <div class="entreprise-card">
            <img src="../../asset/img/starlab.png" alt="" class="card-images">
            <p>starlab</p>
        </div>
    </div>
</section>
<section class="testmonial">
    <h2>Ce que les gens disent de nous</h2>
    <div class="container">
        <div class="testmonial-card">
            <div class="card-header">
                <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
                <strong>Wayne Entreprise</strong>
            </div>
            <div class="card-body">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est ea quam volupttes cupiditate quae eos
                    magnam, vero quasi sequi commodi.</p>
            </div>
        </div>
        <div class="testmonial-card">
            <div class="card-header">
                <img src="../../asset/img/icons8-logo-google-128.png" alt="" class="card-images">
                <strong>Pauline, responsable des ressources humaines</strong>
            </div>
            <div class="card-body">
                <p>La fonctionnalité de gestion des utilisateurs de StockOps est un véritable atout pour notre
                    entreprise.
                    Nous pouvons facilement attribuer des rôles et des autorisations à nos employés, ce qui garantit un
                    accès sécurisé aux informations sensibles. StockOps nous offre un contrôle précis sur les accès et
                    contribue à renforcer la confidentialité de nos données.</p>
            </div>
        </div>
        <div class="testmonial-card">
            <div class="card-header">
                <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
                <strong>Sophie, propriétaire de boutique en ligne</strong>
            </div>
            <div class="card-body">
                <p>Depuis que j'ai commencé à utiliser StockOps, la gestion de mon inventaire est devenue un jeu
                    d'enfant. Je peux suivre mes produits, gérer les niveaux de stock et traiter les commandes en toute
                    simplicité. Cela m'a permis d'améliorer l'efficacité de mon entreprise et de satisfaire mes
                    clients.</p>
            </div>
        </div>
        <div class="testmonial-card">
            <div class="card-header">
                <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
                <strong>Marc, directeur des opérations</strong>
            </div>
            <div class="card-body">
                <p>StockOps a été un changement majeur pour notre entreprise. La plateforme nous offre une visibilité
                    complète sur nos stocks en temps réel, nous permettant de prendre des décisions éclairées et
                    d'optimiser nos ressources. Notre productivité a considérablement augmenté depuis que nous avons
                    intégré StockOps à notre flux de travail.</p>
            </div>
        </div>
        <div class="testmonial-card">
            <div class="card-header">
                <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
                <strong>Laura, responsable des achats</strong>
            </div>
            <div class="card-body">
                <p>Grâce à StockOps, nous avons réussi à réduire nos coûts liés aux stocks et à éviter les ruptures de
                    stock. La fonctionnalité de suivi des quantités de produits est très précise, ce qui nous permet de
                    gérer nos approvisionnements de manière efficace. StockOps est devenu un outil indispensable pour
                    notre processus d'achat.</p>
            </div>
        </div>
        <div class="testmonial-card">
            <div class="card-header">
                <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
                <strong>Alexandre, gérant de restaurant</strong>
            </div>
            <div class="card-body">
                <p>StockOps a grandement simplifié notre gestion des stocks alimentaires. Nous pouvons facilement suivre
                    les dates de péremption, gérer les commandes et minimiser le gaspillage. Cela nous a permis
                    d'optimiser nos coûts d'approvisionnement et de maintenir un niveau de stock idéal pour satisfaire
                    nos clients.</p>
            </div>
        </div>
        <div class="testmonial-card">
            <div class="card-header">
                <img src="../../asset/img/wayne%20entreprise.jpeg" alt="" class="card-images">
                <strong>Émilie, responsable logistique</strong>
            </div>
            <div class="card-body">
                <p>StockOps a transformé notre processus logistique. Nous pouvons maintenant suivre chaque mouvement de
                    stock, des entrées aux sorties, et optimiser nos flux de travail. La plateforme nous fournit des
                    données précises et des rapports détaillés, ce qui nous aide à prendre des décisions stratégiques
                    pour améliorer notre chaîne d'approvisionnement.</p>
            </div>
        </div>
    </div>
</section>
<section class="offres" id="offres">
    <h1>Nos offres</h1>
    <div class="container">
        <div class="card">
            <h2>choisisez des offres qui vous convient</h2>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quae explicabo aliquam facere?</p>
            <img src="../../asset/img/pngwing.com.png" alt="illustration">
        </div>
        <%
            OffreDao offreDao = new OffreDao(connection);
            List<Offre> list_offre = offreDao.get_all();
            for (Offre offre : list_offre) {
        %>
        <div class="card-offre" id="plus">
            <div class="card-offre-header">
                <img src="../../asset/img/price-tag.png" alt="">
                <strong><%=offre.getNom()%>
                </strong>
            </div>
            <p>Vous aurez</p>
            <div class="offer-avantage">
                <div class="listoffer">
                    <img src="../../asset/img/checked.png" alt="check icon">
                    <p><%=offre.getEspace_stockage()%> Go Stockage</p>
                </div>
                <div class="listoffer">
                    <img src="../../asset/img/checked.png" alt="check icon">
                    <p><%=offre.getFrequence_sauvegard()%> De Frequence de Sauvegard</p>
                </div>
            </div>
            <div class="pricing">
                <p><strong><%=offre.getPrix()%> Ariary</strong>/mois</p>
            </div>
            <button class="btnoutline">Choisir</button>
        </div>
        <% } %>
    </div>
</section>
<script src="../../asset/js/jquery.min.js"></script>
<script src="../../asset/js/scripts.js"></script>
</body>
<footer>
    <div class="stockop-footer">
        <img src="../../asset/img/logo.png" alt="">
        <p>Maîtrisez votre stock avec StockOps, la solution de gestion incontournable.</p>
    </div>
    <div class="services">
        <strong>SERVICES</strong>
        <strong>Gestion de stock</strong>
        <strong>Gestion de stock</strong>
        <strong>Gestion de stock</strong>
    </div>
    <div class="offer-footer">
        <strong>OFFRES</strong>
        <a href="#offres">Pack Plus</a>
        <a href="#offres">Pack Pro</a>
    </div>
    <div class="divers">
        <a href="#home">À propos</a>
        <a href="#avantages">Avantages</a>
        <a href="#contact">Nous contacter</a>
    </div>
</footer>
</html>