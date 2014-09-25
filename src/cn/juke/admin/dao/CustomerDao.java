package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.Customer;
import cn.juke.util.Page;

public interface CustomerDao extends GenericDao<Customer>
{
	 public  List<Customer> search(String customerName,Page page,Long comid);
	 
	 public  List<Customer> search(String customerName,Page page);
	 
	 public  List<Customer> search(Page page, int status,Long comid);
	 
	 public  List<Customer> search(Page page, int status);
	 
	 public  List<Customer> search(Page page);
}
