package com.internousdev.tktest.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int isWritten;

	public String execute() {

		String result = ERROR;

		if(session.containsKey("loggedIn")) {
			return result;
		} else {
			if(isWritten != 1) { //登録確認画面からの遷移でない場合
				session.remove("userId");
				session.remove("password");
				session.remove("userName");
				session.remove("email");
			}
			result = SUCCESS;
		}

		return result;
	}

	public void setIsWritten(int isWritten) {
		this.isWritten = isWritten;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
