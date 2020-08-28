<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<body>

<form action ="joinProc.jsp" method="post" name="frm">
	<table>
		<tr>
			<td colspan="2"> JOIN </td> 
		</tr>
		<tr>
			<td> account </td>
			<td> <input type="text" name="id"> </td>
		</tr>
		<tr>
			<td> password </td>
			<td> <input type="text" name="pw"> </td>
		</tr>
		<tr>
			<td> name </td>
			<td> <input type="text" name="name"> </td>
		</tr>
		<tr>
			<td> nickname </td>
			<td> <input type="text" name="nickname"> </td>
		</tr>
		<tr>
			<td> email </td>
			<td> <input type="text" name="email"> </td>
		</tr>
		<tr>
			<td> phone </td>
			<td> <input type="text" name="phone"> </td>
		</tr>
		<tr>
			<td> address </td>
			<td> <input type="text" name="address"> </td>
		</tr>
		<tr>
			<td> photo </td>
			<td> <input type="text" name="photo"> </td>
		</tr>
		<tr>
			<td colspan="2"> 
			<input type="button" value="가입" onclick="reg()">
			<input type="button" value="취소" onclick="can()">
			</td>
		</tr>
	</table>
	</form>
	
	<script>
		function reg(){
			if(frm.id.value.trim().length == 0){
				alert("아이디는 필수입니다.");
			} else if(frm.pw.value.trim().length == 0){
				alert("비밀번호는 필수입니다.");
			} else{
				frm.submit();
			}
		}
		function can(){
			location.href="join.jsp";
		}
	</script>
	
</body>
</html>