package cn.sys.user.dao;

import java.io.Serializable;
import java.util.List;


import cn.sys.user.entity.Student;
import cn.sys.user.entity.StudentRole;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public interface StudentDao {
   
public void save(Student student);
	
	public void update(Student student);
	 
	public void delete(Serializable id);
	
	public List<Student>  findAll();
	
	public Student findById(Serializable id);
	
	public List<Student> findStudentByusernameAndPass(String username,String password);
	
	 PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
	 
	// 保存用户角色
		public void saveUserRole(StudentRole userRole);

		public List<StudentRole> findStudentRolesByStudentId(String id);
}
