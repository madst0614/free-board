package org.freeBoard.service;

import java.util.List;
import java.util.Map;

import org.freeBoard.domain.CategoryVO;

public interface MenuService {
	public Map<String, List<CategoryVO>> makeCategory();
}
