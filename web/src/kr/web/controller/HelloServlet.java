package kr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// JavaEE -> 기본프로그램 Sevelet(서블릿)의 골격
// HttpServlet api import 해야한다.
// 오버라이딩 재정의하기

import kr.web.util.MyUtil;
@WebServlet("/hs.do")

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		MyUtil my = new MyUtil();
		int sum = my.hap();

		// 요청한 클라이언트에게 응답하기
		PrintWriter out = resp.getWriter();
		//Html 코드 내보내기
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
		
	}
	
}

