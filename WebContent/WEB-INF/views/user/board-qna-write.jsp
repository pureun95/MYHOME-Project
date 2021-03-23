<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::QnA</title>
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- 부트스트랩 사용가능한 템플릿 -->

<style>
.boardwrap {
	height: auto;
	min-height: 100%;
}

.container {
	border-color: transparent;
	font-family: 'NanumBarunGothic', sans-serif;
	font-size: 16px;
	position: relative;
		border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
    min-height: 100%;
}

.boardcover {
	float: left;
	width: 100%;
}

#maintitle {
	font-size: 24px;
	font-family: 'MaplestoryOTFLight';
	padding: 0 10px;
	border-left: 5px solid #f1aeae;
	position: relative;
	display: inline;
	text-align: left;
	color: #202020;
	top: 100px;
	left: 100px;
	float: left;
}

 .table {
	position: relative;
	border-top: solid 1px #ccc;
	border-bottom: solid 1px #ccc;
	/* top: -820px;
	left: 280px; */
	float: left;
	width: 100%;
}

#content {
	padding: 15px 15px;
	height: 300px;
	overflow: auto;
	outline: none !important;
}

#title {
	outline: none !important;
}

.btn {
	background-color: #f1aeae;
	color: white;
	outline: none;
	left: 950px;
	background-color: #f1aeae;
	color: white;
	outline: none;
	position: relative;
	
}

.btn:hover {
	background-color: #f1aeae;
	color: white;
}

#writeform {
	position: relative;
	width: 100%;
    float: left;
    top: 130px;
    left: 130px;
}

.btns {
	position: relative;
	left: -320px;
}


</style>


</head>
<body>

	<div class="boardwrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

		<div class="container">

			<div class="col-sm-12 col-md-9">


				<div class="boardcover">
					<div id="maintitle">Q&A</div>


					<form method="POST"
						action="/Myhome_project/Myhome/user/boardqnawriteok.do" id="writeform">
						
							<table class="table write">
								<tr>
									<td style="width:auto;">
										<!-- <select class="form-select boardworksel" aria-label="Default select example" onchange="selch()" id="opt" style="width:110px; float:right;"> -->
										<select class="form-select boardworksel" aria-label="Default select example" id="seqQnAType" name="seqQnAType" style="width:110px; float:right;">
												<option selected value="0">카테고리</option>
												<option value="1">매물</option>
												<option value="2">중고장터</option>
												<option value="3">커뮤니티</option>
												<option value="4">전자계약</option>
												<option value="5">기타</option>
										</select>
										<input type="text" class="form-control"
										placeholder="제목" id="title" name="title" required>
									</td>
									
									
									<td>
								</tr>
								<tr>
									<td><textarea class="form-control" id="content"
											placeholder="내용" name="content" required></textarea></td>
								</tr>
							</table>
						


						<div style="clear: both;"></div>

						<div class="btns">
							<button type="submit" class="btn" id="btn1">글쓰기</button>
							<button type="button" class="btn" id="btn2"
								onclick="location.href='/Myhome_project/Myhome/user/boardqnalist.do';">뒤로가기</button>
						</div>
					</form>
					<div style="clear: both;"></div>

				</div>


			</div>

		</div>

	</div>
	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>

<script>
//console.log(opt.value());
console.log("#seqQnAType option:selected").val();
//console.log("opt option:selected").val();
</script>

</body>
</html>