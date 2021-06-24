//制限時間
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

//リタイア
var btn = document.getElementByName('retired');

btn.addEventListener('click', function() {
	var result = window.confirm('本当に諦めるんですか？');

	if(result) {
		window.location.href = 'retired';
	}
	else {
		alert('最後まで頑張って！');
	}
})

//終了
var btn = document.getElementByName('finish');

btn.addEventListener('click', function() {
	var result = window.confirm('解答を保存してクイズを終了しますか？');

	if(result) {
		window.location.href = 'quiz';
	}
	else {
		alert('最後まで頑張って！');
	}
})
