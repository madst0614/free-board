package org.freeBoard.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {

	// 게시글 넘버
	private Long bno;
	
	public String title;
	public String content;
	public String writer;
	
	public Date regDate;
	public Date updateDate;
	
	private int replyCnt;
	
	private List<BoardAttachVO> attachList;
}
