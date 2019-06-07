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

		session.put("title", title);
		session.put("body", title);

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			result = "sessionError";
		} else {
			//入力チェック
			InputChecker inputChecker = new InputChecker();
			titleMessageList = inputChecker.getMessages(title, "タイトル", 1, 30, 3, 4, 5, 6, 7);
			bodyMessageList = inputChecker.getMessages(body, "本文", 1, 500, 3, 4, 5, 6, 7);
			if(CollectionUtils.isNotEmpty(titleMessageList) || CollectionUtils.isNotEmpty(bodyMessageList)) {
				result = "back";
			} else {
				result = SUCCESS;
			}
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
