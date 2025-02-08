package com.fa.Dto;

public class FileResponse {

	private String fileName;
	private String fileType;
	private String url;
	private long size;
	
	public FileResponse(String fileName, String fileType, String url, long size) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.url = url;
		this.size = size;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}

	
}
