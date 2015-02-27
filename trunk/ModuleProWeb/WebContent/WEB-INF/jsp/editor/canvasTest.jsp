<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editor</title>
<style>
.eResize {
	cursor: e-resize;
}

.nResize {
	cursor: n-resize;
}

.seResize {
	cursor: se-resize;
}

.swResize {
	cursor: sw-resize;
}

.move {
	cursor: move;
}

.crosshair {
	cursor: crosshair;
}

.rectnumber {
	border-right: 1px solid #ccc;
}
</style>


<link href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css"
	rel="stylesheet">
<link type="text/css" href="<c:url value='/css/canvasstyle.css'/>"
	rel="stylesheet">
<link type="text/css" href="<c:url value='/css/colorpicker.css'/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value='/css/jquery.contextMenu.css'/>" rel="stylesheet" />

<script type="text/javascript" src="<c:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-ui.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/colorpicker.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/jquery.contextMenu.js'/>"></script>

<script type="text/javascript">
Array.prototype.removeElement = function(i){
	this.splice(i, 1);
	return this;
}
Array.prototype.clear = function(){
	var len = this.length;
	for(var i=0; i<len; i++){
		this.pop();
	}
	return this;
}

var canvas;
var ctx;
var img = new Image();
var arRectangle = new Array();
var sx, sy;				// 드래그 시작점
var ex, ey;				// 드래그 끝점
var color;				// 현재 색상
var drawing;			// 그리고 있는 중인가
var moving = -1;		// 이동중인 도형 첨자
var lineGap = 10;		// 라인으로 간주하는 GAP
var selectedRect = -1;	// 선택 된 사각형
var moType = "rect";
var lineFirstSx = -1, lineFirstSy = -1;		// 라인 그리기 최초 좌표
var lineSx, lineSy;
var arLine = new Array();
var lineID = 0;

var nameDialog;

// 사각형 생성자
function Rectangle(sx, sy, ex, ey, color) {
	this.id = "";
	this.name = "";
	this.sx = Number(sx);
	this.sy = Number(sy);
	this.ex = Number(ex);
	this.ey = Number(ey);
	this.color = color;
	this.type = moType;
	this.rot = 0;
	this.availability = -1;
	this.density = -1;
	this.mflag = false;
}

//Line 생성자
function Line(id, sx, sy, ex, ey, color){
	this.id = id;
	this.sx = Number(sx);
	this.sy = Number(sy);
	this.ex = Number(ex);
	this.ey = Number(ey);
	this.color = color;
}

function canvasX(clientX) {
	var bound = canvas.getBoundingClientRect();
	var bw = 5;
	return (clientX - bound.left - bw) * (canvas.width / (bound.width - bw * 2));
}

function canvasY(clientY) {
	var bound = canvas.getBoundingClientRect();
	var bw = 5;
	return (clientY - bound.top - bw) * (canvas.height / (bound.height - bw * 2));
}

// x, y 위치의 사각형 찾음. 없으면 -1
function getRectangle(x, y) {
	for (var i = 0;i < arRectangle.length;i++) {
		var rect = arRectangle[i];
		if(rect.mflag || moType == "line"){
			if (x > rect.sx-lineGap && x < rect.ex+lineGap && y > rect.sy-lineGap && y < rect.ey+lineGap) {
				return i;
			}
		}
	}
	return -1;
}

//선을 그은 도형들의 아이디 얻기
function getOverlapRectID(lineID){
	var overlapRectIDList = new Array();
	var returnList = null;
	for(var i=0; i<arLine.length; i++){
		var line = arLine[i];
		if(line.id == lineID){
			var x = line.sx;
			var y = line.sy;
			var overlapIDs = new Array();
			
			for (var j = 0;j < arRectangle.length;j++) {
				var rect = arRectangle[j];
				if (x > rect.sx-lineGap && x < rect.ex+lineGap && y > rect.sy-lineGap && y < rect.ey+lineGap) {
					overlapIDs.push(rect.id);
				}
			}
			overlapRectIDList.push(overlapIDs);
		}
	}
	
	var minLen = 100;
	for(var i=0; i<overlapRectIDList.length; i++){
		if(minLen > overlapRectIDList[i].length){
			minLen = overlapRectIDList[i].length;
			returnList = overlapRectIDList[i];
		}
	}
	
	return returnList;
}

