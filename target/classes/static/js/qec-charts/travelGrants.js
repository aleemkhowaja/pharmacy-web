$(document).ready(function(){

	url = '/QEC_HEC_SU/dashboard/returnTravelGrantsByDepartmentInstituteCenter';
	$.ajax({
		url :url,
		 type: "POST",
         contentType: "application/json",
		 async:false,
		 success : function(data) {
			 travelGrants_fill_chart(data);
		 }
	});
	

})

	function travelGrants_fill_chart(data)
	{
		departments = new Array();
		hecGrants = new Array();
		interNationalGrants = new Array();
		nationalGrants = new Array();
		
		for (var i = 0; i < data.length; i++) {
			var travelGrantsData = data[i];
			departments[i] = travelGrantsData.value1;
			hecGrants[i] = travelGrantsData.value8;
			nationalGrants[i] = travelGrantsData.value9;
			interNationalGrants[i] = travelGrantsData.value10;
		}
		
		$ ('#emp_travelgrands_new').highcharts ({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Travel Grants (Local/National/International)'
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
                    name: 'National',
                    data: nationalGrants
                }, {
                    name: 'International',
                    data: interNationalGrants
                }, {
                    name: 'HEC',
                    data: hecGrants
                }]
        });
	}