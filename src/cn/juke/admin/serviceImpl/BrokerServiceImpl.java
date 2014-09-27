package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.BrokerDao;
import cn.juke.admin.daoimpl.BrokerDaoImpl;
import cn.juke.admin.service.BrokerService;
import cn.juke.bean.Broker;
import cn.juke.util.Page;

public class BrokerServiceImpl implements BrokerService {

	private BrokerDao hd = new BrokerDaoImpl();

	@Override
	public void create(Broker broker) {
		hd.create(broker);
	}

	@Override
	public void update(Broker broker) {
		hd.update(broker);
	}

	@Override
	public void delete(Long id) {
		hd.delete(getBroker(id));
	}

	@Override
	public Broker getBroker(Long id) {
		return hd.query(id);
	}

	@Override
	public List<Broker> search(String name, Page page, Long comid) {
		return hd.search(name, page, comid);
	}

	public List<Broker> search(Page page, Long comid) {
		return hd.search(page, comid);
	}

	public List<Broker> search(Page page) {
		return hd.search(page);
	}

	public List<Broker> search(String name, Page page) {
		return hd.search(name, page);
	}

	public List<Broker> search(Page page, Long comid, Integer crflag,Integer type) {
		return hd.search(page, comid, crflag, type);
	}

	public List<Broker> search(Integer crflag, Page page,Integer type) {
		return hd.search(crflag, page,type);
	}

}
