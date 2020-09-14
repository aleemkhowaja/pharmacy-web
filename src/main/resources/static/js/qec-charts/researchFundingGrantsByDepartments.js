$(document).ready(function(){

	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnResearchFundingGrantsByDepartmentInstituteCenter';
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
			 researchFundingGrants_fill_chart(data);
		 }
	});
	

})

	function researchFundingGrants_fill_chart(data)
	{
		departments = new Array();
		hecGrants = new Array();
		interNationalGrants = new Array();
		nationalGrants = new Array();
		
		for (var i = 0; i < data.length; i++) {
			var researchFundingGrantsData = data[i];
			departments[i] = researchFundingGrantsData.value1;
			hecGrants[i] = researchFundingGrantsData.value8;
			nationalGrants[i] = researchFundingGrantsData.value9;
			interNationalGrants[i] = researchFundingGrantsData.value10;
		}
		
		$ ('#research_funding_grants').highcharts ({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Research Funding (Local/National/International)'
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