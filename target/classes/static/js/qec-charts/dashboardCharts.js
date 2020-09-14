$(document).ready(function(){
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnDashboardCharts';
	//$ ('#dashboard-charts').parent().block();
	
	$.ajax({
		url :url,
		 type: "POST",
         contentType: "application/json",
		 async:false,
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) 
		 {
			employeeCommunityServicesByDepartment_fill_chart(data.returnEmployeeCommunityServicesByDepartmentInstituteCenter);
			monthImpactFactorByHec_fill_chart(data.returnImpactFactorByHec);
			researchFundingGrants_fill_chart(data.returnResearchFundingByDepartmentInstituteCenter);
			travelGrants_fill_chart(data.returnTravelGrantsByDepartmentInstituteCenter);
			hecXYResearchPapers_fill_chart(data.returnXYResearchPaperByDepartmentInstituteCenter);
			
			//load HEC XY research Paper Years
			common_loadCombo('dashboardHECXYPublicationYearCombo',data.returnYearXYResearchPaperByDpt);
			
			//load Monthly HEC Impact Factor Years
			common_loadCombo('dashboardMonthlyImpactFactorByHECYearCombo',data.returnYearXYResearchPaperByDpt);
			
			//load Travel Grant Years
			common_loadCombo('dashboardEmployeeTravelGrantYearCombo',data.yearsOfTravelGrant);
			
			//load Research Funding Years
			common_loadCombo('dashboardEmployeeResearchFundingYearCombo',data.yearsOfTravelGrant);
			
			//load Community Services Years
			common_loadCombo('dashboardEmployeeCommunityServicesYearCombo',data.yearsOfCommunityServices);
			
			
			
//			$("#dashboard_teaching_staff").text(data.teachingStaff);
//			$("#dashboard_non_teaching_staff").text(data.nonTeachingStaff);
//			$("#dashboard_research_papers_impact_factor").text(data.impactFactorResearchPapers);
//			$("#dashboard_research_papers_hec_recognize").text(data.researchPapersHecRecognizeXYZ);
			/*setTimeout(function () {
		        $('#dashboard-charts').parent().unblock();
		    }, 500);*/
		 }
	});
})


function dashboard_returnInfo()
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnDashboardInformation';
	//$ ('#dashboard-charts').parent().block();
	
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
			 
			$("#dashboard_teaching_staff").text(data.teachingStaff);
			$("#dashboard_non_teaching_staff").text(data.nonTeachingStaff);
			$("#dashboard_research_papers_impact_factor").text(data.impactFactorResearchPapers);
			$("#dashboard_research_papers_hec_recognize").text(data.researchPapersHecRecognizeXYZ);
			/*setTimeout(function () {
		        $('#dashboard-charts').parent().unblock();
		    }, 500);*/
		 }
	});
}


/**
 * return HEC XY Research Papers By Year
 */
function dashboard_returnHECXYResearchPapersByYearForChart()
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnXYResearchPaperByDepartmentInstituteCenter';
	var publicationYear = $("#dashboardHECXYPublicationYearCombo").val();
	
	
	$.ajax({
		url :url,
		 type: "POST",
		 data:{publicationYear : publicationYear},
		 async:false,
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) 
		 {
			 hecXYResearchPapers_fill_chart(data);
		 }});
}


/**
 * return Monthly Impact Factor By Year
 */
function dashboard_returnMonthlyImpactFactorByYearForChart()
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnImpactFactorByHECForChart';
	var publicationYear = $("#dashboardMonthlyImpactFactorByHECYearCombo").val();
	
	$.ajax({
		url :url,
		 type: "POST",
		 data:{publicationYear : publicationYear},
		 async:false,
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) 
		 {
			 monthImpactFactorByHec_fill_chart(data);
		 }});
}

/**
 * return Monthly Impact Factor By Year
 */
function dashboard_returnEmployeeTravelGrantByYearForChart()
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url = '/QEC_HEC_SU/dashboard/returnTravelGrantsByDepartmentInstituteCenter';
	var travelGrantYear = $("#dashboardEmployeeTravelGrantYearCombo").val();
	
	$.ajax({
		url :url,
		 type: "POST",
		 data:{travelGrantYear : travelGrantYear},
		 async:false,
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) 
		 {
			 travelGrants_fill_chart(data);
		 }});
}

function dashboard_returnChartByYear(chartOf, evt)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var url="/QEC_HEC_SU/dashboard/";
    if(chartOf == "RFG")
    {
    	url += 'returnResearchFundingGrantsByDepartmentInstituteCenter';
    }
    if(chartOf == "CSG")
    {
    	url += 'returnEmployeeCommunityServiceByDepartmentInstituteCenter';
    }
	
	var year = $("#"+evt.id).val();
	
	$.ajax({
		url :url,
		 type: "POST",
		 data:{chartYear : year},
		 async:false,
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) 
		 {
			 if(chartOf == "RFG")
			    {
				 	researchFundingGrants_fill_chart(data);
			    }
			    if(chartOf == "CSG")
			    {
			    	employeeCommunityServicesByDepartment_fill_chart(data);
			    }
			
		 }});
}

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

function monthImpactFactorByHec_fill_chart(data)
{
	var hec = new Array();
	var impactFactor = new Array();
	var months = new Array();
	for (var i = 0; i < data.length; i++) 
	{
		var monthImpactFactorData = data[i];
		months[i] = impactfactorChartMonths(monthImpactFactorData[0]);
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
	        categories: months
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

function impactfactorChartMonths(month)
{
	if(month==1)
	{
		return "January";
	} else if(month==2)
	{
		return "February";
	}
	else if(month==3)
	{
		return "March";
	}
	else if(month==4)
	{
		return "April";
	}
	else if(month==5)
	{
		return "May";
	}
	else if(month==6)
	{
		return "June";
	}
	else if(month==7)
	{
		return "July";
	}
	else if(month==8)
	{
		return "August";
	}
	else if(month==9)
	{
		return "September";
	}
	else if(month==10)
	{
		return "October";
	}
	else if(month==11)
	{
		return "November";
	}
	else if(month==12)
	{
		return "December";
	}
}

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
