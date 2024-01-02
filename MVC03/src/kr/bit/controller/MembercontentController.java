package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MembercontentController
 */
@WebServlet("/memberContent.do")
public class MembercontentController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : http://127.0.0.1:8089/MVC01/memberContent.do?num=
		int num = Integer.parseInt(request.getParameter("num"));
	
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberContent(num);
		//객체 바인딩
		request.setAttribute("vo", vo);
		//forward 기법
		RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
		rd.forward(request, response);
		
		
	} 
		

}
