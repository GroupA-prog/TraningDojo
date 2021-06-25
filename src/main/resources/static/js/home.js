


//レーダーチャート作成用の関数
function changeCategory() {

	//DBからユーザーの学習モードの正答率を取得

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
				var num = data;

				//レーダーチャートの個数決定
				var chartNum;
				if (num % 5 == 0) {
					chartNum = num / 5;
					console.log(chartNum);
				} else {
					chartNum = (num + 5) / 5;
				}


				//レーダーチャート作成
				var i = 1
				while (i <= chartNum) {


					//レーダーチャートごとの項目数
					if (categoryNum % chartNum == 0) {
						itemNum = categoryNum / chartNum;
					} else {
						var rem = categoryNum % chartNum;
						itemNum = categoryNum / chartNum;

						var k = 1;
						if (k <= rem) {
							itemNum++;
						}
					}


					var ctx = document.getElementById("radarChart");
					var radarChart = new chart(ctx, {

						//グラフの種類
						type: 'radar',

						//データの設定
						data: {

							//データ項目のラベル
							labels: [],

							//データセット
							datasets: [
								{
									//グラフのデータ
									data: [5, 6, 5, 6, 7]

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

					//jsp側のタグの作成
					var radar = document.getElementById("radar");
					var chart = document.createElement("canvas");
					canvas.setAttribute('id', radarChart);
					radar.appendChild(chart);

					i++;
				}

			});

		});



}

let rc = document.querySelector("#radarCategory");
rc.addEventListener('change', changeCategory);