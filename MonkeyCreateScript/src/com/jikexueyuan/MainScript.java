package com.jikexueyuan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author fan2597
 * Create Date:2015-12-10
 * Version:  V1.0
 * CopyRright (c)2015:JIKEXUEYUAN
 */
public class MainScript {
	/**
	 * 事件不用设置太多，可以使用1000个事件来分，如30%则设置300
	 * 如果要跑3万，则将生成的脚本执行30次，即30*1000=3万
	 */
	private static int eventTouch=100;
	private static int eventMotion=100;
	private static int eventPinchzoom=50;
	private static int eventTrackball =10;
	private static int eventRotation=50;
	private static int eventNav =100;
	private static int eventMajornav=100;
	private static int eventSyskeys=30;
	private static int eventAppswitch =30;
	private static int eventFlip=30;
	private static int eventAnyevent =100;
	private static int eventLongpress =100;//补充长按事件
	private static int eventHorizontalSlip=100;
	private static int eventKeyCoord=100;
	
	private static int width=720;
	private static int height=1080;
	private static int throttle=200;
	
	private static String limit_coord="1,2,3,4";//限制坐标区域输入格式     100,100,200,200|100,100,200,200
	private static String key_coord="1,2,3,4";//重点区域坐标，可以增加点击频率
	private static String openAppCmd="";//循环间隔执行的命令
	private static int interval=30;
	private static String app="notification";//notification incallui keyguard


	public static void main(String[] args) {
		System.out.println("***************************************");
		for(int i=0;i<args.length;i++){
			if(args[i].equals("--pct-touch")){
				eventTouch=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-TOUCH:"+eventTouch);
			}else if(args[i].equals("--pct-motion")){
				eventMotion=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-MOTION:"+eventMotion);
			}else if(args[i].equals("--pct-pinchzoom")){
				eventPinchzoom=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-PINCH_ZOOM:"+eventPinchzoom);
			}else if(args[i].equals("--pct-trackball")){
				eventTrackball=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-TRACKBALL:"+eventTrackball);
			}else if(args[i].equals("--pct-rotation")){
				eventRotation=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-ROTATION:"+eventRotation);
			}else if(args[i].equals("--pct-nav")){
				eventNav=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-NAV:"+eventNav);
			}else if(args[i].equals("--pct-majornav")){
				eventMajornav=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-MAJORNAV:"+eventMajornav);
			}else if(args[i].equals("--pct-syskeys")){
				eventSyskeys=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-SYSKEY:"+eventSyskeys);
			}else if(args[i].equals("--pct-appswitch")){
				eventAppswitch=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-APPSWITCH:"+eventAppswitch);
			}else if(args[i].equals("--pct-flip")){
				eventFlip=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-FLIP:"+eventFlip);
			}else if(args[i].equals("--pct-anyevent")){
				eventAnyevent=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-ANYEVENT:"+eventAnyevent);
			}else if(args[i].equals("--throttle")){
				throttle=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-THROTTLE:"+throttle);
			}else if(args[i].equals("--pct-longpress")){
				eventLongpress =Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-LONG_PRESS:"+eventLongpress);
			}else if(args[i].equals("--pct-horizontal_slip")){
				eventHorizontalSlip =Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-HORIZONTAL_SLIP:"+eventHorizontalSlip);
			}else if(args[i].equals("--pct-key-coord")){
				eventKeyCoord =Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-KEY_COORD:"+eventKeyCoord);
			}else if(args[i].equals("--limit_coor")){
				limit_coord =args[i+1];
				System.out.println("[EVENT]-LIMIT_COORD:"+limit_coord);
			}else if(args[i].equals("--key_coor")){
				key_coord =args[i+1];
				System.out.println("[EVENT]-KEY_COORD:"+key_coord);
			}
			
			else if(args[i].equals("--width")){
				width=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-WIDTH:"+width);
			}else if(args[i].equals("--height")){
				height=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-HEIGHT:"+height);
			}else if(args[i].equals("--launch-app")){
				openAppCmd=args[i+1];
				System.out.println("[EVENT]-OPEN_CMD:"+openAppCmd);
			}else if(args[i].equals("--app")){
				app=args[i+1];
				System.out.println("[EVENT]-APP:"+app);
			}else if(args[i].equals("--interval")){
				interval=Integer.parseInt(args[i+1]);
				System.out.println("[EVENT]-INTERVAL:"+interval);
			}
			
			
		}
		System.out.println("***************************************");
		
		
		
		
		 Event e=new Event();
		 ArrayList<EventModel> touch=e.createTouch(eventTouch, width, height);
		 ArrayList<EventModel> motion=e.createMotion(eventMotion, width, height);
		 ArrayList<EventModel> pinchzoom=e.createPinchzoom(eventPinchzoom, width, height);
		 ArrayList<EventModel> trackball=e.createTrackball(eventTrackball, width, height);
		 ArrayList<EventModel> rotation=e.createRotation(eventRotation);		
		 ArrayList<EventModel> nav=e.createNav(eventNav);
		 ArrayList<EventModel> majornav=e.createMajornav(eventMajornav);
		 ArrayList<EventModel> syskey=e.createSyskey(eventSyskeys);
		 ArrayList<EventModel> flip=e.createFlip(eventFlip);
		 ArrayList<EventModel> anyevent=e.createAnyevent(eventAnyevent);
		 ArrayList<EventModel> longpress=e.createLongpress(eventLongpress, width, height);
		 ArrayList<EventModel> horizontalSlip=e.createHorizontalSlip(eventHorizontalSlip, width, height);
		 ArrayList<EventModel> keyCoord=e.createKeyTouch(eventKeyCoord, width, height);
		
		 //应用事件
		 ArrayList<EventModel> notification=e.createNotification();
		 ArrayList<EventModel> incalllui=null;
		 if(app.contains("incallui")){
		    incalllui=e.createCall(app.replaceAll(".*-", ""));
		 }
		 ArrayList<EventModel> keyguard=e.createKeyguard();
		 
		 
		 
		 List<EventModel> eventList=new ArrayList<EventModel>();
		 eventList.addAll(touch);
		 eventList.addAll(motion);
		 eventList.addAll(pinchzoom);
		 eventList.addAll(trackball);
		 eventList.addAll(rotation);
		 eventList.addAll(nav);
		 eventList.addAll(majornav);
		 eventList.addAll(syskey);
		 eventList.addAll(flip);
		 eventList.addAll(anyevent);
		 eventList.addAll(longpress);
		 eventList.addAll(horizontalSlip);
		 eventList.addAll(keyCoord);
		 
		 //seed 种子变化随机序列，多少次种子就变化多少次
		 int seed=new Random().nextInt(8);
		 while(seed==0){
			 seed=new Random().nextInt(8); 
		 }
		 for(int i=0;i<seed;i++){
			 Collections.shuffle(eventList); 
		 }
		
		 
		 String cmd=String.format("RunCmd(%s)", openAppCmd);
		 String fileName="monkeyscript.txt";
		 File file=new File(fileName);
		 while(file.exists()){
			 file.delete();
		 }
		 System.out.println("**************开始生成脚本***************");
		 saveHead(fileName);
		 saveToFile(cmd, fileName);
		 for(int i=0;i<eventList.size();i++){
			 if(i%interval==0){
				 saveToFile(cmd, fileName);
			 }
			 if(app.contains("notification")){
				 if(i%30==0){
					 for(String ns: notification.get(0).event){
						 saveToFile(ns, fileName); 
					 }
					
				 }
			 }else if(app.contains("incallui")){
				 if(i%30==0&&incalllui!=null){
					 for(String ns: incalllui.get(0).event){
						 saveToFile(ns, fileName); 
					 }
					
				 }
			 }else if(app.contains("keyguard")){
				 if(i%30==0){
					 for(String ns: keyguard.get(0).event){
						 saveToFile(ns, fileName); 
					 }
				 }
			 }
			 
			 
			 
			 for(int k=0;k<eventList.get(i).event.size();k++){
				 saveToFile(eventList.get(i).event.get(k), fileName);				 
			 }
			// saveToFile(String.format("UserWait(%s)", throttle), fileName);	
			 
		 }
		 System.out.println("***********************************************");
		 System.out.println("*****************生成脚本成功**********************");
		 System.out.println("****脚本保存在当前文件夹下，文件名为：monkeyscript.txt****");
		 System.out.println("***********************************************");
		

	}
	
