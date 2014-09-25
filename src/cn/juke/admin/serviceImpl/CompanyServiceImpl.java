package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.CompanyDao;
import cn.juke.admin.daoimpl.CompanyDaoImpl;
import cn.juke.admin.service.CompanyService;
import cn.juke.bean.Company;
import cn.juke.util.Page;

public class CompanyServiceImpl implements CompanyService {

	private CompanyDao dd = new CompanyDaoImpl();

	@Override
	public void create(Company Company) {
		dd.create(Company);
	}

	@Override
	public void update(Company Company) {
		dd.update(Company);
	}

	@Override
	public void delete(Long id) {
		dd.delete(get(id));
	}

	@Override
	public Company get(Long id) {
		return dd.query(id);
	}

	public List<Company> search(Page page) {
		return dd.search(page);
	}

	public List<Company> search() {
		return dd.search();
	}

	public List<Company> search(String name) {
		return dd.search(name);
	}
}
