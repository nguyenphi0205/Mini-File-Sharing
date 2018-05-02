package com.dxc.msf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity(name="Downloads")
public class DownloadDTO extends AbstractDTO {

	@Id
	@Column(name="download_id")
	private String downloadID;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="user_id" , nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonDeserialize(as=UserDTO.class)
	private UserDTO userID;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="file_id" , nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonDeserialize(as=FileDTO.class)
	private FileDTO fileID;
	
	@Column(name="createDate")
	private Date createDate;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="lastModifiedDate")
	private Date lastModifiedDate;
	
	public String getDownloadID() {
		return downloadID;
	}

	public void setDownloadID(String downloadID) {
		this.downloadID = downloadID;
	}

	public UserDTO getUserID() {
		return userID;
	}

	public void setUserID(UserDTO userID) {
		this.userID = userID;
	}

	public FileDTO getFileID() {
		return fileID;
	}

	public void setFileID(FileDTO fileID) {
		this.fileID = fileID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toJSon() throws JsonProcessingException {
		ObjectMapper objectmapper =new ObjectMapper();
		return objectmapper.writeValueAsString(this);
	}

}
