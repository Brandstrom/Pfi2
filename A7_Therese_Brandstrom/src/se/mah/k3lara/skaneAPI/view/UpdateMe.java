package se.mah.k3lara.skaneAPI.view;
import java.util.Calendar;

public class UpdateMe extends Thread{
	private GUI gui;
	private boolean running = true;

	public UpdateMe(GUI g){
		this.gui = g;
	}

	public void run() {
		while(running==true){
			try{
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Uppdaterar");
		
			gui.UpdateLabels(); 
		}

	}

}