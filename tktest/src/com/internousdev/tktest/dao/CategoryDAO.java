package com.internousdev.tktest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.tktest.dto.CategoryDTO;
import com.internousdev.tktest.util.DBConnector;

public class CategoryDAO {

	//カテゴリーの情報を全て取得
	public List<CategoryDTO> getCategoryList() {
		
		List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT * FROM category";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				CategoryDTO categoryDTO = new CategoryDTO();
				categoryDTO.setCategoryId(rs.getInt("category_id"));
				categoryDTO.setCategoryName(rs.getString("category_name"));
				categoryDTO.setCategoryDescription(rs.getString("category_description"));
				categoryDTO.setRegistDate(rs.getString("regist_date"));
				categoryDTO.setUpdateDate(rs.getString("update_date"));
				
				categoryList.add(categoryDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
	//カテゴリーの情報を取得
	public CategoryDTO getCategory() {
		
		CategoryDTO categoryDTO = new CategoryDTO();
		DBConnector dbConnector = new DBConnector();
	}
	
}