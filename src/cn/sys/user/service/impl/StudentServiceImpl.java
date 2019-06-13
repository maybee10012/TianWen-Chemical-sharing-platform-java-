package cn.sys.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sys.role.entity.Role;
import cn.sys.user.dao.StudentDao;
import cn.sys.user.entity.Student;
import cn.sys.user.entity.StudentRole;
import cn.sys.user.entity.StudentRoleId;
import cn.sys.user.service.StudentService;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
   
    StudentDao studentDao;
    
    @Resource
     public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



    
    
	public void save(Student student) {
		studentDao.save(student);
		
	}

	
	public void update(Student student) {
	studentDao.update(student);
		
	}


	public void delete(Serializable id) {
		studentDao.delete(id);
	}


	public List<Student> findAll() {
		
		return studentDao.findAll();
	}

	
	public Student findById(Serializable id) {
		
		return studentDao.findById(id);
	}





	@Override
	public List<Student> findStudentByusernameAndPass(String username, String password) {
		
		return studentDao.findStudentByusernameAndPass(username, password);
	}





	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return studentDao.getPageResult(queryHelper, pageNo, pageSize);
	}





	@Override
	public void saveUserAndRole(Student student, String... roleIds) {
		save(student);
		if(roleIds!=null){
			for(String roleId:roleIds){
				studentDao.saveUserRole(new StudentRole(new StudentRoleId(new Role(roleId), student.getId())));
			}
		}
		
	}

   public List<StudentRole> findStudentRolesByStudentId(String id){
	   
	   return studentDao.findStudentRolesByStudentId(id);
   }



	
}
