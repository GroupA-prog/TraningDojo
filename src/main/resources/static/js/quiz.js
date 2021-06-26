
var retired = document.getElementById('retired');
var modalRetired = document.getElementById('modal-retired');

retired.addEventListener('click', function() {
  modalRetired.style.display = 'block';
})
var closeRetired = document.getElementById('closeRetired')

closeRetired.addEventListener('click', function() {
  modalRetired.style.display = 'none';
})


var btn = document.getElementById('finish-btn');
var modal = document.getElementById('modal');

btn.addEventListener('click', function() {
  modal.style.display = 'block';
})

var closeBtn = document.getElementById('closeBtn');

closeBtn.addEventListener('click', function() {
  modal.style.display = 'none';
})


function firstcountdown(){
    const time = 1200000;
	const startTime = Date.now();

	let A = window.sessionStorage.getItem('startTime');
	let B = window.sessionStorage.getItem('time');
	if ( A == null || B == null ) {
		window.sessionStorage.setItem('startTime', startTime);
		window.sessionStorage.setItem('time', time);
	}

	window.sessionStorage.setItem('startTime',startTime);
	window.sessionStorage.setItem('time',time);

	//console.log(window.sessionStorage.getItem('startTime'));
	//console.log(window.sessionStorage.getItem('time'));

	//const sec = Math.floor(time/1000)%60;
	//const min = Math.floor(time/1000/60);

	//document.getElementById("min").textContent=String(min).padStart(2,"0");
	//document.getElementById("sec").textContent=String(sec).padStart(2,"0");


}

//firstcountdown();



function countdown(){
	let time = window.sessionStorage.getItem('time');
	let startTime = window.sessionStorage.getItem('startTime');
	console.log(time);
	console.log(startTime);

/*	if (startTime == null || time == null) {
		startTime = Date.now();
		time = 1200000;
	}
*/
	const timeId = setInterval(() =>{
		const currentTime = Date.now();

		const diff = currentTime - startTime;
		const diffsec = time - diff;

		window.sessionStorage.setItem('startTime',startTime);
		window.sessionStorage.setItem('time',diffsec);

		const sec = Math.floor(diffsec/1000)%60;
		const min = Math.floor(diffsec/1000/60);

		//console.log(sec);
		//console.log(min);

		document.getElementById("min").textContent=String(min).padStart(2,"0");
		document.getElementById("sec").textContent=String(sec).padStart(2,"0");

		if(diffsec <= 0){
			clearInterval(timeId);
			window.location.href = 'retired';
		}
	}, 500);
}
//countdown();

function rel() {
  if (window.name != "any") {
    firstcountdown();
    window.name = "any";
  }
  //countdown();
}


window.onload = function() {

	//firstcountdown();
	countdown();
};