<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/stock.css">
    <title>StockOps</title>
</head>
<body>
<header>
<jsp:include page="../composants/navbar.jsp"/>
</header>


<div class="container" style="margin: 60px;">

    <div class="search-container">
        <input type="text" placeholder="Saisissez le nom d'un produit">
        <button type="submit"><i style="color: #777;" class="fa fa-search" aria-hidden="true"></i></button>
    </div>

    <div class="button2">
        <button type="submit">Ajouter un produit +</button>
    </div>
    <br><br>

    <div class="products">
        <div class="gallery">
            <div class="image">
                <img src="${pageContext.request.contextPath}/asset/products/1.jpg" alt="">
            </div>
            <div class="desc">
                <h5>Trousse d'art <span>[15]</span></h5>
                <p>Lorem ipsum dolor sit amet,...</p>
                <span>2 000 <b>MGA</b></span>
            </div>
            <div class="edit">
                <a href="#" class="button">Modifier <i class="fa fa-pencil-square" aria-hidden="true"></i></a>
            </div>
        </div>


    </div>

</div>

</body>
</html>