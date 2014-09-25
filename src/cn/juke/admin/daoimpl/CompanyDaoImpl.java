package cn.juke.admin.daoimpl;

import java.util.List;

import cn.juke.admin.dao.CompanyDao;
import cn.juke.bean.Company;
import cn.juke.util.Page;

public class CompanyDaoImpl extends GenericHibernateDao<Company> implements
		CompanyDao {
	public CompanyDaoImpl() {
		super(Company.class);

	}

	public List<Company> search(Page page) {
		return queryForList("select count(*) from Company", "from Company",
				null, page);
	}

	public List<Company> search() {
		return queryForList("from Company");
	}
	
	public List<Company> search(String name){
		return queryForList("from Company c where c.name = ?",new Object[]{name});
	}
}
