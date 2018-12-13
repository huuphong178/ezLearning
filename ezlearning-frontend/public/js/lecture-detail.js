$(document).ready(function () {

    $(".tab").click(function(){
        id = $(this).attr("id").replace("-tab","");
        $(".tab").removeClass("tab-enabled");
        $(".tab").addClass("tab-disabled");
        $(this).addClass("tab-enabled");
        $(this).removeClass("tab-disabled");
        $(".tab-content").hide();
        $("#" + id).show();
    })
})