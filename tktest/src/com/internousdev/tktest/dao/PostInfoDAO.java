package com.internousdev.tktest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.tktest.util.DBConnector;

public class PostInfoDAO {
	
	//新規投稿
	public int post(String writerId, String title, String body, int category, String imageFilePath, String imageFileName) {
		
		int result = 0;
		
		DBConnector dbConnector = new DBConnector();
		
		String sql = "INSERT INTO post_info(writer_id, title, body, category, image_file_path, image_file_name, regist_date, update_date) "
				+ "VALUES(?, ?, ?, ?, ?, ?, now(), now())";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, writerId);
			ps.setString(2, title);
			ps.setString(3, body);
			ps.setInt(4, category);
			ps.setString(5, imageFilePath);
			ps.setString(6, imageFileName);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//投稿削除
	public int deletePost(int id, String writerId) {
		
		int result = 0;
		
		DBConnector dbConnector = new DBConnector();
		
		String sql = "DELETE FROM post_info WHERE id = ? AND writer_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, writerId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
