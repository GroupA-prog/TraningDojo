

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

function firstcountdown(){

    const time = 1200000;
	const startTime = Date.now();

	const timeId = setInterval(() =>{
		const currentTime = Date.now();

		const diff = currentTime - startTime;
		const diffsec = time - diff;

		window.sessionStorage.setItem(['startTime'],['startTime']);
		window.sessionStorage.setItem(['time'],['diffsec']);

		const sec = Math.floor(diffsec/1000)%60;
		const min = Math.floor(diffsec/1000/60);
		console(sec);
		alte(min);

		document.getElementById("min").textContent=String(min).padStart(2,"0");
		document.getElementById("sec").textContent=String(sec).padStart(2,"0");


		if(diffsec <= 0){
			clearInterval(timeId);
			window.location.href = 'retired';
		}
	})
}

firstcountdown();



function countdown(){
	const time = window.sessionStorage.getItem(['time']);
	const startTime = window.sessionStorage.getItem(['startTime']);

	const timeId = setInterval(() =>{
		const currentTime = Date.now();

		const diff = currentTime - startTime;
		const diffsec = time - diff;

		window.sessionStorage.setItem(['startTime'],['startTime']);
		window.sessionStorage.setItem(['time'],['diffsec']);

		const sec = Math.floor(diffsec/1000)%60;
		const min = Math.floor(diffsec/1000/60);

		alte(sec);
		alte(min);

		document.getElementById("min").textContent=String(min).padStart(2,"0");
		document.getElementById("sec").textContent=String(sec).padStart(2,"0");

		if(diffsec <= 0){
			clearInterval(timeId);
			window.location.href = 'retired';
		}
	})
}
countdown();

function rel() {
  if (window.name != "any") {
    firstcountdown();
    window.name = "any";
  }
  countdown();
}


window.onload = rel;