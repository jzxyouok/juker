package cn.juke.admin.service;

import java.util.List;

import cn.juke.bean.House;
import cn.juke.bean.User;
import cn.juke.util.Page;

public interface UserService {
		
	public void create(User User);
	
	public void update(User User);
	
	public void delete(Long id);
	
	public User getUser(Long id);
	
	public User searchForObject(String UserName, String password);
	
	public List<User> search(Page page);
	
	public User search(String username);
	
	public List<User> search(Page page,Long comid);
	
}
