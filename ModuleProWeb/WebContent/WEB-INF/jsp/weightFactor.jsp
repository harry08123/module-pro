<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                      
<jsp:include page="/basic/header.do" flush="false">
	<jsp:param value="N" name="Availability"/>
</jsp:include> 

<section id="content">
		<section class="container_12 clearfix">
			<section id="main" class="grid_9 push_3">
				<article>
					<!-- div id="breadcrumbs">
						<a href="#">Home</a> &#187; 
						<a href="#">Sample</a> &#187; 
					</div -->
					<h1>Weight Factor</h1>
					<table id="table1" class="gtable sortable">
						<thead>
							<tr>
								<th width="3%"><input type="checkbox" class="checkall" /></th>
								<th>Category</th>
								<th width="15%">Average<br>Raw Score</th>
								<th width="5%">Weight<br>Factor</th>
								<th width="10%">Weight<br>Factor Percent</th>
								<th width="12%">Weighted<br>Score</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" /></td>
								<td>2</td>
								<td>8</td>
								<td><input type="text" value="4" /></td>
								<td>
									57%
								</td>
								<td>
									4.57
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>w</td>
								<td>2</td>
								<td><input type="text" value="3" /></td>
								<td>
									43%
								</td>
								<td>
									0.86
								</td>
							</tr>
						</tbody>
					</table>
				</article>
				<section class="buttons">
					<div style="text-align:right;">
						<h2>Average : 5.43</h2>
					</div>
					<button type="button" class="button white">새로고침</button>
					<button type="button" class="button white">저장</button>
					<button type="button" class="button white">종료</button>
					
				</section>
				
			</section>
			
			
			<aside id="sidebar" class="grid_3 pull_9">
				<div class="box info">
					<h2>Info</h2>
					<section>
						작성자	: 홍길동<br/>
						작성일자	: 2014-07-14<br/>
						프로젝트명	: LNG<br/>
						평가일자	: 2014-07-31<br/>
					</section>
				</div>
			</aside>
		</section>
	</section>
	
	<div class="bottom"></div>
</body>
</html>