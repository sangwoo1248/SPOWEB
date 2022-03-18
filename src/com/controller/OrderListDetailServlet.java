package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.CartService;

/**
 * Servlet implementation class OrderListDetailServlet
 */
@WebServlet("/OrderListDetailServlet")
public class OrderListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		MemberDTO dto =(MemberDTO)session.getAttribute("login");
		String nextPage= null;
		if(dto==null) {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업");
		}
		else {
		String userid = request.getParameter("userid");
		CartService service = new CartService();
		List<OrderDTO> list = service.orderListDetail(userid);
		request.setAttribute("oDTO", list);	
		nextPage="orderListDetail.jsp";
		//oder테이블에 접근해서 가져오기
		}//end if
		RequestDispatcher dis =
				request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