//x, y 위치의 사각형 찾음. 없으면 -1
function getFindEdge(x, y) {
	var edgeObj = new Object();
	edgeObj.i = -1;
	edgeObj.cursor = 0; 	//커서 모양
	edgeObj.move = "";		//크기변경 방향
	/* 
	- : 1
	| : 2
	\ : 3
	/ : 4
	*/
	for (var i = 0;i < arRectangle.length;i++) {
		var rect = arRectangle[i];
		if(rect.mflag){
			if(rect.type != "line"){
				if(x > rect.sx - lineGap && x < rect.sx + lineGap && y > rect.sy + lineGap && y < rect.ey - lineGap){		//왼쪽
					edgeObj.i = i;
					edgeObj.cursor = 1;
					edgeObj.move = "L";
					return edgeObj;
				}  
				if(x > rect.ex - lineGap && x < rect.ex + lineGap && y > rect.sy + lineGap && y < rect.ey - lineGap){		//오른쪽
					edgeObj.i = i;
					edgeObj.cursor = 1;
					edgeObj.move = "R";
					return edgeObj;
				}
				if(x > rect.sx + lineGap && x < rect.ex - lineGap && y > rect.sy - lineGap && y < rect.sy + lineGap){		//위
					edgeObj.i = i;
					edgeObj.cursor = 2;
					edgeObj.move = "T";
					return edgeObj;
				}  
				if(x > rect.sx + lineGap && x < rect.ex - lineGap && y > rect.ey - lineGap && y < rect.ey + lineGap){		//아래
					edgeObj.i = i;
					edgeObj.cursor = 2;
					edgeObj.move = "B";
					return edgeObj;
				}
				if (x > rect.sx - lineGap && x < rect.sx + lineGap && y > rect.sy - lineGap && y < rect.sy + lineGap){		//좌 위
					edgeObj.i = i;
					edgeObj.cursor = 3;
					edgeObj.move = "TL";
					return edgeObj;
				}
				if	(x > rect.ex - lineGap && x < rect.ex + lineGap && y > rect.ey - lineGap && y < rect.ey + lineGap){		//우 아래
					edgeObj.i = i;
					edgeObj.cursor = 3;
					edgeObj.move = "BR";
					return edgeObj;
				}
				
				if (x > rect.ex - lineGap && x < rect.ex + lineGap && y > rect.sy - lineGap && y < rect.sy + lineGap){  	//우 위
					edgeObj.i = i;
					edgeObj.cursor = 4;
					edgeObj.move = "TR";
					return edgeObj;
				}
				if	(x > rect.sx - lineGap && x < rect.sx + lineGap && y > rect.ey - lineGap && y < rect.ey + lineGap){		//좌 아래
					edgeObj.i = i;
					edgeObj.cursor = 4;
					edgeObj.move = "BL";
					return edgeObj;
				}
				
				if (x > rect.sx && x < rect.ex && y > rect.sy && y < rect.ey) {
					edgeObj.i = i;
					edgeObj.cursor = 5;
					edgeObj.move = "M";
					return edgeObj;
				}
			}
		}
	}
	return edgeObj;
}

// 화면 지우고 모든 도형을 순서대로 다 그림
function drawRects() {
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	
	for (var i = 0;i < arRectangle.length;i++) {
		var r = arRectangle[i];
		if(r.type == "rect"){
			
			ctx.save();
			var centerX = (r.ex-r.sx)/2 + r.sx;
			var centerY = (r.ey-r.sy)/2 + r.sy;
			ctx.translate(centerX, centerY);
			ctx.rotate((Math.PI / 180) * Math.round(r.rot));
			ctx.translate(-(centerX), -(centerY));
			
			ctx.globalCompositeOperation = "lighter";
			ctx.fillStyle = r.color;
			ctx.fillRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
			
			ctx.strokeStyle="black";
			ctx.lineWidth = 1;
			ctx.strokeRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
			
			ctx.restore();
			
		}else if(r.type == "arc"){
			
			ctx.beginPath();
			ctx.globalCompositeOperation = "lighter";
			var arcStd = Math.min(r.ex-r.sx, r.ey-r.sy);
			ctx.arc((arcStd)/2+r.sx, (arcStd)/2+r.sy, (Math.abs(arcStd))/2, 0, 2*Math.PI);
			ctx.fillStyle = r.color;
			ctx.fill();
			
			ctx.strokeStyle="black";
			ctx.lineWidth = 1;
			ctx.stroke();
			
		}
		
		var font = "";
		if(r.availability != -1){
			ctx.beginPath();
			ctx.font="bold 14px 고딕";
			ctx.fillStyle = "red";
			ctx.fillText(r.availability + "%", r.sx+5,r.sy);
			
			/* var fontGap = 0;
			if(r.availability != 0){
				fontGap = 50;
			}
			
			var fontColor = "red";
			if(isNull(r.density)){r.density=0;}
			if(Number(r.density) > 79){fontColor = "green";}
			else if(Number(r.density) < 80 && Number(r.density) > 59){fontColor = "orange";}
			ctx.font="bold 14px 고딕";
			ctx.fillStyle = fontColor;
			ctx.fillText("["+(Math.round(r.density*100)/100)+"%]", r.sx+30+fontGap,r.sy); */
		}
		
		if(r.type != "line"){
			var centerX = (r.ex-r.sx)/2 + r.sx;
			var centerY = (r.ey-r.sy)/2 + r.sy;
			var name = "";
			if(r.name == ""){
				name = r.id;
			}else{
				name = r.name;
			}
			
			var centerGap = 10;
			centerGap = centerGap * name.length;
			
			ctx.font="bold 20px 고딕";
			ctx.fillStyle = "black";
			ctx.fillText(name, centerX-centerGap,centerY);
		}
		
	}
	
	for(var i=0; i<arLine.length; i++){
		var line = arLine[i];
		drawLine(line.sx, line.sy, line.ex, line.ey, line.color);
	}
	
}

