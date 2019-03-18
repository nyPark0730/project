<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
</head>
<body>
<h4>화장실 사용현황</h4>
<button type="button" id="getTotalToiletUseInfoBtn" onclick="getTotalInfo('toilet');">전체 화장실 사용 현황</button><br><br>
<hr />
층:<input type="text" id="toiletfloor" /> 성별:<input type="text" id="gender" />의 <button type="button" id="getToiletUseInfoBtn"  onclick="getInfo('toilet');">화장실 사용 현황</button><br><br>
<hr />
센서코드 : <input type="text" id="toiletCode" />
사용여부 : <input type="text" id="toiletUseyn" />
<button type="button" id="updateToiletUseInfoBtn" onClick="updateInfo('toilet');">화장실 사용여부 수정</button><br><br>
<hr />
<h4>회의실 사용현황</h4>
<button type="button" id="getTotalMeetingRoomUseInfoBtn" onclick="getTotalInfo('meetingRoom');">전체 회의실 사용 현황</button><br><br>
<hr />
<input type="text" id="meetingRoomfloor" />층의 <button type="button" id="getMeetingRoomUseInfoBtn" onclick="getInfo('meetingRoom');">회의실 사용 현황</button><br><br>
<hr />
센서코드 : <input type="text" id="meetingRoomCode" />
사용여부 : <input type="text" id="meetingRoomUseyn" />
<button type="button" id="updateMeetingRoomUseInfoBtn" onClick="updateInfo('meetingRoom');">회의실 사용여부 수정</button><br><br>

</body>
<script>
/**
 * 전체 사용여부 조회
 */
function getTotalInfo(mode) {
	var url = "";
	if (mode == "toilet") {
		url = "/getTotalToiletUseInfo.do";
	} else {
		url = "/getTotalMeetingRoomUseInfo.do";
	}
	
	$.ajax({
		url : url,
		type : "post",
		dataType : "json",
		success : function (data) {
			console.log(data);
		}
	});
}

/**
 * 사용여부 조회
 */
function getInfo(mode) {
	var url = "";
	var floor = "";
	var gender = "";
	if (mode == "toilet") {
		url = "/getToiletUseInfo.do";
		floor = $("#toiletfloor").val();
		gender = $("#gender").val();
	} else {
		url = "/getMeetingRoomUseInfo.do";
		floor = $("#meetingRoomfloor").val();
	}
	
	if (0 == floor.length) {
		alert("층을 입력해주세요.");
		return ;
	}
	
	if (isNaN(floor)) {
		alert("층은 숫자만 가능합니다.");
		return ;
	}
	
	$.ajax({
		url : url,
		type : "post",
		data : { floor : floor, gender: gender},
		dataType : "json",
		success : function (data) {
			console.log(data);
		}
	});
}

/**
 * 사용여부 수정
 */
function updateInfo(mode) {
	var url = "";
	var code = "";
	var useyn = "";
	if (mode == "toilet") {
		url = "/updateToiletUseInfo.do";
		code = $("#toiletCode").val();
		useyn = $("#toiletUseyn").val();
	} else {
		url = "/updateMeetingRoomUseInfo.do";
		code = $("#meetingRoomCode").val();
		useyn = $("#meetingRoomUseyn").val();
	}
	
	if (0 == code.length || 0 == useyn.length) {
		alert("센서코드 또는 사용여부를 입력하세요.");
		return ;
	}
	
	if (isNaN(code)) {
		alert("센서코드 숫자만 가능합니다.");
		return ;
	}
	
	if (useyn != "Y" && useyn != "N") {
		alert("사용여부는 Y나 N만 가능합니다.");
		return ;
	}
	
	$.ajax({
		url : url,
		type : "post",
		data : { code : code, useyn : useyn},
		dataType : "json",
		success : function (data) {
			console.log(data);
		}
	});
}

</script>
</html>
