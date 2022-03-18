package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ProductDTO;
import com.service.ProductService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String sCategory= request.getParameter("sCategory");
		ProductService service = new ProductService();
		
		List<ProductDTO> list = service.productList(sCategory);
		request.setAttribute("productList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
