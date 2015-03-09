import java.util.*;
public class TestMainBike {
	
	
public static void main(String[] args) {
	BikeStore Objekt = new BikeStore();

//Konstruktor1
	
ArrayList<Bike> bikelist = new ArrayList<Bike>();

bikelist.add ( new Bike("blue", 20, 500));
bikelist.add ( new Bike("pink",25, 500));
bikelist.add ( new Bike("gold",10, 2000));
bikelist.add ( new Bike("green", 20, 1500));
bikelist.add ( new Bike("black", 50, 500));
bikelist.add ( new Bike("yellow", 70, 500));
bikelist.add ( new Bike("silver", 20, 500));
bikelist.add ( new Bike("purple", 25, 500));
bikelist.add ( new Bike("white", 90, 500));
bikelist.add ( new Bike("red", 25, 500));


//String[] ColorList = new String [Constants.ColorListSize];
/*
for (int i = 0; i<10; i++){
	
	System.out.println("Bike "+ (i+1)+ " Price: " +
	String.valueOf(bikelist.get(i).getprice())+ " SEK / "+ " Size:  " +
	String.valueOf(bikelist.get(i).getsize()) + " inches/ "+ " Color: "
	+String.valueOf(bikelist.get(i).getcolor()));	


}*/
}
}

	


