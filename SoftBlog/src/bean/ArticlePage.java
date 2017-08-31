package bean;

import java.util.List;

public class ArticlePage {
	private int countSize=0;//总记录数
	private int countPage=1;//总页数
	private int pageSize=5;//每页的记录数（可以得到）
	private int pageIndex=1;//当前页
	private int startIndex=1;//当前最小记录下标
	private int endIndex=5;//当前最大记录下标
	private boolean hasLastPage=false;//是否有上一页
	private boolean hasNextPage=false;//是否有下一页
	private List<Article> list=null;//当前页的数据
	
	public ArticlePage(){
	}
	
	
	
	public ArticlePage(int countSize, int pageSize,int pageIndex,List<Article> list)
	{
		
	}



	public int getCountSize()
	{
		return countSize;
	}
	public void setCountSize(int countSize)
	{
		this.countSize = countSize;
	}
	public int getCountPage()
	{
		return countPage;
	}
	public void setCountPage(int countPage)
	{
		this.countPage = countPage;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getStartIndex()
	{
		return startIndex;
	}
	public void setStartIndex(int startIndex)
	{
		this.startIndex = startIndex;
	}
	public int getEndIndex()
	{
		return endIndex;
	}
	public void setEndIndex(int endIndex)
	{
		this.endIndex = endIndex;
	}
	public boolean isHasLastPage()
	{
		return hasLastPage;
	}
	public void setHasLastPage(boolean hasLastPage)
	{
		this.hasLastPage = hasLastPage;
	}
	public boolean isHasNextPage()
	{
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage)
	{
		this.hasNextPage = hasNextPage;
	}
	public List<Article> getList()
	{
		return list;
	}
	public void setList(List<Article> list)
	{
		this.list = list;
	}
	
	
	public void initAP(){
		this.countPage=countSize%pageSize==0?countSize/pageSize:countSize/pageSize+1;
		this.startIndex=(pageIndex-1)*pageSize+1;
		this.endIndex=pageIndex*pageSize;
		if(pageIndex>1){
			this.hasLastPage=true;
		}else{
			this.hasLastPage=false;
		}
		
		if(countPage>pageIndex){
			this.hasNextPage=true;
		}else{
			this.hasNextPage=false;
		}
	}
}
