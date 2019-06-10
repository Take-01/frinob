package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoritePostInfoDAO;;

public class RevokeFavoritePostCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			//お気に入り登録を解除
			String userId = session.get("userId").toString();
			int postId = Integer.parseInt(session.get("postId").toString());
			FavoritePostInfoDAO favPostDAO = new FavoritePostInfoDAO();
			int count = favPostDAO.revokeFavPost(userId, postId);
			if(count > 0) {
				session.remove("title");
				session.remove("body");
				session.remove("writerId");
				session.remove("writerName");
				session.remove("categoryId");
				session.remove("categoryName");
				session.remove("registDate");
				session.remove("updateDate");
				result = SUCCESS;
			}
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
