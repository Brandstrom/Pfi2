
public class Bike {
	
	private String color;
	private int price;
	private int size;
	
	
	
	//Konstruktor1
	public Bike(String color,int size) {
		this.size=size;
		this.color = color;
		checkColor();
		
	}
	
	//Konstruktor2
	public Bike(String color, int size, int price) {
		this.color = color;
		this.size = size;
		this.price= price;
		checkColor();
		
		if(price< Constants.minPrice){
			this.price = Constants.minPrice;
			
		} else if(price> Constants.maxPrice){
		this.price = Constants.maxPrice;
		
	} else {
		
		this.price = price;
		
	}
	
}
	{
	
	if(price< Constants.minPrice){
		this.size = Constants.minSize;
		
	} else if(size> Constants.maxSize){
	this.size = Constants.maxSize;
	
} else {
	
	this.size = size;
	
}
	}
	public void checkColor(){
		//Kontrollerar färgerna

		boolean correctColor = false;
		for (int i = 0; i < Constants.aloudcolors.length; i++) {
			if (color.equals(Constants.aloudcolors[i])) {
				correctColor = true;
			}
		}
		System.out.println(correctColor);
	}


	//Metod
	public String getcolor(){	
	return color;
}

	public int getsize(){
	return size;

}

	public int getprice(){
	return price;
		
	
}

	public void setprice(int price){
}

	
	
}
