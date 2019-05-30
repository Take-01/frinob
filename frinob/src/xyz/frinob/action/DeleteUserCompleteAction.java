package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoritePostInfoDAO;
import xyz.frinob.dao.FavoriteUserInfoDAO;
import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dao.UserInfoDAO;
import xyz.frinob.dto.PostInfoDTO;
import xyz.frinob.util.InputChecker;

public class DeleteUserCompleteAction extends ActionSupport implements SessionAware {
	

	private Map<String, Object> session;
	private String password;
	private List<String> passwordMessageList;

	public String execute() {

		String result = ERROR;

		if (!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return result = "sessionError";
		}
		
		//パスワードの入力チェック
		InputChecker inputChecker = new InputChecker();
		passwordMessageList = inputChecker.getMessages(password, "パスワード", 6, 20, 1, 2, 6);
		if(CollectionUtils.isNotEmpty(passwordMessageList)) {
			return result = "back";
		}

		String userId = String.valueOf(session.get("userId"));
		FavoritePostInfoDAO favPostDAO = new FavoritePostInfoDAO();
		FavoriteUserInfoDAO favUserDAO = new FavoriteUserInfoDAO();
		
		// お気に入り投稿を解除する
		int revokeFavPostCount = favPostDAO.revokeAllFavPost(userId);
		if (revokeFavPostCount < 0) {
			return result;
		}
		
		// お気に入りユーザーを解除する
		int revokeFavUserCount = favUserDAO.revokeAllFavUser(userId);
		if(revokeFavUserCount < 0) {
			return result;
		}
		
		//お気に入りユーザーテーブルから削除する
		int delFavUserCount = favUserDAO.deleteFavUser(userId);
		if(delFavUserCount < 0) {
			return result;
		}

		// 投稿情報の削除
		PostInfoDAO postInfoDAO = new PostInfoDAO();
		List<PostInfoDTO> postList = postInfoDAO.getUserPostList(userId);

		if(!CollectionUtils.isEmpty(postList)) {
			// お気に入り投稿テーブルから削除する
			for(PostInfoDTO post:postList) {
				int count = favPostDAO.deleteFavPost(post.getId());
				if(count == 0) {
					break;
				}
			}
			// 投稿を削除する
			int count = postInfoDAO.deleteAllPost(userId);
			if(count <= 0) {
				return result;
			}
		}
		
		//ユーザー情報を削除する
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.deleteUser(userId, password);
		if(count > 0) {
			session.clear();
			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
