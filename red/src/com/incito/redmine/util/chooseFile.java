package com.incito.redmine.util;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class chooseFile {
	public static void choose(File file,JTextField jtf){
		
		 JFileChooser jfc=new JFileChooser();  
		 //下面三行定义了文件选择器 
		 ExcelFileFilter excelFilter = new ExcelFileFilter();
		 jfc.addChoosableFileFilter(excelFilter);
		 jfc.setFileFilter(excelFilter); 
	        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
	       jfc.showDialog(new JLabel(), "选择");  
	         file=jfc.getSelectedFile();  
	         try{
	        if(file.isDirectory()){  
	           // System.out.println("文件夹:"+file.getAbsolutePath());  
	 
	        }else if(file.isFile()){  
	   
	        	//把文件路径放入到输入框
	        	jtf.setText(file.getAbsolutePath());
	            
	        }  
	        System.out.println(jfc.getSelectedFile().getName()); 
	         }catch(Exception ex){
	        	
	         }
		
		
	}

}
