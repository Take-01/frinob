package xyz.frinob.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dto.PostInfoDTO;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private List<PostInfoDTO> postList;
	private int backFlg;

	public String execute() {

		if(backFlg == 1) {
			session.remove("postId");
			session.remove("title");
			session.remove("body");
			session.remove("writerId");
			session.remove("writerName");
			session.remove("categoryId");
			session.remove("categoryName");
			session.remove("registDate");
			session.remove("updateDate");
		}

		PostInfoDAO postInfoDAO = new PostInfoDAO();
		postList = postInfoDAO.getPostList();

		return SUCCESS;
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
