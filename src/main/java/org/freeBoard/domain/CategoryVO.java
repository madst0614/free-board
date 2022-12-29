package org.freeBoard.domain;

import java.util.List;

import lombok.Data;

@Data
public class CategoryVO {
	
	private String mid;
	private String name;
	private Long parent;
	
	private List<CategoryVO> children;
}
