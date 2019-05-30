package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.UserInfoDAO;
import xyz.frinob.dto.UserInfoDTO;
import xyz.frinob.util.InputChecker;

public class LoginAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;
	private Map<String, Object> session;
	private List<String> userIdMessageList;
	private List<String> passwordMessageList;

	public String execute() {

		String result = ERROR;

		if(session.containsKey("loggedIn")) {
			return result;
		}

		//入力チェックを行う
		InputChecker inputChecker = new InputChecker();
		userIdMessageList = inputChecker.getMessages(userId, "ユーザーID", 4, 16, 1, 2, 6);
		passwordMessageList = inputChecker.getMessages(password, "パスワード", 6, 20, 1, 2, 6);

		if(CollectionUtils.isNotEmpty(userIdMessageList) || CollectionUtils.isNotEmpty(passwordMessageList)) {
			return result = "login";
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		if(userInfoDAO.isExistsUser(userId, password)) { //登録済みユーザーかチェック
			
			UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(userId);

			if(userInfoDTO.getUserId().equals(userId)) {
				session.put("loggedIn", 1);
				session.put("userId", userInfoDTO.getUserId());
				session.put("userName", userInfoDTO.getUserName());
				result = SUCCESS;

				if (session.containsKey("postFlg") && session.get("postFlg").equals(1)) {
					result = "post";
				}
			}
		}
		return result;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getUserIdMessageList() {
		return this.userIdMessageList;
	}

	public List<String> getPasswordMessageList() {
		return this.passwordMessageList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
