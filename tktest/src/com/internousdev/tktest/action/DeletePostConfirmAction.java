package com.internousdev.tktest.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.tktest.dao.PostInfoDAO;
import com.internousdev.tktest.dto.PostInfoDTO;
import com.internousdev.tktest.dao.CategoryDAO;

public class DeletePostConfirmAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	private int backFlg;
	
	public String execute() {
		
		String result = ERROR;
		
		if(!session.containsKey("loggedIn") || !session.get("loggedIn").equals(1)) {
			return "sessionError";
		}
		
		if(backFlg == 1) {
			session.remove("title");
			session.remove("body");
			session.remove("categoryId");
			session.remove("categoryName");
			return "back";
		}

		int postId = Integer.parseInt(session.get("postId").toString());
		PostInfoDAO postInfoDAO = new PostInfoDAO();
		PostInfoDTO postInfoDTO = postInfoDAO.getPostDetails(postId);
		String categoryName = Category
		session.put("title", postInfoDTO.getTitle());
		session.put("body", postInfoDTO.getBody());
		session.put("categoryId", postInfoDTO.getCategoryId());
	}

}
