
var learning = document.getElementById("lea");
var rank = document.getElementById("ran");
var num = document.getElementById("categoryId");
mode = document.getElementsByName("mode");

function changeBtn() {

	if (mode[0].checked) {
		learning.style.display = 'block';
		rank.style.display = 'none';
		num.style.display = 'block';

	}
	if (mode[1].checked) {
		learning.style.display = 'none';
		rank.style.display = 'block';
		num.style.display = 'none';
	}


}
window.onload = changeBtn;

let select = document.querySelector('[path="categoryId"]');









//問題数の表示