//선 그리기
function drawLine(sx, sy, ex, ey, color)
{
	ctx.beginPath();
	ctx.moveTo(sx, sy);
	ctx.lineTo(ex, ey);
	ctx.strokeStyle=color;
	ctx.lineWidth = 3;
	ctx.stroke();
}

//선 삭제
function deleteLines(id, obj){
	for(var i=arLine.length-1; i>=0; i--){
		if(id == arLine[i].id){
			arLine.removeElement(i);
		}
	}
	$(obj).parent().parent().remove();
	drawRects();
}

//도형의 선이 교차되는 지점 좌표 찾기
function getCrossPoint(x, y){
	
	var crossPointObj = new Object();
	crossPointObj.x = -1;
	crossPointObj.y = -1;
	
	for (var i = 0;i < arRectangle.length;i++) {
		var r = arRectangle[i];
		
		if(r.sx+lineGap > x && r.sx-lineGap < x){
			crossPointObj.x = r.sx;
		}
		
		if(r.ex+lineGap > x && r.ex-lineGap < x){
			crossPointObj.x = r.ex;
		}
		
		if(r.sy+lineGap > y && r.sy-lineGap < y){
			crossPointObj.y = r.sy;
		}
		
		if(r.ey+lineGap > y && r.ey-lineGap < y){
			crossPointObj.y = r.ey;
		}
	}
	
	return crossPointObj;
}

function getRectName(id){
	var name = "";
	for(var i = 0;i < arRectangle.length;i++){
		var r = arRectangle[i];
		if(r.id == id){
			name = r.name == "" ? r.id : r.name;
		}
	}
	return name;
}

//선 색상 바꾸기
function changeLineColor(lineID, lineColor){
	for(var i=0; i<arLine.length; i++){
		var line = arLine[i];
		if(line.id == lineID){
			line.color = lineColor;
		}
	}
}

//다각형 면적을 구하기 위한 X[], Y[], point 갯수를 구한다. 
function getOverlapPoint(lineID){
	var overlapPointObj = new Object();
	overlapPointObj.xArr = null;
	overlapPointObj.yArr = null;
	overlapPointObj.numPoints = 0;
	
	var xArr = new Array();
	var yArr = new Array();
	
	
	for(var i=0; i<arLine.length; i++){
		var line = arLine[i];
		if(line.id == lineID){
			xArr.push(line.sx);
			yArr.push(line.sy);
			overlapPointObj.numPoints++;
		}
	}
	overlapPointObj.xArr = xArr;
	overlapPointObj.yArr = yArr;
	
	return overlapPointObj;
}

//다각형 면적 구하기
function polygonArea(X, Y, numPoints){
	var area = 0;
	var j = numPoints-1;
	
	for (i=0; i<numPoints; i++){ 
		area = area +  (X[j]+X[i]) * (Y[j]-Y[i]); 
		j = i;
	}
	
	return area/2;
}


