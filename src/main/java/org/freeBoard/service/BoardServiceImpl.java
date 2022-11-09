package org.freeBoard.service;

import java.util.List;

import org.freeBoard.domain.BoardVO;
import org.freeBoard.domain.Criteria;
import org.freeBoard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Transactional
	@Override
	public void register(BoardVO board) {

		log.info("register" + board);

		mapper.insertSelectKey(board);
	}

	public BoardVO get(Long bno) {

		log.info("get......." + bno);

		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {

		log.info("modify" + board);

		boolean modifyResult = mapper.update(board) == 1;

		return modifyResult;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		log.info("remove" + bno);

		return mapper.delete(bno) == 1;
	}

	public int getTotal(Criteria cri) {
		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}

	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with Criteria " + cri);
		
		return mapper.getListWithPaging(cri);
	}
}
