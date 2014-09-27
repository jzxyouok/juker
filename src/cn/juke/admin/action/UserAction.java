package cn.juke.admin.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.juke.admin.service.CompanyService;
import cn.juke.admin.service.RoleService;
import cn.juke.admin.service.TreeNodeService;
import cn.juke.admin.service.UserService;
import cn.juke.admin.serviceImpl.CompanyServiceImpl;
import cn.juke.admin.serviceImpl.RoleServiceImpl;
import cn.juke.admin.serviceImpl.TreeNodeServiceImpl;
import cn.juke.admin.serviceImpl.UserServiceImpl;
import cn.juke.bean.Company;
import cn.juke.bean.Role;
import cn.juke.bean.TreeNode;
import cn.juke.bean.User;
import cn.juke.util.MD5;
import cn.juke.util.Page;

import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<User> {

	private UserService hs = new UserServiceImpl();
	private TreeNodeService tns=new TreeNodeServiceImpl();
    private RoleService rs=new RoleServiceImpl();
	private List<User> users;
	private Page page;
	private Set<Role> rrs =new HashSet<Role>();
	private Set<Role> allRoles=new HashSet<Role>();
    private List<Integer> selectedRoles=new ArrayList<Integer>();
    private Set<Integer> susers=new HashSet<Integer>();
    private CompanyService cs=new CompanyServiceImpl();
    
	public Set<Integer> getSusers() {
		return susers;
	}

	public void setSusers(Set<Integer> susers) {
		this.susers = susers;
	}

	public List<Integer> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<Integer> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	public Set<Role> getRrs() {
		return rrs;
	}

	public void setRrs(Set<Role> rrs) {
		this.rrs = rrs;
	}

	public Set<Role> getAllRoles() {
		return allRoles;
	}

	public void setAllRoles(Set<Role> allRoles) {
		this.allRoles = allRoles;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private User user;
	private Long hid;

	private int operate;
	
	private TreeNode root;
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public int getOperate() {
		return operate;
	}

	public void setOperate(int operate) {
		this.operate = operate;
	}

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	@Override
	public User getModel() {
		if (user == null)
			user = new User();
		return user;
	}

	public User getUser() {
		return user;
	}

	public String login() {
            Map<String,Object> session=this.getSession();
            session.put("username",user.getUsername());
           
            User u=hs.search(user.getUsername());
            session.put("userid",u.getId());
            session.put("comid",u.getCompany().getId());
           
//            if("admin".equals(u.getUsername())){
//            	root=tns.get(new Long(1));
//            }
//            else{
            root=new TreeNode(1L,"root",null,null,null);
            Iterator<Role> ir=u.getRoles().iterator();
            Set<TreeNode> parents=new LinkedHashSet<TreeNode>();
            Set<TreeNode> children=new LinkedHashSet<TreeNode>();
            while(ir.hasNext()){
            	Role r=ir.next();
            	{
            		Iterator<TreeNode> nodes=r.getNodes().iterator();
            		while(nodes.hasNext()){
            			TreeNode t=nodes.next();
            			children.add(t);
            			TreeNode p=t.getParent();
            			p.setChildren(new LinkedHashSet<TreeNode>());
            			parents.add(p);
            		}          
            	}
            }
            
            Iterator<TreeNode> pi=parents.iterator();
           
            while(pi.hasNext()){
            	TreeNode p=pi.next();
            	Iterator<TreeNode> ci=children.iterator();
            	while(ci.hasNext()){
            	  TreeNode child=ci.next();
            	  if(child.getParent().getId()==p.getId()){
            		  p.getChildren().add(child);
            	  }
            	}
            		
            }
            root.setChildren(parents);
//            }
			return SUCCESS;
	}
	
	public void setUser(User user) {
		this.user = user;
	}


	public String edit() throws Exception {
		User dUser = hs.getUser(hid);
		if(operate==1)
			dUser.setState("1");
		else if(operate==2)
			dUser.setState("0");
		hs.update(dUser);
		
		Long comid=(Long)getSession().get("comid");
		String username=(String)getSession().get("username");
		if(page==null){
			page=new Page();
			page.setPageIndex(1);
		}
		if("admin".equals(username)){
		users = hs.search(page);
		}
		else users = hs.search(page,comid);
		
		return SUCCESS;
	}
	
	public void validateLogin(){
		
		String passwd=null;
		
		if(user.getPassword()!=null&&!"".equals(user.getPassword().trim()))

		passwd=MD5.getMD5Str(user.getPassword());
		
		User duser = hs.searchForObject(user.getUsername(), passwd);
		if(duser==null)
			{this.addFieldError("user","用戶名或者密码不对！");
		     return ;}
		if(!"1".equals(duser.getState())){
			this.addFieldError("user","该用户还没有被激活！");
		}
	}
	
	public String add(){
		String passwd=MD5.getMD5Str(user.getPassword());
		user.setPassword(passwd);
		Long comid=(Long)getSession().get("comid");
		if(comid==1){
			addFieldError("user","系统管理员不能创建用户");
			return INPUT;
		}
		Company c=cs.get(comid);
		user.setCompany(c);
		user.setState("1");
		user.setModifyt_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		user.setCreate_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		hs.create(user);
		return SUCCESS;
	}
	
	
	public String list(){
		
		Long comid=(Long)getSession().get("comid");
		String username=(String)getSession().get("username");
		User u=hs.search(username);
		if(page==null){
			page=new Page();
			page.setPageIndex(1);
		}
		if("admin".equals(username)){
		users = hs.search(page);
		}
		else users = hs.search(page,comid);
		users.remove(u);
		return SUCCESS;
	}
	
	public String listRoles(){
		Long comid=(Long)getSession().get("comid");
		String username=(String)getSession().get("username");
		User u=hs.search(username);
		if(page==null){
			page=new Page();
			page.setPageIndex(1);
		}
		
		allRoles=new HashSet<Role>(u.getRoles());//授權者擁有的角色
		
		user=hs.getUser(hid);
		
		rrs=user.getRoles();//用户已经有的角色
		allRoles.removeAll(rrs);
		return "success";
	}
	
	public String updateRoles(){
	   user=hs.getUser(new Long(hid));
	   for(int i=0;i<selectedRoles.size();i++){
		   Role r=rs.getRole(new Long(selectedRoles.get(i)));
		   rrs.add(r);
	   }
	   user.setRoles(rrs);
	   hs.update(user);
	   if(page==null)
			page=new Page();
		users=hs.search(page);
	   return "success";
	}
	
	public String update(){
		Iterator<Integer> ii=susers.iterator();
		String state=null;
		if(operate==1)
			state="1";
		else if(operate==2)
			state="0";
		while(ii.hasNext()){
			Integer i=ii.next();
			User du=hs.getUser(new Long(i));
			du.setState(state);
			hs.update(du);
		}
		
		Long comid=(Long)getSession().get("comid");
		String username=(String)getSession().get("username");
		if(page==null){
			page=new Page();
			page.setPageIndex(1);
		}
		if("admin".equals(username)){
		users = hs.search(page);
		}
		else users = hs.search(page,comid);
		return SUCCESS;
	}
}
