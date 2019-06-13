package cn.sys.yhgl.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.sys.role.service.RoleService;
import cn.sys.user.entity.Student;
import cn.sys.user.service.StudentService;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public class YhglAction {

	
	 private String strName;
		private File headImg;
	    private String headImgFileName;
	    private String headImgContentType;
	    
		Student student; 
		
		protected PageResult pageResult;
		private int pageNo;
		private int pageSize;
		public static int DEFAULT_PAGE_SIZE = 3;//默认页大小
		protected String[] selectedRow;
		private String[] roleIds;
	
	@Resource
	StudentService studentService;
	
	@Resource 
	RoleService roleService;
	
	
	
	
	public String listUI(){
		

   	 QueryHelper queryHelper=new QueryHelper(Student.class, "s");
   	 
   
   	 if(student!=null ){
   		 if(StringUtils.isNotBlank(student.getName())){
   			 student.setName(student.getName());
   			 queryHelper.addCondition("name like ?", "%" + student.getName()+ "%");
   		 }
   	 }
   	    pageResult=studentService.getPageResult(queryHelper,getPageNo(), getPageSize());
   	    return "listUI";
    }

    public String editUI(){
   	 
		if(student!=null&&StringUtils.isNotBlank(student.getId())){
		student=studentService.findById(student.getId());
		
		}
    	 
    	 
    	 return "editUI";
    	 
     }
     
     
     
     public String edit(){
    		try {
    			if(student != null){
    				//处理用户头像
    				if(headImg != null){//1、获取头像文件
    					//2、保存头像文件
    					String filePath = ServletActionContext.getServletContext().getRealPath("upload/student");
    					String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf(".")); 
    					FileUtils.copyFile(headImg, new File(filePath, fileName));
    					//3、设置用户头像路径
    					student.setHeadImg("student/" + fileName);
    				}
    				studentService.update(student);
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		return "list";
    	}
     
     public String addUI(){
   ActionContext.getContext().getContextMap().put("rolelist", roleService.findAll());
    	 
    	 
    	 return "addUI";
     }
	
	public String add(){

		if(student!=null){
			//处理用户头像
			if(headImg != null){//1、获取头像文件
				
				//2、保存头像文件
				String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
				String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf(".")); 
				try {
					FileUtils.copyFile(headImg, new File(filePath, fileName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//3、设置用户头像路径
				student.setHeadImg("student/" + fileName);
			}
			studentService.saveUserAndRole(student, roleIds);
		}
		
		return listUI();
	}
	
	
	

	public String getStrName() {
		return strName;
	}




	public void setStrName(String strName) {
		this.strName = strName;
	}




	public File getHeadImg() {
		return headImg;
	}




	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}




	public String getHeadImgFileName() {
		return headImgFileName;
	}




	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}




	public String getHeadImgContentType() {
		return headImgContentType;
	}




	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
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

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	


}
