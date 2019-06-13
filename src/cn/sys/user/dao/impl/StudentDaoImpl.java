package cn.sys.user.dao.impl;

import java.io.Serializable;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import cn.sys.user.dao.StudentDao;
import cn.sys.user.entity.Student;
import cn.sys.user.entity.StudentRole;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao{

	Student student;
	
   
	
	
	public Session getCurrentSession(){
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
	
	
	public void save(Student student) {
		getHibernateTemplate().save(student);
		
	}

	@Override
	public void update(Student student) {
		getHibernateTemplate().update(student);
		
	}

	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findById(id));
		
	}

	@Override
	public List<Student> findAll() {
		Query query = getSession().createQuery("FROM " +student);
		return query.list();
	}

	@Override
	public Student findById(Serializable id) {
		
		return  getHibernateTemplate().get(Student.class,id);
	}

	@Override
	public List<Student> findStudentByusernameAndPass(String username, String password) {
		Query query = getCurrentSession().createQuery("FROM Student WHERE username=? and password=? ");
		query.setParameter(0, username);
		query.setParameter(1, password);
		
		return query.list();
	}


	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
	
			Query query =getCurrentSession().createQuery(queryHelper.getListHql());
			List<Object> parameters = queryHelper.getParameters();
			if(parameters != null){
				for(int i = 0; i < parameters.size(); i++){
					query.setParameter(i, parameters.get(i));
				}
			}
			//设置记录起始索引号
			if(pageNo < 1) pageNo = 1;
			query.setFirstResult((pageNo-1)*pageSize);
			//本次查询记录大小
			query.setMaxResults(pageSize);
			List items = query.list();
			
			//总记录数
			Query countQuery = getCurrentSession().createQuery(queryHelper.getCountHql());
			if(parameters != null){
				for(int i = 0; i < parameters.size(); i++){
					countQuery.setParameter(i, parameters.get(i));
				}
			}
			long totalCount = (Long)countQuery.uniqueResult();
			
			return new PageResult(totalCount, pageNo, pageSize, items);
		}


	@Override
	public void saveUserRole(StudentRole studentRole) {
		getHibernateTemplate().save(studentRole);
		
	}


	@Override
	public List<StudentRole> findStudentRolesByStudentId(String id) {
		Query query=getCurrentSession().createQuery("FROM StudentRole WHERE id.studentId=?");
		query.setParameter(0, id);
		
		return query.list();
	}
}
