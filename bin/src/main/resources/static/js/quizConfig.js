
var learning = document.getElementById("lea");
var rank = document.getElementById("ran");
var numDisp = document.getElementById("num");
mode = document.getElementsByName("mode");
error = document.getElementById("error");
error.style.display = 'block';
numEx = document.getElementById("numEx");

//モード切り替え
function changeBtn() {
	error.style.display = 'none';

	if (mode[0].checked) {
		learning.style.display = 'block';
		rank.style.display = 'none';
		numDisp.style.display = 'block';
		numEx.style.display = 'block';
	}
	if (mode[1].checked) {
		learning.style.display = 'none';
		rank.style.display = 'block';
		numDisp.style.display = 'none';
		numEx.style.display = 'none';
	}


}
window.onload = changeBtn;


//学習モード
function learningChangeCategory() {
	var selectNum = document.getElementById('num');




	//カテゴリ選択のプルダウンを削除
	while (selectNum.firstChild) {
		selectNum.removeChild(selectNum.firstChild);
	};



	var num = 0;

	var categoryId = $("#lea").val();
	let request = {
		categoryId: categoryId,
	};
	fetch("/numJs", {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(request)
	})
		.then(function(res) {
			console.log(res);
			res.json().then(function(data) {
				console.log(data);
				num = data;
				var i = 0;
				while (i < num) {
					i += 10;
					if (i > num) {
						option = document.createElement('option');
						option.setAttribute('value', num);
						option.innerHTML = num;
						selectNum.appendChild(option);
						break;
					}

					option = document.createElement('option');
					option.setAttribute('value', i);
					option.innerHTML = i;
					selectNum.appendChild(option);
				}
			});

		});


	document.createElement('option');

	let option = document.createElement('option');
	option.setAttribute('value', 0);
	option.innerHTML = "選んでください";
	selectNum.appendChild(option);



	/*	var i = 1;
		option = document.createElement('option');
		option.setAttribute('value', 1);
		option.innerHTML = 1;
		selectNum.appendChild(option);
	*/



}

let select = document.querySelector("#lea");
select.addEventListener('change', learningChangeCategory);
window.onload = learningChangeCategory;


function rankChangeCategory() {

	var categoryId = $("#ran").val();
	let request = {
		categoryId: categoryId,
	};
	fetch("/numJs", {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(request)
	})
		.then(function(res) {
			console.log(res);
			res.json().then(function(data) {
				console.log(data);
				num = data;
			});
		});



}










