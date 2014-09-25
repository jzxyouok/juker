package cn.juke.admin.service;

import java.util.List;

import cn.juke.bean.Customer;
import cn.juke.util.Page;

public interface CustomerService {

	public void create(Customer customer);

	public void update(Customer customer);

	public void delete(Long id);

	public Customer getCustomer(Long id);

	public List<Customer> search(String customerName, Page page, Long comid);

	public List<Customer> search(String customerName, Page page);

	public List<Customer> search(Page page, int status, Long comid);

	public List<Customer> search(Page page, int status);

	public List<Customer> search(Page page);
	
	public  List<Customer> search(Page page,String dealer);
	 
	public  List<Customer> search(Page page,String dealer,int status);

}
