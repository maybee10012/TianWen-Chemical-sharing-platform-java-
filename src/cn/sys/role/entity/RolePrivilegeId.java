package cn.sys.role.entity;

import java.io.Serializable;

public class RolePrivilegeId implements Serializable{
   Role role;
   String code;
public RolePrivilegeId() {
	super();
}
public RolePrivilegeId(Role role, String code) {
	super();
	this.role = role;
	this.code = code;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
   
}
