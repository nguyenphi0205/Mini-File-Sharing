package com.dxc.msf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sourceforge.jtds.jdbc.DateTime;

@Entity
@Table(name="Users")
public class UserDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_id")
	private String userID;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String userPassword;
	
	@Column(name="is_admin")
	private String isAdmin;
	
	@Column(name="level_user")
	private String userLevel;
	
	@Column(name="email")
	private String userEmail;
	
	@Column(name="createDate")
	private Date createDate;
	
	@Column(name="deleteDate")
	private Date deleteDate;
	
	@Column(name="lastModifiedDate")
	private Date lastModifyDate;
	

	public String getUserID() {
		return userID;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	@Override
	public String toJSon() throws JsonProcessingException {
		ObjectMapper objectmapper =new ObjectMapper();
		return objectmapper.writeValueAsString(this);
	}
}
