package cn.juke.admin.daoimpl;

import java.util.List;

import cn.juke.admin.dao.RoleDao;
import cn.juke.bean.Role;
import cn.juke.util.Page;

public class RoleDaoImpl extends GenericHibernateDao<Role> implements RoleDao
{
    public RoleDaoImpl() {
        super(Role.class);

    }

    public List<Role> search(Page page)
    {
    	return queryForList("select count(*) from Role","from Role",null, page);
    }
   
    public List<Role> search(Page page,Long comid )
    {
        return queryForList("select count(*) from Role r where r.comid = ?", "from Role r where  r.comid = ? ",new Object[]{comid}, page);
    }
    
}
