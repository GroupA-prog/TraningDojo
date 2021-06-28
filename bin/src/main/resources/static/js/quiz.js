//fadeIn定義
var fadeIn = function(element, time, callback) {
    var fadeTime     = (time) ? time : 400,
        keyFrame     = 30,
        stepTime     = fadeTime / keyFrame,
        maxOpacity   = 1,
        stepOpacity  = maxOpacity / keyFrame,
        opacityValue = 0,
        sId          = '';
    if (!element) return;
    if (element.getAttribute('data-fade-stock-display') !== undefined &&
        element.getAttribute('data-fade-stock-display') !== null) {
        element.style.display = element.getAttribute('data-fade-stock-display');
    }

    var setOpacity = function(setNumber) {
        if ('opacity' in element.style) {
            element.style.opacity = setNumber;
        } else {
            element.style.filter = 'alpha(opacity=' + (setNumber * 100) + ')';

            if (navigator.userAgent.toLowerCase().match(/msie/) &&
                !window.opera && !element.currentStyle.hasLayout) {
                element.style.zoom = 1;
            }
        }
    };

    if (!callback || typeof callback !== 'function') callback = function() {};

    setOpacity(0);

    sId = setInterval(function() {
        opacityValue = Number((opacityValue + stepOpacity).toFixed(12));

        if (opacityValue > maxOpacity) {
            opacityValue = maxOpacity;
            clearInterval(sId);
        }

        setOpacity(opacityValue);

        if (opacityValue === maxOpacity) callback();
    }, stepTime);

    return element;
};
//fadeOut定義
var fadeOut = function(element, time, callback) {
    var fadeTime     = (time) ? time : 400,
        keyFrame     = 30,
        stepTime     = fadeTime / keyFrame,
        minOpacity   = 0,
        stepOpacity  = 1 / keyFrame,
        opacityValue = 1,
        sId          = '';

    if (!element) return;

    element.setAttribute('data-fade-stock-display', element.style.display.replace('none', ''));

    var setOpacity = function(setNumber) {
        if ('opacity' in element.style) {
            element.style.opacity = setNumber;
        } else {
            element.style.filter = 'alpha(opacity=' + (setNumber * 100) + ')';

            if (navigator.userAgent.toLowerCase().match(/msie/) &&
                !window.opera && !element.currentStyle.hasLayout) {
                element.style.zoom = 1;
            }
        }
    };

    if (!callback || typeof callback !== 'function') callback = function() {};

    setOpacity(1);

    sId = setInterval(function() {
        opacityValue = Number((opacityValue - stepOpacity).toFixed(12));

        if (opacityValue < minOpacity) {
            opacityValue = minOpacity;
            element.style.display = 'none';
            clearInterval(sId);
        }

        setOpacity(opacityValue);

        if (opacityValue === minOpacity) callback();
    }, stepTime);

    return element;
};

//モーダルウィンドウ操作
var retired = document.getElementById('retired');
var modalRetired = document.getElementById('modal-retired');

retired.addEventListener('click', function() {
	fadeIn(modalRetired,400);
	modalRetired.style.display = 'block';
})
var closeRetired = document.getElementById('closeRetired')

closeRetired.addEventListener('click', function() {
	fadeOut(modalRetired,400);
})


var btn = document.getElementById('finish-btn');
var modal = document.getElementById('modal');

btn.addEventListener('click', function() {
	fadeIn(modal,400);
	modal.style.display = 'block';
})

var closeBtn = document.getElementById('closeBtn');

closeBtn.addEventListener('click', function() {
	fadeOut(modal,400);
})

//制限時間

var mode = document.getElementById('mode');
var value = mode.getAttribute('value');

if(value == '2'){
	$(document).ready(function(){
	 if($.cookie('end')){
	        var end = new Date($.cookie('end'));
	        $('.end').text($.cookie('end'));
	        timer();
	    } else {
	        var end = new Date();
	        end.setMinutes(end.getMinutes() + 1);
	        $.cookie('end', end);
	        $('.end').text($.cookie('end'));
	        timer();
	    }

	    //カウントダウン関数
	    function timer(){

	        //1秒ごとに実行
	        setInterval(function(){

	            //現在時刻を取得
	            var now = new Date();
	            $('.now').text(now);

	            //終了時間と現在時間の差を求め、時分秒形式に変換
	            var count = Math.floor((end - now) / 1000);

	            //0より大きければカウントダウン続行、小さければhomeへ遷移
	            if (count > 0) {
	                var count = toHms(count);
	                $('.count').text(count);
	            } else {
	            	$.removeCookie('end');
	                var timeup = document.getElementById('timeup');
	                fadeIn(timeup,400);
	  				timeup.style.display = 'block';
	            }

	            //秒→時分秒への変換関数
	            function toHms(t) {

	                var m = t % 3600 / 60 | 0;
	                var s = t % 60;

				document.getElementById("min").textContent=String(m).padStart(2,"0");
				document.getElementById("sec").textContent=String(s).padStart(2,"0");

	            }
	        });
	    }
	});
}

var time = document.getElementById('timebtn');
time.addEventListener('click', function() {
 	window.location.href='userHome';
 })


//制限時間のcookieを破棄

var finish = document.getElementsByName('finish');
finish[0].addEventListener('click', function() {
  $.removeCookie('end');
})
finish[1].addEventListener('click', function() {
  $.removeCookie('end');
});