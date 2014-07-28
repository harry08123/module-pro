<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/basic/header.do"></jsp:include>

<section id="content">
	<section class="container_12 clearfix">
		<section id="main" class="grid_9 push_3">
			<article>
				<h1>Open Project</h5>

				<table id="table2" class="gtable detailtable">
					<thead>
						<tr>
							<th><input type="checkbox" class="checkall" /></th>
							<th>작성자</th>
							<th>프로젝트며</th>
							<th>작성일자</th>
							<th>평가일자</th>
							<th>페모</th>
							<th>Detail Order</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" /></td>
							<td>홍길동</td>
							<td>LNG 모듈화</td>
							<td>2014.07.01</td>
							<td>2014.12.31</td>
							<td>작업</td>
							<td>
								<a href="#" class="detail-link">Detail</a>
							</td>
						</tr>
						<tr class="detail">
							<td colspan="7">
								<table>
									<thead>
										<tr>
											<th>작성자</th>
											<th>프로젝트며</th>
											<th>작성일자</th>
											<th>평가일자</th>
											<th>페모</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>345</td>
											<td>Product 1</td>
											<td>10.14</td>
											<td>4</td>
											<td>40.56</td>
										</tr>
										<tr>
											<td>456</td>
											<td>Product 2</td>
											<td>10.14</td>
											<td>2</td>
											<td>20.28</td>
										</tr>
										<tr>
											<td>678</td>
											<td>Product 3</td>
											<td>10.14</td>
											<td>3</td>
											<td>30.42</td>
										</tr>
										<tr>
											<td>34</td>
											<td>Product 4</td>
											<td>10.14</td>
											<td>1</td>
											<td>10.14</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						
					</tbody>
				</table>

				

			</article>
		</section>
		<jsp:include page="/basic/box_Menu.do"></jsp:include>
	</section>
</section>

<footer id="bottom">
	<section class="container_12 clearfix">
		<div class="grid_6">
			<a href="#">Menu 1</a>
			&middot; <a href="#">Menu 2</a>
			&middot; <a href="#">Menu 3</a>
			&middot; <a href="#">Menu 4</a>
		</div>
		<div class="grid_6 alignright">
			Copyright &copy; 2011 <a href="#">YourCompany.com</a>
		</div>
	</section>
</footer>

</body>
</html>