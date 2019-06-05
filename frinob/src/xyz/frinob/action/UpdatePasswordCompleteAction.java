package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.UserInfoDAO;
import xyz.frinob.util.InputChecker;
import xyz.frinob.util.SaftyPassword;

public class UpdatePasswordCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirm;
	private List<String> passwordMessageList;
	private String notMatchMessage;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			result = "sessionError";
		} else {
			//入力チェック
			InputChecker inputChecker = new InputChecker();
			String[] passwords = {oldPassword, newPassword, newPasswordConfirm};
			List<String> passMsgList = null;
			for(String password:passwords) { //エラーになるものが出た時点でループを終える
				passMsgList = inputChecker.getMessages(password, "パスワード", 6, 20, 1, 2, 8);
				if(CollectionUtils.isNotEmpty(passMsgList)) {
					passwordMessageList = passMsgList;
					return result = "back";
				}
			}

			if(CollectionUtils.isEmpty(passwordMessageList)) { //入力チェック異常なし

				if(!newPassword.equals(newPasswordConfirm)) {
					notMatchMessage = "新しいパスワードが一致していません。";
					return result = "back";
				}

				SaftyPassword saftyPassword = new SaftyPassword();
				String userId = session.get("userId").toString();
				String oldPassHash = saftyPassword.getPasswordHash(oldPassword, userId);
				String newPassHash = saftyPassword.getPasswordHash(newPassword, userId);

				UserInfoDAO userInfoDAO = new UserInfoDAO();
				int count = userInfoDAO.updatePassword(userId, oldPassHash, newPassHash);
				if(count > 0) {
					result = SUCCESS;
				}
			}

		}
		return result;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
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
