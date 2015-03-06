public abstract class Mammal extends Animal {
	
	private int gestationTime;

	public Mammal(String latinName, int gestationTime) {
		super(latinName);
		this.gestationTime = gestationTime;
	}
	
	

	public int getGestationTime() {
		return gestationTime;
	}


	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}