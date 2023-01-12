package org.freeBoard.service;

import java.util.List;

import org.freeBoard.domain.BoardAttachVO;
import org.freeBoard.domain.BoardVO;
import org.freeBoard.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);

	public BoardVO get(Long bno);

	public boolean modify(BoardVO board);

	public boolean remove(Long bno);

	public int getTotal(Criteria cri);
	
	public List<BoardVO> getList(Criteria cri);
	
	public List<BoardAttachVO> getAttachList(Long bno);
}
