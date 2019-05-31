package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.PostInfoDAO;

public class PostCompleteAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	
	public String execute() {
		
		String result = ERROR;
		
		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return result = "sessionError";
		}
		
		String userId = session.get("userId").toString();
		String title = session.get("title").toString();
		String body = session.get("body").toString();
		int category = Integer.parseInt(session.get("categoryId").toString());
		
		//データベースに投稿情報を登録する
		PostInfoDAO postInfoDAO = new PostInfoDAO();
		int count = postInfoDAO.post(userId, title, body, category);
		
		if(count > 0) {
			session.remove("title");
			session.remove("body");
			session.remove("categoryId");
			session.remove("categoryName");
			result = SUCCESS;
		}
		return result;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
