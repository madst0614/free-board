package org.freeBoard.controller;

import java.util.List;

import org.freeBoard.domain.CategoryVO;
import org.freeBoard.domain.MenuDTO;
import org.freeBoard.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@AllArgsConstructor
public class MenuContoller {
	
	private MenuService service;
	
	@GetMapping(value="/getMenu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MenuDTO> getMenu(){
		List<CategoryVO> catList = service.getList();
		log.info("Get Category List: " + catList);	
		
		log.info("getMenuDTO");
		return new ResponseEntity<>(service.getMenu(catList), HttpStatus.OK);
	}
	
}
