package s1011.beans;

import java.sql.Date;

public class Emp {
	//사원번호, 사원명, 급여, 입사일, 부서번호
	private int empno;
	private String ename;
	private int sal;
	private Date hiredate;
	private int deptno;
	
	public Emp() {
	}
	
	public Emp(int empno, String ename, int sal, Date hiredate, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}
