package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.House;
import cn.juke.util.Page;

public interface HouseDao extends GenericDao<House>
{
	 public House search(String HouseName);
	 
	 public List<House> search(Page page,Long comid);
	 
	 public List<House> search(Page page);
	  
}