	public static void saveHead(String fileName){
		saveToFile("type= raw events",fileName);
		saveToFile("count= 10",fileName);
		saveToFile("speed= 1.0",fileName);
		saveToFile("start data >>",fileName);
	}
	
	public static void saveToFile(String text,String fileName) {
		System.out.println(text);
		File runFile = new File(fileName);
		while(!runFile.exists()){
			try {
				runFile.createNewFile();
			} catch (IOException e) {
			}
		}
		BufferedWriter fw = null;
		try {			
			fw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(runFile, true)));
			
			fw.append(text);
			fw.newLine();
			fw.flush(); 			
			fw.close();
		} catch (FileNotFoundException e) {
			 throw new RuntimeException(e); 
		} catch (IOException e) {
			 throw new RuntimeException(e); 
		}
	}
	
	/**
	 * 判断坐标是否在限制区域
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isLimitCoordinate(int x,int y){
		String[] coor=limit_coord.split("\\|");
		for(int i=0;i<coor.length;i++){
		      String[] xy=coor[i].split(",");
		      if(xy.length<4){
		    	  System.out.println("限制坐标格式不对，请按括号里格式填写（1,2,3,4|4,5,6,7）");
		    	  System.exit(1);
		      }
		      if(x>=Integer.parseInt(xy[0])&&x<=Integer.parseInt(xy[2])){
		    	  if(y>=Integer.parseInt(xy[1])&&y<=Integer.parseInt(xy[3])){
		    		 return true; 
		    	  }
		      }
		}
		return false;
	}
	/**
	 * 判断坐标是否落在重点区域
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isKeyCoordinate(int x,int y){
		String[] coor=key_coord.split("\\|");
		for(int i=0;i<coor.length;i++){
		      String[] xy=coor[i].split(",");
		      if(xy.length<4){
		    	  System.out.println("重点区域坐标格式不对，请按括号里格式填写（1,2,3,4|4,5,6,7）");
		    	  System.exit(1);
		      }
		      if(x>=Integer.parseInt(xy[0])&&x<=Integer.parseInt(xy[2])){
		    	  if(y>=Integer.parseInt(xy[1])&&y<=Integer.parseInt(xy[3])){
		    		 return true; 
		    	  }
		      }
		}
		return false;
	}
	

}
