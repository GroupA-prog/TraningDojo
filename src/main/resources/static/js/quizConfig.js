var radioMode = element.mode;
var mode = radioMode.value;
var learning = document.getElementById("learningCategory");
var rank = document.getElementById("rankCategory");
var num = document.getElementById("num");

if(learning.checked){
	learning.style.display = 'block';
	rank.style.display = 'none';

}
if(rank.checked){
	learning.style.display = 'none';
	rank.style.display = 'block';

}

if(mode == 1){
	num.style.display = 'block';
}

if(mode == 2){
	num.style.display = 'none';
}






//問題数の表示
let categorySelect = document.querySelector('[path="categoryId"]');
categorySelect.onchange = event => {

}