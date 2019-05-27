package com.internousdev.tktest.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tktest.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String userId;
	private String password;
	private String userName;
	private String email;
	private List<String> userIdMessageList;
	private List<String> passwordMessageList;
	private List<String> userNameMessageList;
	private List<String> emailMessageList;

	public String execute() {

		String result = ERROR;

		if (session.containsKey("loggedIn")) {
			return result;
		}

		session.put("userId", userId);
		session.put("password", password);
		session.put("userName", userName);
		session.put("email", email);

		//入力チェック
		InputChecker inputChecker = new InputChecker();
		userIdMessageList = inputChecker.getMessages(userId, "ユーザーID", 4, 16, 1, 2, 6);
		passwordMessageList = inputChecker.getMessages(password, "パスワード", 6, 20, 1, 2, 6);
		userNameMessageList = inputChecker.getMessages(userName, "ユーザー名", 3, 20, 1, 2, 3, 4, 5, 6);
		emailMessageList = inputChecker.checkEmailAddress(email);

		if (CollectionUtils.isNotEmpty(userIdMessageList) || CollectionUtils.isNotEmpty(passwordMessageList) || CollectionUtils.isNotEmpty(userNameMessageList) || CollectionUtils.isNotEmpty(emailMessageList)) {
			result = "back";
		} else {
			result = SUCCESS;
		}
		return result;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public List<String> getUserIdMessageList() {
		return this.userIdMessageList;
	}

	public List<String> getPasswordMessageList() {
		return this.passwordMessageList;
	}

	public List<String> getUserNameMessageList() {
		return this.userNameMessageList;
	}

	public List<String> getEmailMessageList() {
		return this.emailMessageList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
