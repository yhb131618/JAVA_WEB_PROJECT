<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	MemberDAO dao = new MemberDAO();
	int cnt = dao.memberDelete(num);
	if(cnt>0) {
		response.sendRedirect("/MVC03/memberlist.do");
	}else {
		throw new ServletException("not Delete");
	}
%>
