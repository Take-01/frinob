package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.CategoryDAO;
import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dao.UserInfoDAO;
import xyz.frinob.dto.CategoryDTO;
import xyz.frinob.dto.PostInfoDTO;
import xyz.frinob.dto.UserInfoDTO;
import xyz.frinob.util.InputChecker;
import xyz.frinob.util.SaftyPassword;

public class LoginAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;
	private List<PostInfoDTO> postList;
	private Map<String, Object> session;
	private List<String> userIdMessageList;
	private List<String> passwordMessageList;
	private String notMatchMessage;

	public String execute() {

		String result = ERROR;

		if(session.containsKey("loggedIn") && session.get("loggedIn").equals(1)) {
			return result;
		}

		//入力チェックを行う
		InputChecker inputChecker = new InputChecker();
		userIdMessageList = inputChecker.getMessageList(userId, "ユーザーID", 4, 16, 1, 2, 8);
		passwordMessageList = inputChecker.getMessageList(password, "パスワード", 6, 20, 1, 2, 8);

		if(CollectionUtils.isNotEmpty(userIdMessageList) || CollectionUtils.isNotEmpty(passwordMessageList)) {
			return result = "login";
		}

		SaftyPassword saftyPassword = new SaftyPassword();
		String passwordHash = saftyPassword.getPasswordHash(password, userId);
		UserInfoDAO userInfoDAO = new UserInfoDAO();

		if(!userInfoDAO.isExistsUser(userId, passwordHash)) { //登録済みユーザーかチェック
			notMatchMessage = "ユーザーIDかパスワードが間違っています。";
			result = "back";
		} else {

			UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(userId);

			if(userInfoDTO.getUserId().equals(userId)) {
				session.put("loggedIn", 1);
				session.put("userId", userInfoDTO.getUserId());
				session.put("userName", userInfoDTO.getUserName());

				//ホーム画面へ遷移するので投稿一覧を取得
				PostInfoDAO postInfoDAO = new PostInfoDAO();
				postList = postInfoDAO.getPostList();

				result = SUCCESS;

				if (session.containsKey("postFlg") && session.get("postFlg").equals(1)) { //投稿ボタンを押下して遷移してきた
					CategoryDAO categoryDAO = new CategoryDAO();
					List<CategoryDTO> categoryList = categoryDAO.getCategoryList();
					if(CollectionUtils.isNotEmpty(categoryList)) {
						session.put("categoryList", categoryList);
					}
					session.remove("postFlg");
					result = "post";
				}
			}
		}
		return result;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PostInfoDTO> getPostList() {
		return this.postList;
	}

	public List<String> getUserIdMessageList() {
		return this.userIdMessageList;
	}

	public List<String> getPasswordMessageList() {
		return this.passwordMessageList;
	}

	public String getNotMatchMessage() {
		return this.notMatchMessage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
