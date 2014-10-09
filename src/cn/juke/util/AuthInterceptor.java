package cn.juke.util;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();

		String user = (String) session.get("username");

		if (user != null
				|| "user_login".equals(invocation.getInvocationContext()
						.getName())
				|| "authCodeAction".equals(invocation.getInvocationContext()
						.getName())
				|| "abc".equals(invocation.getInvocationContext().getName())) {
			return invocation.invoke();
		}

		return "user_login";

	}

}
