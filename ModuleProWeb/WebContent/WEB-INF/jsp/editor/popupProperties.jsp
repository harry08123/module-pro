<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Properties</title>
<style type="text/css">
	.rowClick{background-color: lavender;}
	#properties {
		font-family: "Trebuchet MS", "Helvetica", "Arial",  "Verdana", "sans-serif";
		font-size: 75%;
	}
	
	th{
		font-size: 90%;
		border-bottom: 1px solid #cccccc;
	}
	
	#figuresList td{
		padding: 4px 4px 4px 4px;
	}
	
	input{text-align: right; width: 100px;}
	select{width: 104px;}
</style>
<link href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css" rel="stylesheet">

<script type="text/javascript" src="<c:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-ui.js'/>"></script>

<script type="text/javascript">
$(function(){
	//클릭 된 row 표시
	$("#figuresList tr").each(function(){
		$(this).on("click", function(){
			$("#figuresList tr").each(function(){
				$(this).removeClass();
			});
			$(this).addClass("rowClick");
		});
	});
	
	//초기화 데이터 저장
	var initList = new Array();
	$("#properties input, #properties select").each(function(){
		var initObj = new Object();
		initObj.name = $(this).attr("name");
		initObj.value = $(this).val();
		initList.push(initObj);
	});
	
	//탭 설정
	$("#properties").tabs();
	
	//저장버튼
	$("#saveFiguresBtn").on("click", function(){
		if($("#tabs-4").css("display") != "none"){
			var formData = $("#densityForm").serialize();
			$.ajax({
				async : true,
				type : "POST",
				url : "<c:url value='/updateModelingInfo.do'/>",
				data : formData,
				success : function(data){
					alert("작업밀도 정보가 저장 되었습니다.");
				},
				error : function() {
				}
			});
		}else{
			var url = "";
			if(isNull($("input[name='figUid']").val())){
				url = "<c:url value='/insertFigures.do'/>";
			}else{
				url = "<c:url value='/updateFigures.do'/>";
			}
			
			$("#propertiesForm").attr("action", url);
			$("#propertiesForm").submit();
		}
		
	});
	
	//초기화 버튼
	$("#clearFiguresBtn").on("click", function(){
		$("input[name='figUid']").val("");
		$.each(initList, function(index, item){
			$("#properties input, #properties select").each(function(){
				var name = $(this).attr("name");
				if(item.name == name){
					$(this).val(item.value);
				}
			});
		});
		$("#saveFiguresBtn").html("저장");
		$("#figuresList tr").each(function(){
			$(this).removeClass();
		});
	});
	
	//Distribution 선택
	$("#figDistribution").on("change", function(){
		var distribution = $(this).val();
		$("#tabs-2 tr:not(.select)").each(function(){
			if(distribution == $(this).attr("class")){
				$(this).attr("style", "display:;");
			}else{
				$(this).attr("style", "display:none;");
			}
		});
	});
	
});

//목록 클릭
function selectFigures(figUid){
	$.ajax({
		async : true,
		type : "POST",
		url : "<c:url value='/selectFigures.do'/>",
		data : {
			"figUid"		: figUid,
			"figMoUid"		: $("input[name='figMoUid']").val(),
			"figProjectUid"	: $("input[name='figProjectUid']").val()
		},
		success : function(data){
			for(key in data){
				$("#properties input, #properties select").each(function(){
					var name = $(this).attr("name");
					name = name.toUpperCase();
					if(key == name){
						$(this).val(data[key]);
					}
				});
			}
			$("input[name='figUid']").val(figUid);
			$("#saveFiguresBtn").html("수정");
			$("#figDistribution").trigger("change");
		},
		error : function() {
		}
	});
}

