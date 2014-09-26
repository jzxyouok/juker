package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.DealDao;
import cn.juke.admin.daoimpl.DealDaoImpl;
import cn.juke.admin.service.DealService;
import cn.juke.bean.Deal;
import cn.juke.util.Page;

public class DealServiceImpl implements DealService {

	private DealDao dd = new DealDaoImpl();

	@Override
	public void create(Deal deal) {
		dd.create(deal);
	}

	@Override
	public void update(Deal deal) {
		dd.update(deal);
	}

	@Override
	public void delete(Long id) {
		dd.delete(getDeal(id));
	}

	@Override
	public Deal getDeal(Long id) {
		return dd.query(id);
	}

	public List<Deal> search(Page page) {
		return dd.search(page);
	}

	public List<Deal> search(Page page, String state) {
		return dd.search(page, state);
	}

	public List<Deal> search(Page page, String state, Long comid) {
		return dd.search(page, state, comid);
	}

	public List<Deal> search(Long comid, Page page) {
		return dd.search(comid, page);
	}

	public List<Deal> searchByBroker(Long broker_id, Page page) {
		return dd.searchByBroker(broker_id, page);
	}
}
