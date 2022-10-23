package org.freeBoard.mapper;

import org.freeBoard.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(String userid);
}
