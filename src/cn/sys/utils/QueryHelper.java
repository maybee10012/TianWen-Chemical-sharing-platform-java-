package cn.sys.utils;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	
	//from子句
	private String fromeClause ="";
	//where子句
	private String whereClause ="";
	//order by子句
	private String orderByClause ="";
	//查询条件值
	private List<Object> parameters;
	
	//排序顺序
	public static String ORDER_BY_DESC = "DESC";//降序
	public static String ORDER_BY_ASC = "ASC";//升序
	
	/**
	 * 构造from 子句
	 * @param clazz 实体类
	 * @param alias 别名
	 */
	public QueryHelper(Class clazz, String alis){
		fromeClause = "FROM " + clazz.getSimpleName()+" "+alis;
	}
	
	/**
	 * 构造where子句
	 * @param condition 查询条件；如：i.title like ?
	 * @param params 查询条件中?对应的查询条件值；如：%标题%
	 */
	public void addCondition(String condition, Object... params){
		if (whereClause.length()>0) {//非第一个查询条件
			whereClause += " AND " + condition;
		} else {//第一个查询条件
			whereClause = " WHERE " + condition;
		}
		
		if(parameters == null){
			parameters = new ArrayList<Object>();
		}
		//条件查询条件值
		if(params != null){
			for(Object param: params){
				parameters.add(param);
			}
		}
	}
	
	/**
	 * 构造order by子句
	 * @param property 排序属性；如：i.createTime
	 * @param order 排序序列，DESC 或 ASC
	 */
	public void addOrderByProperty(String property, String order){
		if (orderByClause.length()>0) {//非第一个排序属性
			orderByClause += "," + property + " " + order;
		} else {//第一个排序属性
			orderByClause = " ORDER BY " + property + " " + order;
		}
	}
	
	//获取查询语句
	public String getListHql(){
		return fromeClause + whereClause + orderByClause;
	}
	
	//获取统计总记录数的查询语句
	public String getCountHql(){
		return "SELECT COUNT(*) " + fromeClause + whereClause;
	}
	
	//获取查询语句中对应的查询条件值集合
	public List<Object> getParameters(){
		return parameters;
	}

}
