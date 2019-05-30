package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.UserInfoDAO;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		if(session.containsKey("loggedIn")) {
			return result;
		}

		String userId = String.valueOf(session.get("userId"));
		String password = String.valueOf(session.get("password"));
		String userName = String.valueOf(session.get("email"));
		String email = String.valueOf(session.get("email"));

		//DBに登録する
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = 0;
		count = userInfoDAO.registUser(userId, password, userName, email);
		if(count > 0) {
			session.remove("userId");
			session.remove("password");
			session.remove("userName");
			session.remove("email");
			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
