package edu.rk.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.rk.bookstore.domain.Category;

public class CategoryRowMapper implements RowMapper<Category>{

	public Category mapRow(ResultSet rs, int row) throws SQLException {
		Category category = new Category();
		category.setCatId(rs.getInt(1));
		category.setCatName(rs.getString(2));
		return category;
	}

}
