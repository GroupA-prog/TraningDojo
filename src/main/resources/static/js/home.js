


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
				var gradesData = data;

				/*let request = {
					categoryId: radarCategory,
				};
				fetch("/fullCategoryJs", {
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
							var categoryName = data;*/

				//レーダーチャートの個数決定
				var chartNum;
				if (num % 5 == 0) {
					chartNum = num / 5;
				} else {
					chartNum = parseInt((num + 5) / 5);
				}

				//レーダーチャート作成
				var i = 1;
				var k = 1;
				var m = 0;
				var n = 0;
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

					var name = [];
					var ratio = [];
					while (m < itemNum) {
						name.push(gradesData[m].categoryName);
						ratio.push(gradesData[m].ratio);
						m++
					}

					/*var itemNum2;
					itemNum2 += itemNum;

					var name = [];
					var ratio = [];
					while (m < itemNum2) {

						if (categoryName[n].categoryName === gradesData[m].categoryName) {
							name.push(gradesData[m].categoryName);
							ratio.push(gradesData[m].ratio);
							m++
							console.log(name);
						} else {
							name.push(categoryName[n].categoryName);
							ratio.push(0);
						}
						n++;

					}*/

					radarCharts = 'radarChart' + i;

					//jsp側のタグの作成
					var radar = document.getElementById("radar");
					var chart = document.createElement('canvas');
					chart.setAttribute('id', radarCharts);
					chart.setAttribute('width', 100);
					chart.setAttribute('height', 100);
					radar.appendChild(chart);


					var ctx = document.getElementById(radarCharts);
					radarCharts = new Chart(ctx, {

						//グラフの種類
						type: 'radar',

						//データの設定
						data: {

							//データ項目のラベル
							labels: ['赤', '青', '黄', '白'],

							//データセット
							datasets: [
								{
									label: radarCharts,

									backgroundColor: "rgba(255,0,0,0.2)", // 線の下の塗りつぶしの色
									borderColor: "red",                   // 線の色
									borderWidth: 2,                       // 線の幅
									pointStyle: "circle",                 // 点の形状
									pointRadius: 6,                       // 点形状の半径
									pointBorderColor: "red",              // 点の境界線の色
									pointBorderWidth: 2,                  // 点の境界線の幅
									pointBackgroundColor: "yellow",       // 点の塗りつぶし色
									//グラフのデータ
									data: [50, 85, 30, 100]

								}
							]
						},
						options: {

							//レスポンシブ指定
							responsive: true,

							// タイトル
							title: {
								display: true,
								fontSize: 20,
								text: radarCharts
							},


							scale: {

								pointLabels: {       // 軸のラベル（"国語"など）
									fontSize: 20,         // 文字の大きさ
								},

								ticks: {

									//最小値の値0を指定
									beginAtZero: true,
									min: 0,

									//最大値を指定
									max: 100,

									stepSize: 20,        // 目盛の間隔
									fontSize: 12,        // 目盛り数字の大きさ
									fontColor: "purple"  // 目盛り数字の色


								},

								angleLines: {        // 軸（放射軸）
									display: true,
									color: "purple"
								},

								// 補助線（目盛の線）
								gridLines: {
									display: true,
									color: "lime"
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