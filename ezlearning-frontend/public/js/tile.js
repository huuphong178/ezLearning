$(document).ready(function () {
    $(".tile-course").hover(
        function () {
            $(this).parent("div").find(".tile-preview").show();
        },
        function () {
            $(this).parent("div").find(".tile-preview").hide();
        }
    )
})

function showSlides(curId) {
    var nextId;
    nextId = curId + 1;
    if (nextId > 3) nextId = 1;
    var nextObj = $("#v" + nextId);
    var curObj = $("#v" + curId);
    curObj.fadeOut();
    nextObj.fadeIn();
    setTimeout(showSlides(nextId), 10000);
}

$(document).ready(function () {

    $("#v2").hide();
    $("#v3").hide();
    setTimeout(showSlides(1), 000);
})


