package t0930;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyListener����");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyListener����(�ʱ�ȭ)");
		//������ ��ü ����
		ServletContext application = sce.getServletContext();
		application.setAttribute("book", new Book());
	}
	
}