$(function(){
	canvas = document.getElementById("canvas");
	if (canvas == null || canvas.getContext == null) return;
	ctx = canvas.getContext("2d");
	
	ctx.strokeStyle = "black";
	ctx.lineWidth = 2;
	color = "rgba(255, 255, 0, 0.3)"
	ctx.fillStyle = color;
	
	<c:forEach items="${modelingList}" var="modelingList">
		arRectangle.push(new Rectangle("${modelingList.MO_SX}", "${modelingList.MO_SY}", "${modelingList.MO_EX}", "${modelingList.MO_EY}","${modelingList.MO_COLOR}"));
		arRectangle[arRectangle.length-1].id = "${modelingList.MO_UID}";
		arRectangle[arRectangle.length-1].name = "${modelingList.MO_NAME}";
		arRectangle[arRectangle.length-1].type = "${modelingList.MO_TYPE}";
		arRectangle[arRectangle.length-1].rot = "${modelingList.MO_ROT}";
	</c:forEach>
	
	img.src = "print/${project.PRO_FILE}";
	img.onload = function(){
		var style = "width: "+img.width+"px; height: "+img.height+"px; background-image: url('print/${project.PRO_FILE}');"
		$("#printDIV").attr("style", style);
		$("canvas").attr("width", (img.width)+"").attr("height", (img.height)+"");
		drawRects();
		
	}
	
	canvas.onmousedown = function(e){
		e.preventDefault();
		e.stopPropagation();
		sx = canvasX(e.clientX);
		sy = canvasY(e.clientY);
		
		if(moType != "line"){
			// 클릭한 좌표 구하고 그 위치에 도형이 있는지 조사
			moving = getRectangle(sx, sy);
			drawRects();
			if(e.which == 1){
				// 도형을 클릭한 것이 아니면 그리기 시작
				if (moving == -1) {
					drawing = true;
					selectedRect = -1;
				}else{
					var r = arRectangle[moving];
					if(r.type != "line"){
						ctx.fillStyle = r.color;
						ctx.fillRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
						ctx.strokeStyle="black";
						ctx.lineWidth = 1;
						ctx.strokeRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
						selectedRect = moving;
					}
				}
			}else if(e.which == 3){
				selectedRect = moving;
			}
		
		//선 그리기
		}else{
			
			//도형이 아닌곳을 클릭하면 선이 그려지지 않는다.
			if(getRectangle(sx, sy) == -1){
				for(var i=arLine.length-1; i>=0; i--){
					if(lineID == arLine[i].id){
						arLine.removeElement(i);
					}
				}
				
				drawing = false;
				lineFirstSx = -1;
				lineFirstSy = -1;
				moType = "rect";
				drawRects();
				
				return;
			}
			
			//대강의 위치를 선 위로 잡아준다.
			var crossPointObj = getCrossPoint(sx, sy);
			if(crossPointObj.x != -1 && crossPointObj.y != -1){
				sx = crossPointObj.x;
				sy = crossPointObj.y;
			}
			
			if(lineFirstSx == -1 && lineFirstSy == -1){
				
				lineFirstSx = sx;
				lineFirstSy = sy;
				lineSx = sx;
				lineSy = sy;
				drawing = true;
				lineID++;
				
			}else{
				if((lineFirstSx < sx+lineGap && lineFirstSx > sx-lineGap) && (lineFirstSy < sy+lineGap && lineFirstSy > sy-lineGap)){
					arLine.push(new Line(lineID, lineSx, lineSy, lineFirstSx, lineFirstSy, "yellow"));
					drawing = false;
					lineFirstSx = -1;
					lineFirstSy = -1;
					moType = "rect";
					
					var overlapRectIDList = getOverlapRectID(lineID);
					
					if(overlapRectIDList.length == 2){
						changeLineColor(lineID, "blue");
					}else if(overlapRectIDList.length == 3){
						changeLineColor(lineID, "red");
					}
					
					var rectNames = "";
					var persons = 0;
					for(var i=0; i<overlapRectIDList.length; i++){
						if(i == 0){
							rectNames+= getRectName(overlapRectIDList[i]);
						}else{
							rectNames+= "<p>" + getRectName(overlapRectIDList[i]) + "</p>";
						}
						persons += Number(getRectPersons(overlapRectIDList[i]));
					}
					
					var overlapPoint = getOverlapPoint(lineID);
					var area = polygonArea(overlapPoint.xArr, overlapPoint.yArr, overlapPoint.numPoints);
					area = Math.abs(area);
					
					console.log(persons + " / " + area + " = " + Number(persons)/Number(area));
					var density = Math.round(Number(persons)/Number(area)*100);
					
					var tag = "<tr>"+
							  "<td class='rectnumber' style='width:127px;'>"+rectNames+"</td>"+
							  "<td class='rectnumber' id='area' style='text-align: right; width:48px;'>"+Math.round(area)+"</td>"+
							  "<td class='rectnumber' style='text-align: right; width:48px;'>"+density+"%</td>"+
							  "<td style='text-align: center; width:18px;'>"+
							  "<img src=\"<c:url value='/images/icons/cross.png'/>\" onclick=\"deleteLines('"+lineID+"', this)\" style='cursor: pointer;'>"+
							  "</td>"+
							  "</tr>";
					$("#density").append(tag);
					
				}else{
					arLine.push(new Line(lineID, lineSx, lineSy, sx, sy, "yellow"));
				}
				
				drawRects();
			}
			
			lineSx = sx;
			lineSy = sy;
			
		}
		
	}
	
	canvas.onmousemove = function(e) {
		e.preventDefault();
		e.stopPropagation();
		ex = canvasX(e.clientX);
		ey = canvasY(e.clientY);
		
		if(moType != "line"){
			
			var edgeObj = getFindEdge(ex, ey);
			if(edgeObj.cursor == 0){
				$("canvas").attr("class", "");
			}else if(edgeObj.cursor == 1){ // -
				$("canvas").attr("class", "eResize");
			}else if(edgeObj.cursor == 2){ // |
				$("canvas").attr("class", "nResize");
			}else if(edgeObj.cursor == 3){ // \
				$("canvas").attr("class", "seResize");
			}else if(edgeObj.cursor == 4){ // /
				$("canvas").attr("class", "swResize");
			}else if(edgeObj.cursor == 5){ // +
				if(!event.ctrlKey){
					$("canvas").attr("class", "move");
				}else{
					$("canvas").attr("class", "crosshair");
				}
			}
			
			
			// 화면 다시 그리고 현재 도형 그림
			if (drawing) {
				
				if(Math.abs(sx-ex) > lineGap && Math.abs(sy-ey)> lineGap){
					drawRects();
					ctx.fillStyle = color;
					
					if(moType == "rect"){
						ctx.fillRect(sx, sy, ex-sx, ey-sy);
						ctx.strokeStyle="black";
						ctx.lineWidth = 1;
						ctx.strokeRect(sx, sy, ex-sx, ey-sy);
					}else if(moType == "arc"){
						var arcStd = Math.min(ex-sx, ey-sy);
					 	ctx.fillRect(sx, sy, arcStd, arcStd);
					 	ctx.strokeStyle="black";
						ctx.lineWidth = 1;
						ctx.strokeRect(sx, sy, arcStd, arcStd);
						
						ctx.beginPath();
						ctx.arc((arcStd)/2+sx, (arcStd)/2+sy, (Math.abs(arcStd))/2, 0, 2*Math.PI);
						ctx.stroke();
					}else if(moType == "line"){
						drawLine(sx, sy, ex, ey, "yellow");
					}
	
				}
			}
			
			// 상대적인 마우스 이동 거리만큼 도형 이동
			if (moving != -1) {
				
				var r = arRectangle[moving];
				if(edgeObj.move == "M"){
					if(!event.ctrlKey){
						r.sx += (ex - sx);
						r.sy += (ey - sy);
						r.ex += (ex - sx);
						r.ey += (ey - sy);
					}else{	//컨트롤 키 누른채로(회전)
						r.rot = Number(r.rot) + Number(Math.abs(sx-ex) > Math.abs(sy-ey) ? sx-ex : sy-ey);
					}
				}else if(edgeObj.move == "L"){
					if(r.ex > r.sx+lineGap){
						r.sx += (ex - sx);
						if(r.type == "arc"){
							r.ey -= (ex - sx);
						}
					}
				}else if(edgeObj.move == "R"){
					if(r.ex > r.sx){
						r.ex += (ex - sx);
						if(r.type == "arc"){
							r.ey += (ex - sx);
						}
					}
				}else if(edgeObj.move == "T"){
					if(r.ey > r.sy+lineGap){
						r.sy += (ey - sy);
						if(r.type == "arc"){
							r.ex -= (ey - sy);
						}
					}
				}else if(edgeObj.move == "B"){
					if(r.ey > r.sy){
						r.ey += (ey - sy);
						if(r.type == "arc"){
							r.ex += (ey - sy);
						}
					}
				}else if(edgeObj.move == "TL"){
					if(r.ex > r.sx+lineGap){
						r.sx += (ex - sx);
						if(r.type == "arc"){
							r.ey -= (ex - sx);
						}
					}
					if(r.ey > r.sy+lineGap){
						r.sy += (ey - sy);
						if(r.type == "arc"){
							r.ex -= (ey - sy);
						}
					}
				}else if(edgeObj.move == "BR"){
					if(r.ex > r.sx){
						r.ex += (ex - sx);
						if(r.type == "arc"){
							r.ey += (ex - sx);
						}
					}
					if(r.ey > r.sy){
						r.ey += (ey - sy);
						if(r.type == "arc"){
							r.ex += (ey - sy);
						}
					}
				}else if(edgeObj.move == "TR"){
					if(r.ey > r.sy+lineGap){
						r.sy += (ey - sy);
						if(r.type == "arc"){
							r.ex -= (ey - sy);
						}
					}
					if(r.ex > r.sx){
						r.ex += (ex - sx);
						if(r.type == "arc"){
							r.ey += (ex - sx);
						}
					}
				}else if(edgeObj.move == "BL"){
					if(r.ey > r.sy){
						r.ey += (ey - sy);
						if(r.type == "arc"){
							r.ex += (ey - sy);
						}
					}
					if(r.ex > r.sx+lineGap){
						r.sx += (ex - sx);
						if(r.type == "arc"){
							r.ey -= (ex - sx);
						}
					}
				}
				
				sx = ex;
				sy = ey;
				
				drawRects();
				
				if(r.type != "line"){
					ctx.fillStyle = r.color;
					ctx.fillRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
					ctx.strokeStyle="black";
					ctx.lineWidth = 1;
					ctx.strokeRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
				}
				
			} //end moving != -1
		}else{ // end moType != "line"
			if(drawing){
				drawRects();
				if((lineFirstSx < ex+lineGap && lineFirstSx > ex-lineGap) && (lineFirstSy < ey+lineGap && lineFirstSy > ey-lineGap)){
					drawLine(sx, sy, lineFirstSx, lineFirstSy, "yellow");
				}else{
					drawLine(sx, sy, ex, ey, "yellow");
				}
			}
		}
	}
	
	canvas.onmouseup = function(e) {
		if(moType != "line"){
			// 좌표 정규화해서 새로운 도형을 배열에 추가
			if (drawing) {
				if(Math.abs(sx-ex) > lineGap && Math.abs(sy,ey)> lineGap){	//마우스 움직임이 최소 크기보다 클때만 도형을 그린다
					var x1, y1, x2, y2;
					if(moType == "rect"){
						x1 = Math.min(sx, ex);
						y1 = Math.min(sy, ey);
						x2 = Math.max(sx, ex);
						y2 = Math.max(sy, ey);
						arRectangle.push(new Rectangle(x1, y1, x2, y2, color));
					}else if(moType == "arc"){
						x1 = Math.min(sx, ex);
						y1 = Math.min(sy, ey);
						x2 = Math.max(sx, ex);
						y2 = Math.max(sy, ey);
						var arcStd = Math.min(x2-x1, y2-y1);
						arRectangle.push(new Rectangle(x1, y1, arcStd+x1, arcStd+y1, color));
					}
					selectedRect = arRectangle.length-1;
				}else{
					drawing = false;
				}
			}
			
			if(selectedRect != -1){
				saveModelingInfo();
			}
			
			if(moving != -1){
				var r = arRectangle[moving];
				ctx.fillStyle = r.color;
				ctx.fillRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
				ctx.strokeStyle="black";
				ctx.lineWidth = 1;
				ctx.strokeRect(r.sx, r.sy, r.ex-r.sx, r.ey-r.sy);
			}
			
			drawing = false;
			moving = -1;
		}
	}
	
	
	/*우클릭 메뉴*/
	$.contextMenu({
		selector: "canvas", 
		callback: function(key, options){
			contextFn(key, $(this));
		},
		items: {
			"pop": {name: "Properties"},
			"del": {name: "Delete System"},
			"name" : {name: "Insert System Name"}
		}
	});
	
	//Color Picker
	$("#noIndColor").colorpicker({
		displayIndicator: false
	}).on('change.color', function(evt, selectedColor){
		var r = parseInt(selectedColor.substr(1,2),16);
		var g = parseInt(selectedColor.substr(3,2),16);
		var b = parseInt(selectedColor.substr(5,2),16);
		var a = "0.3";
		color = "rgba("+r+", "+g+", "+b+", "+a+")";
		if(selectedRect != -1){
			arRectangle[selectedRect].color = "rgba("+r+", "+g+", "+b+", "+a+")";
			saveModelingInfo();
		}
	});
	$("#colorpicker").find("div:eq(0)").attr("style", "");
	$("#noIndColor").before("색상");
	
	//Run Simulation
	$("#runSimulationBtn").on("click", function(){
		var formData = $("#projectForm").serialize();
		$.ajax({
			async : false,
			type : "POST",
			url : "<c:url value='/runSimulator.do'/>",
			data : formData,
			success : function(data){
				totAvailability = ((data.totAvailability).toString()).substr(0, 7);
				$("#totAvailability").html(totAvailability);
			},
			error : function() {
			}
		});
		
		var moUidTag = "<input type='hidden' name='moUid' value=''>";
		$("#projectForm").append(moUidTag);
		$.each(arRectangle, function(index, item){
			$("#projectForm input[name='moUid']").val(item.id);
			formData = $("#projectForm").serialize();
			$.ajax({
				async : false,
				type : "POST",
				url : "<c:url value='/runSimulator.do'/>",
				data : formData,
				success : function(data){
					totAvailability = ((data.totAvailability).toString()).substr(0, 7);
					item.availability = totAvailability;
					item.density = data.density;
				},
				error : function() {
				}
			});
		})
		drawRects();
		return false;
	});
	
	nameDialog = $("#nameDialog").dialog({
		autoOpen: false,
		height: 200,
		width: 400,
		modal: true,
		buttons: {
			"Save": insertName,
			Cancel: function() {
				nameDialog.dialog( "close" );
			}
		}
	});
	
	$("#checkall").click(function(){
		var checked = this.checked;
		$(".checkbox").prop("checked", checked);
		$.each(arRectangle, function(index, item){
			item.mflag = checked;
		});
	});
	
});

