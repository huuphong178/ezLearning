$(document).ready(function () {
    $(".tile-course").hover(
        function () {
            $(this).parent("div").find(".tile-preview").show();
        },
        function () {
            $(this).parent("div").find(".tile-preview").hide();
        }
    )

    $("#popular-right").click(function () {
        $("#popular-list").animate({
            marginLeft: "-102%"
        }, 600);
        $("#popular-right").fadeOut("fast");
        $("#popular-left").fadeIn("fast");
    })

    $("#popular-left").click(function () {
        $("#popular-list").animate({
            marginLeft: "0%"
        }, 600);
        $("#popular-right").fadeIn("fast");
        $("#popular-left").fadeOut("fast");
    })
})