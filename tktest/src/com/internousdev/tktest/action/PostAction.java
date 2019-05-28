package com.internousdev.tktest.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	
	public String execute() {
		
		String result = ERROR;
		
		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			session.put("postFlg", 1);
			result = "login";
		} else {
			if(session.containsKey("postFlg") && session.get("postFlg").equals(1)) {
				session.remove("postFlg");
			}
			result = SUCCESS;
		}
		return result;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
