package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.User;
import cn.juke.util.Page;

public interface UserDao extends GenericDao<User>
{
	 public User search(String HouseName, String password);
	 
	 public User search(String username);
	 
	 public List<User> search(Page page);
	 
	 public List<User> search(Page page,Long comid);
}
