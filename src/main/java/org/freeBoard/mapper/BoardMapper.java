package org.freeBoard.mapper;

import org.freeBoard.domain.BoardVO;

public interface BoardMapper {
	
	public void insert(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
