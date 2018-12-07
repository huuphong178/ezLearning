$(".tile-course").hover(
    function () {
        $(this).parent("div").find(".tile-preview").show();
    },
    function () {
        $(this).parent("div").find(".tile-preview").hide();
    }
)

function showSlides(curId) {
    var nextId;
    nextId = curId + 1;
    if (nextId > 3) nextId = 1;
    var nextObj = $("#v" + nextId);
    var curObj = $("#v" + curId);
    nextObj.fadeIn();   
    curObj.fadeOut();
    setTimeout(showSlides(nextId), 3000);
}

$(document).ready(function () {

    $("#v2").hide();
    $("#v3").hide();

    setTimeout(showSlides(1), 3000);


})