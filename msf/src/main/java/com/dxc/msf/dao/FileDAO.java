package com.dxc.msf.dao;

import java.util.List;

import com.dxc.msf.model.FileDTO;

public interface FileDAO {
	public boolean AddUploadFile(FileDTO file);
	public List<FileDTO> getListFile();
}
