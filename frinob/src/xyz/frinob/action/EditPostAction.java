package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class EditPostAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String title;
	private String body;
	private int backFlg;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {

			if(backFlg == 1) { //編集確認画面で戻るボタンが押された
				title = session.get("newTitle").toString();
				body = session.get("newBody").toString();
				session.remove("newTitle");
				session.remove("newBody");
			} else {
				title = session.get("title").toString();
				body = session.get("body").toString();
			}
			result = SUCCESS;
		}
		return result;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setBackFlg(int backFlg) {
		this.backFlg = backFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
