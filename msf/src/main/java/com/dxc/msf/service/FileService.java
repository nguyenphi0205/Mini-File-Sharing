package com.dxc.msf.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.msf.model.DownloadDTO;
import com.dxc.msf.model.FileDTO;

public interface FileService {
	//upload
	public Boolean uploadFile(MultipartFile file);
	public Boolean addUploadFile(FileDTO fileDto);
	public List<FileDTO> getListFile();
	//download
	public Boolean downloadFile(HttpServletResponse response, String fileId);
	public boolean addDownloadFile(DownloadDTO download);
	public List<DownloadDTO> getListDownloadFile();
}
