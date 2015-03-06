
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

;
public class ParserThread extends Thread{
		private GUI gui;
		private boolean running=true;
		private String id;
		private String id2;

public ParserThread(GUI _gui, String id, String id2){ //Parsen ska kunna ändra i GUI
	System.err.println("error");
	System.out.println("error");
	this.gui=_gui;
	this.id=id;
	this.id2=id2;
}



public void run (){

	
	String mystring=Constants.getURL(id,id2,5); // Hämtar info om sökningen och får en väldigt lång adress..	
	Journeys journeys = Parser.getJourneys(mystring); // UML 	// lägg i skånetrafikens API få ut resor översatt från xml
	//journeys // innehåller data i olika variabler
	
	// få ut information/ data 
	gui.a.stop();
	gui.Displaytxt.setText("");
	for (Journey journey : journeys.getJourneys()) {

		//Result.setText("hello dudes!");
		//Result.append(String.valueOf(journey.getStartStation()));
		//Result.append(String.valueOf(journey.getEndStation()));
		//Result.append(String.valueOf(journey.
	
		gui.Displaytxt.append(journey.getStartStation()+" - ");
		gui.Displaytxt.append(journey.getEndStation()+" ");
		String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
		gui.Displaytxt.append(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late \n");
		
		
		System.out.print(journey.getStartStation()+" - ");
		System.out.print(journey.getEndStation());
		 time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
		System.out.print(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late \n");
	} 

	
}






}
