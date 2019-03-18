package ssm.blog.common;

public class Page {

	private int totalSize;//总条数
	private int start;//每页开始条数
	private int pageSize;//每页条数
	private int currPage;//当前页数
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	//总页数
	public int getTotalPage() {
		return (totalSize+pageSize-1)/pageSize;
	}
	
	//首页
	public int startPage() {
		return 1;
	}
	//上一页
	public int syyPage() {
		if(currPage <= startPage()) {
			return startPage();
		}
		return currPage-1;	
	}
	
	//下一页
	public int nextPage() {
		if(currPage >= lastPage()) {
			return lastPage();
		}
		return currPage+1;	
	}
	
	//尾页
	public int lastPage() {
		if(totalSize > 0) {
			return getTotalPage();
		}
		return 1;
	}
	
	//当前页开始条数
	public int pagestart() {
		start = pageSize*(currPage-1);
		return start;
	}
	
}
