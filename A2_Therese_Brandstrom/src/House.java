public class House {
	
	public int yearBuilt;
	private final int minYearBuilt = 1800;
	private final int maxYearBuilt = 2015;
	public int size; 
	private final int minSize = 10;
	private final int maxSize = 1000;
	
	public House(int _size,int _yearBuilt){// constructor
		size=_size;
		yearBuilt=_yearBuilt;
	//System.out.println(getSize());

   } 

   public int getYearBuilt(){
		System.out.println(yearBuilt);
	return yearBuilt; 
   } 
   
   public int getSize() {
	 return size;
   } 

   public void setYearBuilt(){
	   
   } 
   
  
   

} 


