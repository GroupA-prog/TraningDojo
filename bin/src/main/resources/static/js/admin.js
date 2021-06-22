
window.onload = function() {
	let errors = document.getElementsByClassName('error');

	if (errors.length != 0) {
		let target = errors[0];
		let parentDiv = target.parentNode;

		$('#modal-overlay, #modal-content').fadeIn();
		parentDiv.style.display = 'block';
	}

	$('#editCategoryId').change(function() {
		request = { categoryId: $('#editCategoryId').val() };
		AsyncCommunication('/categoryName', request, function(data) {
			$('#editCategoryName').val(data.categoryName);
			$('#editCategoryParentCategoryId').val(data.parentCategoryId);
			$('[name=categoryDisplay]').val([data.display + '']);
		});
	});

	$('#loginId').change(function() {
		request = { loginId: $('#loginId').val() };
		AsyncCommunication('/userRole', request, function(data) {
			$('#role').val(data.role);
		});
	});

};



$(".item").click(
	function() {
		$('#modal-overlay, #modal-content').fadeIn("slow");
	}
);

$('.return').click(
	function() {
		$('.createQuiz').fadeOut('slow');
		$('.editQuiz').fadeOut('slow');
		$('.editQuizList').fadeOut('slow');
		$('.createCategory').fadeOut('slow');
		$('.editCategory').fadeOut('slow');
		$('.editUser').fadeOut('slow');
		$('#modal-overlay, #modal-content').fadeOut("slow");
	}
);

//モーダルの表示内容
$('#createQuiz').click(
	function() {
		$('.createQuiz').css('display', 'block');
	}
);
$('#editQuiz').click(
	function() {
		$('.editQuizList').css('display', 'block');
	}
);
$('#createCategory').click(
	function() {
		$('.createCategory').css('display', 'block');
	}
);
$('#editCategory').click(
	function() {
		$('.editCategory').css('display', 'block');
	}
);
$('#editUser').click(
	function() {
		$('.editUser').css('display', 'block');
	}
);

