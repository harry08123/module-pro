<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE HTML>
<html lang="en">
<head>
<title>Adminique - Unique Admin Template</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<!-- link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>" -->
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


<c:if test="${Availability != 'N' }">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
<%/*
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>



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
*/ %>
<script type="text/javascript">
        $(document).ready(function () {
            $('a#pop').live('click', function (e) {
                e.preventDefault();
                var page = $(this).attr("href")
                var pagetitle = $(this).attr("title")
                var $dialog = $('<div style="overflow:hidden;"></div>')
                .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
                .dialog({
                    autoOpen: false,
                    modal: true,
                    height: 625,
                    width: 1100,
                    title: pagetitle
                });
                $dialog.dialog('open');
            });
        });
        
        <c:if test="${msg != '' && msg ne null }">
	    	alert('<c:out value="${msg }" />');
	    </c:if>
    </script>
    
    
</c:if>
</head>
<body>
<c:if test="${Availability != 'N' }">
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
			Welcome, <a href="#"><c:out value="${mem.getUserName() }" /></a>
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
						<li><a href="<c:url value='/projectNew.do'/> ">New</a></li>
						<li><a href="<c:url value='/projectList.do'/> ">Open Project</a></li>
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
						<c:choose>
							<c:when test="${mem.getProID() ne null }">
								<li><a href="AHP://${mem.getProID()}">AHP</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#" onclick="javascript:alert('프로젝트를 선택해주세요.')">AHP</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</li>
				<li><a href="#">Module Unit</a>
					<ul>
						<c:choose>
							<c:when test="${mem.getProID() ne null }">
								<li><a href="SVG://${mem.getProID()}">Labor Density</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#" onclick="javascript:alert('프로젝트를 선택해주세요.')">Labor Density</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="<c:url value='/statistics.do'/> ">통계</a></li>
						<li><a href="<c:url value='/reportView.do'/> ">Report</a></li>
					</ul>
				</li>
				<li><a href="#">Rams</a></li>
				<li><a id="pop" href="<c:url value='/AHP.do'/>">가중계수</a></li>
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
				<li><a href="j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>
</c:if>