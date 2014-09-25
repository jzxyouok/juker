package cn.juke.admin.daoimpl;

import java.util.List;

import cn.juke.admin.dao.UserDao;
import cn.juke.bean.User;
import cn.juke.util.Page;

public class UserDaoImpl extends GenericHibernateDao<User> implements UserDao {
	public UserDaoImpl() {
		super(User.class);
	}

	public User search(String userName, String password) {
		return (User) queryForObject(
				"from User u where u.username=? and password=?", new Object[] {
						userName, password });
	}

	public User search(String userName) {
		return (User) queryForObject("from User u where u.username=?",
				new Object[] { userName });
	}

	public List<User> search(Page page) {
		return queryForList("select count(*) from User", "from User", null,
				page);
	}

	public List<User> search(Page page, Long comid) {
		return queryForList("select count(*) from User u where u.comid = ?",
				"from User u where u.comid = ?", new Object[] { comid }, page);
	}

}
