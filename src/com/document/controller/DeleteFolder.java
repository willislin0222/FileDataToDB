package com.document.controller;

import java.io.File;

public class DeleteFolder {
	
	public void deleteALL(File path){
        
        if (!path.exists()) {
            return;
        }
        if (path.isFile()) {
            path.delete();
            return;
        }
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
        	deleteALL(files[i]);
        }
        path.delete();
	}
}
