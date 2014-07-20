package com.incito.redmine.util;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class BarProgress extends Thread {
	

	    private static int DELAY = 500;
	    JProgressBar progressBar;    

	    public BarProgress(JProgressBar bar) {
	      progressBar = bar;
	    }

	    public void run() {
	      int minimum = progressBar.getMinimum();
	      int maximum = progressBar.getMaximum();
	      Runnable runner = new Runnable() {
	        public void run() {
	          int value = progressBar.getValue();
	          progressBar.setValue(value+1);
	        }
	      };
	      for (int i=minimum; i<maximum; i++) {
	        try {
	          SwingUtilities.invokeAndWait(runner);
	          // Our task for each step is to just sleep
	          Thread.sleep(DELAY);
	          if(i==maximum-1){
	        	  JOptionPane.showMessageDialog(null, "统计已经完成"); 
	        	  progressBar.setValue(minimum);
	          }
	        } catch (InterruptedException ignoredException) {
	        } catch (InvocationTargetException ignoredException) {
	        }
	      }
	    }

}
