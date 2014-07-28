	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                      
<jsp:include page="/basic/header.do"></jsp:include>    
<section id="content">
	<section class="container_12 clearfix">
		<section id="main" class="grid_9 push_3">
			<article id="dashboard">
				<!--h1>Dashboard</h1>

				<h2>Statistics</h2>
				<div class="statistics">
					<table>
						<tr>
							<td>Users</td>
							<td><a href="#">127</a></td>
						</tr>
						<tr>
							<td>Posts</td>
							<td><a href="#">98</a></td>
						</tr>
						<tr>
							<td>Pages</td>
							<td><a href="#">11</a></td>
						</tr>
						<tr>
							<td>Categories</td>
							<td><a href="#">25</a></td>
						</tr>
						<tr>
							<td>Comments</td>
							<td><a href="#">1,231</a></td>
						</tr>
						<tr>
							<td>Messages</td>
							<td><a href="#">3</a></td>
						</tr>
						<tr>
							<td>Page Views</td>
							<td><a href="#">754</a></td>
						</tr>
					</table>
				</div>
				<div id="pageviews" style="width:420px;height:250px;"></div>
				<div class="clear"></div>

				<h2>Quick Links</h2>
				<section class="icons">
					<ul>
						<li>
							<a href="#">
								<img src="images/eleganticons/Home.png" />
								<span>Home</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Paper.png" />
								<span>Articles</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Paper-pencil.png" />
								<span>Write Article</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Speech-Bubble.png" />
								<span>Comments</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Photo.png" />
								<span>Photos</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Folder.png" />
								<span>File Manager</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Person-group.png" />
								<span>User Manager</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Config.png" />
								<span>Settings</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Piechart.png" />
								<span>Statistics</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Info.png" />
								<span>About</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/Mail.png" />
								<span>Messages</span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="images/eleganticons/X.png" />
								<span>Logout</span>
							</a>
						</li>
					</ul>
				</section>

				<h2>Recent Comments</h2>
				<ul class="comments">
					<li>
						<div class="comment-body clearfix">
							<img class="comment-avatar" src="images/icons/dummy.gif" />
							<a href="#">Bruce</a> on <a href="#">Article 1</a>:
							<div>Whose appear moving i. Blessed. Light. A fruitful likeness every midst own yielding them greater air gathered beginning green blessed and great whose saw.</div>
						</div>
						<div class="links">
							<span class="date">02/03/2010 - 3:30</span>
							<a href="#" class="reply">Reply</a>
							<a href="#" class="delete">Delete</a>
						</div>
					</li>
					<li>
						<div class="comment-body clearfix">
							<img class="comment-avatar" src="images/icons/dummy.gif" />
							<a href="#">Steve</a> on <a href="#">Article 1</a>:
							<div>Fruitful divide fruitful saying can't stars make. Fly open and called there bearing you'll fruitful give. Yielding god can't great have meat isn't form which appear good creepeth first can't made dominion years winged.</div>
						</div>
						<div class="links">
							<span class="date">02/03/2010 - 3:30</span>
							<a href="#" class="reply">Reply</a>
							<a href="#" class="delete">Delete</a>
						</div>
					</li>
					<li>
						<div class="comment-body clearfix">
							<img class="comment-avatar" src="images/icons/dummy.gif" />
							<a href="#">Lauren</a> on <a href="#">Article 2</a>:
							<div>Seas abundantly first us morning which days darkness of midst appear. Was lesser seas fruitful third him isn't you'll given herb saw so waters given forth. Night. Deep and saying sea. The creeping spirit were.</div>
						</div>
						<div class="links">
							<span class="date">02/03/2010 - 3:30</span>
							<a href="#" class="reply">Reply</a>
							<a href="#" class="delete">Delete</a>
						</div>
					</li>
					<li>
						<div class="comment-body clearfix">
							<img class="comment-avatar" src="images/icons/dummy.gif" />
							<a href="#">Adrian</a> on <a href="#">Article 2</a>:
							<div>She'd living. All upon make they're you're gathered kind. Divide they're under Male make without set. Whose. Itself creeping dominion.</div>
						</div>
						<div class="links">
							<span class="date">02/03/2010 - 3:30</span>
							<a href="#" class="reply">Reply</a>
							<a href="#" class="delete">Delete</a>
						</div>
					</li>
					<li>
						<div class="comment-body clearfix">
							<img class="comment-avatar" src="images/icons/dummy.gif" />
							<a href="#">Dave</a> on <a href="#">Article 3</a>:
							<div>Void midst. Fill. He sixth the very saw from was gathering there replenish won't she'd creepeth fly moved lesser they're you're multiply be sea firmament. Fowl above fourth him creeping it doesn't face rule deep have winged.</div>
						</div>
						<div class="links">
							<span class="date">02/03/2010 - 3:30</span>
							<a href="#" class="reply">Reply</a>
							<a href="#" class="delete">Delete</a>
						</div>
					</li>
				</ul>
				<div class="links">
					<a class="button" href="#">View All</a>
				</div-->
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