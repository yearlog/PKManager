package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tools.DemoDaoImpl;

public class ContextInit implements Filter{
	
	protected static final Logger logger = Logger.getLogger(ContextInit.class);

	private FilterConfig config;
	
	private DemoDaoImpl demoDaoImpl;
	
	private String name;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		config = filterConfig;
		ServletContext sc = filterConfig.getServletContext();

		WebApplicationContext cxt =WebApplicationContextUtils.getWebApplicationContext(sc);

		if(cxt != null && cxt.getBean(DemoDaoImpl.class) != null && demoDaoImpl == null){

			demoDaoImpl = (DemoDaoImpl) cxt.getBean(DemoDaoImpl.class);
		}
		name = demoDaoImpl.queryDemo().getName();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
