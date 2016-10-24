package com.kosta._0912;

public class HaksaDTO {
	String name;
	int age;
	String info;
	int jobno;
	String jobname;

	public HaksaDTO() {

	}

	public HaksaDTO(String name, int age, String info, int jobno, String jobname) {
		this.name = name;
		this.age = age;
		this.info = info;
		this.jobno = jobno;
		this.jobname = jobname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getJobno() {
		return jobno;
	}

	public void setJobno(int jobno) {
		this.jobno = jobno;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
}
