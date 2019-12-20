package cn.sys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.sys.login.action.Constant;
import cn.sys.permission.PermissionCheck;
import cn.sys.user.entity.Student;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		//HttpServletRequest和ServletRequest都是接口 
		/*HttpServletRequest继承自ServletRequest 
		HttpServletRequest比ServletRequest多了一些针对于Http协议的方法。 	如 	getHeader(String name)， getMethod() ， 	getSession() 	
		*/
	   HttpServletRequest request=(HttpServletRequest) servletRequest;
	   HttpServletResponse response=(HttpServletResponse) servletResponse;
	    //判断是否为登录请求
	   String uri=request.getRequestURI();
	   if(!uri.contains("/system/login_")){//非登录请求
		   //判断session中是否有用户信息
		   if(request.getSession().getAttribute(Constant.STUDENT)!=null){//已经登录
			  //判断是否访问 用户管理系统
			   if(uri.contains("yhgl")||uri.contains("role")){
				   Student student=(Student) request.getSession().getAttribute(Constant.STUDENT);
				   System.out.print(student.toString());
				 //权限判定
				   //WebApplicationContextUtils获取的是随着应服务器启动时实例化的ioc容器
				   WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
				   PermissionCheck pc=(PermissionCheck) context.getBean("permissionCheck");
				   if(pc.isAccessble(student, "yhgl")||pc.isAccessble(student, "role")){
					   //有权限
					   filterChain.doFilter(request, response);
				   
				   }else{
					   response.sendRedirect(request.getContextPath()+"/system/login_toNoPermissionUI.action");
				   }
			   }//非服务子系统
				filterChain.doFilter(request, response);
			   
		   }else{
			   //没有登录跳转到登录界面
			   response.sendRedirect(request.getContextPath()+"/system/login_tologinUI.action");
		   }
		     }else{
		   //登录请求，直接放行
		   filterChain.doFilter(request, response);
	   }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
}
