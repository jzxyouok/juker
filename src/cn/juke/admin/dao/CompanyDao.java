package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.Company;
import cn.juke.util.Page;

public interface CompanyDao extends GenericDao<Company> {
	
	public List<Company> search(Page page);
    
	public List<Company> search();
}
