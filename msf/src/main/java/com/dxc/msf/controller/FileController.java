package com.dxc.msf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dxc.msf.model.DownloadDTO;
import com.dxc.msf.model.FileDTO;
import com.dxc.msf.service.FileService;
import com.google.gson.Gson;

@Controller
public class FileController {

	@Autowired
	FileService fileService;

	// download file

	@RequestMapping(value = "/file/download", method = RequestMethod.POST)
	public @ResponseBody String downloadFile(HttpServletResponse response, @RequestBody String fileId) {
		Boolean downloadSuccess = fileService.downloadFile(response, fileId);
		if (downloadSuccess) {
			return "{\"status\": \"OK\"}";
		} else {
			return "{\"status\": \"Failed\"}";
		}
	}

	@RequestMapping(value = "/file/adddownloadfile", method = RequestMethod.POST, produces = {
			"application/json; charset=UTF-8" })
	public @ResponseBody String downloadFile(@RequestBody DownloadDTO download) {
		try {
			Boolean uploadSuccess = fileService.addDownloadFile(download);
			if (uploadSuccess) {
				return "{\"status\": \"OK\"}";
			}

		} catch (Exception e) {
			return "{\"status\": \"Failed\"}";
		}
		return "{\"status\": \"Failed\"}";
	}
	
	@RequestMapping(value = "/file/listDownload", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String getListDownloadFile() {
		List<DownloadDTO> list = fileService.getListDownloadFile();
		String json = new Gson().toJson(list);
		return json;
	}

	// upload file

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

	@RequestMapping(value = "/file/adduploadfile", method = RequestMethod.POST, produces = {
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

	@RequestMapping(value = "/file/list", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String getListFile() {
		List<FileDTO> list = fileService.getListFile();
		String json = new Gson().toJson(list);
		return json;
	}
}
