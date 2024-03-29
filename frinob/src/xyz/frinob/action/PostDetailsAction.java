package xyz.frinob.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import xyz.frinob.dao.FavoritePostInfoDAO;
import xyz.frinob.dao.PostInfoDAO;
import xyz.frinob.dto.PostInfoDTO;

public class PostDetailsAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int postId;
	private boolean isRegistered;
	private int userFlg;

	public String execute() {

		String result = ERROR;

		if(session.containsKey("loggedIn") && session.get("loggedIn").equals(1)) { //ログイン済み
			//投稿をお気に入り登録しているか調べる
			FavoritePostInfoDAO favPostDAO = new FavoritePostInfoDAO();
			isRegistered = favPostDAO.isRegistered(session.get("userId").toString(), postId);
		}

		if(session.containsKey("postId")) {
			postId = Integer.parseInt(session.get("postId").toString());
		}

		// 投稿詳細情報を取得
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
		return result;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public boolean getIsRegistered() {
		return this.isRegistered;
	}

	public int getUserFlg() {
		return this.userFlg;
	}

	public void setUserFlg(int userFlg) {
		this.userFlg = userFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
