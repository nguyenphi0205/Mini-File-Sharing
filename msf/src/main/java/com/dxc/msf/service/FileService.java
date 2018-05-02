package com.dxc.msf.service;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import com.dxc.msf.model.FileDTO;

public interface FileService {
	public Boolean uploadFile(MultipartFile file);
	public Boolean downloadFile(HttpServletResponse response, String fileId);
	public Boolean addUploadFile(FileDTO fileDto); 
}
