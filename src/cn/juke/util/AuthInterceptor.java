package cn.juke.util;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor{
	@Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
		
//		System.out.println("请求的方法为:"+invocation.getInvocationContext().getName()); 
//		
//		
//        ActionContext ctx = invocation.getInvocationContext();
//        Map session = ctx.getSession();  
//        
//        String user = (String) session.get("username");  
//  
//        if (user != null || "user_login".equals(invocation.getInvocationContext().getName())||"authCodeAction".equals(invocation.getInvocationContext().getName())||"abc".equals(invocation.getInvocationContext().getName())) {  
//            System.out.println("您已经登陆");  
//            return invocation.invoke();  
//        }  
//        System.out.println("你还没有登录"); 
//        ctx.put("tip", "你还没有登录");  
//        return "user_login"; 
		
		 return invocation.invoke();  
    }

}
