package cn.sys.role.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.sys.login.action.Constant;
import cn.sys.role.entity.Role;
import cn.sys.role.entity.RolePrivilege;
import cn.sys.role.entity.RolePrivilegeId;
import cn.sys.role.service.RoleService;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public class RoleAction extends ActionSupport{
	
	@Resource
	private RoleService roleService;
	
	protected String[] selectedRow;
	protected PageResult pageResult;
	private int pageNo;
	private int pageSize;
	public static int DEFAULT_PAGE_SIZE = 3;//默认页大小
	
	private Role role;


	private String[] privilegeIds;
	private String strName;
	
	public String listUI(){
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVITE_MAP);
		
		QueryHelper queryHelper=new QueryHelper(Role.class, "r");
		if(role!=null){
			if(StringUtils.isNotBlank(role.getName())){
				role.setName(role.getName());
				queryHelper.addCondition("r.name like ?", "%" + role.getName()+ "%");
			}
		}
		System.out.println(getPageSize());
		pageResult=roleService.getPageResult(queryHelper, getPageNo(), getPageSize());
		
		
		return "listUI";
	}

	public String addUI(){
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVITE_MAP);
		strName=role.getName();
		return "addUI";
		
		
	}
	
	public String add(){
		if(role!=null){
			if(privilegeIds!=null){
				Set<RolePrivilege> set = new HashSet<RolePrivilege>();
				for(String code:privilegeIds){
					set.add(new RolePrivilege(new RolePrivilegeId(role,code)));
				}
				role.setRolePrivileges(set);
			}
			roleService.save(role);
		}
		
		return "list";
	}
	
	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		if(pageSize < 1) 
		pageSize = DEFAULT_PAGE_SIZE;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}
	
	
}
