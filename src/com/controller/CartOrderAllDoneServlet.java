package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.dto.OrderDTO;
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/CartOrderAllDoneServlet")
public class CartOrderAllDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if (dto == null) {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업");
			response.sendRedirect(nextPage);
		} else {
			String userid= dto.getUserid();
			String [] checks = request.getParameterValues("num");			
		    List<String> list = Arrays.asList(checks);
	CartService service = new CartService();
		    List<CartDTO> cList = service.orderAllConfirm(list);
		    System.out.println("cList:"+cList);				
	
			String orderName=request.getParameter("orderName");
			String post=request.getParameter("post1");
			String addr1=request.getParameter("addr1");
			String addr2=request.getParameter("addr2");
			String phone=request.getParameter("phone");
			String payMethod=request.getParameter("payMethod");
	List<OrderDTO>  oList = new ArrayList<OrderDTO>();		
			for (CartDTO k : cList) {
System.out.println("CartDTO:"+k);				
				OrderDTO xxx = new OrderDTO();
				xxx.setUserid(userid);
				xxx.setsCode(k.getsCode());
				xxx.setsName(k.getsName());
				xxx.setsPrice(k.getsPrice());
				xxx.setsSize(k.getsSize());
				xxx.setsColor(k.getsColor());
				xxx.setsAmount(k.getsAmount());
				xxx.setsImage(k.getsImage());
				xxx.setOrderName(orderName);
				xxx.setPost(post);
				xxx.setAddr1(addr1);
				xxx.setAddr2(addr2);
				xxx.setPhone(phone);
				xxx.setPayMethod(payMethod);
				oList.add(xxx);
			}
System.out.println("oList"+oList);			
System.out.println("list"+list);			
			service.orderAllDone(oList,list);
			
			
			request.setAttribute("orderAllDone", oList);
			nextPage = "orderAllDone.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
		} // end if

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
