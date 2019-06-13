package cn.sys.user.entity;

import java.io.Serializable;

import cn.sys.role.entity.Role;

public class StudentRoleId implements Serializable{
     private Role role;
      private String studentId;
	public StudentRoleId() {
		super();
	}
	public StudentRoleId(Role role, String studentId) {
		super();
		this.role = role;
		this.studentId = studentId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
      
}
