package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dto.PostInfoDTO;

public class MyPageAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<PostInfoDTO> postList;
	private int backFlg;
	
	public String execute() {
		
		String result = ERROR;
		
		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			result = "sessionError";
		} else {
			if(backFlg == 1) {
				session.remove("postId");
				session.remove("title");
				session.remove("body");
				session.remove("categoryId");
				session.remove("categoryName");
				session.remove("registDate");
				session.remove("updateDate");
			}
			
			PostInfoDAO postInfoDAO = new PostInfoDAO();
			postList = postInfoDAO.getUserPostList(session.get("userId").toString());
			result = SUCCESS;
		}
		return result;
	}
	
	public void setBackFlg(int backFlg) {
		this.backFlg = backFlg;
	}
	
	public List<PostInfoDTO> getPostList() {
		return this.postList;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
