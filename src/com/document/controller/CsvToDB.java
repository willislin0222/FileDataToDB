package com.document.controller;

import java.io.File;
import java.io.FileReader;
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

import au.com.bytecode.opencsv.CSVReader;

public class CsvToDB {

public List<DocumentVO> CsvToDB(String url) throws IOException{
		
		System.out.println("有Csv檔案要匯入資料庫");
		List<DocumentVO> documentList = new ArrayList<DocumentVO>();
		
		CSVReader reader = new CSVReader(new FileReader(url)); 

		String [] nextLine; 
		while ((nextLine = reader.readNext()) != null) { 
		    // nextLine[] is an array of values ​​from the line 
		    DocumentVO documentVO = new DocumentVO();
			documentVO.setName(nextLine[0]);
			documentVO.setTel(nextLine[1]);
			documentVO.setSex(nextLine[2]);
			documentVO.setJoindate(new Date(System.currentTimeMillis()));
			documentVO.setAddress(nextLine[4]);
			documentList.add(documentVO);
		}
		
		//關閉檔案
		reader.close();		

        return documentList;
	}
}
