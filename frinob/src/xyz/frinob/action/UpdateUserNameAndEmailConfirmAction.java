package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.util.InputChecker;

public class UpdateUserNameAndEmailConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String userName;
	private String email;
	private List<String> userNameMessageList;
	private List<String> emailMessageList;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			//入力チェック
			InputChecker inputChecker = new InputChecker();
			userNameMessageList = inputChecker.getMessageList(userName, "ユーザー名", 3, 20, 1, 2, 3, 4, 5, 8);
			emailMessageList = inputChecker.checkEmailAddress(email);

			if(CollectionUtils.isNotEmpty(userNameMessageList) || CollectionUtils.isNotEmpty(emailMessageList)) {
				result = "back";
			} else {
				session.put("userName", userName);
				session.put("email", email);
				result = SUCCESS;
			}
		}
		return result;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
