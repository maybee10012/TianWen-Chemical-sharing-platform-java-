package cn.sys.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sys.role.dao.RoleDao;
import cn.sys.role.entity.Role;
import cn.sys.role.service.RoleService;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
  
	 
	 private RoleDao roleDao;
	 
	 @Resource 
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		
		return roleDao.getPageResult(queryHelper, pageNo, pageSize);
	}

	@Override
	public void save(Role role) {
		roleDao.save(role);
		
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
		
	}

	@Override
	public void delete(Serializable id) {
		roleDao.delete(id);
		
	}

	@Override
	public List<Role> findAll() {
		
		return roleDao.findAll();
	}

	@Override
	public Role findById(Serializable id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

}
