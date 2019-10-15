package com.document.controller;
 
 
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.document.pojo.DocumentVO;
import com.document.service.DocumentService;

 
@Controller
@RequestMapping("/document")
public class DocumentController {
 
	@Autowired
	DocumentService documentService;
	
	
	@RequestMapping("/importexcel")
	public String addDocument(Model model,HttpServletRequest request,@RequestParam("fileexcel") MultipartFile file) throws IOException {//新增資料
		
		UploadFile upLoadFile = new UploadFile();
		DeleteFolder deleteFolder = new DeleteFolder();
		String[] url = upLoadFile.upLoadFile(file, request);
		List<DocumentVO> documentList = new ArrayList<DocumentVO>();
		
		ExcelToDB excelToDB = new ExcelToDB();
		documentList = excelToDB.ExcelToDB(url[1]);
		for(DocumentVO documentVO:documentList){
			System.out.println(documentVO.getName());
			documentService.addDocumentList(documentVO);
		}

		//刪除來源資料夾
		int Index = url[1].lastIndexOf("\\");
        String deleteFloder = url[1].substring(0, Index-8);
        File file1 = new File(deleteFloder);
        deleteFolder.deleteALL(file1);
		return "success";
	}	
	
	@RequestMapping("/importCSV")
	public String addDocumentCsv(Model model,HttpServletRequest request,@RequestParam("filecsv") MultipartFile file) throws IOException {//新增資料
		
		UploadFile upLoadFile = new UploadFile();
		DeleteFolder deleteFolder = new DeleteFolder();
		String[] url = upLoadFile.upLoadFile(file, request);
		List<DocumentVO> documentList = new ArrayList<DocumentVO>();
		
		CsvToDB csvToDB = new CsvToDB();
		documentList = csvToDB.CsvToDB(url[1]);
		for(DocumentVO documentVO:documentList){
			System.out.println(documentVO.getName());
			documentService.addDocumentList(documentVO);
		}
		
		//刪除來源資料夾
		int Index = url[1].lastIndexOf("\\");
        String deleteFloder = url[1].substring(0, Index-8);
        File file1 = new File(deleteFloder);
		deleteFolder.deleteALL(file1);
		return "success";
	}	
//		
	
}