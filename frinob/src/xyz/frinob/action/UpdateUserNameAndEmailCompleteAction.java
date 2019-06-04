package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.UserInfoDAO;

public class UpdateUserNameAndEmailCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			result = "sessionError";
		} else {

			String userId = session.get("userId").toString();
			String userName = session.get("userName").toString();
			String email = session.get("email").toString();

			UserInfoDAO userInfoDAO = new UserInfoDAO();
			int count = userInfoDAO.updateUserNameAndEmail(userId, userName, email);
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
