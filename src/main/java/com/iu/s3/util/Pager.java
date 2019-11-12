package com.iu.s3.util;

public class Pager {
	
	public Pager() {
		perPage = 10;
	}
	
	private Integer curPage; //현재 페이지 번호
	private Integer perPage; //불러올 때 글의 개수
	//DB
	private Integer startRow; // 시작 rowNum
	private Integer lastRow; // 끝 rowNum
	//view (jsp)
	private Integer startNum; //시작 번호
	private Integer lastNum; //끝 번호
	private Integer curBlock; //현재 블락 번호
	private Integer totalBlock; //전체 블락의 개수

	//search
	private String kind; // 검색 종류
	private String search; // 검색어
	
	public Integer getCurPage() {
		if (this.curPage == null || this.curPage == 0) {
			this.curPage = 1;
		}		
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if (this.perPage == null || this.perPage == 0) {
			this.perPage = 10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public Integer getCurBlock() {
		return curBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	
	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getLastRow() {
		return lastRow;
	}

	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
//		search = "%"+search+"%";
		if (this.search == null) {
			search = "";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	public void makePager(int totalCount) {
		//1. 전체 글의 개수

		//2. 전체 페이지의 개수
		int totalPage = totalCount / this.getPerPage();
		if (totalCount%this.getPerPage() != 0) {
			totalPage = totalPage + 1;
		}
		System.out.println("totalPage "+totalPage);
		
		//3. 전체 블락의 개수
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if (totalPage%perBlock != 0) {
			totalBlock = totalBlock + 1;
		}
		System.out.println("total block " + totalBlock);
		//4. curPage를 이용해서 curBlock이 무엇인가?
		curBlock = this.getCurPage()/perBlock;
		if (this.getCurPage()%perBlock != 0) {
			curBlock = curBlock + 1;
		}
		System.out.println("cur block "+curBlock);
		System.out.println("------------------");
		//5. curBlock으로 startNum, lastNum 구하기
		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		if (curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
	}
	
	public void makeRow() {
		//ROWNUM 계산
		this.startRow = (this.getCurPage() - 1) * this.perPage + 1;
		this.lastRow = this.getCurPage() * this.perPage;
		
		this.setStartRow(startRow);
		this.setLastRow(lastRow);
		
		
	}
	
}
