package cn.sys.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Student implements Serializable{
	private String id;
	
	private String name;
	private String username;
	private String gender;
	private String password;
	private String headImg;
	
	private String phone;
	private String state;
	private String workhouse;
	private String email;
	private String profession;
	private Date registdate;
	private String teacher;
	private String college;
	
	private List<StudentRole> studentRoles;

//状态
	public static String STUDENT_STATE_VALID = "1";//有效
	public static String STUDENT_STATE_INVALID = "0";//无效
	
	
	public Student() {
		super();
	}
	
	public Student(String id, String name, String username, String gender, String password, String headImg,
			String phone, String state, String workhouse, String email, String profession, Date registdate,
			String teacher, String college) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.password = password;
		this.headImg = headImg;
		this.phone = phone;
		this.state = state;
		this.workhouse = workhouse;
		this.email = email;
		this.profession = profession;
		this.registdate = registdate;
		this.teacher = teacher;
		this.college = college;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String isGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWorkhouse() {
		return workhouse;
	}
	public void setWorkhouse(String workhouse) {
		this.workhouse = workhouse;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public Date getRegistdate() {
		return registdate;
	}
	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}
	
	public List<StudentRole> getStudentRoles() {
		return studentRoles;
	}

	public void setStudentRoles(List<StudentRole> studentRoles) {
		this.studentRoles = studentRoles;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", username=" + username + ", gender=" + gender + ", password="
				+ password + ", headImg=" + headImg + ", phone=" + phone + ", state=" + state + ", workhouse="
				+ workhouse + ", email=" + email + ", profession=" + profession + ", registdate=" + registdate
				+ ", teacher=" + teacher + ", college=" + college + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}	
	
}