function contextFn(key){
	if(selectedRect != -1){
		if(key == "del"){
			if(confirm("삭제 하시겠습니까?")){
				deleteModelingInfo();
			}
		}else if(key == "pop"){
			$("#propertiesForm input[name='figMoUid']").val(arRectangle[selectedRect].id);
			$("#propertiesForm input[name='moType']").val(arRectangle[selectedRect].type);
			openPopup();
		}else if(key == "name"){
			nameDialog.dialog("open");
		}
	}else{
		alert("도형을 선택 하세요.");
	}
}

function saveModelingInfo(){
	var url = "";
	if(drawing){
		url = "<c:url value='/insertModelingInfo.do'/>";
	}else{
		url = "<c:url value='/updateModelingInfo.do'/>";
	}
	
	$.ajax({
		async : false,
		type : "POST",
		url : url,
		data : {
			"mo_project"	: $("input[name='mo_project']").val(),
			"mo_type"		: arRectangle[selectedRect].type,
			"mo_uid"		: arRectangle[selectedRect].id,
			"mo_sx"			: arRectangle[selectedRect].sx,
			"mo_sy"			: arRectangle[selectedRect].sy,
			"mo_ex"			: arRectangle[selectedRect].ex,
			"mo_ey"			: arRectangle[selectedRect].ey,
			"mo_color"		: arRectangle[selectedRect].color,
			"mo_rot"		: arRectangle[selectedRect].rot
		},
		success : function(data){
			arRectangle[selectedRect].id = data.mo_uid;
			if(drawing){
				var tag = "<tr id='row_"+data.mo_uid+"'>"+
						  "<td class='check-form'><input id='fig_"+data.mo_uid+"' class='checkbox' type='checkbox' onchange=\"changeFigMovind('"+data.mo_uid+"')\"></td>"+
						  "<td>"+data.mo_uid+"</td>"+
						  "</tr>";
				$("#figures").append(tag);
			}
			drawRects();
		},
		error : function() {
		}
	});
}

