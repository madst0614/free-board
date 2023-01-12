package org.freeBoard.service;

import java.util.List;
import java.util.Map;

import org.freeBoard.domain.CategoryVO;
import org.freeBoard.domain.MenuDTO;

public interface MenuService {
	public List<CategoryVO> getList();
	
	public Map<String, CategoryVO> getCatMap(List<CategoryVO> list);
	
	public MenuDTO getMenu(List<CategoryVO> list);
}
