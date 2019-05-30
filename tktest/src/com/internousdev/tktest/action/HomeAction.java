package com.internousdev.tktest.action;

import java.util.List;

import com.internousdev.tktest.dao.PostInfoDAO;
import com.internousdev.tktest.dto.PostInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	private List<PostInfoDTO> postList;
	private PostInfoDTO postInfoDTO;

	public String execute() {
		
		PostInfoDAO postInfoDAO = new PostInfoDAO();
		postList = postInfoDAO.getPostList();
		
		return SUCCESS;
	}

	public List<PostInfoDTO> getPostList() {
		return this.postList;
	}
	
	public PostInfoDTO getPostInfoDTO() {
		return this.postInfoDTO;
	}
	
}
