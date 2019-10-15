package com.document.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.dao.Document_Interface;
import com.document.pojo.DocumentVO;
import com.document.service.DocumentService;


@Service
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	private Document_Interface document_Interface;//UserMapper 是接口

	@Override
	public void addDocumentList(DocumentVO documentVO) {
		document_Interface.insert(documentVO);
		
	}

	@Override
	public int updateDocumentList(DocumentVO documentVO) {
		return document_Interface.update(documentVO);
	}

	@Override
	public void deleteDocumentList(int id) {
		document_Interface.delete(id);
		
	}

	@Override
	public DocumentVO getDocumentListByPK(int id) {
		return document_Interface.findDoumentByPrimaryKey(id);
	}

	@Override
	public List<DocumentVO> getAll() {
		return document_Interface.getAll();
	}



}
