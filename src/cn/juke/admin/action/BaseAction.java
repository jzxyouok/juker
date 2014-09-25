package cn.juke.admin.action;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

 
public class BaseAction extends ActionSupport implements SessionAware,ServletResponseAware{
	
	private static final long serialVersionUID = 1L; 
	
	private HttpServletResponse servletResponse;
	
	private String comid;
	
    private Map<String,Object> session;
	
    HttpServletRequest request = ServletActionContext.getRequest();
	ServletContext application = request.getSession().getServletContext();
	HttpServletResponse response=ServletActionContext.getResponse();
	public HttpServletResponse getServletResponse() {
		return servletResponse;
	}
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request){
		this.request = request;
	}
	public ServletContext getApplication() {
		return application;
	}
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public Long getComid(){
		return (Long)session.get("comid");
	}
}
