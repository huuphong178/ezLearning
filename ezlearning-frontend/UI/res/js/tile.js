$(".tile-course").hover(
    function(){
        $(this).parent("div").find(".tile-preview").show();
    },
    function(){
        $(this).parent("div").find(".tile-preview").hide();
    }
)