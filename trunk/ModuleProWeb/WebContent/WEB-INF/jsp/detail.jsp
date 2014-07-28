<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/basic/header.do"></jsp:include>

<section id="content">
	<section class="container_12 clearfix">
		<section id="main" class="grid_9 push_3">
			<article>
				<center>
				<label><h4>일정</h4></label>
				</center>
				<!--h1>Tables</h1>
				
				<h2>Standard Table</h2-->
				
				<form>
					<table id="table1" class="gtable sortable">
						<thead>
							<tr>
								<th width="3%"><input type="checkbox" class="checkall" /></th>
								<th width="15%">Factor</th>
								<th>Description</th>
								<th width="5%">N/A</th>
								<th width="10%">SCORE</th>
								<th width="12%">&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.1 단축된 일정</td>
								<td>선작업(prework)은 병행 활동과 공장의 생산성 증대 통해 일정을 압축시킬수 있다.</td>
								<td><input type="checkbox" name="check1"></td>
								<td>
									5
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.2 계획된 셧다운(shutdowns), 정전, 혹은 턴어라운드(turnarounds)</td>
								<td>건설에 앞서 어셈블리와 확인을 최대화하는 것은 셧다운 시간(shudown time)을 줄이기 위한 가능성 갖는다.</td>
								<td><input type="checkbox" name="check2" checked="true"></td>
								<td>
									1
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.3 최근 사업 결정</td>
								<td>선작업은 시장에 물품을 보내는 것과 관련된 최후의 사업 결정의 지연을 허용하면서, 더 높은 공장 생산성과 다중 제조 부지를 활용함으로써 설비 일정을 압축시키기 위한 가능성을 지닌다.</td>
								<td><input type="checkbox" name="check3" checked="true"></td>
								<td>
									3
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.4 조기 착수의 이점</td>
								<td>일정 압축은 설비가 더 짧은 가동 러닝 곡선(startup learning curve)을 야기하기 이전에 장비 성능 검사에 따라 멀리 떨어진 현장에서 다수의 작업 현장과 증가된 생산성의 결과이다.</td>
								<td><input type="checkbox" name="check4" checked="true"></td>
								<td>
									2
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.5 환경적 혹은 다른 프로젝트 허용 시기</td>
								<td>선작업은 부지 허가가 처리되는 동안 그 밖의 장소에서 착수하기 위해 작업을 허용할 수 있다.(주의사항은 허가요청 거부의 가능성 때문에 수행되어야 한다.)</td>
								<td><input type="checkbox" name="check5" checked="true"></td>
								<td>
									4
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.6 해상 운송 및 수송과 연관된 제한시간</td>
								<td>프로젝트 위치는 수송, 수용이나 설치 요소 역량을 좌우하거나 제한할 수 있다.<br/>
									만약 해상운송 기회를 놓진다면, 선작업 운송은 해상운송이나 수송 기회에 대한 시기선택이 요구 될 수 있다.</td>
								<td><input type="checkbox" name="check6" checked="true"></td>
								<td>
									0
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.7 장기 발주 장비나 물품</td>
								<td>장기발주품목은 선작업 수준에 관계 없이 일정에 영향을 줄것이다. 그러한 품목은 또한 선작업 수준과 범위를 제어 할 수 있다.</td>
								<td><input type="checkbox" name="check7"></td>
								<td>
									2
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.8 일정 불이익과 연관된 위험</td>
								<td>날씨 혹은 노동 조건과 연관된 일정 위험요소를 감소시킴에 따라, 선작업은 일정 불이익의 위험요소를 제한 할 수 있다.</td>
								<td><input type="checkbox" name="check8" checked="true"></td>
								<td>5
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.9 빠른 프로젝트 수행에 대한 보상</td>
								<td>선작업을 통한 일정 변화에서 일정 압축 그리고/혹은 일정 감소는 가능하면 우대책의 기회를 제공 할 수 있다.</td>
								<td><input type="checkbox" name="check9" checked="true"></td>
								<td>
									2
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>1.10 물품을 신속하게 시장에 진입시키기 위한 필요조건.</td>
								<td>선작업은 공장에서 생산성 향상을 통하여 그리고 디시퀀싱 활동(desequencing activites)으로 시장 진입 시간을 감소시킬 수 있다. 이것은 물품의 빠른 시장 진입을 허용할 수 있다.</td>
								<td><input type="checkbox" name="check10"></td>
								<td>
									1
								</td>
								<td>
									<img class="move" src="images/icons/arrow-move.png" alt="Move" title="Move" />
									<a href="#" title="Edit"><img src="images/icons/edit.png" alt="Edit" /></a>
									<a href="#" title="Delete"><img src="images/icons/cross.png" alt="Delete" /></a>
								</td>
							</tr>
						</tbody>
						<!--tfoot>
							<tr>
								<td colspan="6"></td>
								<td colspan="4">Average Raw Score : 5.30293</td>
							</tr>
						</tfoot-->
					</table>
					<div class="tablefooter clearfix">
						<div class="actions">
							<select>
								<option>Action:</option>
								<option>Delete</option>
								<option>Move</option>
							</select>
							<button class="button small">Apply</button>
						</div>
						<div class="pagination">
							<!--<a href="#">Prev</a>-->
							<a href="#" class="current">1</a>
							<a href="#">2</a>
							<a href="#">3</a>
							<a href="#">4</a>
							<a href="#">5</a>
							...
							<a href="#">78</a>
							<a href="#">Next</a>
						</div>
					</div>
					<div class="tablefooter clearfix">
						<div class="actions">
						</div>
						<div class="pagination">
							<label> Average Raw Score : 5.30293 </label>
						</div>
					</div>
				</form>

			</article>
			<article>
					<form id="myForm" class="uniform" method="post">
						<fieldset>
							<legend>Data Input</legend>
							<dl class="inline">
								<dt><label for="name">Factor</label></dt>
								<dd>
									<input type="text" id="name" class="medium required" size="50" />
								</dd>

								<dt><label for="description">Description</label></dt>
								<dd><textarea id="description" class="medium"></textarea>
								<small>This is an input description</small></dd>

								<dt><label for="score">Score</label></dt>
								<dd>
									<select size="1" id="score" class="medium required">
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</dd>
							</dl>
							<div class="buttons">
								<button type="submit" class="button">등 록</button>
							</div>
						</fieldset>
					</form>
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