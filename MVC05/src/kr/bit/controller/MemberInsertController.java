package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글처리 
				String ctx=request.getContextPath(); //MVC04
				request.setCharacterEncoding("utf-8");
				// 1.파라미터 수집(VO)
				String id = (request.getParameter("id"));
				String pass =(request.getParameter("pass"));
				String name = (request.getParameter("name"));
				int age = Integer.parseInt(request.getParameter("age"));
				String email = (request.getParameter("email"));
				String phone = (request.getParameter("phone"));
				
				//MemverVo vo = new Member(id, pass, name, age, email, phone);
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPass(pass);
				vo.setName(name);
				vo.setAge(age);
				vo.setEmail(email);
				vo.setPhone(phone);
				
				
				//System.out.println(vo.toString());
				
				//Model과 연동부분
				MemberDAO dao = new MemberDAO();
				int cnt = dao.memberInsert(vo);
				PrintWriter out = response.getWriter();
				
				String nextPage=null;
				
				if(cnt>0) {
					//out.println("insert success");
					//다시 회원리스트 보기로 복귀
					nextPage = "redirect:"+ctx+"/memberlist.do";
					
				} else {	
					// 가입실행 -> 예외 객체를 만들어서 WAS에 던지자.
					throw new ServletException("not insert");
					
				}
		return nextPage;
	}

}
