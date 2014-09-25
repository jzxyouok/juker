package cn.juke.admin.service;

import java.util.List;

import cn.juke.bean.TreeNode;
import cn.juke.util.Page;

public interface TreeNodeService {
		
	public void create(TreeNode treeNode);
	
	public void update(TreeNode treeNode);
	
	public void delete(Long id);
	
	public TreeNode get(Long id);
	
	public List<TreeNode> search(Page page,Long comid);
	
	public List<TreeNode> search(Page page);

	public List<TreeNode> search();
}
