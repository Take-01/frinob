package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dto.PostInfoDTO;

public class MyPostDetailsAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int postId;

	public String execute() {

		String result = ERROR;

		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) { //未ログイン
			result = "sessionError";
		} else {

			//投稿詳細を取得
			PostInfoDAO postInfoDAO = new PostInfoDAO();
			PostInfoDTO postInfoDTO = postInfoDAO.getPostDetails(postId);
			if(postInfoDTO != null && postInfoDTO.getId() != 0) {
				session.put("postId", postId);
				session.put("title", postInfoDTO.getTitle());
				session.put("body", postInfoDTO.getBody());
				session.put("categoryId", postInfoDTO.getCategoryId());
				session.put("categoryName", postInfoDTO.getCategoryName());
				session.put("registDate", postInfoDTO.getRegistDate());
				session.put("updateDate", postInfoDTO.getRegistDate());

				result = SUCCESS;
			}
		}
		return result;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
