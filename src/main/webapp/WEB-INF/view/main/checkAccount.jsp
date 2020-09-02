<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.UserDAO" %>
<%@ page import="org.json.simple.JSONObject" %>
<%
    String account = request.getParameter("account");
    JSONObject json = new JSONObject();
    String message;

    if (new UserDAO().selectUserByAccount(account) != null) {
        message = "사용 불가";
    } else {
        message = "사용 가능";
    }

    json.put("result", message);
    out.println(json);
%>	