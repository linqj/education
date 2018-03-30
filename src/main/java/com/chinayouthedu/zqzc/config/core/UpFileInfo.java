package com.chinayouthedu.zqzc.config.core;

/**
 * 上传文件信息
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月25日   下午7:09:08 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class UpFileInfo extends BaseFileEntity{
	
	private String field;// 上传的文件域的ID或Name
	private String fileName;// 文件名称
	private String filePath;// 上传路径
	private Long fileSize;// 文件字节大小
	private String suffix;//后缀名
	private String fileType;//文件类型

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

}
