package com.fastcampus.ch4.domain;

public class PageHandler {
	int totalCnt;      // 총 게시물 갯수
	int pageSize;      // 한 페이지의 크기(페이지 내의 게시물 수)
	int naviSize = 10; // 페이지 네비게이션의 크기
	int totalPage;     // 전체 페이지의 갯수
	int page;          // 현재 페이지
	int startPage;     // 네비게이션의 첫페이지
	int endPage;       // 네비게이션의 마지막페이지
	boolean showPrev;  // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
	boolean showNext;  // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부
	
	public PageHandler(int totalCnt, int page) {
		this(totalCnt, page, 10);
	}
	public PageHandler(int totalCnt, int page, int pageSize) {
		this.totalCnt = totalCnt;
		this.page = page;
		this.pageSize = pageSize;
		
		totalPage = (int)Math.ceil(totalCnt / (float)pageSize);           // 나머지가 있을 경우엔 +1 해줘야 하므로 ceil(올림) 사용
		startPage = page / naviSize * naviSize + 1;                // 현재 페이지 / 네비게이션 사이즈 * 네비게이션 사이즈 => 현재 페이지의 1의 자리수 버리기 + 1 => startPage의 1의 자리는 1임
		endPage = Math.min((startPage + naviSize) - 1, totalPage); // endPage가 toTalPage보다 작을경우가 있으므로 둘 중 작은값을 사용하기
		showPrev = startPage != 1;
		showNext = endPage != totalPage;
	}
	
	void print() {
		System.out.println("page = " + page);
		System.out.print(showPrev ? "[PREV] " : "");
		for(int i = startPage; i <= endPage; i++) {
			System.out.print(i+ " ");
		}
		System.out.println(showNext ? " [NEXT]" : "");
		
	}
	
	@Override
	public String toString() {
		return "PageHandler [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", naviSize=" + naviSize
				+ ", totalPage=" + totalPage + ", page=" + page + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", showPrev=" + showPrev + ", showNext=" + showNext + "]";
	}
	
	
}
