package com.dxc.msf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity(name="Categories")
public class CategoryDTO extends AbstractDTO {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="categories_id")
	private String categoryID;
	
	@Column(name="categories_name")
	private String categoryName;
	
	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toJSon() throws JsonProcessingException {
		ObjectMapper objectmapper =new ObjectMapper();
		return objectmapper.writeValueAsString(this);
	}

}
