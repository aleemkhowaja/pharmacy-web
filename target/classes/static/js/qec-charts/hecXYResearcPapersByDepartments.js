$(document).ready(function(){

	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnXYResearchPaperByDepartmentInstituteCenter';
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
			 hecXYResearchPapers_fill_chart(data);
		 }
	});
	

})

	function hecXYResearchPapers_fill_chart(data)
	{
		departments = new Array();
		xResearchPapers = new Array();
		yResearchPapers = new Array();
		
		for (var i = 0; i < data.length; i++) {
			var xyResearchPaperData = data[i];
			departments[i] = xyResearchPaperData.value1;
			xResearchPapers[i] = xyResearchPaperData.value8;
			yResearchPapers[i] = xyResearchPaperData.value9;
		}
		
		console.log(departments);
		$('#journal_Hec_Category').highcharts ({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: 'HEC X Y research paper by department/institute/centre'
	        },
	        xAxis: {
	            categories: departments
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: 'Total'
	            },
	            stackLabels: {
	                enabled: true,
	                style: {
	                    fontWeight: 'bold',
	                    color: (Highcharts.theme&&Highcharts.theme.textColor)||'gray'
	                }
	            }
	        },
	        legend: {
	            align: 'right',
	            x: -30,
	            verticalAlign: 'top',
	            y: 25,
	            floating: true,
	            backgroundColor: (Highcharts.theme&&Highcharts.theme.background2)||'white',
	            borderColor: '#CCC',
	            borderWidth: 1,
	            shadow: false
	        },
	        tooltip: {
	            headerFormat: '<b>{point.x}</b><br/>',
	            pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
	        },
	        plotOptions: {
	            column: {
	                stacking: 'normal',
	                dataLabels: {
	                    enabled: true,
	                    color: (Highcharts.theme&&Highcharts.theme.dataLabelsColor)||'white',
	                    style: {
	                        textShadow: '0 0 3px black'
	                    }
	                }
	            }
	        },
	        series: [{
	                name: 'X',
	                data: xResearchPapers
	            }, {
	                name: 'Y',
	                data: yResearchPapers
	            }]
		});
	}