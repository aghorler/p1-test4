/* Superclass */

package prac4c;

public class Vehicle{
	  protected String make, model;
	  protected int year;
	  protected boolean isRented;
	  static int nextId;
	  protected int id;

	  public Vehicle(){
	  }
	  
	  public Vehicle(String make, String model, int year){
		  this.make = make;
		  this.model = model;
		  this.year = year;
		  id = nextId++;
	  }
	  
	  public String getMake(){
		  return make;
	  }
	  
	  public String getModel(){
		  return model;
	  }
	  
	  public int getYear(){
		  return year;
	  }
	  
	  public void setMake(String make){
		  this.make = make;
	  }
	  
	  public void setModel(String model){
		  this.model = model;
	  }
	  
	  public void setYear(int year){
		  this.year = year;
	  }
	  
	  public void setIsRented(boolean isRented){
		  this.isRented = isRented;
	  }
	  
	  public boolean getIsRented(){
		  return isRented;
	  }
	  
	  public int getID(){
		  return id;
	  }

	  public String toString(){
	    return "\nID: "+ id + "\nMake: " +  make + "\nModel: " + model + "\nYear: " + year;
	  }
	}
