package cn.juke.admin.dao;

import java.util.List;

import cn.juke.bean.TreeNode;
import cn.juke.util.Page;


public interface TreeNodeDao extends GenericDao<TreeNode>
{
	public List<TreeNode> search(Page page);
   
    public List<TreeNode> search(Page page,Long comid );
    
    public List<TreeNode> search();
}
