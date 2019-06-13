package cn.sys.chemical.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.sys.chemical.entity.Drug;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public interface DrugService {
  
	
	void save(Drug drug);
	void update(Drug drug);
	void delete(Serializable id);
	List<Drug> findAll();
	Drug findById(Serializable id);
	//分页查询列表-查询助手queryHelper
     PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
	void exportExcel(List<Drug> drugList,ServletOutputStream outputStream);
	void importExcel(File drugExcel);
	
	
}
