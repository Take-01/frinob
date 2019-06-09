package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserNameAndEmailAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String userName;
	private String email;
	private int backFlg;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			if(backFlg == 1) { //確認画面で戻るボタンが押された
				userName = session.get("userName").toString();
				email = session.get("email").toString();
				session.remove("userName");
				session.remove("email");
			}
			result = SUCCESS;
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

	public void setBackFlg(int backFlg) {
		this.backFlg = backFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
