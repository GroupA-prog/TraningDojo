
function countdown(){
var time = window.sessionStorage.getItem(['time']);
const now = new Date();
const timeUp = new Date(now.getFullYear(),now.getMonth(),now.getDate(),now.getHours(),now.getMinutes()+ time );
const differ = timeUp.getTime()-now.getTime();

const sec = Math.floor(differ/1000)%60;
const min = Math.floor(differ/1000/60)%60;

document.getElementById("min").textContent=String(min).padStart(3,"0");
document.getElementById("sec").textContent=String(sec).padStart(2,"0");
setTimeout(countdown,1000);
}
countdown();


var btn = document.getElementById('retired');

btn.addEventListener('click', function() {
	var result = window.confirm('本当に諦めるんですか？');

	if(result) {
		location.href = 'quizConfig';
	}
	else {
		location.href = 'quiz';
	}
})