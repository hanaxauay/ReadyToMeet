package com.final2.readytomeet.dto;

public class Pagination {

	/** 1. 페이지 당 보여지는 게시글의 최대 개수 **/
	private int pageSize = 13;

	/** 2. 페이징된 버튼의 블럭당 최대 개수 **/
	private int blockSize = 5;

	/** 3. 현재 페이지 **/
	private int page = 1;

	/** 4. 현재 블럭 **/
	private int block = 1;

	/** 5. 총 게시글 수 **/
	private int totalListCnt;

	/** 6. 총 페이지 수 **/
	private int totalPageCnt;

	/** 7. 총 블럭 수 **/
	private int totalBlockCnt;

	/** 8. 블럭 시작 페이지 **/
	private int startPage = 1;

	/** 9. 블럭 마지막 페이지 **/
	private int endPage = 1;

	/** 10. DB 접근 시작 index **/
	private int startIndex = 0;

	/** 11. 이전 블럭의 마지막 페이지 **/
	private int prevBlock;

	/** 12. 다음 블럭의 시작 페이지 **/
	private int nextBlock;


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getTotalListCnt() {
		return totalListCnt;
	}

	public void setTotalListCnt(int totalListCnt) {
		this.totalListCnt = totalListCnt;
	}

	public int getTotalPageCnt() {
		return totalPageCnt;
	}

	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public int getTotalBlockCnt() {
		return totalBlockCnt;
	}

	public void setTotalBlockCnt(int totalBlockCnt) {
		this.totalBlockCnt = totalBlockCnt;
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

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public Pagination(int totalListCnt, int page) {
		setPage(page);
		setTotalListCnt(totalListCnt);

		if (totalListCnt > 0) {
			setTotalPageCnt((int) Math.ceil(totalListCnt * 1.0 / pageSize));
			setTotalBlockCnt((int) Math.ceil(totalPageCnt * 1.0 / blockSize));

			setBlock((int) Math.ceil((page * 1.0) / blockSize));
			setStartPage((block - 1) * blockSize + 1);
			setEndPage(startPage + blockSize - 1);
			if (endPage > totalPageCnt) {
				setEndPage(totalPageCnt);
			}
			setPrevBlock((block * blockSize) - blockSize);
			if (prevBlock < 1) {
				setPrevBlock(1);
			}
			setNextBlock((block * blockSize) + 1);
			if (nextBlock > totalPageCnt) {
				setNextBlock(totalPageCnt);
			}
			setStartIndex((page - 1) * pageSize);
		} else {
			// 검색 결과가 없는 경우 페이지네이션을 0으로 설정합니다.
			setTotalPageCnt(0);
			setTotalBlockCnt(0);
			setStartPage(0);
			setEndPage(0);
			setPrevBlock(0);
			setNextBlock(0);
			setStartIndex(0);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
