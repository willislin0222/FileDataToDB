package com.document.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.document.pojo.DocumentVO;

public class ExcelToDB {

public List<DocumentVO> ExcelToDB(String url) throws IOException{
		
		System.out.println("有Excel檔案要匯入資料庫");
		List<DocumentVO> documentList = new ArrayList<DocumentVO>();
		

		File xlsFile = new File(url);

		// 工作表
		Workbook workbook = WorkbookFactory.create(xlsFile);
		
		// 表個數。
		int numberOfSheets = workbook.getNumberOfSheets();
		
		// 遍歷表。
				for (int i = 0; i < numberOfSheets; i++) {
					Sheet sheet = workbook.getSheetAt(i);

					// 行數。
					int rowNumbers = sheet.getLastRowNum() + 1;

					// Excel第一行。
					Row temp = sheet.getRow(0);
					if (temp == null) {
						continue;
					}

					int cells = temp.getPhysicalNumberOfCells();

					// 讀資料。
					for (int row = 1; row < rowNumbers; row++) {
						DocumentVO documentVO = new DocumentVO();
						Row r = sheet.getRow(row);
						String d = r.getCell(3).toString();
						documentVO.setName(r.getCell(0).toString());
						documentVO.setTel(r.getCell(1).toString());
						documentVO.setSex(r.getCell(2).toString());
						documentVO.setJoindate(new Date(System.currentTimeMillis()));
						documentVO.setAddress(r.getCell(4).toString());
						documentList.add(documentVO);
					}
				}
				
		//關閉檔案
		workbook.close();
        return documentList;
	}
}
