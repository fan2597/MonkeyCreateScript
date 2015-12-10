package com.jikexueyuan;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author fan2597
 * Create Date:2015-12-10
 * Version:  V1.0
 * CopyRright (c)2015:JIKEXUEYUAN
 */
public class Event {
	
	/**
	 * 创建Touch事件
	 * @param count
	 * @param width
	 * @param height
	 * @return
	 */
	public ArrayList<EventModel> createTouch(int count,int width,int height){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		int x=0;
		int y=0;
		int tapDuration=10;
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			x=new Random().nextInt(width);
			y=new Random().nextInt(height);
			tapDuration=new Random().nextInt(50);
			while(MainScript.isLimitCoordinate(x, y)){
				//限制坐标区域功能
				x=new Random().nextInt(width);
				y=new Random().nextInt(height);
				
			}
			cmd=String.format("Tap(%s,%s,%s)", x,y,tapDuration);
			model.event.add(cmd);
            events.add(model);
            System.out.println("[SCRIPT]: "+cmd);
		}
		return events;
	}
	/**
	 * 创建增加关键坐标的频率
	 * @param count
	 * @param width
	 * @param height
	 * @return
	 */
	public ArrayList<EventModel> createKeyTouch(int count,int width,int height){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		int x=0;
		int y=0;
		int tapDuration=10;
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			x=new Random().nextInt(width);
			y=new Random().nextInt(height);
			tapDuration=new Random().nextInt(50);
			while(!MainScript.isKeyCoordinate(x, y)){
				//限制坐标区域功能
				x=new Random().nextInt(width);
				y=new Random().nextInt(height);				
			}
			cmd=String.format("Tap(%s,%s,%s)", x,y,tapDuration);
			model.event.add(cmd);
            events.add(model);
            System.out.println("[SCRIPT]: "+cmd);
		}
		return events;
	}
	/**
	 * 创建导航事件
	 * @param count
	 * @return
	 */
	public ArrayList<EventModel> createNav(int count){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String keyName="KEYCODE_DPAD_UP";
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			int nav=new Random().nextInt(100);
			if(nav<=25){
				keyName="KEYCODE_DPAD_UP";
			}else if(nav>25&&nav<=50){
				keyName="KEYCODE_DPAD_DOWN";
			}else if(nav>50&&nav<=75){
				keyName="KEYCODE_DPAD_LEFT";
			}else{
				keyName="KEYCODE_DPAD_RIGHT";
			}
			cmd=String.format("DispatchPress(%s)", keyName);
			model.event.add(cmd);
			events.add(model);	
			System.out.println("[SCRIPT]: "+cmd);
		}
		return events;
	}
	
	/**
	 * 创建主要导航事件
	 * @param count
	 * @return
	 */
	public ArrayList<EventModel> createMajornav(int count){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String keyName="KEYCODE_MENU";
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			int nav=new Random().nextInt(100);
			if(nav<=20){
				keyName="KEYCODE_MENU";
			}else{
				keyName="KEYCODE_DPAD_CENTER";
			}			
			cmd=String.format("DispatchPress(%s)", keyName);
			model.event.add(cmd);
			events.add(model);	
			System.out.println("[SCRIPT]: "+cmd);
		}
		return events;
	}
	/**
	 * 创建系统按键事件
	 * @param count
	 * @return
	 */
	public ArrayList<EventModel> createSyskey(int count){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String keyName="KEYCODE_BACK";
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			int nav=new Random().nextInt(100);
			if(nav<=20){
				keyName="KEYCODE_BACK";
			}else if(nav>20&&nav<=30){
				keyName="KEYCODE_CALL";
			}if(nav>30&&nav<=40){
				keyName="KEYCODE_ENDCALL";
			}
			else if(nav>40&&nav<=60){
				keyName="KEYCODE_VOLUME_DOWN";
			}else if(nav>60&&nav<=80){
				keyName="KEYCODE_VOLUME_UP";
			}else{
				keyName="KEYCODE_HOME";
			}
			cmd=String.format("DispatchPress(%s)", keyName);
			model.event.add(cmd);
			events.add(model);	
			System.out.println("[SCRIPT]: "+cmd);
			
		}
		return events;
	}
	/**
	 * 创建其他按键事件
	 * @param count
	 * @return
	 */
	public ArrayList<EventModel> createAnyevent(int count){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		
		ArrayList<Integer> keycode=new ArrayList<Integer>();
		ArrayList<Integer> keycodeOther=new ArrayList<Integer>();
		keycodeOther.add(3);
		keycodeOther.add(4);
		keycodeOther.add(5);
		keycodeOther.add(6);
		keycodeOther.add(19);
		keycodeOther.add(20);
		keycodeOther.add(21);
		keycodeOther.add(22);
		keycodeOther.add(23);
		keycodeOther.add(24);
		keycodeOther.add(25);
		keycodeOther.add(26);//电源
		keycodeOther.add(82);
		//NAV  19-22  MAJORNAV  23 82  syskey 3 4 5 6 24 25
		String cmd="";
		for(int i=0;i<260;i++){
			if(!keycodeOther.contains(i)){
			keycode.add(i);
			}
		}
		
		
		int index=0;
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			
			index=new Random().nextInt(260);			
			while(!keycode.contains(index)){
				index=new Random().nextInt(260);
			}
			cmd=String.format("DispatchPress(%s)", index);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
		return events;
	}
	/**
	 * 创建画直线事件
	 * @param count
	 * @param width
	 * @param height
	 * @return
	 */
	public ArrayList<EventModel> createMotion(int count,int width,int height){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		int x0=0,y0=0,x1=0,y1=0;
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			x0=new Random().nextInt(width);
			y0=new Random().nextInt(height);
			x1=new Random().nextInt(width);
			y1=new Random().nextInt(height);
			
			while(MainScript.isLimitCoordinate(x0, y0)|MainScript.isLimitCoordinate(x1, y1)){
				//限制坐标区域功能
				x0=new Random().nextInt(width);
				y0=new Random().nextInt(height);
				x1=new Random().nextInt(width);
				y1=new Random().nextInt(height);
			}
			cmd=String.format("Drag(%s,%s,%s,%s,6)", x0,y0,x1,y1);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	/**
	 * 创建旋转事件
	 * @param count
	 * @return
	 */
	public ArrayList<EventModel> createRotation(int count){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String rotationDegree="0",peresist="0",cmd="";
		int nav=0;
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			nav=new Random().nextInt(100);
			if(nav<=25){
				rotationDegree="0";
			}else if(nav>25&&nav<=50){
				rotationDegree="1";
			}else if(nav>50&&nav<=75){
				rotationDegree="2";
			}else{
				rotationDegree="3";
			}
			nav=new Random().nextInt(100);
			if(nav<=50){
				peresist="0";
			}else{
				peresist="1";
			}
			cmd=String.format("RotateScreen(%s,%s)", rotationDegree,peresist);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	/**
	 * 创建软键盘开关事件
	 * @param count
	 * @return
	 */
	public ArrayList<EventModel> createFlip(int count){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String keyboardOpen="true",cmd="";
		int nav=0;
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			
			nav=new Random().nextInt(100);
			if(nav<=50){
				keyboardOpen="true";
			}else{
				keyboardOpen="false";
			}
			cmd=String.format("DispatchFlip(%s)", keyboardOpen);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	/**
	 * 创建手势缩放事件
	 * @param count
	 * @param width
	 * @param height
	 * @return
	 */
	public ArrayList<EventModel> createPinchzoom(int count,int width,int height){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		int pt1xStart,pt1yStart,pt1xEnd,pt1yEnd,pt2xStart,pt2yStart,pt2xEnd,pt2yEnd,stepCount;
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			
			pt1xStart=new Random().nextInt(width);
			pt1yStart=new Random().nextInt(height);
			pt1xEnd=new Random().nextInt(width);
			pt1yEnd=new Random().nextInt(height);
			
			pt2xStart=new Random().nextInt(width);
			pt2yStart=new Random().nextInt(height);
			pt2xEnd=new Random().nextInt(width);
			pt2yEnd=new Random().nextInt(height);
			
			while(MainScript.isLimitCoordinate(pt1xStart, pt1yStart)|
					MainScript.isLimitCoordinate(pt1xEnd, pt1yEnd)|
					MainScript.isLimitCoordinate(pt2xStart, pt2yStart)|
					MainScript.isLimitCoordinate(pt2xEnd, pt2yEnd)){
				//限制坐标区域功能
				pt1xStart=new Random().nextInt(width);
				pt1yStart=new Random().nextInt(height);
				pt1xEnd=new Random().nextInt(width);
				pt1yEnd=new Random().nextInt(height);
				
				pt2xStart=new Random().nextInt(width);
				pt2yStart=new Random().nextInt(height);
				pt2xEnd=new Random().nextInt(width);
				pt2yEnd=new Random().nextInt(height);
			}
			
			
			
			
			
			stepCount=new Random().nextInt(10);
			while(stepCount<3){
				stepCount=new Random().nextInt(10);
			}
			
			cmd=String.format("PinchZoom(%s,%s,%s,%s,%s,%s,%s,%s,%s)", pt1xStart,pt1yStart,pt1xEnd,pt1yEnd,pt2xStart,pt2yStart,pt2xEnd,pt2yEnd,stepCount);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	/**
	 * 创建轨迹球事件
	 * @param count
	 * @param width
	 * @param height
	 * @return
	 */
	public ArrayList<EventModel> createTrackball(int count,int width,int height){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String cmd="";
		int x,y;
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			x=new Random().nextInt(width);
			y=new Random().nextInt(height);

			cmd=String.format("DispatchTrackball(5109520,5109520,0,%s,%s,0.20784314,0.06666667,0,0.0,0.0,65539,0)", x,y);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	/**
	 * 创建长按事件
	 * @param count
	 * @param width
	 * @param height
	 * @return
	 */
	public ArrayList<EventModel> createLongpress(int count,int width,int height){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String cmd="";
		int x,y,pressDuration;
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			x=new Random().nextInt(width);
			y=new Random().nextInt(height);
			pressDuration=new Random().nextInt(4000);
			cmd=String.format("PressAndHold(%s,%s,%s)", x,y,pressDuration);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	/**
	 * 创建下拉通知栏事件
	 * @return
	 */
	public ArrayList<EventModel> createNotification(){
		ArrayList<EventModel> events=new ArrayList<EventModel>();		
			EventModel model=new EventModel();	
			//720*1080 终极省电  664  136   1080*1920 终极省电  						
			model.event.add("Drag(300,800,300,400,8)");
			model.event.add("Drag(300,800,300,400,8)");
			model.event.add("Drag(300,10,300,700,8)");
			model.event.add("Drag(300,10,300,700,8)");
			events.add(model);					
	return events;		
	}
	/**
	 * 创建打开拨号盘拨号事件
	 * @param phoneNum
	 * @return
	 */
	public ArrayList<EventModel> createCall(String phoneNum){
		ArrayList<EventModel> events=new ArrayList<EventModel>();		
			EventModel model=new EventModel();	
			//异常页面处理
			model.event.add("Drag(300,800,300,400,8)");
			model.event.add("Drag(300,800,300,300,8)");
			//打开拨号盘，拨号
			model.event.add("RunCmd(am start -a android.intent.action.CALL -d tel:"+phoneNum+")");
			events.add(model);					
	return events;		
	}
	/**
	 * 创建灭屏，唤醒屏幕事件
	 * @return
	 */
	public ArrayList<EventModel> createKeyguard(){
		ArrayList<EventModel> events=new ArrayList<EventModel>();		
			EventModel model=new EventModel();	
			model.event.add("DispatchPress(KEYCODE_POWER)");
			model.event.add("DeviceWakeUp()");		
			model.event.add("DeviceWakeUp()");	
			model.event.add("DeviceWakeUp()");	
			events.add(model);					
	return events;		
	}
	
	/**
	 * 创建水平滑动事件
	 * @param count
	 * @param width
	 * @param height
	 * @return
	 */
	public ArrayList<EventModel> createHorizontalSlip(int count,int width,int height){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String cmd="";
		int x0,x1,y,stepCount;
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			x0=new Random().nextInt(width);
			x1=new Random().nextInt(width);
			y=new Random().nextInt(height);
			stepCount=new Random().nextInt(10);
			cmd=String.format("Drag(%s,%s,%s,%s,%s)", x0,y,x1,y,stepCount);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	
	/**
	 * 创建打开instrumentation脚本事件
	 * @param count
	 * @param test_name
	 * @param runner_name
	 * @return
	 */
	public ArrayList<EventModel> createInstrumentation(int count,String test_name,String runner_name){
		ArrayList<EventModel> events=new ArrayList<EventModel>();
		String cmd="";
		for(int i=0;i<count;i++){
			EventModel model=new EventModel();
			cmd=String.format("LaunchInstrumentation(%s,%s)", test_name,runner_name);
			model.event.add(cmd);
			events.add(model);
			System.out.println("[SCRIPT]: "+cmd);
		}
	return events;		
	}
	
	

}
