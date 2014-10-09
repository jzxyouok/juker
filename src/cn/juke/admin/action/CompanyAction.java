package cn.juke.admin.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import cn.juke.admin.service.CompanyService;
import cn.juke.admin.serviceImpl.CompanyServiceImpl;
import cn.juke.bean.Company;
import cn.juke.util.Page;

import com.opensymphony.xwork2.ModelDriven;

public class CompanyAction extends BaseAction implements ModelDriven<Company> {

	private Company company;
	private CompanyService cs = new CompanyServiceImpl();
	private String coms;
	private String message;
	private List<Company> companies = new ArrayList<Company>();
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMessage() {
		return message;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JSON(serialize = false)
	public Company getModel() {
		if (company == null)
			company = new Company();
		return company;
	}

	public String add() {
		if (null == company.getName() || company.getName().trim().length() < 2) {
			addFieldError("name", "开发商名字长度不能小于2");
			return INPUT;
		} else if ((cs.search(company.getName())).size() != 0) {
			addFieldError("name", "开发商名字已存在");
			return INPUT;
		}
		cs.create(company);
		message = company.getName() + "已創建成功!";
		return SUCCESS;
	}

	public String getComs() {
		return coms;
	}

	public void setComs(String coms) {
		this.coms = coms;
	}

	public String get() {
		List<Company> companies = cs.search();
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < companies.size(); i++) {
			Company c = companies.get(i);
			if (c.getId() != 1) {
				sb.append("{'id':'" + c.getId() + "','name':'" + c.getName()
						+ "'}");
				if (c.getId() != companies.size()) {
					sb.append(",");
				}
			}
		}
		sb.append("]");
		coms = sb.toString();
		return "success";
	}

	public String list() {
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		Company c = cs.get(new Long(1));
		companies = cs.search(page);
		companies.remove(c);
		return "success";
	}
}
