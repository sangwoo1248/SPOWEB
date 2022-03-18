package com.controller;

import java.io.IOException;
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
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/CartOrderAllConfirmServlet")
public class CartOrderAllConfirmServlet extends HttpServlet {
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
			String[] checks = request.getParameterValues("check");
			List<String> list = Arrays.asList(checks);

			//상품정보
			CartService service = new CartService();
			List<CartDTO> cList = service.orderAllConfirm(list);
			
			 //회원정보
			String userid = dto.getUserid();	
			MemberService mService = new MemberService();
			MemberDTO mDTO = mService.mypage(userid);
			
			request.setAttribute("cList", cList);
			request.setAttribute("mDTO", mDTO);
			
			nextPage = "orderAllConfirm.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
		} // end if

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
