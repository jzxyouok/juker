package cn.juke.admin.daoimpl;

import java.util.List;

import cn.juke.admin.dao.TreeNodeDao;
import cn.juke.bean.TreeNode;
import cn.juke.util.Page;

public class TreeNodeDaoImpl extends GenericHibernateDao<TreeNode> implements
		TreeNodeDao {

	public TreeNodeDaoImpl(Class<TreeNode> clazz) {
		super(clazz);
	}

	public TreeNodeDaoImpl() {
		this(TreeNode.class);
	}
	
	public List<TreeNode> search(Page page)
    {
    	return queryForList("select count(*) from TreeNode","from TreeNode",null, page);
    }
   
    public List<TreeNode> search(Page page,Long comid )
    {
        return queryForList("select count(*) from TreeNode r where r.comid = ?", "from TreNode r where  r.comid = ? ",new Object[]{comid}, page);
    }
    
    public List<TreeNode> search(){
    	return queryForList("from TreeNode");
    }
}
