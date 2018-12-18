$(document).ready(function(){

    var el = $('<img src="res/icons/lecture-create/add.png" width="15px" class="btn-img add-btn">');

    $("#new-course").click(function(){
        $("#cadd-modal").fadeIn("fast");
    })

    $("#cmodal-close").click(function(){
        $("#cadd-modal").fadeOut("fast");
    })

    $(".add-btn").click(function(){
        $("#ladd-modal").fadeIn("fast");
    })

    $("#lmodal-close").click(function(){
        $("#ladd-modal").fadeOut("fast");
    })

    $(".delete-btn").click(function(){
        $(this).parent().parent().parent().parent().remove();
    })

    $(".ldelete-btn").click(function(){
        $(this).parent().parent().remove();
    })

})