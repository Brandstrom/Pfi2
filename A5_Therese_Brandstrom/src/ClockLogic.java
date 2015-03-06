import java.util.Calendar;

import java.util.List;

import javax.swing.SwingWorker;

public class ClockLogic extends SwingWorker <Void, Void> implements ClockInterface{


ClockGUI clock;
public int time_hours;
public int time_minutes;
public int time_seconds;
public static int alarm_hours;
public static int alarm_minutes;
public static int alarm_second;
private boolean alarm;

public ClockLogic(ClockGUI gui){
	
	clock = gui;
}

@Override 
protected Void doInBackground() throws Exception {
	while(isCancelled() == false){
		
		if(time_hours == alarm_hours && time_minutes == alarm_minutes && time_seconds == alarm_second && alarm == true){
			clock.invokeAlarm();
			System.out.println("Vakna NU Latmask!");
		}
		
		this.publish();
	}
	return null;
}

protected void process(List<Void> chunks){
	

Calendar minTid = Calendar.getInstance();
time_hours = minTid.get(Calendar.HOUR_OF_DAY);
time_minutes = minTid.get(Calendar.MINUTE);
time_seconds = minTid.get(Calendar.SECOND);

clock.setTime(time_hours, time_minutes, time_seconds);

}
public void setAlarm(int hours, int minutes, int seconds){
	
	alarm_hours = hours;
	alarm_minutes = minutes;
	alarm_second = seconds;
	
}

public void setBoolean(boolean Alarm){
	alarm = Alarm;
}

public void reset(){
	
	alarm_hours = 0;
	alarm_minutes = 0;
	alarm_second = 0;
}

@Override
public void update(int hours, int minutes, int seconds) {
	// TODO Auto-generated method stub
	
}

}
