package cn.juke.admin.service;

import java.util.List;

import cn.juke.bean.Deal;
import cn.juke.util.Page;

public interface DealService {

	public void create(Deal deal);

	public void update(Deal deal);

	public void delete(Long id);

	public Deal getDeal(Long id);

	public List<Deal> search(Page page);

	public List<Deal> search(Page page, String state);

	public List<Deal> search(Page page, String state, Long comid);

	public List<Deal> search(Long comid, Page page);
	
	public List<Deal> searchByBroker(Long broker_id,Page page);

}
