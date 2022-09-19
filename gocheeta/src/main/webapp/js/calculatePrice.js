$(document).ready(function(){
	$('#stepOne').click(function(){
		var pickUp = $('#pickUp').val();
		var dropLocation = $('#dropLocation').val();
		
		$.ajax({
			url: 'DestinationServlet',
			method: 'GET',
			dataType: 'json',
			data: {street: pickUp, city: dropLocation},
			success: function(data){
				console.log(data.destination);
				$('#destination').val(data.destination);
				$('#des').html(data.destination);
			}
		});
	});
	
	$('#stepTwo').click(function(){
		var pricePerKm = $('#pricePerKm').val();
		var destination = $('#destination').val();
		var totalPrice = 0;
		
		totalPrice = pricePerKm * destination;
		
		$('#price').val(totalPrice.toFixed(2));
		$('#totalPrice').html(totalPrice.toFixed(2));
		$('#totalPrice2').html(totalPrice.toFixed(2));
	});
});