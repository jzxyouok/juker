package cn.juke.admin.serviceImpl;

import java.util.List;

import cn.juke.admin.dao.TreeNodeDao;
import cn.juke.admin.daoimpl.TreeNodeDaoImpl;
import cn.juke.admin.service.TreeNodeService;
import cn.juke.bean.TreeNode;
import cn.juke.util.Page;

public class TreeNodeServiceImpl implements TreeNodeService {

	private TreeNodeDao hd = new TreeNodeDaoImpl();

	@Override
	public void create(TreeNode treeNode) {
		hd.create(treeNode);
	}

	@Override
	public void update(TreeNode treeNode) {
		hd.update(treeNode);
	}

	@Override
	public void delete(Long id) {
		hd.delete(get(id));
	}

	@Override
	public TreeNode get(Long id) {
		return hd.query(id);
	}
    
	public List<TreeNode> search(Page page) {
		return hd.search(page);
	}

	public List<TreeNode> search(Page page, Long comid) {
		return hd.search(page, comid);
	}
    
	public List<TreeNode> search() {
		return hd.search();
	}
}
