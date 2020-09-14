$(document).ready(function(){
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnImpactFactorByHECForChart';
	$.ajax({
		url :url,
		 type: "POST",
         contentType: "application/json",
		 async:false,
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			 monthImpactFactorByHec_fill_chart(data);
		}
	});
})

function monthImpactFactorByHec_fill_chart(data)
{
	hec = new Array();
	impactFactor = new Array();
	for (var i = 0; i < data.length; i++) 
	{
		var monthImpactFactorData = data[i];
		hec[i] = monthImpactFactorData[1];
		impactFactor[i] = monthImpactFactorData[2];
	}
	Highcharts.chart('impact_factor', {
	    chart: {
	        type: 'spline'
	    },
	    title: {
	        text: 'Monthly Impact Factor by HEC / Impact'
	    },
	    xAxis: {
	        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
	            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
		    },
	    yAxis: {
	        title: {
	            text: 'Ratio'
	        },
	        labels: {
	            formatter: function () {
	                return this.value;
	            }
	        }
	    },
	    tooltip: {
	        crosshairs: true,
	        shared: true
	    },
	    plotOptions: {
	        spline: {
	            marker: {
	                radius: 4,
	                lineColor: '#666666',
	                lineWidth: 1
	            }
	        }
	    },
	    series: [
	        {
		        name: 'Impact Factor',
			    marker: {
			    	symbol: 'circle'
			    },
			    data: hec
		    },
		    {
		        name: 'HEC',
		        marker: {
		            symbol: 'diamond'
		        },
		        data: impactFactor
		    }]
		});
	}
