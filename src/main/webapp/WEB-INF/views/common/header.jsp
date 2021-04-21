<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
    <title>Dashboard | SOBRUS PHARMA </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <!-- VENDOR CSS -->
    <link href="<c:url value="/assets/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/assets/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/assets/vendor/linearicons/style.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/assets/vendor/chartist/css/chartist-custom.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/assets/vendor/toastr/toastr.min.css" />"  rel="stylesheet" >

    <!-- MAIN CSS -->
    <link href="<c:url value="/assets/css/main.css" />" rel="stylesheet" type="text/css">

    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link href="<c:url value="/assets/css/demo.css" />" rel="stylesheet" type="text/css">

    <!-- GOOGLE FONTS -->
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" />" rel="stylesheet" type="text/css">

    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/assets/img/apple-icon.png" />">
    <link rel="icon" type="image/png" sizes="96x96" href="<c:url value="/assets/img/favicon.png"/>">



    <!-- Javascript -->
    <script src="<c:url value="/assets/vendor/jquery/jquery.min.js" />"></script>
    <script src="<c:url value="/assets/vendor/bootstrap/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js" />"></script>
    <script src="<c:url value="/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js" />"></script>
    <script src="<c:url value="/assets/vendor/chartist/js/chartist.min.js" />"></script>
    <script src="<c:url value="/assets/scripts/klorofil-common.js" />"></script>
    <script src="<c:url value="/assets/vendor/toastr/toastr.min.js" />" ></script>


</head>

<script>

    $(function() {
        var options;

        var data = {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            series: [
                [200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
            ]
        };

        // line chart
        options = {
            height: "300px",
            showPoint: true,
            axisX: {
                showGrid: false
            },
            lineSmooth: false,
        };

        new Chartist.Line('#demo-line-chart', data, options);

        // bar chart
        options = {
            height: "300px",
            axisX: {
                showGrid: false
            },
        };

        new Chartist.Bar('#demo-bar-chart', data, options);


        // area chart
        options = {
            height: "270px",
            showArea: true,
            showLine: false,
            showPoint: false,
            axisX: {
                showGrid: false
            },
            lineSmooth: false,
        };

        new Chartist.Line('#demo-area-chart', data, options);


        // multiple chart
        var data = {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            series: [
                {
                    name: 'series-real',
                    data: [200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
                },
                {
                    name: 'series-projection',
                    data: [240, 350, 360, 380, 400, 450, 480, 523, 555, 600, 700, 800],
                }
            ]
        };

        var options = {
            fullWidth: true,
            lineSmooth: false,
            height: "270px",
            low: 0,
            high: 'auto',
            series: {
                'series-projection': {
                    showArea: true,
                    showPoint: false,
                    showLine: false
                },
            },
            axisX: {
                showGrid: false,

            },
            axisY: {
                showGrid: false,
                onlyInteger: true,
                offset: 0,
            },
            chartPadding: {
                left: 20,
                right: 20
            }
        };

        new Chartist.Line('#multiple-chart', data, options);

    });
</script>

<label id="validate-required-error" style="display: none;" class="non-readonly" >Field is required.</label>
<label id="validate-regex-error" style="display: none;" class="non-readonly" >Please Enter Valid Value.</label>
