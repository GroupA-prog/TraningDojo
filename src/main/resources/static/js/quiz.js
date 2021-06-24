

function buttonClick() {
	var result = window.confirm('本当に諦めるんですか？');
	console.log(result);
	if(result) {
		window.location.href = 'retired';
	}
	else {
		alert('最後まで頑張って！');
	}
}
var btn = document.getElementById('retired');

btn.addEventListener('click', buttonClick);



var btn = document.getElementById('finish');

btn.addEventListener('click', function() {
	var result = window.confirm('解答を保存してクイズを終了しますか？');

	if(result) {
		window.location.href = 'quiz';
	}
	else {
		alert('最後まで頑張って！');
		return false;
	}
})

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
