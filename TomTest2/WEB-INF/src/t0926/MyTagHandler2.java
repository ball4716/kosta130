package t0926;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler2 extends TagSupport{//�������� �κ� ����
	@Override
	public int doStartTag() throws JspException {
		//����� ������ �±׸� ������ �� ������ �ڵ�
		JspWriter out = pageContext.getOut();
		
		try {
			for (int i = 0; i < 10; i++) {
				if(i%2==0)
					out.print("<font color=red size=6>Ŀ���� �±� �ȳ�<br></font>");
				else
					out.print("<font color=blue size=6>Ŀ�����±� �ȳ�<br></font>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;//�±��� ������ ���� ��� ---> ���±�
	}
}
