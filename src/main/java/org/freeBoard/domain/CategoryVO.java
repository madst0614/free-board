package org.freeBoard.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryVO {

	private String mid;
	private String name;
	private String parent;
	private Long morder;

	private List<CategoryVO> children;
	
	public CategoryVO(String mid, String name, String parent) {
		this.mid = mid;
		this.name = name;
		this.parent = parent;
	}
	
	public CategoryVO(String mid, String name, String parent, Long morder) {
		this.mid = mid;
		this.name = name;
		this.parent = parent;
		this.morder = morder;
	}

	public CategoryVO(String mid, String name, String parent, List<CategoryVO> children) {
		this.mid = mid;
		this.name = name;
		this.parent = parent;
		this.children = children;
	}

}
