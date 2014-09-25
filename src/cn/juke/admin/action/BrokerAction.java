package cn.juke.admin.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.juke.admin.service.BrokerService;
import cn.juke.admin.serviceImpl.BrokerServiceImpl;
import cn.juke.bean.Broker;
import cn.juke.util.Page;

import com.opensymphony.xwork2.ModelDriven;

public class BrokerAction extends BaseAction implements ModelDriven<Broker> {

	private Broker broker;
	private List<Broker> brokers;
	private BrokerService bs = new BrokerServiceImpl();
	private Page page;
	private Long bid;
	private String username;
    private Set<Integer> sbrokers=new HashSet<Integer>();
	
	public Set<Integer> getSbrokers() {
		return sbrokers;
	}

	public void setSbrokers(Set<Integer> sbrokers) {
		this.sbrokers = sbrokers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Broker getModel() {
		if (broker == null)
			broker = new Broker();
		return broker;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public List<Broker> getBrokers() {
		return brokers;
	}

	public void setBrokers(List<Broker> brokers) {
		this.brokers = brokers;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String list() {
		System.out.println(page);
		if (page == null){
			page = new Page();
			page.setPageIndex(1);}
		Long comid = (Long) getSession().get("comid");
		username = (String) getSession().get("username");
	
		if ("admin".equals(username)) {
			brokers = bs.search( page);
		} else
			brokers = bs.search(page, comid);
		return SUCCESS;
	}

	 public String delete(){
	 broker=bs.getBroker(bid);
	 broker.setState(0);
	 bs.update(broker);
	 return list();
	 }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String listByName() {
		String name;
		try{
		name= new String((broker.getName()).getBytes("ISO-8859-1"),"UTF-8"); 
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		broker.setName(name);
		if (page == null)
			page = new Page();
		Long comid = (Long) getSession().get("comid");
		String username = (String) getSession().get("username");
		page.setPageIndex(1);
		if("admin".equals(username)) {
			brokers = bs.search(name, page);
		} else
			brokers = bs.search(name, page, comid);
		return SUCCESS;
	}
	
	public String edits(){
		Iterator<Integer> ii=sbrokers.iterator();
		while(ii.hasNext()){
			Integer i=ii.next();
			Broker b=bs.getBroker(new Long(i));
			b.setState(0);
			bs.update(b);
		}
		return list();
	}
}
