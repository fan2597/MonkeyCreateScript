package com.jikexueyuan;

import java.util.ArrayList;

/**
 * 
 * @author fan2597
 * Create Date:2015-12-10
 * Version:  V1.0
 * CopyRright (c)2015:JIKEXUEYUAN
 */
public class EventModel {
   
	ArrayList<String> event=new ArrayList<String>();
	
	public void print(){
		for(String s:event){
			System.out.println("[EVENT]: "+s);
		}
	}
	
}
