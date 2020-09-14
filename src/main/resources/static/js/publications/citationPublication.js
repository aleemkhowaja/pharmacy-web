/**
 * 
 */

function citationPublication_returnTabPage(url)
{
	var responseData = null;
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	event.preventDefault();
	$.ajax({
		url :url,
		type: "GET",
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader(header, token);
		},
		async:false,
		success : function(response) 
		{
			responseData = response;
		}
	});
	return responseData;
}
