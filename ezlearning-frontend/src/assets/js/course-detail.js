$(document).ready(function () {
    $("#payment").css("margin-left",$("#content").css("margin-left"));
    $(document).scroll(function () {
        if ($(this).scrollTop() >= 364) {
            $(".course-tab").css("position","fixed");
            $(".course-tab").css("top","60px");
            $("#payment").css("position","fixed");
            $("#payment").css("top","60px");
            $(".course-detail").css("margin-top","48px");
        } else {
            $('.course-tab').css("position","absolute");
            $(".course-tab").css("top","424px");
            $("#payment").css("position","absolute");
            $("#payment").css("top","424px");
            $(".course-detail").css("margin-top","48px");
        }
    });
})