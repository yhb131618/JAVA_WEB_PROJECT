package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberinsertController
 */

@WebServlet("/memberUpdate.do")
public class MemberupdateController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//한글처리 
		request.setCharacterEncoding("utf-8");
		// 1.파라미터 수집(VO)
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = (request.getParameter("email"));
		String phone = (request.getParameter("phone"));
		
		//MemverVo vo = new Member(id, pass, name, age, email, phone);
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.memberUpdate(vo);

		//PrintWriter out = response.getWriter();
				
		if(cnt>0) {
			//out.println("insert success");
			//다시 회원리스트 보기로 복귀
			response.sendRedirect("/MVC03/memberlist.do");
			
		} else {	
			// 가입실행 -> 예외 객체를 만들어서 WAS에 던지자.
			throw new ServletException("not Update");
			
		}
		
	}

}
