$(document).ready(function(){
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnEmployeeCommunityServiceByDepartmentInstituteCenter';
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
			 employeeCommunityServicesByDepartment_fill_chart(data);
		 }
	});
	

})

	function employeeCommunityServicesByDepartment_fill_chart(data)
	{
		employeeServicesByDepartments = new Array();
		
		for (var i = 0; i < data.length; i++) {
			var employeeCommunityServiceData = data[i];
			employeeServices = new Array();
			employeeServices[0] = employeeCommunityServiceData.value1;
			employeeServices[1] = employeeCommunityServiceData.value8;
			employeeServicesByDepartments[i] = employeeServices;
		}
		
		$ ('#community_services').highcharts (
				  {
				        chart: {
				            type: 'column'
				        },
				        title: {
				            text: 'Community Services'
				        },
				        subtitle: {
				            text: ''
				        },
				        xAxis: {
				            type: 'category',
				            labels: {
				                rotation: -45,
				                style: {
				                    fontSize: '13px',
				                    fontFamily: 'Verdana, sans-serif'
				                }
				            }
				        },
				        yAxis: {
				            min: 0,
				            title: {
				                text: 'Employees'
				            }
				        },
				        legend: {
				            enabled: false
				        },
				        tooltip: {
				            pointFormat: ''
				        },
				        series: [{
				            name: 'Employees',
				            data: employeeServicesByDepartments,
				            dataLabels: {
				                enabled: true,
				                rotation: -90,
				                color: '#FFFFFF',
				                align: 'right',
				                format: '{point.y:.1f}', // one decimal
				                y: 10, // 10 pixels down from the top
				                style: {
				                    fontSize: '13px',
				                    fontFamily: 'Verdana, sans-serif'
				                }
				            }
				        }]
				    });
	}