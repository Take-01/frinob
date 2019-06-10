package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoritePostInfoDAO;
import xyz.frinob.dto.FavoritePostInfoDTO;

public class FavoritePostListAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<FavoritePostInfoDTO> favPostList;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			//お気に入り投稿のリストを取得
			FavoritePostInfoDAO favPostDAO = new FavoritePostInfoDAO();
			favPostList = favPostDAO.getFavPostList(session.get("userId").toString());

			result = SUCCESS;
		}
		return result;
	}

	public List<FavoritePostInfoDTO> getFavPostList() {
		return favPostList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
