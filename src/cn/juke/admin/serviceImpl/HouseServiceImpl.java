package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.HouseDao;
import cn.juke.admin.daoimpl.HouseDaoImpl;
import cn.juke.admin.service.HouseService;
import cn.juke.bean.House;
import cn.juke.util.Page;

public class HouseServiceImpl implements HouseService {

	private HouseDao hd = new HouseDaoImpl();

	@Override
	public void create(House house) {
		hd.create(house);
	}

	@Override
	public void update(House house) {
		hd.update(house);
	}

	@Override
	public void delete(Long id) {
		hd.delete(getHouse(id));
	}

	@Override
	public House getHouse(Long id) {
		return hd.query(id);
	}

	@Override
	public House searchForObject(String houseName) {
		return hd.search(houseName);
	}

	public List<House> search(Page page,Long comid) {
		return hd.search(page,comid);
	}
	
	public List<House> search(Page page){
		return hd.search(page);
	}
}
