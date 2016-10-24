package t0930;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncFilter implements Filter{
	
	private String encType;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init()");
		encType = config.getInitParameter("encType");//web.xml에 정의된 param-value 얻어오기
	}

	@Override
	public void destroy() {
		System.out.println("destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter()");
		if(encType != null){
			request.setCharacterEncoding(encType);
		} else {
			request.setCharacterEncoding("UTF-8");
		}
		chain.doFilter(request, response);
	}
}
