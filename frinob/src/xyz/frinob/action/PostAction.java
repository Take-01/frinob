package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.CategoryDAO;
import xyz.frinob.dto.CategoryDTO;

public class PostAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int backFlg;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			session.put("postFlg", 1);
			result = "login";
		} else {
			if(backFlg != 1) { //投稿確認画面からの遷移でない
				session.remove("title");
				session.remove("body");
				session.remove("categoryName");
				session.remove("categoryId");
			}

			//カテゴリーIDとカテゴリー名のリストをセッションに格納
			CategoryDAO categoryDAO = new CategoryDAO();
			List<CategoryDTO> categoryList = categoryDAO.getCategoryList();
			if(CollectionUtils.isNotEmpty(categoryList)) {
				session.put("categoryList", categoryList);
			}
			result = SUCCESS;
		}
		return result;
	}

	public void setBackFlg(int backFlg) {
		this.backFlg = backFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
