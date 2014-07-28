<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                      
<jsp:include page="/basic/header.do" flush="false">
	<jsp:param value="N" name="Availability"/>
</jsp:include> 

<section id="content">
		<section class="container_12 clearfix">
			<section id="main" class="grid_12">
				<article class="content">
					<!-- div id="breadcrumbs">
						<a href="#">Home</a> &#187; 
						<a href="#">Sample</a> &#187; 
					</div -->
					<h1>AHP</h1>
					<p><img alt="ahp" src='<c:url value="/images/ahp2.jpg" />' /></p>
				</article>
			</section>
		</section>
	</section>
	
	<div class="bottom"></div>
</body>
</html>