function deleteModelingInfo(){
	$.ajax({
		async : true,
		type : "POST",
		url : "<c:url value='/deleteModelingInfo.do'/>",
		data : {
			"mo_project"	: $("input[name='mo_project']").val(),
			"mo_uid"		: arRectangle[selectedRect].id
		},
		success : function(data){
			$("#figures tr[id='row_"+arRectangle[selectedRect].id+"']").remove();
			arRectangle.removeElement(selectedRect);
			drawRects();
		},
		error : function() {
		}
	});
}

function openPopup(){
	var popUrl = "<c:url value='/popupProperties.do'/>";
	var popTitle = "Properties";
	var popOption = "width=600, height=550, top=50, left=150, resizable=no, scrollbars=no, status=no;";
	window.open("",popTitle,popOption);
	document.propertiesForm.target = popTitle;
	document.propertiesForm.action = popUrl;
	document.propertiesForm.method = "post";
	document.propertiesForm.submit();
}

function printChange(fileObj){
	$("#projectForm").attr("enctype", "multipart/form-data");
	$("#projectForm").attr("action", "<c:url value='/updateEditorProject.do'/>");
	$("#projectForm").attr("method", "post");
	$("#projectForm").append(fileObj);
	$("#colorpicker").append($(fileObj).clone());
	$("#projectForm").submit();
}

