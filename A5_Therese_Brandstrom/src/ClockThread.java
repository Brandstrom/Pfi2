import java.awt.*;
import java.util.Calendar;

public class ClockThread extends Thread {
	
	String currentTime;
	Label labelToChange;
	boolean keepGoing = true; // oändlig whileloop
	
	
	//Konstruktor
	
	ClockThread(Label lbl){
		super();
		labelToChange = lbl;
	}
	
	//Metod1
	
	public void stopLoping(){
		keepGoing = false;
		
	}
	
	//Metod2
	
	public void run(){
	while (keepGoing){
		try {
		
			Thread.sleep(900);
		} catch (InterruptedException e){
			e.printStackTrace();
		
		}
		
		//Variabel
		
		//currentTime = String.valueOf(new Date());
		labelToChange.setText(currentTime);
	}
		
	}
	
}
