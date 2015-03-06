
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

;
public class AnimationThread extends Thread{
		private GUI gui;
		private boolean running=true;

public AnimationThread(GUI _gui){ //Parsen ska kunna ändra i GUI
	System.err.println("error");
	System.out.println("error");
	this.gui=_gui;
	
}



public void run (){
/*
	for(int i=0 ;    i < 10     ;  i=i + 1  ){  
		System.out.println("loopar");	
	}
	*/
	String dots=".";
while(running==true){
	
	
	try{
		//System.out.println(gui.siffra);	
		gui.Displaytxt.setText("Searching"+dots);//DIsplayar ut text	
		dots+=".";
		
		Thread.sleep(500);
	}catch(Exception e){

	}
	
}






}
}