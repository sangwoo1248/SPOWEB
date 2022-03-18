package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.MembershipService;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		MemberDTO dto =(MemberDTO)session.getAttribute("login");
		String nextPage= null;
		if(dto==null) {
			nextPage="LoginUIServlet";
	session.setAttribute("mesg", "로그인이 필요한 작업");
		}else {
			String sImage= request.getParameter("sImage");
			String sCode= request.getParameter("sCode");
			String sName= request.getParameter("sName");
			String sPrice= request.getParameter("sPrice");
			String sSize= request.getParameter("sSize");
			String sColor= request.getParameter("sColor");
			String sAmount= request.getParameter("sAmount");
			String userid = dto.getUserid();
			
	CartDTO xxx = new CartDTO();
		xxx.setsImage(sImage);
		xxx.setsCode(sCode);
		xxx.setsName(sName);
		xxx.setsPrice(Integer.parseInt(sPrice));
		xxx.setsSize(sSize);
		xxx.setsColor(sColor);
		xxx.setsAmount(Integer.parseInt(sAmount));
		xxx.setUserid(userid);	
		
		CartService service = new CartService();
		service.cartAdd(xxx);
		nextPage="ProductRetrieveServlet?sCode="+sCode;
		
		}//end if
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
