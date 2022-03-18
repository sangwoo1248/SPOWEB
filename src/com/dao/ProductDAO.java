package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ProductDTO;

public class ProductDAO {

	public List<ProductDTO> productList(SqlSession session, String sCategory) {
		List<ProductDTO> list = session.selectList("ProductMapper.productList", sCategory);
		return list;
	}

	public ProductDTO productRetrieve(SqlSession session, String sCode) {
		ProductDTO dto = session.selectOne("ProductMapper.productRetrieve", sCode);
		return dto;
	}

}
