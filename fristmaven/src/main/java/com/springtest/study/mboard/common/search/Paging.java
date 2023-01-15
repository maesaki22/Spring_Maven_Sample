package com.springtest.study.mboard.common.search;

import java.io.Serializable;

public class Paging implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8260325303653127704L;
	// 전체 레코드 수
	protected int recordTotalCount = 0;
	// 페이지 레코드 수 10
	protected int recordCountPerPage = 10;
	// 페이지 번호 
	protected int pageNo = 1;
	// 페이지 레코드 시작번호
	protected int pageStartRecordNo = 0;
	// 페이지 레코드 종료번호
	protected int pageEndRecordNo = 0;
	// 페이지 마지막 번호
	protected int pageLastNo = 0;
	
	public int getRecordTotalCount() {
		return recordTotalCount;
	}
	public void setRecordTotalCount(int recordTotalCount) {
		this.recordTotalCount = recordTotalCount;
	}
	
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		// 0 page 일경우 10으로 잡아줘야한다.
		if(recordCountPerPage<=0) {
			recordCountPerPage=10;
		}
		this.recordCountPerPage = recordCountPerPage;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(pageNo<=0) {
			pageNo = 1;
		}
		this.pageNo = pageNo;
	}
	public int getPageStartRecordNo() {
		return pageStartRecordNo;
	}
	public void setPageStartRecordNo(int pageStartRecordNo) {
		this.pageStartRecordNo = pageStartRecordNo;
	}
	public int getPageEndRecordNo() {
		return pageEndRecordNo;
	}
	public void setPageEndRecordNo(int pageEndRecordNo) {
		this.pageEndRecordNo = pageEndRecordNo;
	}
	public int getPageLastNo() {
		return pageLastNo;
	}
	public void setPageLastNo(int pageLastNo) {
		this.pageLastNo = pageLastNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	// 위의 정보로 페이징 함수 구현 (( oracle 과 mysql mariaDB 의 시작 시점이 다르다  oracle : 1  // 그외 0 시작 )) 두개의 조건을 만족시킬수 있게구현
	protected void process(boolean zero) {
		int startBase = 1;
		int endBase = 0;
		// 제로 베이스 
		if (zero) {
			startBase = 0;
			endBase = -1;
		}
		// 페이지 마지막 번호 설정
		// 나머지가 없으면 +0 // 나머지가 있다면 +1  :: 페이지 마지막번호에 0 or 1 추가
		// 레코드 번호
		pageLastNo = (recordTotalCount / recordCountPerPage) + (recordTotalCount % recordCountPerPage == 0 ? 0 : 1);
		if (pageLastNo > 0) {
			// 현재 페이지 번호가 페이지 마지막 번호도 크면 페이지 마지막 번호로 변경
			// 현재 페이지 번호가 페이지 마지막 번호와 같을 때 삭제가 발생할 경우 전체 레코드 수가 줄어 들어 페이지 마지막 번호가 줄어 들 경우 페이지 마지막 번호로 변경
			if (pageNo > pageLastNo) {
				pageNo = pageLastNo;
			}
			// 페이지의 레코드 시작 번호 설정
			pageStartRecordNo = ((pageNo - 1) * recordCountPerPage) + startBase;
			// 페이지의 레코드 종료 번호 설정
			pageEndRecordNo = pageNo * recordCountPerPage + endBase;
			// 페이지의 레코드 종료 번호가 전체 레코드 수보다 크면 전체 레코드 수로 변경
			if (pageEndRecordNo > (recordTotalCount + endBase)) {
				pageEndRecordNo = recordTotalCount + endBase;
			}
		} else {
			pageStartRecordNo = 0;
			pageEndRecordNo = 0;
			pageLastNo = 0;
		}
	}
	// mariaDB . mySQL  0베이스
	public void processZero() {
			process(true);
	}
	// Oracle   1베이스
	public void processOne() {
		process(false);
	}
}

