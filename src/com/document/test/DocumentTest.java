package com.document.test;
 
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.document.pojo.DocumentVO;
import com.document.service.DocumentService;


public class DocumentTest extends Junit4Test{
 
	@Autowired
	private DocumentService documentService;	
	

 
	@Test
	@Transactional
	@Rollback(false)//防止事务自动回滚
	public void test() {
		testUser();
	}
	
	private void testUser() {
		
		
		//addDocument
		DocumentVO documentVO = new DocumentVO();
		documentVO.setName("test");
		documentVO.setAddress("1234");
		documentVO.setSex("F");
		documentVO.setTel("0912345678");
		documentVO.setJoindate(new Date(System.currentTimeMillis()));
		documentService.addDocumentList(documentVO);
		
//		upateDocument
//		DocumentVO documentVO = new DocumentVO();
//		documentVO = documentService.getDocumentListByPK(1);
//		documentVO.setSex("M");
//		documentService.updateDocumentList(documentVO);
		
		//deleteDocument
//		documentService.deleteDocumentList(2);
		
		//getAllDocumentrList
//		List<DocumentVO> documentVOlist = new ArrayList<DocumentVO>();
//		for(DocumentVO documentList:documentVOlist){
//			System.out.println(documentList.getId() + documentList.getSex());
//		}
	}
}