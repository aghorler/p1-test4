/* Subclass of Vehicle */

package prac4c;

public class Car extends Vehicle{
	private int numberOfSeats;
	private double engineCapacity;
	
	public Car(){
	}
	
	public Car(String make, String model, int year, boolean isRented, int numberOfSeats, double engineCapacity){
		super(make, model, year);
		super.isRented = isRented; //Optionally could have used set method in RentABomb class.
		this.numberOfSeats = numberOfSeats;
		this.engineCapacity = engineCapacity;
	}
	
	public int getNumberOfSeats(){
		return numberOfSeats;
	}
	
	public double getEngineCapacity(){
		return engineCapacity;
	}
	
	public String toString(){
		return super.toString() + "\nNumber of Seats: " + numberOfSeats + "\nEngine capacity: " + engineCapacity;
	}
}
