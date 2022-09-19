$(document).ready(function () {
   if($('.feedback-slider').length){
       var viewedSlider = $('.feedback-slider');

       viewedSlider.owlCarousel({
           loop: true,
           autoplay: true,
           autoplayTimeout: 6000,
           nav: false,
           dots: false,
           responsiveClass: true,
           responsive: {
               0: {
                   items: 3,
                   margin: 5
               }
           }
       });
   } 
});