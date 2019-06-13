package cn.sys.user.entity;

import java.io.Serializable;

public class StudentRole implements Serializable{
      StudentRoleId id;

	public StudentRole() {
		super();
	}

	public StudentRole(StudentRoleId id) {
		super();
		this.id = id;
	}

	public StudentRoleId getId() {
		return id;
	}

	public void setId(StudentRoleId id) {
		this.id = id;
	}
  
  
  
  
}
