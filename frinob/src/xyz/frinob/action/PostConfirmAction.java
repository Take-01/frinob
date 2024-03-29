package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dto.CategoryDTO;
import xyz.frinob.util.InputChecker;

public class PostConfirmAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String title;
	private String body;
	private int categoryId;
	private List<String> titleMessageList;
	private List<String> bodyMessageList;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			return result = "sessionError";
		}

		//カテゴリー名を取得する
		@SuppressWarnings("unchecked")
		List<CategoryDTO> categoryDTOList = (List<CategoryDTO>) session.get("categoryList");
		for(CategoryDTO categoryDTO:categoryDTOList) {
			if(categoryDTO.getCategoryId() == categoryId) {
				String categoryName = categoryDTO.getCategoryName();
				session.put("categoryName", categoryName);
				break;
			}
		}

		session.put("title", title);
		session.put("body", body);
		session.put("categoryId", categoryId);

		//入力チェック
		InputChecker inputChecker = new InputChecker();
		titleMessageList = inputChecker.getMessageList(title, "タイトル", 1, 30, 3, 4, 5, 6, 7);
		bodyMessageList = inputChecker.getMessageList(body, "本文", 1, 500, 3, 4, 5, 6, 7);

		if(CollectionUtils.isNotEmpty(titleMessageList) || CollectionUtils.isNotEmpty(bodyMessageList)) {
			result = "back";
		} else {
			//入力値エラーなし
			result = SUCCESS;
		}
		return result;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<String> getTitleMessageList() {
		return this.titleMessageList;
	}

	public List<String> getBodyMessageList() {
		return this.bodyMessageList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
