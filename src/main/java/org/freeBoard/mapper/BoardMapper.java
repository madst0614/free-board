package org.freeBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.freeBoard.domain.BoardVO;
import org.freeBoard.domain.Criteria;

public interface BoardMapper {
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
}
