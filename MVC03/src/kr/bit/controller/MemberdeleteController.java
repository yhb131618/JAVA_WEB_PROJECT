package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

/**
 * Servlet implementation class MemberdeleteControler
 */
@WebServlet("/memberDelete.do")
public class MemberdeleteController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : http://127.0.0.1:8089/MVC01/memberDelete.do?num=7
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);
		if(cnt>0) {
			response.sendRedirect("/MVC03/memberlist.do");
		}else {
			throw new ServletException("not Delete");
		}
	}

}
