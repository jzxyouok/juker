package cn.juke.admin.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cn.juke.admin.service.UserService;
import cn.juke.admin.serviceImpl.UserServiceImpl;
import cn.juke.bean.User;
import cn.juke.util.MD5;

import com.opensymphony.xwork2.ModelDriven;

public class SignupAction extends BaseAction implements ModelDriven<User> {
	private User user;
	private String roleId;
	private String authCode;

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	private String result;
	private UserService us = new UserServiceImpl();
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getModel() {
		if (user == null)
			user = new User();
		return user;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		if ("1".equals(type)) {
			String serverCode = (String) getSession().get(
					"SESSION_SECURITY_CODE");
			authCode=authCode.substring(0,authCode.lastIndexOf(","));
			if (serverCode.equals(authCode))
			{
				result = "{'result':'ok'}";
			}
			else
				result = "{'result':'fail'}";
		} else if ("2".equals(type)) {
			user.setUsername(user.getUsername().substring(0,user.getUsername().lastIndexOf(",")));
			if (null == us.search(user.getUsername())) {
				result = "{'result':'ok'}";
			} else
				result = "{'result':'fail'}";
		}

		else {
			//user.setUsername(user.getUsername().substring(0,user.getUsername().lastIndexOf(",")));
			String passwd = MD5.getMD5Str(user.getPassword());
			user.setPassword(passwd);
			user.setState("0");
			user.setModifyTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			us.create(user);
		    Map<String,Object> session=this.getSession();
	        //session.put("username",user.getUsername());	
			return "ok";
		}
		return SUCCESS;
	}
}
