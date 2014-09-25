package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.RoleDao;
import cn.juke.admin.daoimpl.RoleDaoImpl;
import cn.juke.admin.service.RoleService;
import cn.juke.bean.Role;
import cn.juke.util.Page;

public class RoleServiceImpl implements RoleService {

	private RoleDao hd = new RoleDaoImpl();

	@Override
	public void create(Role user) {
		hd.create(user);
	}

	@Override
	public void update(Role user) {
		hd.update(user);
	}

	@Override
	public void delete(Long id) {
		hd.delete(getRole(id));
	}

	@Override
	public Role getRole(Long id) {
		return hd.query(id);
	}

	public List<Role> search(Page page) {
		return hd.search(page);
	}

	public List<Role> search(Page page, Long comid) {
		return hd.search(page, comid);
	}
}
