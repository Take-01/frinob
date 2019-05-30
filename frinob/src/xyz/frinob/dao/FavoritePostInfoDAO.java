package xyz.frinob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.frinob.dto.FavoritePostInfoDTO;
import xyz.frinob.util.DBConnector;

public class FavoritePostInfoDAO {
	
	//お気に入り登録
	
	/**
	 * 投稿のお気に入りを解除する。
	 * @param userId 登録者のユーザーID
	 * @param favPostId 登録されている投稿ID
	 * @return 解除件数(正常なら1)
	 */
	public int revokeFavPost(String userId, int favPostId) {
		
		int result = 0;
		DBConnector dbConnector = new DBConnector();
		String sql = "DELETE FROM favorite_post_info WHERE user_id = ? AND post_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, favPostId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 全てのお気に入り登録を解除。
	 * @param userId 登録者のユーザーID
	 * @return 解除件数
	 */
	public int revokeAllFavPost(String userId) {
		
		int result = 0;
		DBConnector dbConnector = new DBConnector();
		String sql = "DELETE FROM favorite_post_info WHERE user_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * お気に入り登録した投稿のリストを取得する。
	 * @param userId 登録者のユーザーID
	 * @return 投稿のリスト
	 */
	public List<FavoritePostInfoDTO> getFavPostList(String userId) {
		
		List<FavoritePostInfoDTO> favPostList = new ArrayList<FavoritePostInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT fpi.id, fpi.user_id, fpi.post_id, fpi.post_tag, "
				+ "fpi.regist_date as fav_regist_date, fpi.update_date as fav_update_date, "
				+ "pi.writer_id, pi.title, pi.body, pi.image_file_path, pi.image_file_name, "
				+ "pi.regist_date as post_regist_date, pi.update_date as post_update_date "
				+ "FROM favorite_post_info as fpi LEFT JOIN post_info as pi "
				+ "ON fpi.fav_post_id = pi.id WHERE fpi.user_id = ? ORDER BY fav_update_date";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				FavoritePostInfoDTO favPostDTO = new FavoritePostInfoDTO();
				favPostDTO.setId(rs.getInt("id"));
				favPostDTO.setUserId(rs.getString("user_id"));
				favPostDTO.setFavPostId(rs.getInt("post_id"));
				favPostDTO.setPostTag(rs.getString("post_tag"));
				favPostDTO.setFavRegistDate(rs.getString("fav_regist_date"));
				favPostDTO.setFavUpdateDate(rs.getString("fav_update_date"));
				favPostDTO.setWriterId(rs.getString("writer_id"));
				favPostDTO.setTitle(rs.getString("title"));
				favPostDTO.setBody(rs.getString("body"));
				favPostDTO.setImageFilePath(rs.getString("image_file_path"));
				favPostDTO.setImageFileName(rs.getString("image_file_name"));
				favPostDTO.setPostRegistDate(rs.getString("post_regist_date"));
				favPostDTO.setPostUpdateDate(rs.getString("post_update_date"));
				
				favPostList.add(favPostDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return favPostList;
	}
	
	/**
	 * お気に入り登録されている投稿を削除する。
	 * @param favPostId 登録されている投稿ID
	 * @return 削除件数(正常なら1)
	 */
	public int deleteFavPost(int favPostId) {
		
		int result = 0;
		DBConnector dbConnector = new DBConnector();
		String sql = "DELETE FROM favorite_post_info WHERE post_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, favPostId);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 投稿をお気に入り登録しているか調べる。
	 * @param userId ユーザーID
	 * @param postId 投稿ID
	 * @return お気に入り登録済みならtrue
	 */
	public boolean isRegistered(String userId, int postId) {
		
		boolean result = false;
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT COUNT(*) FROM favorite_post_info WHERE user_id = ? AND post_id = ?";
		
		try(Connection con = dbConnector.getConnection()) {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, postId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				if(count > 0) {
					result = true;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}