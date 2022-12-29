package org.freeBoard.service;

import java.util.List;
import java.util.Map;

import org.freeBoard.domain.CategoryVO;
import org.freeBoard.domain.MenuDTO;
import org.freeBoard.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService{
	
	private MenuMapper mapper;
	
	public void addChildren() {
		
	}
	
	public  List<CategoryVO> init() {
		List<CategoryVO> temp = mapper.getList();
		
		temp.forEach(category->{
			if(category.getParent()!=null) {
				temp.
			}
		});
		
		
		
		return temp;
	}
	
	@Override
	public Map<String, List<CategoryVO>> makeCategory() {
		log.info("Get BoardList");
		
		return mapper.getBoardList();
	}

}
