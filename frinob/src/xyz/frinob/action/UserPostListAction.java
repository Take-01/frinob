package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoriteUserInfoDAO;
import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dto.PostInfoDTO;

public class UserPostListAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private boolean isRegistered;
	private String writerId;
	private List<PostInfoDTO> userPostList;

	public String execute() {

		String result = ERROR;

		session.remove("postId");
		session.remove("title");
		session.remove("body");
		session.remove("categoryId");
		session.remove("categoryName");
		session.remove("registDate");
		session.remove("updateDate");

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {

			if(session.containsKey("writerId")) { //投稿詳細画面から遷移してきた
				writerId = session.get("writerId").toString();
			}

			//ユーザーをお気に入り登録しているか調べる
			FavoriteUserInfoDAO favUserDAO = new FavoriteUserInfoDAO();
			isRegistered = favUserDAO.isRegistered(session.get("userId").toString(), writerId);

			//投稿者IDに紐づいた投稿を取得
			PostInfoDAO postInfoDAO = new PostInfoDAO();
			userPostList = postInfoDAO.getUserPostList(writerId);

			result = SUCCESS;
		}
		return result;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public boolean getIsRegistered() {
		return this.isRegistered;
	}

	public List<PostInfoDTO> getUserPostList() {
		return this.userPostList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
