$(document).ready(function () {
    $(".tab").click(function () {
        id = $(this).attr("id").replace("-tab", "");
        $(".tab").removeClass("tab-enabled");
        $(".tab").addClass("tab-disabled");
        $(this).addClass("tab-enabled");
        $(this).removeClass("tab-disabled");
        $(".tab-content").hide();
        $("#" + id).show();
    })

    $("#tprofile-edit-btn").click(function(){
        $("#tprofile-edit").show();
        $("#tprofile-info").hide();
    })

    $("#tprofile-save-btn").click(function(){
        $("#tprofile-info").show();
        $("#tprofile-edit").hide();
    })
})
