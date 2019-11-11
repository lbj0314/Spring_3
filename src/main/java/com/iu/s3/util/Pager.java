package com.iu.s3.util;

public class Pager {
	
	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	public Pager() {
		perPage = 10;
	}
	
	public Integer getCurPage() {
		if (this.curPage == null) {
			this.curPage = 1;
		}
		
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
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
	
	public void makePager(int totalCount) {
		//1. 전체 글의 개수

		//2. 전체 페이지의 개수
		int totalPage = totalCount / perPage;
		if (totalCount%perPage != 0) {
			totalPage = totalPage + 1;
		}
		System.out.println("totalPage "+totalPage);
		//3. 전체 블락의 개수
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if (totalPage%perBlock != 0) {
			totalBlock = totalBlock + 1;
		}
		System.out.println("total block "+totalBlock);
		//4. curPage를 이용해서 curBlock이 무엇인가?
		curBlock = curPage/perBlock;
		if (curPage%perBlock != 0) {
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
	
	public RowMaker makeRow() {
		//ROWNUM 계산
		int startRow = (this.getCurPage() - 1) * perPage + 1;
		int lastRow = this.getCurPage() * perPage;
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
	}
	
}
