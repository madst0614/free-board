package org.freeBoard.service;

import java.util.List;

import org.freeBoard.domain.MenuVO;
import org.freeBoard.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService{
	
	private MenuMapper mapper;
	
	@Override
	public List<MenuVO> getBoardList() {
		log.info("Get BoardList");
		
		return mapper.getBoardList();
	}

}
