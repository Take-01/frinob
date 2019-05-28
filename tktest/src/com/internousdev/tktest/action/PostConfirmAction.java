package com.internousdev.tktest.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tktest.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class PostConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String title;
	private String body;
	private int category;
	private List<String> titleMessageList;
	private String bodyMessage;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return result = "sessionError";
		}

		//入力チェック
		InputChecker inputChecker = new InputChecker();
		titleMessageList = inputChecker.getMessages(title, "タイトル", 1, 30, 1, 2, 3, 4, 5, 6);
		bodyMessage = inputChecker.checkLength(body, "本文", 1, 500);
		
		if(CollectionUtils.isNotEmpty(titleMessageList) || !bodyMessage.equals("")) {
			result = "back";
		} else {
			//入力値エラーなし
			session.put("title", title);
			session.put("body", body);
			session.put("category", category);
			result = SUCCESS;
		}
		return result;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
