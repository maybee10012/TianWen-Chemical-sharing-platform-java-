package cn.sys.permission;



import cn.sys.user.entity.Student;


public interface PermissionCheck {
	

	
	public boolean isAccessble(Student student, String code);
}
