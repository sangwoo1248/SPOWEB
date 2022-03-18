package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.ProductDAO;
import com.dto.ProductDTO;

public class ProductService {

	public List<ProductDTO> productList(String sCategory) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<ProductDTO> list = null;
		ProductDAO dao = new ProductDAO();
		try {
			list = dao.productList(session, sCategory);
			session.commit();
		}
		finally {
			session.close();
		}
		return list;
	}

	public ProductDTO productRetrieve(String sCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = null;
		try {
			dto = dao.productRetrieve(session, sCode);
		}
		finally {
			session.close();
		}
		return dto;
	}

}
