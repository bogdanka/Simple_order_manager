$(document).ready(function () {
    function changeActiveButton(elem) {
        $(elem).each(function () {
            $(this).toggleClass("active");
        })
    }

    $('button.main_button-add').click(function () {
        $('.forms#add').show();
    });
    $('h3.close').click(function () {
        $('.forms').hide();
    });




});




