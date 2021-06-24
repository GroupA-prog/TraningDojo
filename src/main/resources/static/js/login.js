window.onload = function() {


	$('#reCheck').click(function() {
		console.log('hello');
		$('#modal-overlay').fadeIn('slow');
		$('#modal-content').fadeIn('slow');

		$('#confirmLoginId').val( $('#newLoginId').val() );
		$('#confirmUserName').val( $('#newUserName').val() );
	});

	$('.back').click(function() {
		$('#modal-overlay').fadeOut('slow');
		$('#modal-content').fadeOut('slow');
	});
};