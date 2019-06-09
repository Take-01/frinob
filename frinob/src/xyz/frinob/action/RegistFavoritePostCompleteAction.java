package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoritePostInfoDAO;
import xyz.frinob.util.InputChecker;

public class RegistFavoritePostCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String tag1;
	private String tag2;
	private String tag3;
	private String tag4;
	private String tag5;
	private String tagMessage;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {
			//入力チェック
			InputChecker inputChecker = new InputChecker();
			String[] tags = {tag1, tag2, tag3, tag4, tag5};
			for(String tag:tags) {
				tagMessage = inputChecker.getMessage(tag, "タグ", 1, 2, 3, 4, 5);
				if(tagMessage != null) {
					return result = "back";
				}
			}
			//お気に入り登録する
			String userId = session.get("userId").toString();
			int postId = Integer.parseInt(session.get("postId").toString());
			FavoritePostInfoDAO favPostDAO = new FavoritePostInfoDAO();
			int count = favPostDAO.registFavPost(userId, postId, tags);
			if(count > 0) {
				result = SUCCESS;
			}
		}
		return result;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public void setTag4(String tag4) {
		this.tag4 = tag4;
	}

	public void setTag5(String tag5) {
		this.tag5 = tag5;
	}

	public void setTagMessage(String tagMessage) {
		this.tagMessage = tagMessage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
