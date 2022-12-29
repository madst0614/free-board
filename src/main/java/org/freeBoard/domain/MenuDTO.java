package org.freeBoard.domain;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MenuDTO {
	
	Map<String, List<CategoryVO>> category;
}
