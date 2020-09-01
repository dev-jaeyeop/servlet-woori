<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@page import="com.jj.dao.JoinDAO"%>
<%
    String id = request.getParameter("account");
    JSONObject json = new JSONObject();
    JoinDAO userDAO = new JoinDAO();
    String message;

    if (userDAO.checkID(id)) {
        message = "사용 불가";
    } else {
        message = "사용 가능";
    }

    json.put("result", message);
    out.println(json);
%>	