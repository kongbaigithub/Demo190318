package ssm.blog.entity;

import java.util.List;

public class PageBean<T> {

	private int currPage;//当前页数
	private int pageSize;//每页个数
	private long total;//总记录数
	private int start;
	private int end;
	private List<T> result;//分页查询的结果
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int currPage, int pageSize) {
		this.currPage = currPage;
        this.pageSize = pageSize;
        this.start = (currPage-1)*pageSize;
//        this.end = currPage*pageSize;
        this.end = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(Long long1) {
		this.total = long1;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", total=" + total + ", start=" + start
				+ ", end=" + end + ", result=" + result + "]";
	}
	
	
}
