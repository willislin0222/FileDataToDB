package com.document.dao;

import java.util.List;

import com.document.pojo.DocumentVO;


public interface Document_Interface {

	public int insert(DocumentVO documentVO);
	public int update(DocumentVO documentVO);
	public void delete(int id);
	public DocumentVO findDoumentByPrimaryKey(int id);
	public List<DocumentVO> getAll();
}
