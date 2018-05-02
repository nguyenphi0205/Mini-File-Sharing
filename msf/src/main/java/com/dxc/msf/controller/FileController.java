package com.dxc.msf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dxc.msf.model.FileDTO;
import com.dxc.msf.service.FileService;

@Controller
public class FileController {

	@Autowired
	FileService fileService;

	@RequestMapping(value = "/file/download", method = RequestMethod.POST)
	public @ResponseBody String downloadFile(HttpServletResponse response, @RequestBody String fileId) {
		Boolean downloadSuccess = fileService.downloadFile(response, fileId);
		if (downloadSuccess) {
			return "{\"status\": \"OK\"}";
		} else {
			return "{\"status\": \"Failed\"}";
		}
	}

	@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFile(HttpServletRequest request, HttpServletResponse response,
			@RequestBody FileDTO file) {
		MultipartHttpServletRequest mRequest;
		try {
			mRequest = (MultipartHttpServletRequest) request;
			mRequest.getParameterMap();
			Iterator<String> iterator = mRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile mFile = mRequest.getFile(iterator.next());
				Boolean uploadSuccess = fileService.uploadFile(mFile);
				if (uploadSuccess) {
					return "{\"status\": \"OK\"}";
				}
			}
		} catch (Exception e) {
			return "{\"status\": \"Failed\"}";
		}
		return "{\"status\": \"Failed\"}";
	}
	
	@RequestMapping(value = "/file/adduploadfile", method = RequestMethod.POST,produces = {
	"application/json; charset=UTF-8" })
	public @ResponseBody String uploadFile(@RequestBody FileDTO file) {
		try {		
				Boolean uploadSuccess = fileService.addUploadFile(file);
				if (uploadSuccess) {
					return "{\"status\": \"OK\"}";
				}
		
		} catch (Exception e) {
			return "{\"status\": \"Failed\"}";
		}
		return "{\"status\": \"Failed\"}";
	}
}
