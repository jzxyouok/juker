package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.Role;
import cn.juke.util.Page;

public interface RoleDao extends GenericDao<Role>
{
	 
	 public List<Role> search(Page page);
	 
	 public List<Role> search(Page page,Long comid);
}
