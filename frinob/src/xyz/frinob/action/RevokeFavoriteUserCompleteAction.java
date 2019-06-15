package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoriteUserInfoDAO;

public class RevokeFavoriteUserCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			FavoriteUserInfoDAO favUserDAO = new FavoriteUserInfoDAO();
			int count = favUserDAO.revokeFavUser(session.get("userId").toString(), session.get("writerId").toString());
			if(count > 0) {
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
