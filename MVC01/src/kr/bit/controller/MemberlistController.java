package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberlistController
 */
@WebServlet("/memberlist.do")
public class MemberlistController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 클라이언트의 요청을 받기 (MemberList.do)
		// 2 회원전체 리스트 가져오기 (Model 연동)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.memberList();
		
		//System.out.println(list);
		// 3. 회원전체리스트를 HTML로 만들어서 응답하기
		// 응답되는 데이터 안에 한글이 있는 경우 -> 인코딩
		
		response.setContentType("text/html;charset=utf-8");
		// MIME TPYE이라고 사전에 보내줘야  클라이언트에서 한글이 깨지지 않은다.
		PrintWriter out=response.getWriter();
		// 아래 코드는 브라우저로 스트림이 되는데 byte 형식으로 스트림되면서
		// 한글이 깨지는 현상이 일어난다.
		// 이를 위해서 인코딩 과정이 필요하다. MIME TYPE
		
		out.println("<html>");
		out.println("<body>");		
		out.println("<table border='1'>");
		out.println("<thead>");
	    out.println("<tr>");
	    out.println("<th>번호</th>");	
	    out.println("<th>아이디</th>");	
	    out.println("<th>비밀번호</th>");	
	    out.println("<th>이름</th>");	
	    out.println("<th>나이</th>");	
	    out.println("<th>이메일</th>");	
	    out.println("<th>전화번호</th>");	
	    out.println("<th>삭제</th>");	
	    out.println("</tr>");	
		out.println("</thead>");	
		out.println("<tbody>");	
		
		for(MemberVO vo : list) {
			out.println("<tr>");	
		    out.println("<td>"+ vo.getNum()+"</td>");	
		    out.println("<td><a href='/MVC01/memberContent.do?num="+vo.getNum()+"'>"+ vo.getId()+"</a></td>");	
		    out.println("<td>"+ vo.getPass()+"</td>");	
		    out.println("<td>"+ vo.getName()+"</td>");	
		    out.println("<td>"+ vo.getAge()+"</td>");	
		    out.println("<td>"+ vo.getEmail()+"</td>");	
		    out.println("<td>"+ vo.getPhone()+"</td>");	
		    out.println("<th><a href='/MVC01/memberDelete.do?num="+vo.getNum()+"'>삭제</a></th>");	
		    out.println("</tr>");	
		}
		out.println("</tbody>");	
	    out.println("<tr>");
	    out.println("<td colspan='8' align='right'>");
	    out.println("<a href='member/memberResister.html'>회원가입</a>");
	    out.println("</td>");
	    out.println("</tr>");
		out.println("</table>");	
		out.println("</body>");	
		out.println("</html>");
	}

}
