package com.dxc.msf.model;

public class RankDTO extends AbstractDTO {
	private static final long serialVersionUID = 1L;

	private String rankID;
	
	private String rankName;
	
	private String rankDownloadQuota;
	
	private String rankUploadQuota;

	public String getRankID() {
		return rankID;
	}

	public void setRankID(String rankID) {
		this.rankID = rankID;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public String getRankDownloadQuota() {
		return rankDownloadQuota;
	}

	public void setRankDownloadQuota(String rankDownloadQuota) {
		this.rankDownloadQuota = rankDownloadQuota;
	}

	public String getRankUploadQuota() {
		return rankUploadQuota;
	}

	public void setRankUploadQuota(String rankUploadQuota) {
		this.rankUploadQuota = rankUploadQuota;
	}
	
	

}
