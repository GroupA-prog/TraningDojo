
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


//制限時間
$(document).ready(function(){
 if($.cookie('end')){
        var end = new Date($.cookie('end'));
        $('.end').text($.cookie('end'));
        timer();
    } else {
        var end = new Date();
        end.setMinutes(end.getMinutes() + 20);
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
                window.location.href='userHome';
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
//制限時間のcookieを破棄

var finish = document.getElementsByName('finish');
finish[0].addEventListener('click', function() {
  $.removeCookie('end');
})
finish[1].addEventListener('click', function() {
  $.removeCookie('end');
});