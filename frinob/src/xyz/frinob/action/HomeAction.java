package xyz.frinob.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dto.PostInfoDTO;

public class HomeAction extends ActionSupport {

	private List<PostInfoDTO> postList;

	public String execute() {
		
		PostInfoDAO postInfoDAO = new PostInfoDAO();
		postList = postInfoDAO.getPostList();
		
		return SUCCESS;
	}

	public List<PostInfoDTO> getPostList() {
		return this.postList;
	}
	
}
