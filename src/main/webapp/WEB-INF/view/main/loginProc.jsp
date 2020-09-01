<%@page import="com.jj.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>loginProc</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginDAO dao = new LoginDAO();
		boolean result = dao.memberLogin(id, pw);
		if(result){ //result==true
		session.setAttribute("loginid", id);
	%>
	
	<script>
		alert("로그인되었습니다.");
		location.href = "login.jsp";
	</script>
	
<% } else { %>

	<script>
		alert("로그인 정보를 확인하세요.");
		location.href = "login.jsp";
	</script>
	
<% } %>

</body>
</html>