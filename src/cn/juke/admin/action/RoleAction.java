package cn.juke.admin.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import cn.juke.admin.service.RoleService;
import cn.juke.admin.service.TreeNodeService;
import cn.juke.admin.service.UserService;
import cn.juke.admin.serviceImpl.RoleServiceImpl;
import cn.juke.admin.serviceImpl.TreeNodeServiceImpl;
import cn.juke.admin.serviceImpl.UserServiceImpl;
import cn.juke.bean.Role;
import cn.juke.bean.TreeNode;
import cn.juke.bean.User;
import cn.juke.util.Page;

import com.opensymphony.xwork2.ModelDriven;

public class RoleAction extends BaseAction implements ModelDriven<Role> {

	private List<Role> roles;

	private Page page;

	private Role role;

	private Long rid;

	private RoleService rs = new RoleServiceImpl();

	private UserService us = new UserServiceImpl();

	private TreeNodeService tns = new TreeNodeServiceImpl();

	private Set<TreeNode> havedNodes = new LinkedHashSet<TreeNode>();

	private Set<TreeNode> allNodes = new LinkedHashSet<TreeNode>();

	private Set<Integer> selectedNodes = new LinkedHashSet<Integer>();

	public Set<Integer> getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(Set<Integer> selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Set<TreeNode> getHavedNodes() {
		return havedNodes;
	}

	public void setHavedNodes(Set<TreeNode> havedNodes) {
		this.havedNodes = havedNodes;
	}

	public Set<TreeNode> getAllNodes() {
		return allNodes;
	}

	public void setAllNodes(Set<TreeNode> allNodes) {
		this.allNodes = allNodes;
	}

	@Override
	public Role getModel() {
		if (role == null)
			role = new Role();
		return role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String list() {
		String username = (String) getSession().get("username");
		System.out.println(getSession().get("comid"));
		Long comid = (Long) getSession().get("comid");
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username))
			roles = rs.search(page);
		else
			roles = rs.search(page, comid);

		System.out.println(roles);
		return "success";
	}

	public String update() {
		Long comid = (Long) getSession().get("comid");
		role = rs.getRole(rid);
		Set<TreeNode> nodes = new LinkedHashSet<TreeNode>();
		Iterator<Integer> t = selectedNodes.iterator();
		while (t.hasNext()) {
			Integer i = t.next();
			TreeNode node = tns.get(new Long(i));
			if (node.getParent().getParent().getId() == 1L) {
				System.out.println(node);
				nodes.add(node);
			}
		}
		role.setNodes(nodes);
		rs.update(role);
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		roles = rs.search(page, comid);
		return "success";
	}

	public String edit() {
		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		role = rs.getRole(rid);

		havedNodes = new LinkedHashSet<TreeNode>(role.getNodes());

		String username = (String) getSession().get("username");
		User u = us.search(username);
		if ("admin".equals(u.getUsername())) {
			allNodes = new LinkedHashSet<TreeNode>(tns.search());
			Iterator<TreeNode> ii = allNodes.iterator();
			while (ii.hasNext()) {
				TreeNode i=ii.next();
				System.out.println(i);
				if (i.getId()==1||i.getParent().getId() == 1)
					ii.remove();
			}
		}
		// 如果是管理员，获得所有菜单，否则只能分配自己有的菜单
		else {
			Iterator<Role> ir = u.getRoles().iterator();
			while (ir.hasNext()) {
				Role r = ir.next();
				{
					Iterator<TreeNode> nodes = r.getNodes().iterator();
					while (nodes.hasNext()) {
						TreeNode t = nodes.next();
						allNodes.add(t);
					}
				}
			}
		}

		allNodes.removeAll(havedNodes);
		return "success";
	}

	public String add() {
		String username = (String) getSession().get("username");
		Long comid = (Long) getSession().get("comid");
		if (!comid.equals(role.getComid()) && !username.equals("admin")) {
			role.setComid(comid);
		}
		role.setCreate_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date()));
		rs.create(role);

		if (page == null) {
			page = new Page();
			page.setPageIndex(1);
		}
		if ("admin".equals(username))
			roles = rs.search(page);
		else
			roles = rs.search(page, comid);

		return "success";
	}
}
