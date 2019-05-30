package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dto.PostInfoDTO;

public class DeletePostConfirmAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	private int backFlg;
	
	public String execute() {
		
		String result = ERROR;
		
		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return "sessionError";
		}
		
		if(backFlg == 1) { //投稿削除確認画面で戻るボタンが押された
			session.remove("title");
			session.remove("body");
			session.remove("categoryId");
			session.remove("categoryName");
			
			result = "back";
		} else {
			int postId = Integer.parseInt(session.get("postId").toString());
			PostInfoDAO postInfoDAO = new PostInfoDAO();
			PostInfoDTO postInfoDTO = postInfoDAO.getPostDetails(postId);
			
			session.put("title", postInfoDTO.getTitle());
			session.put("body", postInfoDTO.getBody());
			session.put("categoryId", postInfoDTO.getCategoryId());
			session.put("categoryName", postInfoDTO.getCategoryName());
			
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
