package t0926;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{//�������� �κ� ����
	@Override
	public int doStartTag() throws JspException {
		//����� ������ �±׸� ������ �� ������ �ڵ�
		JspWriter out = pageContext.getOut();
		
		try {
			out.print("�ȳ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;//�±��� ������ ���� ��� ---> ���±�
	}
}
