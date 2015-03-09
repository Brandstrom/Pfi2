import java.util.ArrayList;


public class BikeStore {

	
	
	//Array av Bikes
	
	private ArrayList <Bike> cyklar=new ArrayList <Bike> (); 
	
	//Metod 
	
	public String getAllBikes(){
		String infoOfAllBikes="" ;
		String nrOfBikes="";
		
		for (int i = 0; i<cyklar.size(); i++){
			
			nrOfBikes=nrOfBikes+"Bike "+ (i+1)+ " Price: " +
			String.valueOf(cyklar.get(i).getprice())+ " SEK / "+ " Size:  " +
			String.valueOf(cyklar.get(i).getsize()) + " inches/ "+ " Color: "
			+String.valueOf(cyklar.get(i).getcolor()+"\n");
			

		}
		
		
		return nrOfBikes;
	}

	// Bike Klass
	
public void addBike(String _color, String _size ,String _price){
	cyklar.add(new Bike(_color, Integer.parseInt(_size),Integer.parseInt(_price)));
	
	
}
	
	
	
}