package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeletePostConfirmAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	private int backFlg;
	
	public String execute() {
		
		String result = ERROR;
		
		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return "sessionError";
		}
		
		if(backFlg == 1) { //投稿削除確認画面で戻るボタンが押された
			result = "back";
		} else {
			result = SUCCESS;
		}
		return result;
	}
	
	public void setBackFlg(int backFlg) {
		this.backFlg = backFlg;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
