<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>BLOSSOM 2.0</title>
	<!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="/resources/plugins/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
    <link href="/resources/plugins/bootstrap-4.3.1-dist/css/bootstrap.css" rel="stylesheet">
	<style type="text/css">
	#mailDiv {
		margin: 12px;
		font-size: 13px;
	}
	</style>
</head>
<body>
	<div id="mailDiv">
		<button type="button" class="btn btn-secondary btn-sm" style="margin-bottom: 0px;" id="sendEmail">보내기</button>
		<button type="button" class="btn btn-outline-secondary text-dark btn-sm" style="margin-bottom: 0px;">임시저장</button>
		<button type="button" class="btn btn-outline-secondary text-dark btn-sm" style="margin-bottom: 0px;">닫기</button>
		<hr>
		<div class="form-inline form-group" style="margin-right: 2px; margin-left: 2px;margin-bottom: 2px;margin-top: 0px;">
			<div style="width: 90px;"><font style="text-align: left;">받는 사람&nbsp;&nbsp;<span style="color: gray;">▼</span></font></div>
			<img src="/resources/image/person.PNG" /><input type="text" size="110" id="recipient" >
			<div style="width: 90px;"><font style="text-align: left;">보내는 사람&nbsp;&nbsp;<span style="color: gray;">▼</span></font></div>
			<img src="/resources/image/person.PNG" /><input type="text" size="110" id="sender" >
		</div>
		<div class="form-inline form-group" style="margin: 2px;">
			<div style="width: 113px;"><font style="text-align: left;">제목</font></div>
			<input type="text" size="110" id="title">
		</div>
		<div class="form-inline form-group" style="margin: 2px;">
			<div style="width: 108px;"><font style="text-align: left;">옵션&nbsp;&nbsp;<span style="color: gray;">▼</span></font></div>
			<input type="checkbox" checked="checked">&nbsp;수신확인&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox">&nbsp;예약발송&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-outline-secondary text-dark btn-sm">양식템플릿가져오기</button><br>
		</div>
			<img src="/resources/image/namoWeb.PNG" />
			<textarea rows="17" cols="131" id="contents"></textarea><br><br>
			<img src="/resources/image/file.PNG" />
	</div>
</body>
<script>
$(document).ready(function() {
	$("#sendEmail").click(function() {
		var sender = $("#sender").val();
		var recipient = $("#recipient").val();
		var title = $("#title").val();
		var contents = $("#contents").val();
		if (0 == sender.length || 0 == recipient.length || 0 == title.length || 0 == contents.length) {
			alert("입력을 확인하세요.");
			return ;
		}
		
		$.ajax({
			url  : "/sendMail.do" , 
			type : "post",
			data : {sender : sender , recipient : recipient, title : title, contents : contents},
			dataType : "json" ,
			success  : function(data){
				alert("메일 보내기 완료");
			}
		});
		//window.close();
	});
});

</script>
</html>
