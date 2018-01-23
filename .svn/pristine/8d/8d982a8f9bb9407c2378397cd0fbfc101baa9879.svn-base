package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="loginFilter",urlPatterns="/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String contextUrl = req.getRequestURI();
		String servletPath = req.getServletPath();
		String url = "index";//UserServlet
		if(contextUrl.indexOf(url)>-1||contextUrl.indexOf("UserServlet")>-1||contextUrl.indexOf("ManagerServlet")>-1||contextUrl.endsWith(".js")||contextUrl.indexOf(".css")>-1){//登录的页面不做拦截
				//不做拦截
		}else{
			HttpSession session = req.getSession();
			if(session.getAttribute("username")==null){//说明没有登录，或者超时
				//异步拦截
				if (req.getHeader("x-requested-with") != null&& req.getHeader("x-requested-with") .equalsIgnoreCase("XMLHttpRequest")) {
					resp.addHeader("sessionstatus", "timeOut"); 
					resp.addHeader("loginPath", "login.jsp"); 
					return ;
					//chain.doFilter(request, response);// 不可少，否则请求会出错 
				} else{//同步拦截
						//resp.setContentType(arg0);
						//resp.getWriter().println("<script></ser");
						//resp.sendRedirect("login.jsp");
						resp.setContentType("text/html;charset=utf-8");
						PrintWriter out = resp.getWriter();
						out.println("<script language='javascript' type='text/javascript'>");
						out.println("alert('由于你长时间没有操作,导致Session失效!请你重新登录!');window.parent.location.href='" + req.getContextPath() + "/index.jsp'");
						out.println("</script>");
						return; 
					}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
