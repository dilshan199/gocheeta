jQuery().ready(function(){
    var current_fs, next_fs, previous_fs;
    var opacity;
    var validate = jQuery("#bookingForm").validate({
        rules: {
			branchId: {
				required: true
			},
            pickUp: {
                required: true
            },
            dropLocation: {
                required: true
            },
            pickUpDate: {
                required: true
            }
        },
        errorElement: 'span',
        errorClass: 'help-inline-error',
    });
    $(".next").click(function(){
        if(validate.form()){
            current_fs = $(this).parent();
            next_fs = $(this).parent().next();

            $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

            next_fs.show();
            current_fs.animate({opacity:0},{
                step: function(now){
                    opacity = 1 - now;
                    current_fs.css({
                        'display': 'none',
                        'position': 'relative'
                    });
                    next_fs.css({
                        'opacity': opacity
                    });
                },
                duration: 600
            });
        }
    });
    jQuery(".prev").click(function () {
        current_fs = jQuery(this).parent();
        previous_fs = jQuery(this).parent().prev();

        jQuery("#progressbar li").eq(jQuery("fieldset").index(current_fs)).removeClass("active");

        previous_fs.show();
        current_fs.animate({opacity: 0},{
            step: function(now){
                opacity = 1 - now;

                current_fs.css({
                    'display': 'none',
                    'position': 'relative'
                });
                previous_fs.css({
                    'opacity': opacity
                });
            },
            duration: 600
        });
    });
});