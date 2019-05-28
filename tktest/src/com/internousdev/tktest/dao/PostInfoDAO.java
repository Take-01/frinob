package com.internousdev.tktest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.tktest.dto.PostInfoDTO;
import com.internousdev.tktest.util.DBConnector;

public class PostInfoDAO {
	
	//新規投稿
	public int post(String writerId, String title, String body, int category) {
		
		int result = 0;
		
		DBConnector dbConnector = new DBConnector();
		
		String sql = "INSERT INTO post_info(writer_id, title, body, category, regist_date, update_date) "
				+ "VALUES(?, ?, ?, ?, now(), now())";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, writerId);
			ps.setString(2, title);
			ps.setString(3, body);
			ps.setInt(4, category);
			
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
	
	//投稿をすべて削除
	public int deleteAllPost(String writerId) {
		
		int result = 0;
		
		DBConnector dbConnector = new DBConnector();
		
		String sql = "DELETE FROM post_info WHERE writer_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, writerId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//投稿一覧
	public List<PostInfoDTO> getPostList(String writerId) {
		
		List<PostInfoDTO> postList = new ArrayList<PostInfoDTO>();
		
		DBConnector dbConnector = new DBConnector();
		
		String sql = "SELECT * FROM post_info WHERE writer_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, writerId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PostInfoDTO postInfoDTO = new PostInfoDTO();
				postInfoDTO.setId(rs.getInt("id"));
				postInfoDTO.setWriterId(rs.getString("writer_id"));
				postInfoDTO.setTitle(rs.getString("title"));
				postInfoDTO.setBody(rs.getString("body"));
				postInfoDTO.setCategory(rs.getInt("category"));
				postInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				postInfoDTO.setImageFileName(rs.getString("image_file_name"));
				postInfoDTO.setRegistDate(rs.getString("regist_date"));
				postInfoDTO.setUpdateDate(rs.getString("update_date"));
				
				postList.add(postInfoDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return postList;
	}

}
