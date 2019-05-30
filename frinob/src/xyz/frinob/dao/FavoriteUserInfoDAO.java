package xyz.frinob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.frinob.dto.FavoriteUserInfoDTO;
import xyz.frinob.util.DBConnector;

public class FavoriteUserInfoDAO {
	
	//お気に入り登録
	
	//お気に入り解除
	public int revokeFavUser(String userId, String favUserId) {
		
		int result = 0;
		DBConnector dbConnector = new DBConnector();
		String sql = "DELETE FROM favorite_user_info WHERE user_id = ? AND fav_user_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, favUserId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//全てのお気に入り登録を解除
	public int revokeAllFavUser(String userId) {
		
		int result = 0;
		DBConnector dbConnector = new DBConnector();
		String sql = "DELETE FROM favorite_user_info WHERE use_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//お気に入り登録したユーザーリスト
	public List<FavoriteUserInfoDTO> getFavUserList(String userId) {
		
		List<FavoriteUserInfoDTO> favUserList = new ArrayList<FavoriteUserInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT fui.id, fui.user_id, fui.fav_user_id, fui.user_tag, "
				+ "fui.regist_date, fui.update_date, ui.user_name "
				+ "FROM favorite_user_info as fui LEFT JOIN user_info as ui "
				+ "ON fui.fav_user_id = ui.user_id WHERE user_id = ? ORDER BY update_date";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				FavoriteUserInfoDTO favUserDTO = new FavoriteUserInfoDTO();
				favUserDTO.setId(rs.getInt("id"));
				favUserDTO.setUserId(rs.getString("user_id"));
				favUserDTO.setFavUserid(rs.getString("fav_user_id"));
				favUserDTO.setUserTag(rs.getString("user_tag"));
				favUserDTO.setRegistDate(rs.getString("regist_date"));
				favUserDTO.setUpdateDate(rs.getString("update_date"));
				favUserDTO.setFavUserName(rs.getString("user_name"));
				
				favUserList.add(favUserDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return favUserList;
	}
	
/*	//お気に入りユーザー詳細
	public FavoriteUserInfoDTO getFavUser(String userId, String favUserId) {
		
		FavoriteUserInfoDTO favUserDTO = new FavoriteUserInfoDTO();
		
		DBConnector dbConnector = new DBConnector();
		
		String sql = "SELECT * FROM favorite_user_info WHERE user_id = ? AND fav_user_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, favUserId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				favUserDTO.setId(rs.getInt("id"));
				favUserDTO.setUserId(rs.getString("user_id"));
				favUserDTO.setFavUserid(rs.getString("fav_user_id"));
				favUserDTO.setUserTag(rs.getString("user_tag"));
				favUserDTO.setRegistDate(rs.getString("regist_date"));
				favUserDTO.setUpdateDate(rs.getString("update_date"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return favUserDTO;
	}*/

	//お気に入り登録されているユーザー情報を削除
	public int deleteFavUser(String favUserId) {
		
		int result = 0;
		DBConnector dbConnector = new DBConnector();
		String sql = "DELETE FROM favorite_user_info WHERE fav_user_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, favUserId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}