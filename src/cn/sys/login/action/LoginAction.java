package cn.sys.login.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.sys.role.service.RoleService;
import cn.sys.user.entity.Student;
import cn.sys.user.service.StudentService;
import freemarker.template.utility.StringUtil;

public class LoginAction {

	Student student;
	String loginResult;
	
	@Resource
	StudentService studentService;
	
	@Resource
	private RoleService roleService;
	
	
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;
	private String[] roleIds;
	private String strName;
	//跳转到登录页面
		public String toLoginUI(){
			return "loginUI";
		}
		
		public String login(){
			if(student!=null){
			
		   if(StringUtils.isNotBlank(student.getUsername())&&StringUtils.isNotBlank(student.getPassword())){
			List<Student> list=studentService.findStudentByusernameAndPass(student.getUsername(), student.getPassword());
			
			if(list!=null&&list.size()>0){
				student=list.get(0);
				//1.3.3、将用户信息存入session
				ServletActionContext.getRequest().getSession().setAttribute(Constant.STUDENT, student);
				return "home";
			} else{
				loginResult="登陆失败：账号或密码失败";
				
			} 
		   }else{
				loginResult="登录失败，账号或密码不能为空";
			
			} 
			}else{
				loginResult = "帐号、密码不能为空！";
			}
			return toLoginUI();
		   
		   
		}
		
		public String registeredUI(){
			ActionContext.getContext().getContextMap().put("roleList", roleService.findAll());
			
			return "registeredUI";
		}
		
		public String registered(){
			
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
			
			return toLoginUI();
		}
		
		public String toNoPermissionUI(){
			return "toNoPermissionUI";
		}
		public String logout(){
			ServletActionContext.getRequest().getSession().removeAttribute(Constant.STUDENT);
			return toLoginUI();
		}
		
		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public String getLoginResult() {
			return loginResult;
		}

		public void setLoginResult(String loginResult) {
			this.loginResult = loginResult;
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

		public String[] getRoleIds() {
			return roleIds;
		}

		public void setRoleIds(String[] roleIds) {
			this.roleIds = roleIds;
		}

		public String getStrName() {
			return strName;
		}

		public void setStrName(String strName) {
			this.strName = strName;
		}

		
}
		  		
			
		   		

