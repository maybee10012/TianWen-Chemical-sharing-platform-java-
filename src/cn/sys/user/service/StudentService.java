package cn.sys.user.service;

import java.io.Serializable;
import java.util.List;


import cn.sys.user.entity.Student;
import cn.sys.user.entity.StudentRole;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public interface StudentService {
  
	
	public void save(Student student);
	
	public void update(Student student);
	 
	public void delete(Serializable id);
	
	public List<Student>  findAll();
	
	public Student findById(Serializable id);
	
	public List<Student> findStudentByusernameAndPass(String username,String password);

	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
	 
	// 保存用户及其对应的角色
		public void saveUserAndRole(Student user, String... roleIds);
		
		 public List<StudentRole> findStudentRolesByStudentId(String id);
}
