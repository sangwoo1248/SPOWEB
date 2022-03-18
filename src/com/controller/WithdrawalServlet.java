package com.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class WithdrawalServlet
 */
@WebServlet("/WithdrawalServlet")
public class WithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
				
		String nextPage = null;
		if(dto==null) {
			nextPage="mypage.jsp";
			session.setAttribute("mesg", "탈퇴x");
		}
		else {
			String userid = dto.getUserid();
			String passwd = request.getParameter("passwd");

			System.out.println(userid);
			System.out.println(passwd);
			
			nextPage="SendMailServlet";
			MemberService service = new MemberService();
			service.withDrawal(userid);
			session.invalidate();
		}
		response.sendRedirect(nextPage);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
