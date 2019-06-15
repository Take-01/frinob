package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoriteUserInfoDAO;
import xyz.frinob.util.InputChecker;

public class RegistFavoriteUserCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String tag1;
	private String tag2;
	private String tag3;
	private String tag4;
	private String tag5;
	private String tagMessage;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
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
			//ユーザーをお気に入り登録する
			String userId = session.get("userId").toString();
			String writerId = session.get("writerId").toString();
			FavoriteUserInfoDAO favUserDAO = new FavoriteUserInfoDAO();
			int count = favUserDAO.registFavUser(userId, writerId, tags);
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
