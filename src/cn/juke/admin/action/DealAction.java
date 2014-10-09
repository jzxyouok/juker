package cn.juke.admin.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.juke.admin.service.DealService;
import cn.juke.admin.serviceImpl.DealServiceImpl;
import cn.juke.bean.Deal;
import cn.juke.util.Page;

import com.opensymphony.xwork2.ModelDriven;

public class DealAction extends BaseAction implements ModelDriven<Deal> {

	private List<Deal> deals;
	private Deal deal;
	private DealService ds = new DealServiceImpl();
	private Long did;
	private Page page;
	private String dstate;
	private Integer type;
	private Set<Integer> sdeals = new HashSet<Integer>();

	public Set<Integer> getSdeals() {
		return sdeals;
	}

	public void setSdeals(Set<Integer> sdeals) {
		this.sdeals = sdeals;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDstate() {
		return dstate;
	}

	public void setDstate(String dstate) {
		this.dstate = dstate;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	@Override
	public Deal getModel() {
		if (deal == null)
			deal = new Deal();
		return deal;
	}

	public String list() {
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");

		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			if (dstate == null)
				deals = ds.search(page);
			else
				deals = ds.search(page, dstate);
		} else {
			if (dstate == null)
				deals = ds.search(comid, page);
			else
				deals = ds.search(page, dstate, comid);
		}
		if (type == 0)
			{
			
			return "search";
			
			}
		return "success";
	}

	public String update() {
//		System.out.println(did);
		Deal d = ds.getDeal(did);
		d.setCstate(deal.getCstate());
		d.setCommision(deal.getCommision());
		d.setDealtime(deal.getDealtime());
		d.setMoney(deal.getMoney());
		d.setHouse_type(deal.getHouse_type());
		ds.update(d);

		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			if (dstate == null)
				deals = ds.search(page);
			else
				deals = ds.search(page, dstate);
		} else {
			if (dstate == null)
				deals = ds.search(comid, page);
			else
				deals = ds.search(page, dstate, comid);
		}
		return SUCCESS;
	}

	public String edit() {
		Iterator<Integer> ii = sdeals.iterator();
		while (ii.hasNext()) {
			Deal d = ds.getDeal(new Long(ii.next()));
			d.setCstate("1");
			ds.update(d);
		}
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			deals = ds.search(page, dstate);
		} else {
			deals = ds.search(page, dstate, comid);
		}
		return SUCCESS;
	}

	public String detail() {
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		deals = ds.searchByBroker(did, page);
		return "success";
	}
	
	public String modify(){
		
		Deal d = ds.getDeal(did);
		d.setCstate("1");
		ds.update(d);

		System.out.println("DState=="+dstate);
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			if (dstate == null)
				deals = ds.search(page);
			else
				deals = ds.search(page, dstate);
		} else {
			if (dstate == null)
				deals = ds.search(comid, page);
			else
				deals = ds.search(page, dstate, comid);
		}
		return SUCCESS;
	}
	
	public String listAll() {
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");

		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username)) {
			if (dstate == null)
				deals = ds.search(page);
			else
				deals = ds.search(page, dstate);
		} else {
			if (dstate == null)
				deals = ds.search(comid, page);
			else
				deals = ds.search(page, dstate, comid);
		}
		return "success";
	}
}
