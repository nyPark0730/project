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
<h1>
	Hello world!
</h1>
<button type="button" id="getTotalToiletUseInfoBtn">전체 화장실 사용 현황</button><br><br>
<hr />
<input type="text" id="floor" />층의 <button type="button" id="getToiletUseInfoBtn">화장실 사용 현황</button><br><br>
<hr />
센서코드 : <input type="text" id="code" />
사용여부 : <input type="text" id="useyn" />
<button type="button" id="updateToiletUseInfoBtn">사용여부 수정</button><br><br>

</body>
<script>
$(document).ready(function () {
	
	// 전체 화장실 사용 현황 조회
	$("#getTotalToiletUseInfoBtn").click(function () {
		$.ajax({
			url : "/getTotalToiletUseInfo.do",
			type : "post",
			dataType : "json",
			success : function (data) {
				console.log(data);
			}
		});
	});
	
	// 특정 층의 화장실 사용 현황 조회
	$("#getToiletUseInfoBtn").click(function () {
		var floor = $("#floor").val();
		if (0 == floor.length) {
			alert("층을 입력해주세요.");
			return ;
		}
		
		if (isNaN(floor)) {
			alert("층은 숫자만 가능합니다.");
			return ;
		}
		
		$.ajax({
			url : "/getToiletUseInfo.do",
			type : "post",
			data : { floor : floor},
			dataType : "json",
			success : function (data) {
				console.log(data);
			}
		});
	});
	
	// 사용 여부 수정
	$("#updateToiletUseInfoBtn").click(function () {
		var code = $("#code").val();
		var useyn = $("#useyn").val();
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
			url : "/updateToiletUseInfo.do",
			type : "post",
			data : { code : code, useyn : useyn},
			dataType : "json",
			success : function (data) {
				console.log(data);
			}
		});
	});
	
});
</script>
</html>
