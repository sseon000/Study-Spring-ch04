package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
//	private int page;           // 현재 페이지
//	private int pageSize;       // 한 페이지의 크기(페이지 내의 게시물 수)
//	private String option;      // 검색 옵션
//	private String keyword;     // 검색 키워드
	private SearchCondition sc; // 상위 4개 클래스화
	private int totalCnt;       // 총 게시물 갯수
	private int naviSize = 10;  // 페이지 네비게이션의 크기
	private int totalPage;      // 전체 페이지의 갯수
	private int startPage;      // 네비게이션의 첫페이지
	private int endPage;        // 네비게이션의 마지막페이지
	private boolean showPrev;   // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
	private boolean showNext;   // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부
	
	public PageHandler(int totalCnt, SearchCondition sc) {
		this.totalCnt = totalCnt;
		this.sc = sc;
		
		doPaging(totalCnt, sc);
	}
	
	public void doPaging(int totalCnt, SearchCondition sc) {
		this.totalCnt = totalCnt;
		
		totalPage = (int)Math.ceil(totalCnt / (float)sc.getPageSize()); // 나머지가 있을 경우엔 +1 해줘야 하므로 ceil(올림) 사용
		startPage = (sc.getPage()-1) / naviSize * naviSize + 1;         // 현재 페이지 / 네비게이션 사이즈 * 네비게이션 사이즈 => 현재 페이지의 1의 자리수 버리기 + 1 => startPage의 1의 자리는 1임
		endPage = Math.min((startPage + naviSize) - 1, totalPage);      // endPage가 toTalPage보다 작을경우가 있으므로 둘 중 작은값을 사용하기
		showPrev = startPage != 1;
		showNext = endPage != totalPage;
	}
	
	public SearchCondition getSc() {
		return sc;
	}

	public void setSc(SearchCondition sc) {
		this.sc = sc;
	}
	
	public int getTotalCnt() {
		return totalCnt;
	}
	
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	public int getNaviSize() {
		return naviSize;
	}
	
	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean isShowPrev() {
		return showPrev;
	}
	
	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}
	
	public boolean isShowNext() {
		return showNext;
	}
	
	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}
	
	void print() {
		System.out.println("page = " + sc.getPage());
		System.out.print(showPrev ? "[PREV] " : "");
		for(int i = startPage; i <= endPage; i++) {
			System.out.print(i+ " ");
		}
		System.out.println(showNext ? " [NEXT]" : "");
		
	}

	@Override
	public String toString() {
		return "PageHandler [sc=" + sc + ", totalCnt=" + totalCnt + ", naviSize=" + naviSize + ", totalPage="
				+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", showPrev=" + showPrev
				+ ", showNext=" + showNext + "]";
	}
	
}
