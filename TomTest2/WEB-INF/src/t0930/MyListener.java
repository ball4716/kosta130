package t0930;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyListener종료");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyListener시작(초기화)");
		//공유할 객체 저장
		ServletContext application = sce.getServletContext();
		application.setAttribute("book", new Book());
	}
	
}
