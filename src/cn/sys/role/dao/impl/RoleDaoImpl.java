package cn.sys.role.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sys.role.dao.RoleDao;
import cn.sys.role.entity.Role;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao{
	
	
	public Session getCurrentSession(){
		  return getHibernateTemplate().getSessionFactory().getCurrentSession();
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
	public void save(Role role) {
		getHibernateTemplate().save(role);
		
	}

	@Override
	public void update(Role role) {
		getHibernateTemplate().update(role);
		
	}

	@Override
	public void delete(Serializable id) {
    getHibernateTemplate().delete(findById(id));
		
	}

	@Override
	public List<Role> findAll() {
		Query query=getSession().createQuery("From" +" " + Role.class.getSimpleName());
		return query.list();
	}

	@Override
	public Role findById(Serializable id) {
		
		return getHibernateTemplate().get(Role.class, id);
	}
	

}
