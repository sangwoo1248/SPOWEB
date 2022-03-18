package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class PassFindServlet
 */
@WebServlet("/PassFindServlet")
public class PassFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		
		System.out.println(userid);
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(phone3);
		
		MemberService service = new MemberService();
		
		MemberDTO xxx = service.passFind(dto);
		String nextPage= null;
		
		if(xxx==null) {
			nextPage="loginForm.jsp";  
		}
		else {
			nextPage="SendMailServlet";
			request.setAttribute("member", xxx);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
