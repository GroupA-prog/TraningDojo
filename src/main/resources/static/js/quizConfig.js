
var learning = document.getElementById("lea");
var rank = document.getElementById("ran");
var numDisp = document.getElementById("num");
mode = document.getElementsByName("mode");


//モード切り替え
function changeBtn() {

	if (mode[0].checked) {
		learning.style.display = 'block';
		rank.style.display = 'none';
		numDisp.style.display = 'block';

	}
	if (mode[1].checked) {
		learning.style.display = 'none';
		rank.style.display = 'block';
		numDisp.style.display = 'none';
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
			});
		});

	document.createElement('option');

	let option = document.createElement('option');
	option.setAttribute('value', 0);
	option.innerHTML = "選んでください";
	selectNum.appendChild(option);



	var i = 0;
	option = document.createElement('option');
	option.setAttribute('value', 1);
	option.innerHTML = 1;
	selectNum.appendChild(option);



	while (i + 10 < num) {
		i += 10;
		option = document.createElement('option');
		option.setAttribute('value', i);
		option.innerHTML = i;
		selectNum.appendChild(option);
	}
	if (i + 10 >= num) {

		if (num !== 1 && num !== 0) {

			option = document.createElement('option');
			option.setAttribute('value', num);
			option.innerHTML = num;
			selectNum.appendChild(option);
		}
	}
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










