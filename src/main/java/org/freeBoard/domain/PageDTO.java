package org.freeBoard.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int start;
	private int end;
	private boolean prev, next;

	private Criteria criteria;
	private int total;

	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;

		this.end = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
		this.start = this.end - 9;

		int realEnd = (int) (Math.ceil(total * 1.0 / criteria.getAmount()));

		if (realEnd < this.end)
			this.end = realEnd;

		this.prev = this.start > 1;
		this.next = this.end < realEnd;
	}

}
