package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ProductDTO;
import com.service.ProductService;

/**
 * Servlet implementation class ProductRetrieve
 */
@WebServlet("/ProductRetrieveServlet")
public class ProductRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String sCode = request.getParameter("sCode");
		
		ProductService service = new ProductService();
		
		ProductDTO dto = service.productRetrieve(sCode);
		request.setAttribute("productRetrieve", dto);
		
		RequestDispatcher dis =request.getRequestDispatcher("productRetrieve.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
