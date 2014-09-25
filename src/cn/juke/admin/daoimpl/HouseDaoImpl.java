package cn.juke.admin.daoimpl;

import java.util.List;

import cn.juke.admin.dao.HouseDao;
import cn.juke.bean.House;
import cn.juke.util.Page;

public class HouseDaoImpl extends GenericHibernateDao<House> implements HouseDao
{
    public HouseDaoImpl() {
        super(House.class);

    }

    public House search(String HouseName)
    {
        return (House) queryForObject("from House u where u.housename=? ",
                new Object[] { HouseName });
    }
    
    public List<House> search(Page page,Long comid)
    {
        return queryForList("select count(*) from House h where h.comid=? ", "from House h where h.comid=?",new Object[]{comid},
                page);
    }
   
    public List<House> search(Page page)
    {
        return queryForList("from House", null, page);
    }
    
}