function insertName(){
	var name = $("#name").val();
	$.ajax({
		async : true,
		type : "POST",
		url : "<c:url value='/updateModelingInfo.do'/>",
		data : {
			"mo_project"	: $("input[name='mo_project']").val(),
			"mo_uid"		: arRectangle[selectedRect].id,
			"mo_name"		: name
		},
		success : function(data){
			$("#name").val("");
			arRectangle[selectedRect].name = name;
			arRectangle[selectedRect].id = data.mo_uid;
			$("#figures tr[id='row_"+arRectangle[selectedRect].id+"'] td").last().html(name);
			drawRects();
		},
		error : function() {
		}
	});
	nameDialog.dialog( "close" );
}

function getRectPersons(id){
	var persons = 0;
	$.ajax({
		async : false,
		type : "POST",
		url : "<c:url value='/selectModel.do'/>",
		data : {
			"mo_project"	: $("input[name='mo_project']").val(),
			"figMoUid"		: id,
			"mo_name"		: name
		},
		success : function(data){
			persons = data.MO_PERSONS;
		},
		error : function() {
		}
	});
	
	return persons;
}

function changeFigMovind(id){
	$.each(arRectangle, function(index, item){
		if(item.id == id){
			item.mflag = $("#fig_"+id).is(":checked");
		}
	});
}

/*크게보기 zoomIn*/
var zoomLevel = 1;
function zoomIn(zoom, tagId){
	if($("#"+tagId).length > 0){
		zoomLevel += Number(zoom);
		$("#"+tagId).css({ zoom: zoomLevel, '-moz-transform': 'scale(' + zoomLevel + ')'});
		$("#canvas").css({ zoom: zoomLevel, '-moz-transform': 'scale(' + zoomLevel + ')'});
	}
}
function zoomOut(zoom, tagId){
	if($("#"+tagId).length > 0){
		zoomLevel += Number(zoom);
		$("#"+tagId).css({ zoom: zoomLevel, '-moz-transform': 'scale(' + zoomLevel + ')'});
		$("#canvas").css({ zoom: zoomLevel, '-moz-transform': 'scale(' + zoomLevel + ')'});
	}
}

