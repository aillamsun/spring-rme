package com.gooddeep.front.p_robot.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gooddeep.dev.core.helper.UuidHelper;
import com.gooddeep.front.commons.context.AppContext;
import com.gooddeep.remoteser.elasticsearch.model.RobotAutoReply;

public class ExcelUtils1 {
	
	/**
	 * 读取excel内容，TextReply格式，keywords,content
	 * @param excelPath
	 * @return
	 * @throws IOException
	 */
	public static List<RobotAutoReply>getTextReplyExcel(InputStream inputStream)  throws IOException {
		
		//String strPath="C:\\Users\\Administrator\\Desktop\\a.xlsx";
        // 构造 XSSFWorkbook 对象，strPath 传入文件路径
		List<RobotAutoReply> trList=new ArrayList();
        XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
        // 读取第一章表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        // 定义 row、cell
        XSSFRow row;
        String cell;
        // 循环输出表格中的内容
        for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
           
         /*   for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
                // 通过 row.getCell(j).toString() 获取单元格内容，
                cell = row.getCell(j).toString();
                System.out.print(cell + "\t");
            }*/
            if(row.getFirstCellNum()==0&&row.getPhysicalNumberOfCells()>=2)
            {
            	RobotAutoReply textReply=new RobotAutoReply();
            	textReply.setKeyword(row.getCell(0).toString());
            	textReply.setReply(row.getCell(1).toString());
            	textReply.setId(UuidHelper.getRandomUUID());
            	textReply.setUserKey(AppContext.getUserInfo().getRobotApiKey());
            	trList.add(textReply);
            }
            
        }
		return trList;
	}

	
/*	public static Workbook createworkbook(InputStream inp) throws IOException,InvalidFormatException {
	       if (!inp.markSupported()) {
	           inp = new PushbackInputStream(inp, 8);
	       }
	       if (POIFSFileSystem.hasPOIFSHeader(inp)) {
	           return new HSSFWorkbook(inp);
	       }
	       if (POIXMLDocument.hasOOXMLHeader(inp)) {
	           return new XSSFWorkbook(OPCPackage.open(inp));
	       }
	       throw new IllegalArgumentException("你的excel版本目前poi解析不了");
	   }*/
}
