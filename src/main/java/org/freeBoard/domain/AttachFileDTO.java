package org.freeBoard.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	
	private String uuid;
	private String fileName;
	private boolean image;
	private String uploadPath;
}
