package cn.sys.chemical.action;

import java.io.File;


import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


import cn.sys.chemical.entity.Drug;
import cn.sys.chemical.service.DrugService;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

public class DrugAction extends ActionSupport{
	
	protected String[] selectedRow;
	private Drug drug;
	protected PageResult pageResult;
	private int pageNo;
	private int pageSize;
	public static int DEFAULT_PAGE_SIZE = 3;//默认页大小
	private File drugExcel;
	private String drugExcelFileName;
	private String drugExcelContentType;
	@Resource
	DrugService drugService;
	
	
	
	
	
	public String addUI(){
	
	
	
	return "addUI";
	}	
	
	public String add(){
		if(drug!=null){
		drugService.save(drug);
		
	}
		return "list";
	
	
	}
	
	public String listUI(){
		QueryHelper queryHelper=new QueryHelper(Drug.class, "r");
		if(drug!=null){
			if(StringUtils.isNotBlank(drug.getEnglishname())){
				/*drug.setChinesename(drug.getChinesename());*/
				drug.setEnglishname(drug.getEnglishname());
				queryHelper.addCondition("r.englishname like ?", "%" + drug.getEnglishname() + "%");
			}else{
				if(StringUtils.isNotBlank(drug.getChinesename())){
					drug.setChinesename(drug.getChinesename());
					queryHelper.addCondition("r.chinesename like ?", "%" +drug.getChinesename()+ "%");
				}
				
			}
			
		}
		pageResult=drugService.getPageResult(queryHelper, getPageNo(), getPageSize());
		return "listUI";
		
	}

	
	public String editUI(){
		if(drug!=null){
			
			drug=drugService.findById(drug.getId());
			System.out.println(drug.toString());
		}
		
		
		
		return "editUI";
		
	}
	
	public String edit(){
		
		if(drug!=null&&StringUtils.isNotBlank(drug.getId())){
			drugService.update(drug);
			
		}
		return "list";
	}
	
	
	public String delete(){
		if(drug!=null&&StringUtils.isNotBlank(drug.getId())){
			drugService.delete(drug.getId());
		}
		return "list";
	}
	public String deleteSelected(){
		if(selectedRow!=null){
			for(String id:selectedRow){
				drugService.delete(id);
			}
			
		}
		return "list";
	}
	
	public void exportExcel()  {
		
		try{
			HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/x-excel");
	  
			response.setHeader("Content-Disposition", "attachment;filename="+new String("化学品列表.xls".getBytes(),"ISO-8859-1"));
		
	    ServletOutputStream outputStream=response.getOutputStream();
	    drugService.exportExcel(drugService.findAll(), outputStream);
	    
		} catch (Exception e) {

			e.printStackTrace();
		}
	    
	}
	
	//导入用户列表
		public String importExcel(){
			if(drugExcel != null){
				//判断是否是excel文件
				if(drugExcelFileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
					drugService.importExcel(drugExcel);
				}
			}
			return "list";
		}
		
		
		public String useUI(){
			QueryHelper queryHelper=new QueryHelper(Drug.class, "r");
			if(drug!=null){
				if(StringUtils.isNotBlank(drug.getEnglishname())){
					/*drug.setChinesename(drug.getChinesename());*/
					drug.setEnglishname(drug.getEnglishname());
					queryHelper.addCondition("r.englishname like ?", "%" + drug.getEnglishname() + "%");
				}else{
					if(StringUtils.isNotBlank(drug.getChinesename())){
						drug.setChinesename(drug.getChinesename());
						queryHelper.addCondition("r.chinesename like ?", "%" +drug.getChinesename()+ "%");
					}
					
				}
				
			}
			pageResult=drugService.getPageResult(queryHelper, getPageNo(), getPageSize());
			return "useUI";
			
		}
		
		public String recordUI(){
			if(drug!=null){
				
				drug=drugService.findById(drug.getId());
				System.out.println(drug.toString());
			}
			return "recordUI";
		}

		
		public String caculate(){
			if(drug!=null){
			Drug beforedrug=drugService.findById(drug.getId());
			System.out.println(beforedrug.toString());
			Double beforeheight=beforedrug.getHeight();
			System.out.print(beforeheight);
			Double previousheight=drug.getHeight();
			System.out.print(previousheight);
			Double newheight=beforeheight-previousheight;
		   System.out.print(newheight);
			beforedrug.setHeight(newheight);
			drugService.update(beforedrug);
			}
			return "list";
		}
	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
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
		if(pageSize < 1) pageSize = DEFAULT_PAGE_SIZE;
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

	public File getDrugExcel() {
		return drugExcel;
	}

	public void setDrugExcel(File drugExcel) {
		this.drugExcel = drugExcel;
	}

	public String getDrugExcelFileName() {
		return drugExcelFileName;
	}

	public void setDrugExcelFileName(String drugExcelFileName) {
		this.drugExcelFileName = drugExcelFileName;
	}

	public String getDrugExcelContentType() {
		return drugExcelContentType;
	}

	public void setDrugExcelContentType(String drugExcelContentType) {
		this.drugExcelContentType = drugExcelContentType;
	}
	
}
