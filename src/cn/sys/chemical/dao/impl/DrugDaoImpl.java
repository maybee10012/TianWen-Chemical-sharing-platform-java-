package cn.sys.chemical.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.sys.chemical.dao.DrugDao;
import cn.sys.chemical.entity.Drug;
import cn.sys.utils.ExcelUtil;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public class DrugDaoImpl extends HibernateDaoSupport implements DrugDao{
     public Drug drug;
  
  public Session getCurrentSession(){
	  return getHibernateTemplate().getSessionFactory().getCurrentSession();
  }
     
     
	@Override
	public void save(Drug drug) {
		getHibernateTemplate().save(drug);
		
	}

	@Override
	public void update(Drug drug) {
	getHibernateTemplate().update(drug);
		
	}

	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findById(id));
		
	}

	@Override
	public List<Drug> findAll() {
		Query query=getSession().createQuery("FROM" +" "+ Drug.class.getSimpleName());
		return query.list();
	}
	@Override
	public Drug findById(Serializable id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Drug.class, id);
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
	public void exportExcel(List<Drug> drugList, ServletOutputStream outputStream) {
		ExcelUtil.exportExcel(drugList, outputStream);
		
	}

}