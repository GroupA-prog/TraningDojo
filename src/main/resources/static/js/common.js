$(".item").click(
    function() {
        $('#modal-overlay, #modal-content').fadeIn("slow");
    }
);

$('.return').click(
    function() {
        $('#modal-overlay, #modal-content').fadeOut("slow");
    }
);
