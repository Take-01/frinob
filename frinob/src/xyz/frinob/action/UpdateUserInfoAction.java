package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.UserInfoDAO;
import xyz.frinob.dto.UserInfoDTO;

public class UpdateUserInfoAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private UserInfoDTO userInfoDTO;
	private String userId;
	private String userName;
	private String email;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			UserInfoDTO userInfoDTO = new UserInfoDTO();
			userInfoDTO = userInfoDAO.getUserInfo(session.get("userId").toString());

			if(userInfoDTO.getId() != 0) {
				userId = userInfoDTO.getUserId();
				userName = userInfoDTO.getUserName();
				email = userInfoDTO.getEmail();
				result = SUCCESS;
			}
		}
		return result;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getEmail() {
		return this.email;
	}

	public UserInfoDTO getUserInfoDTO() {
		return this.userInfoDTO;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
