package cn.sys.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;


import cn.sys.chemical.entity.Drug;

public class ExcelUtil {
	public static void exportExcel(List<Drug> drugList, ServletOutputStream outputStream) {
	try {
		//1、创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//1.1、创建合并单元格对象
		CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 11);//起始行号，结束行号，起始列号，结束列号
		//1.2、创建头标题行样式并创建字体
		HSSFCellStyle style1 = createCellStyle(workbook, (short)16);
		
		//1.3、创列标题样式
		HSSFCellStyle style2 = createCellStyle(workbook, (short)13);
		
		//2、创建工作表
		HSSFSheet sheet = workbook.createSheet("化学品列表");
		//2.1、加载合并单元格对象
		sheet.addMergedRegion(cellRangeAddress);
		//2.2、设置默认列宽
		sheet.setDefaultColumnWidth(25);
		
		//3、创建行
		//3.1、创建头标题行并写入头标题
		HSSFRow row1 = sheet.createRow(0);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(style1);
		cell1.setCellValue("化学品列表");
		
		//3.2、创建列标题并写入列标题
		HSSFRow row2 = sheet.createRow(1);
		String[] titles = {"化学品ID","中文名","英文名","分子式","厂家","纯度","性状","重量","负责人","标签","存放位置"};
		for(int i = 0; i < titles.length; i++){
			HSSFCell cell2 = row2.createCell(i);
			cell2.setCellStyle(style2);
			cell2.setCellValue(titles[i]);
		}
		
		//4、创建单元格，写入用户数据到excel
		if(drugList != null && drugList.size() > 0){
			for(int j = 0; j < drugList.size(); j++){
				HSSFRow row = sheet.createRow(j+2);
				row.createCell(0).setCellValue(drugList.get(j).getId());
				row.createCell(1).setCellValue(drugList.get(j).getChinesename());
				row.createCell(2).setCellValue(drugList.get(j).getEnglishname());
				row.createCell(3).setCellValue(drugList.get(j).getMolecular());
				row.createCell(4).setCellValue(drugList.get(j).getFactory());
				row.createCell(5).setCellValue(drugList.get(j).getPurity());
				row.createCell(6).setCellValue(drugList.get(j).getTraits());
				row.createCell(7).setCellValue(drugList.get(j).getHeight());
				row.createCell(8).setCellValue(drugList.get(j).getPrincipal());
				row.createCell(9).setCellValue(drugList.get(j).getLable());
				row.createCell(10).setCellValue(drugList.get(j).getPosition());
			}
		}
		//5、输出
		workbook.write(outputStream);
		workbook.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

/**
 * 创建单元格样式
 * @param workbook 工作簿
 * @param fontSize 字体大小
 * @return 单元格样式
 */
private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize){
	HSSFCellStyle style = workbook.createCellStyle();
	style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
	style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
	//创建字体
	HSSFFont font = workbook.createFont();
	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗字体
	font.setFontHeightInPoints(fontSize);
	//在样式中加载字体
	style.setFont(font);
	return style;
}

}
