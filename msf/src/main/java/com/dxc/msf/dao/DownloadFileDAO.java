package com.dxc.msf.dao;

import java.util.List;

import com.dxc.msf.model.DownloadDTO;

public interface DownloadFileDAO {
	public Boolean AddDownloadFile(DownloadDTO download);
	public List<DownloadDTO> getListDownload();
}
