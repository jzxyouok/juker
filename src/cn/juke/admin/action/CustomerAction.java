package cn.juke.admin.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.juke.admin.service.CustomerService;
import cn.juke.admin.service.DealService;
import cn.juke.admin.serviceImpl.CustomerServiceImpl;
import cn.juke.admin.serviceImpl.DealServiceImpl;
import cn.juke.bean.Customer;
import cn.juke.bean.Deal;
import cn.juke.util.Page;

import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends BaseAction implements ModelDriven<Customer> {

	private CustomerService hs = new CustomerServiceImpl();
	private DealService ds = new DealServiceImpl();
	private Set<Integer> scustomers = new HashSet<Integer>();
	private List<Customer> customers;
	private Customer customer;
	private Integer cstatus;
	private Long hid;
	private int to_status;
	private int operate;
	private Page page;
	private String t_status;// 批量操作时隐藏的参数
	private String der;

	public String getDer() {
		return der;
	}

	public void setDer(String der) {
		this.der = der;
	}

	public Set<Integer> getScustomers() {
		return scustomers;
	}

	public void setScustomers(Set<Integer> scustomers) {
		this.scustomers = scustomers;
	}

	public String getT_status() {
		return t_status;
	}

	public void setT_status(String t_status) {
		this.t_status = t_status;
	}

	public Integer getCstatus() {
		return cstatus;
	}

	public void setCstatus(Integer cstatus) {
		this.cstatus = cstatus;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getOperate() {
		return operate;
	}

	public void setOperate(int operate) {
		this.operate = operate;
	}

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String list() {
		int s = cstatus == null ? -1 : cstatus;
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			customers = hs.search(page, s);
		} else {
			 if (s < 2)
				customers = hs.search(page, s);
			else
				customers = hs.search(page,username,s);
		}
		if(s==-1){
			return "ok";
		}
		return SUCCESS;
	}

	public String stats() {
		Deal dDeal = ds.getDeal(hid);
		cstatus = dDeal.getStatus();
		System.out.println("hid==" + hid + " dDeal==" + dDeal);
		if (to_status == 2)
			dDeal.setDealer(der);
		else if (to_status == 1)
			dDeal.setDealer(null);
		dDeal.setStatus(to_status);
		ds.update(dDeal);
		customers = hs.search(page, cstatus, getComid());

		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			customers = hs.search(page, cstatus);
		} else
			customers = hs.search(page, cstatus, comid);
		return SUCCESS;

	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public String update() throws Exception {
		Iterator<Integer> ii = scustomers.iterator();
		to_status = Integer.parseInt(t_status);
		while (ii.hasNext()) {
			int i = ii.next();
			Deal dd = ds.getDeal(new Long(i));
			System.out.println(dd);
			cstatus = dd.getStatus();
			dd.setStatus(to_status);
			if (to_status == 1)
				dd.setDealer(null);
			ds.update(dd);
		}
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			customers = hs.search(page, cstatus);
		} else
			customers = hs.search(page, cstatus, comid);
		return SUCCESS;
	}

	public int getTo_status() {
		return to_status;
	}

	public void setTo_status(int to_status) {
		this.to_status = to_status;
	}

	public String byName() {
		String name;
		try {
			name = new String((customer.getName()).getBytes("ISO-8859-1"),
					"UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		customer.setName(name);
		if (page == null)
			page = new Page();
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		page.setPageIndex(1);
		if ("admin".equals(username)) {
			customers = hs.search(name, page);
		} else
			customers = hs.search(name, page, comid);
		return SUCCESS;
	}

	@Override
	public Customer getModel() {
		if (customer == null)
			customer = new Customer();
		return customer;
	}
}