function lineBack(){
	if(arLine.length > 0){
		var lastLineID = arLine[arLine.length-1].id;
		for(var i=arLine.length-1; i>=0; i--){
			if(lastLineID == arLine[i].id){
				arLine.removeElement(i);
			}
		}
		$("#density tr").last().remove();
		drawRects();
	}
}

/*도형선택*/
function selectMotype(type){
	moType = type;
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

/*
 * 널 체크를 위한 함수.
 */
function isNull(obj){
	var returnFlag = false;
	if(obj == null || obj == "undefined" || obj == "" || obj == "NaN"){
		returnFlag = true;
	}
	return returnFlag;
}

</script>
</head>
<body>
	<div class="center">
		<div class="top-menu" id="colorpicker">
			<ul>
				<li style="float:left;"><img src="/ModulePro/images/canvasTest/logo.png" style="height:42px;"></li>
				<li><input type="file" name="file" style="width:277px;" onchange="printChange(this);"></li>
				<li class="color-pic"><input id="noIndColor" class="colorPicker evo-cp8" style="display:none;"></li>
				<!-- <li><button id="line" onclick="lineBack()">뒤로</button></li> -->
				<li class="figure-pic"><label for="line"><input type="image" onfocus="this.blur()" src="/ModulePro/images/canvasTest/figure03.png" id="line" onclick="selectMotype('line')"><span>중복면적</span></label></li>
				<li class="figure-pic"><label for="arc"><input type="image" onfocus="this.blur()" src="/ModulePro/images/canvasTest/figure02.png" id="arc" onclick="selectMotype('arc')"><span>원</span></label></li>
				<li class="figure-pic"><label for="rect"><input type="image" onfocus="this.blur()" src="/ModulePro/images/canvasTest/figure01.png" id="rect" onclick="selectMotype('rect')"><span>사각형</span></label></li>
			</ul>
		</div>
		<div class="drow-wrap">
			<div id="printDIV">
				<canvas id="canvas" width="800" height="600"> 이 브라우저는 캔버스를
				지원하지 않습니다. </canvas>
			</div>
		</div>
		<div class="simul-wrap">
		<form id="projectForm">
			<input type="hidden" name="mo_project" value="${project.PRO_UID}">
			<table width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<th>Iteration</th>
					<td><input type="text" name="proIterNum"
						value="${project.PRO_ITERNUM}"></td>
				</tr>
				<tr>
					<th>Setting Time</th>
					<td><input type="text" name="proStartTime"
						value="${project.PRO_STARTTIME}"></td>
				</tr>
				<tr>
					<th>Life Time</th>
					<td><input type="text" name="proLifeTime"
						value="${project.PRO_LIFETIME}"></td>
				</tr>
				<tr>
					<th>of Time Division/Year</th>
					<td><input type="text" name="proTd"
						value="${project.PRO_TD}"></td>
				</tr>
				<tr>
					<td colspan="2"><button id="runSimulationBtn" onfocus="this.blur()">Run Simulation</button></td>
				</tr>
				<tr class="totAvailability">
					<th>Total Availability</th>
					<td><p id="totAvailability"></p></td>
				</tr>
			</table>
		</form>
		</div>
		<div class="result-wrap01">
			<table cellspacing="0" cellpadding="0">
				<thead><tr>
					<th class="check-form"><input type="checkbox" id="checkall" ></th>
					<th>도형</th>
				</tr></thead>
				<tbody id="figures">
				<c:forEach items="${modelingList}" var="modelingList">
				<tr id="row_${modelingList.MO_UID }">
					<td class="check-form"><input id="fig_${modelingList.MO_UID }" class="checkbox" type="checkbox" onchange="changeFigMovind('${modelingList.MO_UID }')"></td>
					<td>${modelingList.MO_NAME eq null ? modelingList.MO_UID : modelingList.MO_NAME }</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="result-wrap02">
			<table width="100%" cellspacing="0" cellpadding="0">
				<thead>
					<tr><th colspan="4">중복 범위 작업밀도</th></tr>
					<tr>
						<th class="sec">중복명</th>
						<th class="sec" style="width:53px;">면적</th>
						<th class="sec" style="width:60px;">밀도</th>
						<th class="sec" style="width:43px;">삭제</th>
				</tr></thead>
				<tbody id="density">
				</tbody>
			</table>
		</div>
	</div>
	
	<div style="display: none;">
		<form id="propertiesForm" name="propertiesForm" action="">
			<input type="hidden" name="figProjectUid" value="${project.PRO_UID}">
			<input type="hidden" name="figMoUid" value=""> <input
				type="hidden" name="moType" value="">
		</form>
	</div>

	<div id="nameDialog" title="Input Name">
		<form>
			<fieldset>
				<label for="name">Name</label> <input type="text" name="name"
					id="name" value="" class="text ui-widget-content ui-corner-all">
				<input type="submit" tabindex="-1"
					style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>

</body>
</html>