//삭제 클릭
function deleteFigures(figUid){
	var figMoUid = $("input[name='figMoUid']").val();
	var figProjectUid = $("input[name='figProjectUid']").val();
	var deleteForm = "<form method='post' action='<c:url value='/deleteFigures.do'/>'>"+
	"<input type='hidden' name='figUid' value='"+figUid+"'/>"+
	"<input type='hidden' name='figMoUid' value='"+figMoUid+"'/>"+
	"<input type='hidden' name='figProjectUid' value='"+figProjectUid+"'/>"+
	"</form>";
	$(deleteForm).submit();
}



/*
 * 널 체크를 위한 함수.
 */
function isNull(obj){
	var sObj = showObj(obj);
	var returnFlag = false;
	if(sObj == null || sObj == "undefined" || sObj == "" || sObj == "NaN"){
		returnFlag = true;
	}
	if(obj == null || obj == "undefined" || obj == "" || obj == "NaN"){
		returnFlag = true;
	}
	return returnFlag;
}
/*
 * 오브젝트를 표시하기 위한 함수.
 */
function showObj(obj) {
	var str = "";
	for(key in obj) {
		str += key+"="+obj[key]+"\n\n";
	}
	return str;
}
</script>
</head>
<body>
<center>
	<table>
		<tr>
			<td>
				<div id="properties">
					<ul>
						<li><a href="#tabs-1">GENERAL</a></li>
						<li><a href="#tabs-2">FAILURE</a></li>
						<li><a href="#tabs-3">REPAIR</a></li>
						<li><a href="#tabs-4">작업밀도</a></li>
					</ul>
					<form id="propertiesForm" method="post">
						<input type="hidden" name="figProjectUid" value="${paramMap.figProjectUid }">
						<input type="hidden" name="figMoUid" value="${paramMap.figMoUid }">
						<input type="hidden" name="figUid" value="">
						<div id="tabs-1" style="height: 100px;">
							<table>
								<tr>
									<td>Failure Mode</td>
									<td>
										<select name="figFailMode">
											<option value="Critical">Critical</option>
											<option value="Degraded">Degraded</option>
											<option value="Incipient">Incipient</option>
											<option value="Unknown">Unknown</option>
											<option value="All Modes">All Modes</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>Impact of Faliure</td>
									<td>
										<input type="text" name="figImpFailure" value="100">
									</td>
								</tr>
								<tr>
									<td>Impact of Repair</td>
									<td>
										<input type="text" name="figImpRepair" value="100">
									</td>
								</tr>
								<tr>
									<td>Delivery</td>
									<td>
										<input type="text" name="figDelivery" value="0">
									</td>
								</tr>
							</table>
						</div>
						<div id="tabs-2" style="height: 100px;">
							<table>
								<tr class="select">
									<td>Distributuion</td>
									<td>
										<select id="figDistribution" name="figDistribution">
											<option value="1">Exponential</option>
											<option value="2">Normal</option>
											<option value="3">Rectangular</option>
											<option value="4">Triangular</option>
											<option value="5">Weibull(no delay)</option>
											<option value="6">Weibull(time delay)</option>
										</select>
									</td>
								</tr>
								<!-- Exponential -->
								<tr class="1">
									<td>MTTF</td>
									<td><input type="text" name="figFailureTime" value="10.1499998"></td>
								</tr>
								
								<!-- Normal -->
								<tr class="2" style="display: none;">
									<td>Expected Value</td>
									<td><input type="text" name="figNormExptMttf" value="0"></td>
								</tr>
								<tr class="2" style="display: none;">
									<td>Standard Deviation</td>
									<td><input type="text" name="figNormStdMttf" value="0"></td>
								</tr>
								
								<!-- Rectangular -->
								<tr class="3" style="display: none;">
									<td>Min MTTF</td>
									<td><input type="text" name="figMinMttf" value="0"></td>
								</tr>
								<tr class="3" style="display: none;">
									<td>Max MTTF</td>
									<td><input type="text" name="figMaxMttf" value="0"></td>
								</tr>
								
								<!-- Triangular -->
								<tr class="4" style="display: none;">
									<td>Min MTTF</td>
									<td><input type="text" name="figMinMttf" value="0"></td>
								</tr>
								<tr class="4" style="display: none;">
									<td>Most Likely MTTF</td>
									<td><input type="text" name="figMostMttf" value="0"></td>
								</tr>
								<tr class="4" style="display: none;">
									<td>Max MTTF</td>
									<td><input type="text" name="figMaxMttf" value="0"></td>
								</tr>
								
								<!-- Weibull(no delay) -->
								<tr class="5" style="display: none;">
									<td>Characteristic</td>
									<td><input type="text" name="figWeiCharMttf" value="0"></td>
								</tr>
								<tr class="5" style="display: none;">
									<td>Shape Factor</td>
									<td><input type="text" name="figWeiShapeMttf" value="0"></td>
								</tr>
								
								<!-- Weibull(time delay) -->
								<tr class="6" style="display: none;">
									<td>Characteristic</td>
									<td><input type="text" name="figWeiCharMttf" value="0"></td>
								</tr>
								<tr class="6" style="display: none;">
									<td>Shape Factor</td>
									<td><input type="text" name="figWeiShapeMttf" value="0"></td>
								</tr>
								<tr class="6" style="display: none;">
									<td>Time Delay</td>
									<td><input type="text" name="figWeiDeltime" value="0"></td>
								</tr>
								
							</table>
						</div>
						<div id="tabs-3" style="height: 100px;">
							<table>
								<tr>
									<td>Distributuion</td>
									<td>
										<select name="repdistribution">
											<option value="1">Exponential</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>MTTR</td>
									<td>
										<input type="text" name="figMttr" value="1.5">
									</td>
								</tr>
							</table>
						</div>
					</form>
					<form id="densityForm">
						<input type="hidden" name="mo_project" value="${paramMap.figProjectUid }">
						<input type="hidden" name="mo_uid" value="${paramMap.figMoUid }">
						<div id="tabs-4" style="height: 100px;">
							<table>
								<%-- 
								<c:if test="${paramMap.moType eq 'rect' }">
									<tr>
										<td>가로</td>
										<td>
											<input type="text" name="mo_width" value="${model.MO_WIDTH }">
										</td>
									</tr>
									<tr>
										<td>세로</td>
										<td>
											<input type="text" name="mo_height" value="${model.MO_HEIGHT }">
										</td>
									</tr>
								</c:if>
								<c:if test="${paramMap.moType eq 'arc' }">
									<tr>
										<td>반지름</td>
										<td>
											<input type="text" name="mo_ardius" value="${model.MO_RARDIUS }">
										</td>
									</tr>
								</c:if>
								 --%>
								<tr>
									<td>작업인원 수</td>
									<td>
										<input type="text" name="mo_persons" value="${model.MO_PERSONS }">
									</td>
								</tr>
							</table>
						</div>
					</form>
				</div>
			</td>
		</tr>
		<tr>
			<td align="right">
				<button id="clearFiguresBtn">초기화</button>
				<button id="saveFiguresBtn">저장</button>
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<thead>
						<tr>
							<th>Failure Mode</th>
							<th>Failure Distribution</th>
							<th>Impact of Failure</th>
							<th>Impact of Repair</th>
							<th>Delivery</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody id="figuresList">
						<c:forEach var="figList" items="${figuresList }">
						<tr style="cursor: pointer;" onclick="selectFigures('${figList.FIGUID }')">
							<td>${figList.FIGFAILMODE }</td>
							<td>${figList.FIGDISTRIBUTIONNAME }</td>
							<td style="text-align: right;">${figList.FIGIMPFAILURE }</td>
							<td style="text-align: right;">${figList.FIGIMPREPAIR }</td>
							<td style="text-align: right;">${figList.FIGDELIVERY }</td>
							<td style="text-align: center;"><button onclick="deleteFigures('${figList.FIGUID }')">삭제</button></td>
							
							<td id="figUid" style="display: none;">${figList.FIGUID }</td>
							<td id="figMoUid" style="display: none;">${figList.FIGMOUID }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
	
	
	
</center>
</body>
</html>