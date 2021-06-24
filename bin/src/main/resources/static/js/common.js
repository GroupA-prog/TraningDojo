$(".item").click(
    function() {
        $('#modal-overlay, #modal-content').fadeIn("slow");
    }
);

$('.return').click(
    function() {
        $('#modal-overlay, #modal-content').fadeOut("slow");
    }
);

/*
requestObj　内容
	{
		method: 'POST',
		headers: {
					'Content-Type': 'application/json'
				},
		body: JSON.stringify(data)
	}
*/

function AsyncCommunication(url, requestObj, func) {
	request = {
		method: 'POST',
		headers: {
					'Content-Type': 'application/json'
				},
		body: JSON.stringify(requestObj)
	};

	fetch(url, request)
	.then( res => {
				console.log(res);
				return res.json().then( data => {
					func(data);
				});
	})
	.catch( res => {
		console.log(res);
	});
}


