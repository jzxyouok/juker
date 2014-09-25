package cn.juke.admin.service;

import java.util.List;

import cn.juke.bean.Role;
import cn.juke.util.Page;

public interface RoleService {
		
	public void create(Role Role);
	
	public void update(Role Role);
	
	public void delete(Long id);
	
	public Role getRole(Long id);
	
	public List<Role> search(Page page);
	
	public List<Role> search(Page page,Long comid);
	
}
