package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	private String encType;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		encType = config.getInitParameter("EncType");
		/*System.out.println(encType);
		System.out.println("context-param에정의된 값:"+config.getServletContext().getInitParameter("EncType"));*/
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//POST 한글 처리
		if(encType!=null){
			request.setCharacterEncoding(encType);
		}else{
			request.setCharacterEncoding("UTF-8");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
