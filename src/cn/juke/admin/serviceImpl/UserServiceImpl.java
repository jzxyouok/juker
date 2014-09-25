package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.UserDao;
import cn.juke.admin.daoimpl.UserDaoImpl;
import cn.juke.admin.service.UserService;
import cn.juke.bean.User;
import cn.juke.util.Page;

public class UserServiceImpl implements UserService {

	private UserDao hd = new UserDaoImpl();

	@Override
	public void create(User user) {
		hd.create(user);
	}

	@Override
	public void update(User user) {
		hd.update(user);
	}

	@Override
	public void delete(Long id) {
		hd.delete(getUser(id));
	}

	@Override
	public User getUser(Long id) {
		return hd.query(id);
	}

	@Override
	public User searchForObject(String userName, String password) {
		return hd.search(userName, password);
	}

	public List<User> search(Page page) {
		return hd.search(page);
	}
	
	public User search(String username){
		return hd.search(username);
	}
	
	public List<User> search(Page page,Long comid){
		return hd.search(page, comid);
	}
}
