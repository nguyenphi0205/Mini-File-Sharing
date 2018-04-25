package com.dxc.msf.model;

public class UserDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;
	
	private String userID;
	
	private String userName;
	
	private String userPassword;
	
	private String userTypeID;
	
	private String rankID;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(String userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getRankID() {
		return rankID;
	}

	public void setRankID(String rankID) {
		this.rankID = rankID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
