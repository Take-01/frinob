package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.util.InputChecker;

public class EditPostConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String title;
	private String body;
	private List<String> titleMessageList;
	private List<String> bodyMessageList;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {

			session.put("newTitle", title);
			session.put("newBody", body);

			//入力チェック
			InputChecker inputChecker = new InputChecker();
			titleMessageList = inputChecker.getMessageList(title, "タイトル", 1, 30, 3, 4, 5, 6, 7);
			bodyMessageList = inputChecker.getMessageList(body, "本文", 1, 500, 3, 4, 5, 6, 7);
			if(CollectionUtils.isNotEmpty(titleMessageList) || CollectionUtils.isNotEmpty(bodyMessageList)) {
				result = "back"; //編集画面へ
			} else {
				result = SUCCESS;
			}
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
