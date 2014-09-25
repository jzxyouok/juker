package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.Deal;
import cn.juke.util.Page;

public interface DealDao extends GenericDao<Deal>
{	 
	 
	 public List<Deal> search(Page page);
	 
	 public List<Deal> search(Page page,String state);
	 
	 public List<Deal> search(Page page,String state,Long comid);

	 public List<Deal> search(Long comid,Page page);
}
