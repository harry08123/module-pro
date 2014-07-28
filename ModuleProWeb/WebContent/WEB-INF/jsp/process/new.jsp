<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/basic/header.do"></jsp:include>
 

<section id="content">
	<section class="container_12 clearfix">
		<section id="main" class="grid_9 push_3">
			<article>
				<h1>New Project</h1>
				<form class="uniform">
					<dl>
						<dt><label for="writer">작성자</label></dt>
						<dd><input type="text" name="writer" id="writer" class="big" /></dd>

						<dt><label for="projectName">프로젝트명</label></dt>
						<dd><input type="text" name="projectName" id="projectName" class="big" /></dd>

						<dt><label for="newsdate">작성일자</label></dt>
						<dd><input type="text" name="writeDate" id="newsdate"/></dd>

						<dt><label for="dob">평가일자</label></dt>
						<dd><input type="text" name="appraisalDate" id="dob"/></dd>

						<dt><label for="comment">메모</label></dt>
						<dd>
							<textarea name="comment" id="comment" class="big" rows="15"></textarea>
						</dd>

					</dl>
					<p>
						<button type="submit" class="button big">저장</button>
					</p>
				</form>
			</article>
			<!--article>
				<h1>Recent News</h1>
				<ul class="news">
					<li>
						<div class="date">Dec 02, 2010 - 8:31pm</div>
						80 Days Around The World, We'll Find A Pot Of Gold Just Sitting Where The Rainbow's Ending.
						<a title="Edit" href="#"><img alt="Edit" src="images/icons/edit.png"></a>
					</li>
					<li>
						<div class="date">Nov 28, 2010 - 7:32pm</div>
						Ten Years Ago A Crack Commando Unit Was Sent To Prison By A Military Court For A Crime They Didn't Commit.
						<a title="Edit" href="#"><img alt="Edit" src="images/icons/edit.png"></a>
					</li>
					<li>
						<div class="date">Nov 09, 2010 - 6:21pm</div>
						Knight Rider, A Shadowy Flight Into The Dangerous World Of A Man Who Does Not Exist.
						<a title="Edit" href="#"><img alt="Edit" src="images/icons/edit.png"></a>
					</li>
					<li>
						<div class="date">Oct 22, 2010 - 10:09am</div>
						Children Of The Sun, See Your Time Has Just Begun.
						<a title="Edit" href="#"><img alt="Edit" src="images/icons/edit.png"></a>
					</li>
					<li>
						<div class="date">Oct 09, 2010 - 2:49am</div>
						Today, Still Wanted By The Government.
						<a title="Edit" href="#"><img alt="Edit" src="images/icons/edit.png"></a>
					</li>
				</ul>
			</article-->
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