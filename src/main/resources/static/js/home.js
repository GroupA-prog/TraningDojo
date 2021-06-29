


//レーダーチャート作成用の関数
function changeCategory() {
	var selectNum = document.getElementById('radar');
	while (selectNum.firstChild) {
		selectNum.removeChild(selectNum.firstChild);
	};

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
				console.log(num);
				if (num % 5 == 0) {
					chartNum = num / 5;
				} else {
					chartNum = parseInt((num + 5) / 5);
					console.log(chartNum);
				}

				//レーダーチャート作成
				var i = 1;
				var k = 1;
				var m = 0;
				var itemNum2 = 0;

				while (i <= chartNum) {

					var itemNum;

					//レーダーチャートごとの項目数
					if (num % chartNum == 0) {
						itemNum = num / chartNum;
						console.log(itemNum);
					} else {
						var rem = num % chartNum;
						itemNum = parseInt(num / chartNum);


						if (k <= rem) {
							itemNum++;
							k++;
						}
					}

					itemNum2 += itemNum;

					var name = [];
					var ratio = [];
					console.log(name);
					while (m < itemNum2) {


						name.push(data[m].categoryName);
						ratio.push(data[m].ratio);
						console.log(name);
						m++
						console.log(m);

					}

					radarCharts = 'radar' + i;

					//jsp側のタグの作成
					var radar = document.getElementById("radar");
					var chart = document.createElement('canvas');
					chart.setAttribute('id', radarCharts);
					chart.setAttribute('style', 'position: relative; height:450px; width:550px;');
					radar.appendChild(chart);


					var ctx = document.getElementById(radarCharts);
					radarCharts = new Chart(ctx, {

						//グラフの種類
						type: 'radar',

						//データの設定
						data: {

							//データ項目のラベル
							labels: name,


							//データセット
							datasets: [
								{

									backgroundColor: "rgba(255,0,0,0.2)", // 線の下の塗りつぶしの色
									borderColor: "red",                   // 線の色
									borderWidth: 2,                       // 線の幅
									pointStyle: "circle",                 // 点の形状
									pointRadius: 6,                       // 点形状の半径
									pointBorderColor: "red",              // 点の境界線の色
									pointBorderWidth: 2,                  // 点の境界線の幅
									pointBackgroundColor: "yellow",       // 点の塗りつぶし色
									//グラフのデータ
									data: ratio

								}
							]
						},
						options: {

							scaleLineColor: "red",

							//レスポンシブ指定
							responsive: false,

							// タイトル
							title: {
								display: false,
								fontSize: 30,
								text: radarCharts,
								fontColor: "red",
							},

							legend: {
								display: false
							},


							scale: {

								label: {
									display: false,

								},

								pointLabels: {       // 軸のラベル（"国語"など）
									fontSize: 20,         // 文字の大きさ
									fontColor: "red",
								},

								ticks: {

									//最小値の値0を指定
									beginAtZero: true,
									min: 0,

									//最大値を指定
									max: 100,

									stepSize: 10,        // 目盛の間隔
									fontSize: 12,        // 目盛り数字の大きさ
									fontColor: "green"  // 目盛り数字の色


								},

								angleLines: {        // 軸（放射軸）
									display: true,
									color: "purple"
								},

								// 補助線（目盛の線）
								gridLines: {
									display: true,
									color: "purple"
								},
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

