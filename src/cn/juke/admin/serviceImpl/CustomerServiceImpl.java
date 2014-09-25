package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.CustomerDao;
import cn.juke.admin.daoimpl.CustomerDaoImpl;
import cn.juke.admin.service.CustomerService;
import cn.juke.bean.Customer;
import cn.juke.util.Page;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao hd = new CustomerDaoImpl();

	@Override
	public void create(Customer customer) {
		hd.create(customer);
	}

	@Override
	public void update(Customer customer) {
		hd.update(customer);
	}

	@Override
	public void delete(Long id) {
		hd.delete(getCustomer(id));
	}

	@Override
	public Customer getCustomer(Long id) {
		return hd.query(id);
	}

	@Override
	public List<Customer> search(String customerName, Page page, Long comid)
	{
		return hd.search(customerName, page, comid);
	}

	public List<Customer> search(String customerName, Page page)
	{
		return hd.search(customerName, page);
	}

	public List<Customer> search(Page page, int status, Long comid){
		return hd.search( page,status,comid);
	}

	public List<Customer> search(Page page, int status){
		return hd.search(page, status);
	}

	public List<Customer> search(Page page)
	{
		return hd.search(page);
	}
}
