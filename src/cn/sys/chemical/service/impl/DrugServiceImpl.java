package cn.sys.chemical.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;


import cn.sys.chemical.dao.DrugDao;
import cn.sys.chemical.entity.Drug;
import cn.sys.chemical.service.DrugService;
import cn.sys.utils.PageResult;
import cn.sys.utils.QueryHelper;

@Service("drugService")
public class DrugServiceImpl implements DrugService{
  
	
    DrugDao drugDao;
	

    @Resource
	public void setDrugDao(DrugDao drugDao) {
		this.drugDao = drugDao;
	}


	public void save(Drug drug) {
		drugDao.save(drug);
		
	}

	
	public void update(Drug drug) {
		drugDao.update(drug);
		
	}

	@Override
	public void delete(Serializable id) {
		drugDao.delete(id);
		
	}

	@Override
	public List<Drug> findAll() {
		// TODO Auto-generated method stub
		return drugDao.findAll();
	}

	@Override
	public Drug findById(Serializable id) {
		
		return drugDao.findById(id);
	}


	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return drugDao.getPageResult(queryHelper, pageNo, pageSize);
	}


	@Override
	public void exportExcel(List<Drug> drugList, ServletOutputStream outputStream) {
		drugDao.exportExcel(drugList, outputStream);
		
	}



	public void importExcel(File drugExcel) {
		try{
		FileInputStream fileInputStream= new FileInputStream(drugExcel);
	
		Workbook workbook=WorkbookFactory.create(fileInputStream);
		Sheet sheet=workbook.getSheetAt(0);
		if(sheet.getPhysicalNumberOfRows() > 2){
			//4、读取单元格
			Drug drug = null;
			Row row = null;
			for(int i = 2; i < sheet.getPhysicalNumberOfRows(); i++){
				row = sheet.getRow(i);
				drug = new Drug();
				String ID = row.getCell(0).getStringCellValue();
				drug.setId(ID);
				String chinesename = row.getCell(1).getStringCellValue();
				drug.setChinesename(chinesename);
				String englishname = row.getCell(2).getStringCellValue();
				drug.setEnglishname(englishname);
				String molecular = row.getCell(3).getStringCellValue();
			    drug.setMolecular(molecular);
				String factory = row.getCell(4).getStringCellValue();
				drug.setFactory(factory);
				String purity = row.getCell(5).getStringCellValue();
				drug.setPurity(purity);
            	String traits = row.getCell(6).getStringCellValue();
				drug.setTraits(traits);
				double height = row.getCell(7).getNumericCellValue();
				drug.setHeight(height);
				String principal = row.getCell(8).getStringCellValue();
				drug.setPrincipal(principal);
				String lable = row.getCell(9).getStringCellValue();
				drug.setLable(lable);
				String position = row.getCell(10).getStringCellValue();
				drug.setPosition(position);
				
				
				
				
				save(drug);
			}
		}
		workbook.close();
		fileInputStream.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
   }
}
}
