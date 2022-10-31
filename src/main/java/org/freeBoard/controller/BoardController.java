package org.freeBoard.controller;

import org.freeBoard.domain.Criteria;
import org.freeBoard.domain.PageDTO;
import org.freeBoard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/*")
@Log4j2
@AllArgsConstructor
public class BoardController {
	private BoardService service;

	@GetMapping("/list")
	public void list(Model model) {

		model.addAttribute("list", service.getList(cri));

		int total = service.getTotal(cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
}
