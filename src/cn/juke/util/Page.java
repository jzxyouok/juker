package cn.juke.util;

public class Page
{
	public static int DEFAULT_PAGE_SIZE = 10;
	private int pageSize;
	
	private int pageIndex=1;
	
	private int totalCount;
	
	private int pageCount;
	
	public Page()
	{
		pageSize = DEFAULT_PAGE_SIZE;
	}
	
	public int getPageIndex()
	{
		return pageIndex;
	}
	
	public int getPageCount()
	{
		return pageCount;
	}
	
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	
	public int getTotalCount()
	{
		return totalCount;
	}
	
	public int getPageSize()
	{
		return pageSize;
	}
	
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	
	public int getFirstResult()
	{
		return (pageIndex - 1) * pageSize;
	}
	
	public boolean isEmpty()
	{
		return totalCount == 0;
	}
	
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
		pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
		if (totalCount == 0)
		{
			if (pageIndex != 1)
				throw new IndexOutOfBoundsException("Page index out of range");
		}
		else if (pageIndex > pageCount)
		{
			if(pageIndex==pageCount+1)
				pageIndex=pageCount;
			else throw new IndexOutOfBoundsException("Page index out of range");
			}
	}
	
	public boolean getHasPrevious()
	{
		return pageIndex > 1;
	}
	
	public boolean getHasNext()
	{
		return pageIndex < pageCount;
	}
	
	@Override
	public String toString()
	{
		return "共有" + totalCount + "条记录," + pageCount + "页，当前页为" + pageIndex;
	}
}
