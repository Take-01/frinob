package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoritePostInfoDAO;
import xyz.frinob.dao.PostInfoDAO;

public class DeletePostCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			return "sessionError";
		}

		int postId = Integer.parseInt(session.get("postId").toString());
		FavoritePostInfoDAO favPostDAO = new FavoritePostInfoDAO();
		int count1 = favPostDAO.deleteFavPost(postId); //お気に入り投稿テーブルから削除
		if(count1 >= 0) {
			PostInfoDAO postInfoDAO = new PostInfoDAO();
			int count2 = postInfoDAO.deletePost(postId, session.get("userId").toString()); //投稿情報テーブルから削除
			if(count2 > 0) {
				session.remove("postId");
				session.remove("title");
				session.remove("body");
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
