package com.internousdev.tktest.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tktest.dao.FavoritePostInfoDAO;
import com.internousdev.tktest.dao.PostInfoDAO;
import com.internousdev.tktest.dto.PostInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PostDetailsAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	private int postId;
	private int backFlg;
	private boolean isRegistered;
	
	public String execute() {
		
		String result = ERROR;
		
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
			
			result = "back";
		} else {
			if(session.containsKey("loggedIn") && session.get("loggedIn").equals(1)) {
				//ログイン済みなら投稿をお気に入り登録しているか調べる
				FavoritePostInfoDAO favPostDAO = new FavoritePostInfoDAO();
				isRegistered = favPostDAO.isRegistered(session.get("userId").toString(), postId);
			}
			//投稿詳細情報を取得
			PostInfoDAO postInfoDAO = new PostInfoDAO();
			PostInfoDTO postInfoDTO = postInfoDAO.getPostDetails(postId);
			if(postInfoDTO != null && postInfoDTO.getId() != 0) {
				session.put("postId", postId);
				session.put("title", postInfoDTO.getTitle());
				session.put("body", postInfoDTO.getBody());
				session.put("writerId", postInfoDTO.getWriterId());
				session.put("writerName", postInfoDTO.getWriterName());
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
	
	public void setBackFlg(int backFlg) {
		this.backFlg = backFlg;
	}
	
	public boolean getIsRegistered() {
		return this.isRegistered;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
