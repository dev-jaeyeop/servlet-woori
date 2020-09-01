<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bandList</title>
<style>
	*{
		margin : 0;
		padding: 0;
		box-sizing: border-box;
	}
	
	#wrap{
		width: 100%;
	}
	
	.top, .bottom{
		display: flex;
		border: 1px solid black;
	}
	
	.logo>img{
		width: 60px;
		heigth: 60px;
	}
	
	table, table td{
		border : 1px solid black;
	}
	
	.middle, .list{
		border: 1px solid black;
	}
	
	#layer{
		position: absolute;
		top: 45%;
		left: 45%;
		width: 350px;
		height: 450px;
		/* display: none; */
		border: 1px solid black;
		z-index: 10;
	}
        
</style>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
</head>
<body>
	<div id="wrap">
		<div class="top">
			<div> <div class="logo"> <img src="img/woori.png"></div> </div>
			<div>
				<form action="/Woori/search.do" method="post" name="search">
					<input type="text" class="search" name="search"> <input type="button" value="검색">
				</form> 
			</div>
			<div> <input type="button" value="카테고리" onclick="openPop()"> </div>
				<div id="layer" class="pop">
							 <div class="btn-r">
			                 	<a href="#" class="btn_layerClose">Close</a>
			           		 </div>
					<div class="interest">
					<table>
						<c:forEach var="category" items="${categories}" begin="0" step="1">
							<tr>
								<td> ${category.name} </td>
								<td>  ${category.icon} </td>
							</tr>
						</c:forEach>
					</table>
					</div>
				</div>
		</div>
		<div class="middle">
			<c:forEach var="band" items="${bands}" begin="0" step="1">
				<div class="list">
					
					<div class="photo"> ${band.photo} </div>
					<div class="mid">
						<div class="category"> ${band.categoryId} </div>
						<div class="name"> ${band.name} </div>
						<div class="intro"> ${band.introduction} </div>
					</div>
					<div class="limit">
						<div class="lim_ppl"> ${band.currentMember} / ${band.capacity} </div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="bottom">
			<div> <input type="button" value="공지사항"> </div>
			<div> <input type="button" value="방 생성"> </div>
			<div> <input type="button" value="내가 속한 모임"> </div>
			<div> <input type="button" value="마이페이지"> </div>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			
		});
		function openPop(){
			$("#layer").show();
		}
		
	</script>
</body>
</html>