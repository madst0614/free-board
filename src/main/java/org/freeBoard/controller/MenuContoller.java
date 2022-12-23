package org.freeBoard.controller;

import org.freeBoard.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/menu/")
@RestController
@Log4j2
@AllArgsConstructor
public class MenuContoller {
	
	private MenuService service;
	
	
	
	
}
