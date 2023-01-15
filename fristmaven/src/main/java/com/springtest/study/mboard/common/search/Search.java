package com.springtest.study.mboard.common.search;

public class Search extends BaseSearch{ //		BaseSearch 상속받아서 BaseSearch의 변수와 getter setter를 사용할수 있다.

	/**
	 * 
	 */
	private static final long serialVersionUID = 239812573556189761L;

	// 페이징 객체
	private Paging paging = null;

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
