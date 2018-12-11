$(document).ready(function () {
$(".tile-course").hover(
    function () {
        $(this).parent("div").find(".tile-preview").show();
    },
    function () {
        $(this).parent("div").find(".tile-preview").hide();
    }
)

$(".popular-right").click(function(){
    $(this).parents('.popular').find(".popular-list").animate({marginLeft: "-102%"}, 600);
    $(this).fadeOut("fast");
    $(this).parents(".popular").find(".popular-left").fadeIn("fast");
})

$(".popular-left").click(function(){
    $(this).parents(".popular").find(".popular-list").animate({marginLeft: "0%"}, 600);
    $(this).parents(".popular").find(".popular-right").fadeIn("fast");
    $(this).fadeOut("fast");
})
})