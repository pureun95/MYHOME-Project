<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myhome::Q&A</title>
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="/Myhome_project/css/template.css">
<link rel="stylesheet" href="/Myhome_project/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="/Myhome_project/css/boarduserver.css"> -->


<!-- board-community-view.jsp -->

<style>
.boardwrap {
	height: auto;
	min-height: 170%;
	
}

.container {
	border-color: transparent;
	font-family: 'NanumBarunGothic', sans-serif;
	font-size: 16px;
	position: relative;
		border-right: 1px solid #DBDCE0;
    border-left: 1px solid #DBDCE0;
    /* height: 100% */
}

.boardcover {
	float: left;
	width: 100%;
}

#maintitle {
	/* border-bottom: 1px solid #ccc; */
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
}

#maintitle2 {
	/* border-bottom: 1px solid #ccc; */
	font-size: 24px;
	font-family: 'MaplestoryOTFLight';
	padding: 0 10px;
	border-left: 5px solid #f1aeae;
	position: relative;
	display: inline;
	text-align: left;
	color: #202020;
	top: 100px;
	left: 20px;
}

.table {
	position: relative;
	top: 160px;
	left: 100px;
	width: 100%;
	border-top: solid 1px #ccc;
	border-bottom: solid 1px #ccc;
}

.table thead tr th {
	text-align: center;
}

.firtd {
	text-align: center;
	width: 90px;
}

.sectd {
	text-align: center;
	width: auto;
}

.thitd {
	text-align: center;
	width: 130px;
}

.fortd {
	text-align: center;
	width: 130px;
}

.fiftd {
	text-align: center;
	width: 90px;
}

#content {
	padding: 15px 15px;
	height: 300px;
	overflow: auto;
}

#content textarea {
	width: 100%;
	height: 300px;
}


#btn4 {
	float: left;
	position: relative;
	background-color: #f1aeae;
	color: white;
	outline: none;
	border: none;
	font-family: 'NanumBarunGothic', sans-serif;
	color: white;
	vertical-align: middle;
	width: 70px;
	height: 34px;
	margin-right: 5px;
	border-radius: 3px;
	left: 80px;
	top: 150px;
}

.boardbutton .btn {
	float: left;
	position: relative;
	background-color: #f1aeae;
	color: white;
	outline: none;
	border: none;
	font-family: 'NanumBarunGothic', sans-serif;
	color: white;
	/* padding: 8px 15px; */
	vertical-align: middle;
	width: 70px;
	height: 34px;
	margin-right: 5px;
	border-radius: 3px;
	display: inline-block;
}

#btn1 {
	top: 160px;
	left: 85px;
	float: left;
}

#btn2 {
	top: 160px;
	left: -140px;
	float: left;
}

#btn3 {
	top: 160px;
	left: -140px;
	float: left;
}

/*  .boardbutton {
		
		position: relative;
		float: left;
		top: 170px;
    	left: 720px;
		 
	}
	 */
.modal-backdrop {
	z-index: auto !important;
	background-color: #ccc !important;
}

.modal-dialog {
	position: relative;
	top: 200px;
}

/*  #btn4 {
	    left: auto;
	    top: auto;
	 }  */
#basic-addon2 {
	background-color: #f1aeae;
	color: white;
	outline: none;
	float: right;
	position: relative;
	top: -34px;
	
	    z-index: 2;
}

#ccontent {
	width: 100%;
	position: relative;
	float: left;
	/* top: -340px;
		left: 500px; */
		    z-index: 1;
}

.comment {
	width: 100%;
	margin: 100px auto;
	position: relative;
	margin-bottom: 200px;
	float: left;
}

#buttons {
	position: relative;
	left: 770px;
	float: left;
}

.panel-default {
	border-color: transparent !important;
}

#commentForm {
	position: relative;
	top: 180px;
	left: 100px;
	width: 100%;
	margin-top: 20px;
}

#name {
	font-weight: bold;
}

#delete {
	padding: 4px 6px;
	text-align: center;
	background-color: #f1aeae;
	border: 0;
	color: white;
	border-radius: 4px;
	cursor: pointer;
	margin-left: 7px;
}

.commenttable td:nth-child(1) {
	width: 100px;
}

.well {
	width: 100%;
	float: left;
	position: relative;
	top: 50px;
	left: 100px;
}

.commenttable {
	top: 80px;
}

#table2 {
	position: relative;
	top: 100px;
    width: 100%;
    margin-bottom: 100px;
}

#footer {
	
}
</style>


</head>
<body>

	<div class="boardwrap">

		<!-- header -->
		<%@include file="/WEB-INF/views/inc/bootstrap-header.jsp"%>

		<div class="container">

			<div class="col-sm-12 col-md-9">
				<!-- <div> -->
				<div class="boardcover">
					<div id="maintitle">Q&A</div>
					<table class="table table-striped table-condensed" id="tbl">
						<thead>
							<tr class="headtr">
								<th class="firtd boardtd">번호</th>
								<th class="sectd boardtd">제목</th>
								<th class="thitd boardtd">작성자(닉네임)</th>
								<th class="fortd boardtd">답변상태</th>
								<th class="fiftd boardtd">작성일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<!--                         <td> -->
								<%--                             <td class="firtd">${dto.seqCommunity}. ${id}</td> --%>
								<td class="firtd">${dto.seqQnA}</td>
								<td class="sectd"><span class="boardspan headspan">[${dto.category}]</span>${dto.title}</td>
								<td class="thitd">${dto.nickName}</td>
								<td class="fiftd">${dto.state}</td>
								<td class="fortd">${dto.writeDate.substring(0,10)}</td>
								<!--                         </td> -->
							</tr>

							<tr>
								<td id="content" colspan="5">
									<textarea disabled="disabled">${dto.content}</textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="boardbutton" id="buttons">
					
						<button id="btn4"
							onclick="location.href='/Myhome_project/Myhome/user/boardqnalist.do';">
							목록</button>
					

				</div>
					
					<div id="table2">
					<div id="maintitle2">답변</div>
					<table class="table table-striped table-condensed" id="tbl">
						<thead>
							<tr class="headtr">
								<th class="firtd boardtd">번호</th>
								<th class="sectd boardtd">제목</th>
								<th class="thitd boardtd">작성자</th>
								<th class="fortd boardtd">답변상태</th>
								<th class="fiftd boardtd">작성일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<!--                         <td> -->
								<%--                             <td class="firtd">${dto.seqCommunity}. ${id}</td> --%>
								<td class="firtd">${dto.seqQnAComment}</td>
								<td class="sectd">${dto.title}</td>
								<td class="thitd">${dto.id}</td>
								<td class="fiftd">${dto.state}</td>
								<td class="fortd">${dto.cWriteDate.substring(0,10)}</td>
								<!--                         </td> -->
							</tr>

							<tr>
								<td id="content" colspan="5">
									<textarea disabled="disabled">${dto.cContent}</textarea>
								</td>
							</tr>
						</tbody>
					</table>
					</div>
					
					
					
				</div>


				<!-- </div> -->
				<!-- col-sm-12 col-md-9 -->

				
				<!-- 본문 버튼그룹  -->
				<!-- <div style="clear: both;"></div> -->



			</div>
			<!-- col-sm-12 col-md-9 -->

		</div>
		<!-- container -->

	</div>
	<!-- boardwrap -->
	
	<!-- footer -->
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>

	<script>
		
	</script>
</body>
</html>