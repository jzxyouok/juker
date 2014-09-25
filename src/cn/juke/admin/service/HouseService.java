package cn.juke.admin.service;

import java.util.List;

import cn.juke.bean.House;
import cn.juke.util.Page;

public interface HouseService {
		
	public void create(House House);
	
	public void update(House House);
	
	public void delete(Long id);
	
	public House getHouse(Long id);
	
	public House searchForObject(String HouseName);
	
    public List<House> search(Page page,Long comid);
    
    public List<House> search(Page page);
	
}
