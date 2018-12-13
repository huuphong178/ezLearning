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

$("#nav-profile-banner-s").hover(
    function () {
        $(this).parent().find("#dropdown-profile").fadeIn("fast");
    }
)

$("#nav-profile-banner-s").parent().find("#dropdown-profile").hover(
    function () {
        $(this).fadeIn("fast");
    },
    function () {
        $(this).fadeOut("fast");
    }
)

$("#nav-profile-banner-t").hover(
    function () {
        $(this).parent().find("#dropdown-profile").fadeIn("fast");
    }
)

$("#nav-profile-banner-t").parent().find("#dropdown-profile").hover(
    function () {
        $(this).fadeIn("fast");
    },
    function () {
        $(this).fadeOut("fast");
    }
)

$("#nav-profile-s").hover(
    function () {
        $(this).parent().find("#dropdown-profile").fadeIn("fast");
    }
)

$("#nav-profile-s").parent().find("#dropdown-profile").hover(
    function () {
        $(this).fadeIn("fast");
    },
    function () {
        $(this).fadeOut("fast");
    }
)

$("#nav-profile-t").hover(
    function () {
        $(this).parent().find("#dropdown-profile").fadeIn("fast");
    }
)

$("#nav-profile-t").parent().find("#dropdown-profile").hover(
    function () {
        $(this).fadeIn("fast");
    },
    function () {
        $(this).fadeOut("fast");
    }
)

function signUpModal() {
    $("#sign-up-modal").show();
    $("#sign-in-modal").hide();
    $("#sign-in-tab").removeClass("active");
    $("#sign-up-tab").addClass("active");
}

function signInModal() {
    $("#sign-up-modal").hide();
    $("#sign-in-modal").show();
    $("#sign-up-tab").removeClass("active");
    $("#sign-in-tab").addClass("active");
}

$("#sign-up-tab").click(function () {
    signUpModal();
})

$("#sign-in-tab").click(function () {
    signInModal();
})

function suWarning(msg) {
    $("#su-warn").css("opacity","0");
    setTimeout(function () {
        $("#su-warn").animate({opacity: "1"},200);
    }, 50);
    $("#su-warn").text(msg);
}

function siWarning(msg) {
    $("#si-warn").css("opacity","0");
    setTimeout(function () {
        $("#si-warn").animate({opacity: "1"},200);
    }, 50);
    $("#si-warn").text(msg);
}

$("#sign-up-submit").click(function(){
    $("#su-warn").show();
    suWarning("Test 1");
})

$("#sign-in-submit").click(function(){
    $("#si-warn").show();
    siWarning("Test 2");
})

$(".sign-up-btn").click(function(){
    $("#su-si-modal").fadeIn("fast");
    signUpModal();
})

$(".sign-in-btn").click(function(){
    $("#su-si-modal").fadeIn("fast");
    signInModal();
})

$("#su-si-close").click(function(){
    $("#su-si-modal").fadeOut("fast");
})