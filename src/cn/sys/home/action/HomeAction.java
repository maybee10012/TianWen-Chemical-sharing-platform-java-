package cn.sys.home.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.Query;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.sys.chemical.entity.Drug;
import cn.sys.chemical.service.DrugService;
import cn.sys.login.action.Constant;
import cn.sys.user.entity.Student;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;
import net.sf.json.JSONObject;

public class HomeAction extends ActionSupport{
	@Resource
	DrugService drugService;
     
	
	protected PageResult pageResult;
	private int pageNo;
	private int pageSize;
	public static int DEFAULT_PAGE_SIZE = 3;//默认页大小
	protected String[] selectedRow;
	

	//跳转到系统首页
	public String execute(){
		QueryHelper queryHelper=new QueryHelper(Drug.class, "");
		pageResult=drugService.getPageResult(queryHelper, getPageNo(), getPageSize());
		
		
	  return "home";
		
		
		/*Student student = (Student)ServletActionContext.getRequest().getSession().getAttribute(Constant.STUDENT);
		System.out.println(student);
		
		return "home";*/
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
		if(pageSize<1)
			pageSize=DEFAULT_PAGE_SIZE;
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String[] getSelectedRow() {
		return selectedRow;
	}


	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}
	
	
	

}
