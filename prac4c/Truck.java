/* Subclass of Vehicle */

package prac4c;

public class Truck extends Vehicle{
	private String optLoad; //Operation load?
	
	public Truck(){
	}
	
	public Truck(String make, String model, int year, boolean isRented, String optLoad){
		super(make, model, year);
		super.isRented = isRented; //Optionally could have used set method in RentABomb class.
		this.optLoad = optLoad;
	}
	
	public String getOptLoad(){
		return optLoad;
	}
	
	public String toString(){
		return super.toString() + "\nOperation load: " + optLoad;
	}

}
