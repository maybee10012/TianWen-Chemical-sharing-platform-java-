package cn.sys.login.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.experimental.ParallelComputer;

public class Constant {
	
	//系统中session中的用户标识符
	public static String STUDENT = "SYS_STUDENT";

	/*------------------------系统权限集合----------------------------*/
	public static String PRIVILEGE_GRZY="grzy";
	public static String PRIVILEGE_GZZD="gzzd";
	public static String PRIVILEDE_HXPGL="hxpgl";
	public static String PRIVILEDE_HXPSY="hxpsy";
	public static String PRIVILEGE_YHGL="yhgl";
	public static String PRIVILEGE_JSGL="jsgl";
	public static String PRIVILEGE_JWTZ="jwtz";
	public static String PRIVILEGE_SYSYU="sysyu";
	
	
	public static Map<String, String> PRIVITE_MAP;
	
	static {
		PRIVITE_MAP=new HashMap<String, String>();
		PRIVITE_MAP.put(PRIVILEGE_GRZY, "个人主页");
		PRIVITE_MAP.put(PRIVILEGE_GZZD, "规章制度");
		PRIVITE_MAP.put(PRIVILEDE_HXPGL, "化学品管理");
		PRIVITE_MAP.put(PRIVILEDE_HXPSY, "化学品使用");
		PRIVITE_MAP.put(PRIVILEGE_YHGL, "用户管理");
		PRIVITE_MAP.put(PRIVILEGE_JSGL, "角色管理");
		PRIVITE_MAP.put(PRIVILEGE_SYSYU, "实验室预约");
		PRIVITE_MAP.put(PRIVILEGE_JWTZ, "教务通知");
		
		
		
		
	}
}
