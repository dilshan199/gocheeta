$(document).ready(function(){
	$('#branchId').change(function(){
		$('#pickUp').find('option').remove();
		$('#pickUp').append('<option>~~ Select Street ~~</option>');
		let branchId = $('#branchId').val();
		let data = {
			operation: 'street',
			branchId: branchId
		};
		
		$.ajax({
			url: 'LocationServlet',
			method: 'GET',
			data: data,
			success: function(data, textStatus, jqXHR){
				console.log(data);
				let obj = $.parseJSON(data);
				$.each(obj, function(key, value){
					$('#pickUp').append('<option value="' + value.street + '">' + value.street + '</option>')
				});
				$('select').formSelect();
			},
			error: function(jqXHR, textStatus, errorThrown){
				$('#pickUp').append('<option>Street Unavailable</option>');
			},
			cache: false
		});
	});
	
	$('#branchId').change(function(){
		$('#dropLocation').find('option').remove();
		$('#dropLocation').append('<option>~~ Select City ~~</option>');
		let branchId = $('#branchId').val();
		let data = {
			operation: 'city',
			branchId: branchId
		};
		
		$.ajax({
			url: 'CityServlet',
			method: 'GET',
			data: data,
			success: function(data, textStatus, jqXHR){
				console.log(data);
				let obj = $.parseJSON(data);
				$.each(obj, function(key, value){
					$('#dropLocation').append('<option value="' + value.city + '">' + value.city + '</option>')
				});
				$('select').formSelect();
			},
			error: function(jqXHR, textStatus, errorThrown){
				$('#dropLocation').append('<option>City Unavailable</option>');
			},
			cache: false
		});
	});
});