package cn.juke.admin.service;

import java.util.List;

import cn.juke.bean.Company;
import cn.juke.util.Page;

public interface CompanyService {

	public void create(Company Company);

	public void update(Company Company);

	public void delete(Long id);

	public Company get(Long id);

	public List<Company> search(Page page);

	public List<Company> search();
	
	public List<Company> search(String name);

}
