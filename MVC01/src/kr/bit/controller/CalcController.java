package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MyCalc;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// 1. 클라이언트에서 넘어온 폼 파라메터 받기
		int su1= Integer.parseInt(request.getParameter("su1"));
		int su2= Integer.parseInt(request.getParameter("su2"));
		
		
		//2. 비즈니스로직 -> Model로 분리하기
//		int sum=0;
//		for (int i = su1; i<=su2;i++) {
//			sum+=i;
//		}
//		PrintWriter out=response.getWriter();
//		out.println("total="+sum);
//		
		MyCalc my =new MyCalc();
		int sum = my.hap(su1, su2);


		//3. 응답하는 부분(프리젠테이션로직-> View = JSP)
		PrintWriter out=response.getWriter();
    	out.println("total1="+sum);
		
		
	}

}
