package com.internousdev.tktest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.tktest.dto.UserInfoDTO;
import com.internousdev.tktest.util.DBConnector;

public class UserInfoDAO {
	
	//ユーザーIDとパスワードに一致するデータが登録されているか調べる
	public boolean isExistsUser(String userId, String password) {
		
		boolean result = false;
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT COUNT(*) FROM user_info WHERE user_id = ? AND password = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("count") > 0) {
					result = true;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//ユーザーIDと一致するユーザー情報を取得
	public UserInfoDTO getUserInfo(String userId) {

		DBConnector dbConnector = new DBConnector();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "SELECT * FROM user_info WHERE user_id = ?";

		try(Connection con = dbConnector.getConnection()) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setUserName(rs.getString("user_name"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setRegistDate(rs.getString("regist_date"));
				userInfoDTO.setUpdateDate(rs.getString("update_date"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	//新規ユーザー登録
	public int registUser(String userId, String password, String userName, String email) {

		int result = 0;

		DBConnector dbConnector = new DBConnector();

		String sql = "INSERT INTO user_info(user_id, password, user_name, email, regist_date, update_date) "
				+ "VALUES(?, ?, ?, ?, now(), now())";

		try(Connection con = dbConnector.getConnection()) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, userName);
			ps.setString(4, email);

			result = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//ユーザー削除
	public int deleteUser(String userId, String password) {
		
		int result = 0;
		
		DBConnector dbConnector = new DBConnector();
		
		String sql = "DELETE FROM user_info WHERE user_id = ? AND password = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
