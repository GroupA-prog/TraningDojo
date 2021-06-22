
var learning = document.getElementById("lea");
var rank = document.getElementById("ran");
var num = document.getElementById("num");
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

let select = document.querySelector("#num");

select.addEventListener('change', function() {
	var categoryName = document.getElementByName("categoryName");
	let request = {
		categoryName: categoryName,
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
			return res.json();
		})
		.then(function(data) {
			console.log(data);
			catNum = data;
		});


});










//問題数の表示


