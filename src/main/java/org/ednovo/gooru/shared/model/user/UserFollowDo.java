package org.ednovo.gooru.shared.model.user;

import java.io.Serializable;

public class UserFollowDo implements Serializable{
	private static final long serialVersionUID = 6752607500919973286L;
	private String gooruUid;
	private String username;
	private String profileImageUrl;
	
	public UserFollowDo(){}

	public String getGooruUid() {
		return gooruUid;
	}

	public void setGooruUid(String gooruUid) {
		this.gooruUid = gooruUid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	
}