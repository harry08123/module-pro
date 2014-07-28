<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                      
<jsp:include page="/basic/header.do" flush="false">
	<jsp:param value="N" name="Availability"/>
</jsp:include> 
<script type="text/javascript">
<!--
function ahp2popup(){
	window.open('<c:url value="/ahp2.do"/>',"ahp2","width=1000px,height=600px,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes,left=100,top=100");
}
//-->
</script>
<section id="content">
		<section class="container_12 clearfix">
			<section id="main" class="grid_12">
				<article class="content">
					<!-- div id="breadcrumbs">
						<a href="#">Home</a> &#187; 
						<a href="#">Sample</a> &#187; 
					</div -->
					<h1>AHP</h1>
					<p><img alt="ahp" src='<c:url value="/images/ahp1.jpg" />' usemap="#map1" ></p>
					<map name="map1">
						<area alt="map1" shape="rect" coords="648,306,734,347" href="#" onclick="javascript:ahp2popup(); return false;" target="_blank">
					</map>
				</article>
			</section>
		</section>
	</section>
	
	<div class="bottom"></div>
</body>
</html>