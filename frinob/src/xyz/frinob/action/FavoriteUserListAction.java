package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoriteUserInfoDAO;
import xyz.frinob.dto.FavoriteUserInfoDTO;

public class FavoriteUserListAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<FavoriteUserInfoDTO> favUserList;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			FavoriteUserInfoDAO favUserDAO = new FavoriteUserInfoDAO();
			favUserList = favUserDAO.getFavUserList(session.get("userId").toString());
			result = SUCCESS;
		}
		return result;
	}

	public List<FavoriteUserInfoDTO> getFavUserList() {
		return this.favUserList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
