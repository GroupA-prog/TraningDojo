
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
			$('#editCategoryParentCategoryId').val(data.parentCategoryId == null ? -1 : data.parentCategoryId);
			$('[name=categoryDisplay]').val([data.display + '']);

			console.log(data.parentCategoryId);
		});
	});

	$('#loginId').change(function() {
		request = { loginId: $('#loginId').val() };
		AsyncCommunication('/userRole', request, function(data) {
			$('#role').val(data.role);
		});
	});

	//カテゴリごとの問題一覧表示
	$('#selectQuizCategoryId').change(function() {
		request = { categoryId: $('#selectQuizCategoryId').val() };
		AsyncCommunication('/getQuizList', request, function(data) {
			console.log(data);
			$('#quizListTable').find('tbody tr').remove();
			data.forEach(function(d) {
				let tag = '<tr><td>' + d.quizId + '</td><td><a id="' + d.quizId + '">' + d.quizTitle + '</a></td></tr>';
				$('#quizListTable').append(tag);
			});
			//クイズ編集情報をセット
			$('#quizListTable a').on('click', function(e) {
				$('.editQuizList').fadeOut('fast');
				$('.editQuiz').fadeIn('slow');

				console.log($(this).attr('id'));
				let request = { quizId: $(this).attr('id')};
				AsyncCommunication('/getQuiz', request, function(data) {
					console.log(data);
					$('#editQuizCategoryId').val(data.categoryId);
					$('#editQuizTitle').val(data.quizTitle);
					$('#editProblemStatement').val(data.quizStatment);
					$('#editChoice1').val(data.quizSelect[0].choice);
					$('#editChoice2').val(data.quizSelect[1].choice);
					$('#editChoice3').val(data.quizSelect[2].choice);
					$('#editChoice4').val(data.quizSelect[3].choice);
					$('#editAnswer').val(data.correctAnswer);
					$("input[name='quizDisplay']").val(["" + data.display]);
					$('#editCommentary').val(data.commentary);
				});
			});
		});
	});

};



$(".item").click(
	function() {
		$('#modal-overlay, #modal-content').fadeIn("slow");
	}
);

$('.return').click(function() {
		$('.createQuiz').fadeOut('slow');
		$('.editQuiz').fadeOut('slow');
		$('.editQuizList').fadeOut('slow');
		$('.createCategory').fadeOut('slow');
		$('.editCategory').fadeOut('slow');
		$('.editUser').fadeOut('slow');
		$('#modal-overlay, #modal-content').fadeOut("slow");
});

$('.returnQuizList').click(function() {
	$('.editQuiz').fadeOut('fast');
	$('.editQuizList').fadeIn('slow');
});

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

