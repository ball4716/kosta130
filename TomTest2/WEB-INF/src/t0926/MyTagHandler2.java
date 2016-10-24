package t0926;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler2 extends TagSupport{//로직적인 부분 정의
	@Override
	public int doStartTag() throws JspException {
		//사용자 정의한 태그를 만났을 때 실행할 코드
		JspWriter out = pageContext.getOut();
		
		try {
			for (int i = 0; i < 10; i++) {
				if(i%2==0)
					out.print("<font color=red size=6>커스텀 태그 안녕<br></font>");
				else
					out.print("<font color=blue size=6>커스텀태그 안녕<br></font>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;//태그의 본문이 없는 경우 ---> 빈태그
	}
}
