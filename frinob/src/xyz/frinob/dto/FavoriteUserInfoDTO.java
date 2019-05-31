package xyz.frinob.dto;

public class FavoriteUserInfoDTO {

	private int id;
	private String userId;
	private String favUserid;
	private String userTag1;
	private String userTag2;
	private String userTag3;
	private String userTag4;
	private String userTag5;
	private String registDate;
	private String updateDate;
	private String favUserName;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFavUserid() {
		return this.favUserid;
	}

	public void setFavUserid(String favUserid) {
		this.favUserid = favUserid;
	}

	public String getUserTag1() {
		return userTag1;
	}

	public void setUserTag1(String userTag1) {
		this.userTag1 = userTag1;
	}

	public String getUserTag2() {
		return userTag2;
	}

	public void setUserTag2(String userTag2) {
		this.userTag2 = userTag2;
	}

	public String getUserTag3() {
		return userTag3;
	}

	public void setUserTag3(String userTag3) {
		this.userTag3 = userTag3;
	}

	public String getUserTag4() {
		return userTag4;
	}

	public void setUserTag4(String userTag4) {
		this.userTag4 = userTag4;
	}

	public String getUserTag5() {
		return userTag5;
	}

	public void setUserTag5(String userTag5) {
		this.userTag5 = userTag5;
	}

	public String getRegistDate() {
		return this.registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getFavUserName() {
		return this.favUserName;
	}

	public void setFavUserName(String favUserName) {
		this.favUserName = favUserName;
	}
}
