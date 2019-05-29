package com.internousdev.tktest.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tktest.dao.PostInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PostCompleteAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	
	public String execute() {
		
		String result = ERROR;
		
		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return result = "sessionError";
		}
		
		String userId = String.valueOf(session.get("userId"));
		String title = String.valueOf(session.get("title"));
		String body = String.valueOf(session.get("body"));
		int category = Integer.parseInt(String.valueOf(session.get("categoryId")));
		
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
