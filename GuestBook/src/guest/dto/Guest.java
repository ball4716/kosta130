package guest.dto;

import java.sql.Date;

public class Guest {
	private int id;
	private String name;
	private String pass;
	private String email;
	private String tel;
	private String contents;
	private Date gdate;
	
	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(int id, String name, String pass, String email, String tel, String contents, Date gdate) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.tel = tel;
		this.contents = contents;
		this.gdate = gdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getGdate() {
		return gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	
	
}
