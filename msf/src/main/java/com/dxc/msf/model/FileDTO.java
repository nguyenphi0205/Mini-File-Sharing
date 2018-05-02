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

import net.sourceforge.jtds.jdbc.DateTime;

@Entity(name = "Files")
public class FileDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "file_id")
	private String fileID;

	@Column(name = "file_name")
	private String fileName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonDeserialize(as = UserDTO.class)
	private UserDTO userPK;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categories_id", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonDeserialize(as = CategoryDTO.class)
	private CategoryDTO categoryPK;

	@Column(name = "file_size")
	private int fileSize;

	@Column(name = "comment")
	private String comment;

	@Column(name = "createDate")
	private Date createFileDate;

	@Column(name = "deleteDate")
	private Date deleteFileDate;

	@Column(name = "lastModifiedDate")
	private Date lastModifyDate;
	@Column(name = "filePath")
	private String filePath;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public Date getCreateFileDate() {
		return createFileDate;
	}

	public void setCreateFileDate(Date createFileDate) {
		this.createFileDate = createFileDate;
	}

	public Date getDeleteFileDate() {
		return deleteFileDate;
	}

	public void setDeleteFileDate(Date deleteFileDate) {
		this.deleteFileDate = deleteFileDate;
	}

	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	@Override
	public String toJSon() throws JsonProcessingException {
		ObjectMapper objectmapper = new ObjectMapper();
		return objectmapper.writeValueAsString(this);
	}

}
