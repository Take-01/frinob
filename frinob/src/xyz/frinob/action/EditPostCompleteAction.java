package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.PostInfoDAO;

public class EditPostCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {

			//編集された投稿情報を登録
			int postId = Integer.parseInt(session.get("postId").toString());
			String title = session.get("newTitle").toString();
			String body = session.get("newBody").toString();
			PostInfoDAO postInfoDAO = new PostInfoDAO();
			int count = postInfoDAO.updatePostInfo(postId, title, body);
			if(count > 0) {
				session.remove("postId");
				session.remove("newTitle");
				session.remove("newBody");
				;
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
