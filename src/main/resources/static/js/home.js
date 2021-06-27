


//レーダーチャート作成用の関数
function changeCategory() {

	//DBからユーザーの学習モードの正答率を取得
	var radarCategory = $("#radarCategory").val();
	let request = {
		categoryId: radarCategory,
	};
	fetch("/categoryJs", {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(request)
	})
		.then(function(res) {
			console.log(res);
			res.json().then(function(data) {
				console.log(data);
				num = data.length;





				//レーダーチャートの個数決定
				var chartNum;
				if (num % 5 == 0) {
					chartNum = num / 5;
				} else {
					chartNum = parseInt((num + 5) / 5);
				}

				//レーダーチャート作成
				var i = 1
				var k = 1;
				while (i <= chartNum) {


					//レーダーチャートごとの項目数
					if (num % chartNum == 0) {
						itemNum = num / chartNum;
					} else {
						var rem = num % chartNum;
						itemNum = parseInt(num / chartNum);


						if (k <= rem) {
							itemNum++;
							k++;
						}
					}

					radarCharts = 'radarChart' + i;

					//jsp側のタグの作成
					var radar = document.getElementById("radar");
					var chart = document.createElement('canvas');
					chart.setAttribute('id', radarCharts);
					radar.appendChild(chart);


					var ctx = document.getElementById(radarCharts);
					radarCharts = new Chart(ctx, {

						//グラフの種類
						type: 'radar',

						//データの設定
						data: {

							//データ項目のラベル
							labels: ['あ', 'い', 'う', 'え'],

							//データセット
							datasets: [
								{
									//グラフのデータ
									data: [5, 6, 5, 6]

								}
							]
						},
						options: {

							//レスポンシブ指定
							responsive: true,
							scale: {
								ticks: {

									//最小値の値0を指定
									beginAtZero: true,
									min: 0,

									//最大値を指定
									max: 100,
								}
							}
						}
					});



					i++;
				}

			});

		});



}

let rc = document.querySelector("#radarCategory");
rc.addEventListener('change', changeCategory);