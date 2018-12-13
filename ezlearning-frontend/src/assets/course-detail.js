$(document).ready(function () {

    $('html,body').animate({ scrollTop: 1 }, 'fast');

    function goToByScroll(id) {
        id = id.replace("-tab", "");
        $('html,body').animate({
            scrollTop: ($("#" + id).offset().top - 130)
        },
            'slow');
    }

    $(".tab").click(function () {
        if ($(this).hasClass("tab-disabled")) {
            goToByScroll($(this).attr("id"));
        }
    })

    $("#payment").css("margin-left", $("#content").css("margin-left"));

    $(document).scroll(function () {

        var infoTop = $("#info").offset().top - 131;
        var lectureTop = $("#lecture").offset().top - 131;
        var teacherTop = $("#teacher").offset().top - 131;
        var ratingTop = $("#rating").offset().top - 131;

        if (($(this).scrollTop() >= infoTop) && ($(this).scrollTop() <= lectureTop)) {
            if ($("#info-tab").hasClass("tab-disabled")) {
                $(".tab").removeClass("tab-enabled");
                $(".tab").addClass("tab-disabled");
                $("#info-tab").addClass("tab-enabled");
                $("#info-tab").removeClass("tab-disabled");
            }
        }

        if (($(this).scrollTop() >= lectureTop) && ($(this).scrollTop() <= teacherTop)) {
            if ($("#lecture-tab").hasClass("tab-disabled")) {
                $(".tab").removeClass("tab-enabled");
                $(".tab").addClass("tab-disabled");
                $("#lecture-tab").addClass("tab-enabled");
                $("#lecture-tab").removeClass("tab-disabled");
            }
        }

        if (($(this).scrollTop() >= teacherTop) && ($(this).scrollTop() <= ratingTop)) {
            if ($("#teacher-tab").hasClass("tab-disabled")) {
                $(".tab").removeClass("tab-enabled");
                $(".tab").addClass("tab-disabled");
                $("#teacher-tab").addClass("tab-enabled");
                $("#teacher-tab").removeClass("tab-disabled");
            }
        }

        if (($(this).scrollTop() >= ratingTop)) {
            if ($("#rating-tab").hasClass("tab-disabled")) {
                $(".tab").removeClass("tab-enabled");
                $(".tab").addClass("tab-disabled");
                $("#rating-tab").addClass("tab-enabled");
                $("#rating-tab").removeClass("tab-disabled");
            }
        }

        if ($(this).scrollTop() >= 364) {
            $(".course-tab").css("position", "fixed");
            $(".course-tab").css("top", "60px");
            $("#payment").css("position", "fixed");
            $("#payment").css("top", "60px");
            $(".course-detail").css("margin-top", "48px");
        } else { 
            $('.course-tab').css("position", "absolute");
            $(".course-tab").css("top", "424px");
            $("#payment").css("position", "absolute");
            $("#payment").css("top", "424px");
            $(".course-detail").css("margin-top", "48px");
        }

        var ratingBottom = $("#rating").offset().top + $("#rating").outerHeight(true);
        var priceHeight = $("#payment").outerHeight(true);
        var stopPos = ratingBottom - priceHeight - 40;

        if (stopPos <= $(this).scrollTop()) {
            $("#payment").css("position", "absolute");
            $("#payment").css("top", stopPos + 60);
        }

    });

    var starChoose = false;
    var lastChoose;

    function rateChange(e) {
        var thisId = e.attr("id");
        curId = + thisId.replace("rate-", "");
        for (i = 1; i <= curId; i++) {
            changeId = "rate-" + i;
            $("#" + changeId).attr("src", "res/icons/ratings/rate-full.png");
        }
        for (i > curId; i <= 5; i++) {
            changeId = "rate-" + i;
            $("#" + changeId).attr("src", "res/icons/ratings/rate-outline.png");
        }
    }

    $(".rate-act").mouseenter(function () {
        rateChange($(this));
    })

    $(".rate-star").mouseleave(function () {
        if (starChoose == false) {
            for (i = 1; i <= 5; i++) {
                changeId = "rate-" + i;
                $("#" + changeId).attr("src", "res/icons/ratings/rate-outline.png");
            }
        }
        else {
            rateChange(lastChoose);
        }
    })

    $(".rate-act").click(function () {
        rateChange($(this));
        lastChoose = $(this);
        starChoose = true;
    })

    $("#rate-submit").click(function(){
        $(".comment-act").hide();
        $(".re-rate").show();
    })

    $(".re-rate > a").click(function(){
        $(".comment-act").show();
        $(".re-rate").hide();
    })

})