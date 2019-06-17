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

	/**
	 * ユーザーをお気に入り登録する。
	 * @param userId ユーザーID
	 * @param writerId お気に入り登録するユーザーID
	 * @param tags ユーザータグ
	 * @return 登録件数(正常なら1)
	 */
	public int registFavUser(String userId, String writerId, String ... tags) {

		int result = 0;
		DBConnector dbConnector = new DBConnector();
		String sql = "INSERT INTO favorite_user_info(user_id, fav_user_id, ";

		if(tags == null) { //タグが未入力
			sql += "regist_date, update_date) VALUES(?, ?, now(), now())";
		} else {
			//入力されたタグの数に合わせてSQL文を作成
			for(int i = 1;i <= tags.length;i++) {
				sql += "user_tag" + i + ", ";
			}
			sql += "regist_date, update_date) VALUES(?, ?, ";

			for(int i = 1;i <= tags.length;i++) {
				sql += "?, ";
			}
			sql += "now(), now())";
		}

		try(Connection con = dbConnector.getConnection()) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, writerId);

			if(tags != null) { //タグが入力されている
				for(int i = 0;i < tags.length;i++) {
					ps.setString(i + 3, tags[i]);
				}
			}

			result = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ユーザーのお気に入り登録を一件解除する。
	 * @param userId ユーザーID
	 * @param favUserId お気に入りユーザーのユーザーID
	 * @return 解除件数(正常なら1)
	 */
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

	/**
	 * ユーザーのお気に入り登録をすべて解除する。
	 * @param userId ユーザーID
	 * @return 削除件数
	 */
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

	/**
	 * お気に入り登録したユーザーリストを取得する。
	 * @param userId ユーザーID
	 * @return お気に入り登録したユーザーのリスト
	 */
	public List<FavoriteUserInfoDTO> getFavUserList(String userId) {

		List<FavoriteUserInfoDTO> favUserList = new ArrayList<FavoriteUserInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT fui.id, fui.user_id, fui.fav_user_id, "
				+ "fui.user_tag1, fui.user_tag2, fui.user_tag3, fui.user_tag4, fui.user_tag5, "
				+ "fui.regist_date, fui.update_date, ui.user_name "
				+ "FROM favorite_user_info as fui LEFT JOIN user_info as ui "
				+ "ON fui.fav_user_id = ui.user_id WHERE fui.user_id = ? ORDER BY update_date";

		try(Connection con = dbConnector.getConnection()) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				FavoriteUserInfoDTO favUserDTO = new FavoriteUserInfoDTO();
				favUserDTO.setId(rs.getInt("id"));
				favUserDTO.setUserId(rs.getString("user_id"));
				favUserDTO.setFavUserId(rs.getString("fav_user_id"));
				favUserDTO.setUserTag1(rs.getString("user_tag1"));
				favUserDTO.setUserTag1(rs.getString("user_tag2"));
				favUserDTO.setUserTag1(rs.getString("user_tag3"));
				favUserDTO.setUserTag1(rs.getString("user_tag4"));
				favUserDTO.setUserTag1(rs.getString("user_tag5"));
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

	/**
	 * お気に入り登録されているユーザー情報を削除
	 * @param favUserId お気に入り登録されているユーザーID
	 * @return 削除件数
	 */
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

	/**
	 * ユーザーをお気に入り登録しているか調べる。
	 * @param userId ユーザーID
	 * @param writerId 対象のユーザーID
	 * @return 登録済みならtrue
	 */
	public boolean isRegistered(String userId, String writerId) {

		boolean result = false;
		DBConnector dbConnector = new DBConnector();
		String sql = "SELECT COUNT(*) FROM favorite_user_info WHERE user_id = ? AND fav_user_id = ?";

		try(Connection con = dbConnector.getConnection()) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, writerId);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count(*)");
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
