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
	
	/**
	 * 新規投稿をする。
	 * @param writerId 投稿者ID
	 * @param title タイトル
	 * @param body 本文
	 * @param category カテゴリーID
	 * @return 投稿件数(正常なら1)
	 */
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
	
	/**
	 * 投稿IDと投稿者IDに紐付いた投稿を削除する。
	 * @param id 投稿ID
	 * @param writerId 投稿者ID
	 * @return 削除件数(正常なら1)
	 */
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
	
	/**
	 * 投稿者IDに紐付いた投稿をすべて削除する。
	 * @param writerId 投稿者ID
	 * @return 削除件数
	 */
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
	
	/**
	 * 投稿者IDに紐付いた投稿のリストを取得する。
	 * @param writerId 投稿者ID
	 * @return 投稿のリスト
	 */
	public List<PostInfoDTO> getUserPostList(String writerId) {
		
		List<PostInfoDTO> postList = new ArrayList<PostInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT * FROM post_info WHERE writer_id = ? ORDER BY regist_date";
		
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
				postInfoDTO.setCategoryId(rs.getInt("category"));
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
	
	/**
	 * 投稿IDに紐付いた投稿情報を取得する。
	 * @param id 投稿ID
	 * @return PostInfoDTO型 投稿情報
	 */
	public PostInfoDTO getPostDetails(int id) {
		
		PostInfoDTO postInfoDTO = new PostInfoDTO();
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT pi.id, pi.wirter_id, pi.title, pi.body, pi.category, "
				+ "pi.image_file_path, pi.image_file_name, pi.regist_date, pi.update_date, "
				+ "ca.category_name, ui.user_name FROM post_info as pi LEFT JOIN category as ca "
				+ "ON pi.category = ca.category_id LEFT JOIN user_info as ui "
				+ "ON pi.writer_id = ui.user_id WHERE pi.id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				postInfoDTO.setId(rs.getInt("id"));
				postInfoDTO.setWriterId(rs.getString("writer_id"));
				postInfoDTO.setWriterName(rs.getString("user_name"));
				postInfoDTO.setTitle(rs.getString("title"));
				postInfoDTO.setBody(rs.getString("body"));
				postInfoDTO.setCategoryId(rs.getInt("category"));
				postInfoDTO.setCategoryName(rs.getString("category_name"));
				postInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				postInfoDTO.setImageFileName(rs.getString("image_file_name"));
				postInfoDTO.setRegistDate(rs.getString("regist_date"));
				postInfoDTO.setUpdateDate(rs.getString("update_date"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return postInfoDTO;
	}

	/**
	 * 投稿のリストを取得する。同じ投稿者のものは3件まで取得する。
	 * @return 投稿情報のリスト
	 */
	public List<PostInfoDTO> getPostList() {
		
		List<PostInfoDTO> postInfoList = new ArrayList<PostInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT * FROM post_info as p1 WHERE "
				+ "(SELECT COUNT(*) FROM post_info as p2 WHERE p2.writer_id = p1.writer_id) < 4 "
				+ "ORDER BY regist_date LIMIT 50";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PostInfoDTO postInfoDTO = new PostInfoDTO();
				postInfoDTO.setId(rs.getInt("id"));
				postInfoDTO.setWriterId(rs.getString("writer_id"));
				postInfoDTO.setTitle(rs.getString("title"));
				postInfoDTO.setBody(rs.getString("body"));
				postInfoDTO.setCategoryId(rs.getInt("category"));
				postInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				postInfoDTO.setImageFileName(rs.getString("image_file_name"));
				postInfoDTO.setRegistDate(rs.getString("regist_date"));
				postInfoDTO.setUpdateDate(rs.getString("update_date"));
				
				postInfoList.add(postInfoDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return postInfoList;
	}
}
