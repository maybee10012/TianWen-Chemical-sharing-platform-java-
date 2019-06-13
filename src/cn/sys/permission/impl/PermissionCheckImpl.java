package cn.sys.permission.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.sys.permission.PermissionCheck;
import cn.sys.role.entity.Role;
import cn.sys.role.entity.RolePrivilege;
import cn.sys.user.entity.Student;
import cn.sys.user.entity.StudentRole;
import cn.sys.user.service.StudentService;

public class PermissionCheckImpl implements PermissionCheck{

	@Resource
	StudentService studentService;
	
	@Override
	public boolean isAccessble(Student student, String code) {
	
		List<StudentRole>  studentRoles=student.getStudentRoles();
		if(studentRoles==null){
			studentRoles=studentService.findStudentRolesByStudentId(student.getId());
		}
		
		//2、将code与用户权限集合进行对比
		Role role=null;
		for(StudentRole sr:studentRoles){
			role=sr.getId().getRole();
		for(RolePrivilege rp:role.getRolePrivileges()){
		   if(code.equals(rp.getId().getCode())){
			//  有权限
			   return true;
		   }
		}
		}
	
		
		
		return false;
	}

}
