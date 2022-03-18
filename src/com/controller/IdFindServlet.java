package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/IdFindServlet")

public class IdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger looger = LoggerFactory.getLogger(IdFindServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
			
		MemberDTO dto = new MemberDTO();
		dto.setUsername(username);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		
		System.out.println(username);
		System.out.println(email1);
		System.out.println(email2);
		
		
		 looger.trace("Mesasge{}", "username"); 
		 looger.debug("Mesasge{}", "username");
		  looger.info("Mesasge{}", "username"); 
		  looger.warn("Mesasge{}", "username");
		 looger.error("Mesasge{}", "username");
		 
		
		
		MemberService service = new MemberService();
		
		MemberDTO xxx = service.idFind(dto);
		System.out.println(dto);
		String nextPage= null;
		if(xxx==null) {
			nextPage="loginForm.jsp";
		}
		else {
			nextPage="SendMailServlet";
			request.setAttribute("member", xxx);
		}
		
		RequestDispatcher dis= request.getRequestDispatcher(nextPage);

		dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
