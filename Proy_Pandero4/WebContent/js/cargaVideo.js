
		var varHidden = document.getElementById("idForm:idHidden");

		window.addEventListener('load', init);
		function init() {
			var video = document.querySelector('#v'), canvas = document
					.querySelector('#c'), btn = document.querySelector('#t');

			navigator.getUserMedia = (navigator.getUserMedia
					|| navigator.webkitGetUserMedia
					|| navigator.mozGetUserMedia || navigator.msGetUserMedia);

			if (navigator.getUserMedia) {
				navigator.getUserMedia({
					video : true
				}, function(stream) {
					video.src = window.URL.createObjectURL(stream);
					video.play();
				}, function(e) {
					console.log(e);
				})
			} else
				alert('Tienes un navegador obsoleto');

			video.addEventListener('loadedmetadata', function() {
				canvas.width = video.videoWidth;
				canvas.height = video.videoHeight;
			}, false);

			btn.addEventListener('click', function() {

				canvas.getContext('2d').drawImage(video, 0, 0);
				var imgData = canvas.toDataURL('image/png');

				varHidden.setAttribute('value', imgData);
			});
		}