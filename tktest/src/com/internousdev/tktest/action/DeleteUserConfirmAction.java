package com.internousdev.tktest.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tktest.dao.UserInfoDAO;
import com.internousdev.tktest.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUserConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return result = "sessionError";
		}
		
		String userId = String.valueOf(session.get("userId"));
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO = userInfoDAO.getUserInfo(userId);
		
		if(userInfoDTO != null) {
			session.put("userName", userInfoDTO.getUserName());
			session.put("email", userInfoDTO.getEmail());
			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}