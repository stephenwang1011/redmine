package com.incito.redmine.util;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ConditionalsAfterClick {
public static void judge(JTextField jtf,ButtonGroup bg,JProgressBar jpb){
	Enumeration<AbstractButton> en=bg.getElements();
	while(en.hasMoreElements()){
	AbstractButton ab=en.nextElement();
	boolean b = ab.isSelected();
	if("".equals(jtf.getText().trim())){
		  JOptionPane.showMessageDialog(null, "您还没有选择文件!"); 
		
	}else if(b==false){

		  JOptionPane.showMessageDialog(null, "您还没有选择项目!"); 
	}else if("".equals(jtf.getText().trim())&&b==false){
		
		 JOptionPane.showMessageDialog(null, "您还没有选择文件!"); 
		
	}else{
		Thread stepper = new BarProgress(jpb);
        stepper.start();
		
	}
	
}
	}
}

