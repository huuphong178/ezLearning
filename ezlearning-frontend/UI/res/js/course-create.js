$(document).ready(function(){
    $('#upload-input').change(function() {
        var i = $("#custom-upload").find("#filename");
        var file = $('#upload-input')[0].files[0].name;
        i.html(file);
      });
})