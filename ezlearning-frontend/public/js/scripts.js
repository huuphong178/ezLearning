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
    $("#su-warn").css("opacity", "0");
    setTimeout(function () {
        $("#su-warn").animate({ opacity: "1" }, 200);
    }, 50);
    $("#su-warn").text(msg);
}

function siWarning(msg) {
    $("#si-warn").css("opacity", "0");
    setTimeout(function () {
        $("#si-warn").animate({ opacity: "1" }, 200);
    }, 50);
    $("#si-warn").text(msg);
}

$("#sign-up-submit").click(function () {
    $("#su-warn").show();
    suWarning("Đăng ký không thành công, vui lòng thử lại!");
})

$("#sign-in-submit").click(function () {
    $("#si-warn").show();
    siWarning("Đăng nhập không thành công, vui lòng thử lại!");
})

$(".sign-up-btn").click(function () {
    $("#su-si-modal").fadeIn("fast");
    signUpModal();
})

$(".sign-in-btn").click(function () {
    $("#su-si-modal").fadeIn("fast");
    signInModal();
})

$("#su-si-close").click(function () {
    $("#su-si-modal").fadeOut("fast");
})

function tmodalAction(iconToggle, title, msg, addonToggle, addonText) {
    //iconToggle: 1 - hiện icon thành công, 0 - hiện icon thất bại, khác - không hiện
    //title: tiêu đề thông báo
    //msg: nội dung thông báo
    //addonToggle: 1 - hiện link dẫn đến trang khác (như Tất cả khóa học), khác - không hiện
    //addon Text: nội dung link nếu addonToggle == 1
    
    var modal = $("#modal-template");
    modal.find(".tmodal-title").html(title);
    modal.find(".tmodal-msg").html(msg);
    if (iconToggle == 0) {
        modal.find("#tmodal-failure").show();
    }
    else if (iconToggle == 1) {
        modal.find("#tmodal-success").show();
    }
    if (addonToggle == 1) {
        modal.find("#addon").show();
        modal.find("#addon-text").html(addonText);
    }
    modal.fadeIn();
    modal.find("#tmodal-close").click(function () {
        modal.fadeOut();
    });
}

$("#checkout-submit").click(function () {
    tmodalAction(
        1,
        "Thanh toán thành công",
        "Bạn đã thanh toán thành công khóa học",
        1,
        "Xem đơn hàng"
    );
})