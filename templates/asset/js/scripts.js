$(document).ready(function() {
    $(".nav-menu a").click(function(event) {
      event.preventDefault();
      $(".nav-menu a.active").removeClass("active");
      $(this).addClass("active");
  
      var target = $(this.hash);
      $("html, body").animate({
        scrollTop: target.offset().top
      }, 1000);
    });
  });

  