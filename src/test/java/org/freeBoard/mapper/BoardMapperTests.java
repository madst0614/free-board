package org.freeBoard.mapper;

import java.util.List;

import org.freeBoard.domain.BoardVO;
import org.freeBoard.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("테스트");
//		board.setContent("됩니까?");
//		board.setWriter("되나?");
//
//		mapper.insertSelectKey(board);
//
//		log.info(board);
//	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		// 10개씩 3페이지
		cri.setPageNum(1);
		cri.setAmount(10);
		cri.setMid("free");
		
		log.info("testPaging");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}	
	
	/*@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");

		mapper.insert(board);

		log.info(board);
	}

	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");

		mapper.insertSelectKey(board);
		log.info(board);
	}

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testRead() {
		BoardVO board = mapper.read(25L);

		log.info(board);
	}

	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(3L));
	}

	@Test
	public void testUpdate() {

		BoardVO board = new BoardVO();
		board.setBno(23L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");

		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}

	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		// 10개씩 3페이지
		cri.setPageNum(1);
		cri.setAmount(10);
		
		log.info("testPaging");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}*/
	
	/*
	 * @Test public void testSearch() { Criteria cri = new Criteria();
	 * cri.setKeyword("새로"); cri.setType("");
	 * 
	 * List<BoardVO> list = mapper.getListWithPaging(cri);
	 * 
	 * list.forEach(board->log.info(board)); }
	 */
}
