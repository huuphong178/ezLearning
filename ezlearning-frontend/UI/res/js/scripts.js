$(document).ready(function () {
    $(document).scroll(function () {
        if ($(this).scrollTop() > 50) {
            $(".navbar").slideDown(200);
        } else {
            $('.navbar').slideUp(200);
        }
    });
})

$("#fteachers-right").click(function () {
    $("#fteachers-list").animate({
        marginLeft: "-102%"
    }, 600);
    $("#fteachers-right").fadeOut("fast");
    $("#fteachers-left").fadeIn("fast");
})

$("#fteachers-left").click(function () {
    $("#fteachers-list").animate({
        marginLeft: "0%"
    }, 600);
    $("#fteachers-right").fadeIn("fast");
    $("#fteachers-left").fadeOut("fast");
})

$("#nav-cats").hover(
    function () {
        $(this).parent().find("#dropdown-cats").fadeIn("fast");
    }
)

$("#nav-cats").parent().find("#dropdown-cats").hover(
    function () {
        $(this).fadeIn("fast");
    },
    function () {
        $(this).fadeOut("fast");
    }
)

$("#nav-cats-banner").hover(
    function () {
        $(this).parent().find("#dropdown-cats").fadeIn("fast");
    }
)

$("#nav-cats-banner").parent().find("#dropdown-cats").hover(
    function () {
        $(this).fadeIn("fast");
    },
    function () {
        $(this).fadeOut("fast");
    }
)