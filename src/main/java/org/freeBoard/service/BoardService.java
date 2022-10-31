package org.freeBoard.service;

import org.freeBoard.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);

	public BoardVO get(Long bno);

	public boolean modify(BoardVO board);

	public boolean remove(Long bno);
	
	public int getTotal(Criteria cri);
}
