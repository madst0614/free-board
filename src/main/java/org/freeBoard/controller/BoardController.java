package org.freeBoard.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.freeBoard.domain.BoardAttachVO;
import org.freeBoard.domain.BoardVO;
import org.freeBoard.domain.CategoryVO;
import org.freeBoard.domain.Criteria;
import org.freeBoard.domain.MenuDTO;
import org.freeBoard.domain.PageDTO;
import org.freeBoard.service.BoardService;
import org.freeBoard.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping(value = { "/board", "/board/*" })
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	private MenuService menuService;

	@GetMapping(value = { "" })
	public String board(Criteria cri, Model model) {
		
		List<CategoryVO> catList = menuService.getList();
		log.info("Get Category List: " + catList);
		
		model.addAttribute("name","전체");
		
		log.info("list criteria: " + cri);
		model.addAttribute("list", service.getList(cri));

		int total = service.getTotal(cri);

		log.info("page total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		MenuDTO menu = menuService.getMenu(catList);
		log.info("getMenu " + menu);
		model.addAttribute("menu", menu);

		return "board/list";
	}

	@GetMapping("/{board}")
	public String board(@PathVariable("board") String board, Criteria cri, Model model) {
		
		List<CategoryVO> catList = menuService.getList();
		log.info("Get Category List: " + catList);
		
		Map<String, CategoryVO> catMap = menuService.getCatMap(catList);
		log.info("Get Category Map: "+ catMap );
		model.addAttribute("name", catMap.get(board).getName());
		
		MenuDTO menu = menuService.getMenu(catList);
		log.info("getMenu " + menu);
		model.addAttribute("menu", menu);
		
		log.info("board : "+board);
		cri.setMid(board);
		
		log.info("list criteria: " + cri);
		model.addAttribute("list", service.getList(cri));

		int total = service.getTotal(cri);

		log.info("page total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		return "board/list";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public void register() {

	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("register: " + board);

		if (board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}

		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());

		return ("redirect:/board/"+board.getMid());
	}

	@GetMapping(value = { "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or /modify");
		model.addAttribute("board", service.get(bno));
	}

	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {

		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}

		return ("redirect:/board/"+board.getMid()) + cri.getListLink();
	}

	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/remove")
	public String remove(BoardVO board, @RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {

		log.info("remove....." + bno);

		List<BoardAttachVO> attachList = service.getAttachList(bno);

		if (service.remove(bno)) {

			deleteFiles(attachList);
			rttr.addFlashAttribute("result", "success");
		}

		return ("redirect:/board/"+cri.getMid()) + cri.getListLink();
	}

	public void deleteFiles(List<BoardAttachVO> attachList) {
		if (attachList == null || attachList.size() == 0) {
			return;
		}

		log.info("delete attach files");
		log.info(attachList);

		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
						"C:\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());

				Files.deleteIfExists(file);

			} catch (Exception e) {
				log.error("delete file error" + e.getMessage());
			}
		});
	}

	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno) {
		log.info("getAttachList" + bno);

		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}

}
