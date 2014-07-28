<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Adminique - Unique Admin Template</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/skins/orange.css'/>" title="orange">

<link rel="alternate stylesheet" type="text/css" href="<c:url value='/css/skins/orange.css'/>" title="orange">
<link rel="alternate stylesheet" type="text/css" href="<c:url value='/css/skins/red.css'/>" title="red" disabled>
<link rel="alternate stylesheet" type="text/css" href="<c:url value='/css/skins/green.css'/>" title="green" disabled>
<link rel="alternate stylesheet" type="text/css" href="<c:url value='/css/skins/purple.css'/>" title="purple" disabled>
<link rel="alternate stylesheet" type="text/css" href="<c:url value='/css/skins/yellow.css'/>" title="yellow" disabled>
<link rel="alternate stylesheet" type="text/css" href="<c:url value='/css/skins/black.css'/>" title="black" disabled>
<link rel="alternate stylesheet" type="text/css" href="<c:url value='/css/skins/blue.css'/>" title="blue" disabled>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/superfish.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/uniform.default.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery.wysiwyg.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/facebox.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/smoothness/jquery-ui-1.8.8.custom.css'/>">

<!--[if lte IE 8]>
<script type="text/javascript" src="<c:url value='/js/html5.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/selectivizr.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/excanvas.min.js'/>"></script>
<![endif]-->

<script type="text/javascript" src="<c:url value='/js/jquery-1.4.4.min.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.8.8.custom.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.validate.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.uniform.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.wysiwyg.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/superfish.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/cufon-yui.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/Delicious_500.font.js'/>"></script>
<!-- script type="text/javascript" src="<c:url value='/js/jquery.flot.min.js'/>"></script-->
<script type="text/javascript" src="<c:url value='/js/custom.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/facebox.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.cookie.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/switcher.js'/>"></script>

<script type="text/javascript">
/*
jQuery(function($) {

	
	var d1 = [[1293814800000, 17], [1293901200000, 29], [1293987600000, 34], [1294074000000, 46], [1294160400000, 36], [1294246800000, 16], [1294333200000, 36]];
    var d2 = [[1293814800000, 20], [1293901200000, 75], [1293987600000, 44], [1294074000000, 49], [1294160400000, 56], [1294246800000, 23], [1294333200000, 46]];
    var d3 = [[1293814800000, 32], [1293901200000, 42], [1293987600000, 59], [1294074000000, 57], [1294160400000, 47], [1294246800000, 56], [1294333200000, 59]];

	$.plot($('#pageviews'), [
        { label: 'Unique',  data: d1},
        { label: 'Pages',  data: d2},
        { label: 'Hits',  data: d3}
    ], {
		series: {
			lines: { show: true },
			points: { show: true }
		},
		xaxis: {
			mode: 'time',
			timeformat: '%b %d'
		}
	});

});
*/
</script>
<c:if test="${param.Availability != 'N' }">
	<!-- Add jQuery library -->
	<script type="text/javascript" src="<c:url value='/fancyapps/lib/jquery-1.10.1.min.js' />"></script>

	<script type="text/javascript" src="<c:url value='/fancyapps/source/jquery.fancybox.js?v=2.1.5' />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/fancyapps/source/jquery.fancybox.css?v=2.1.5' />" media="screen" />

	
<script type="text/javascript">
$(document).ready(function() {
	$('.fancybox').fancybox({type:'ajax'});
	
	$("#fancybox-manual-b").click(function() {
		$.fancybox.open({
			href : '<c:url value="/weightFactor.do"/>',
			type : 'iframe',
			width : "960px",
			padding : 5
		});
	});
	
	$("#fancybox-manual-c").click(function() {
		$.fancybox.open({
			href : '<c:url value="/AHP.do"/>',
			type : 'iframe',
			width : "960px",
			padding : 5
		});
	});
	
	$("#Labor_Density").click(function() {
		$.fancybox.open({
			href : '<c:url value="/photo.do"/>',
			type : 'iframe',
			width : "960px",
			padding : 5
		});
	});
	
});


</script>
</c:if>
</head>
<body>
<c:if test="${param.Availability != 'N' }">
<header id="top">
	<div class="container_12 clearfix">
		<div id="logo" class="grid_5">
			<!-- replace with your website title or logo -->
			<a id="site-title" href="<c:url value='/dashboard.php'/>"><img src="<c:url value='/images/kict_logo_s.png'/>" height="40"/><!--span>Admin</span>ique--></a>
			<!--a id="view-site" href="#">View Site</a-->
		</div>

		<div class="grid_4" id="colorstyle">
			<!--div>Change Color</div>
			<a href="#" rel="blue"></a>
			<a href="#" rel="green"></a>
			<a href="#" rel="red"></a>
			<a href="#" rel="purple"></a>
			<a href="#" rel="orange"></a>
			<a href="#" rel="yellow"></a>
			<a href="#" rel="black"></a>
			<a href="#" rel="gray"></a-->
		</div>

		<div id="userinfo" class="grid_3">
			Welcome, <a href="#">Administrator</a>
		</div>
	</div>
</header>

<nav id="topmenu">
	<div class="container_12 clearfix">
		<div class="grid_12">
			<ul id="mainmenu" class="sf-menu">
				<!--li class="current"><a href="dashboard.html">Dashboard</a></li-->
				<li><a href="#">Process</a>
					<ul>
						<li><a href="<c:url value='/newProcess.do'/> ">New</a></li>
						<li><a href="<c:url value='/processList.do'/> ">Open Project</a></li>
					</ul>
				</li>
				<li><a href="#">Survey</a>
					<ul>
						<li><a href="#">Site</a></li>
						<li><a href="#">Route</a></li>
						<li><a href="#">Module</a></li>
					</ul>
				</li>
				<li><a href="#">타당성</a>
					<ul>
						<li><a href="#">타당성 평가</a></li>
						<li><a id="fancybox-manual-c" href="javascript:;">AHP</a></li>
					</ul>
				</li>
				<li><a href="#">Module Unit</a>
					<ul>
						<li><a id="Labor_Density" href="javascript:;">Labor Density</a></li>
						<li><a href="<c:url value='/statistics.do'/> ">통계</a></li>
						<li><a href="<c:url value='/reportView.do'/> ">Report</a></li>
					</ul>
				</li>
				<li><a href="#">Rams</a></li>
				<li><a id="fancybox-manual-b" href="javascript:;">가중계수</a></li>
				<!--li><a href="#">Sample Pages</a>
					<ul>
						<li><a href="news.html">News</a></li>
						<li><a href="gallery.html">Photo Gallery</a></li>
						<li><a href="settings.html">Settings</a></li>
						<li><a href="login.html">Login</a></li>
						<li><a href="1-column.html">1 Column Page</a></li>
						<li><a href="3-columns.html">3 Columns Page</a></li>
						<li><a href="sticky-footer.html">Sticky Footer</a></li>
					</ul>
				</li>
				<li><a href="#">Layout Width</a>
					<ul id="layoutwidth">
						<li><a href="#" rel="fixed">Fixed</a></li>
						<li><a href="#" rel="fluid">Fluid</a></li>
					</ul>
				</li-->
			</ul>
			<ul id="usermenu">
				<li><!--a href="#" class="inbox">Inbox (3)</a--></li>
				<li><a href="AHP://">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>
</c:if>