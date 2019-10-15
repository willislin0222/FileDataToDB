package com.document.service;

import java.util.List;

import com.document.pojo.DocumentVO;

public interface DocumentService {

	public void addDocumentList(DocumentVO documentVO);
	public int  updateDocumentList(DocumentVO documentVO);
	public void deleteDocumentList(int id);
	public DocumentVO getDocumentListByPK(int id);
	public List<DocumentVO> getAll();
}
