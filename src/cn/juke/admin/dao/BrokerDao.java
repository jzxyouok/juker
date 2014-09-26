package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.Broker;
import cn.juke.util.Page;

public interface BrokerDao extends GenericDao<Broker>
{
	 public List<Broker> search(String name,Page page,Long comid);
	 
	 public List<Broker> search(String name,Page page);
	 
	 public List<Broker> search(Page page,Long comid);
	 
	 public List<Broker> search(Page page);
	 
	 public List<Broker> search(Page page,Long comid,Integer crflag);
	 
	 public List<Broker> search(Integer crflag,Page page);
	 
}
