$(document).ready(function () {
    $(".navbar").hide();
    $(document).scroll(function () {
        if ($(this).scrollTop() > 50) {
            $(".navbar").slideDown(200);
        } else {
            $('.navbar').slideUp(200);
        }
    });
})