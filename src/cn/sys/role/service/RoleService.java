package cn.sys.role.service;

import java.io.Serializable;
import java.util.List;


import cn.sys.role.entity.Role;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public interface RoleService {
	void save(Role role);
	void update(Role role);
	void delete(Serializable id);
	List<Role> findAll();
	Role findById(Serializable id);
	
	  PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}
