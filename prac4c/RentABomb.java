package prac4c;

import java.util.*;

public class RentABomb {
	private ArrayList<Vehicle> vehicles;
	
	public RentABomb(){
		vehicles = new ArrayList<Vehicle>();
	}
	
	private void addVehicle(){
		Scanner input = null;
		try{
			input = new Scanner(System.in);
			System.out.println("Make: ");
			String make = input.nextLine();
			System.out.println("Model: ");
			String model = input.nextLine();
			System.out.println("Year: ");
			int year = input.nextInt();
			
			System.out.println("Rented status: " +
								"\n1. Is rented (true)." +
								"\n2. Is not rented (false).");
			int rentChoice = input.nextInt();
			
			boolean isRented;
			
			if(rentChoice == 1){
				isRented = true;
			}
			else if(rentChoice == 2){
				isRented = false;
			}
			else{
				System.out.println("Invalid choice. Defaulting to is not rented (false).");
				isRented = false;
			}
			
			int typeOfVehicle = 0;
			System.out.println("Type of vehicle: " +
								"\n1. Car" +
								"\n2. Truck");
			
			typeOfVehicle = input.nextInt();
			
			switch(typeOfVehicle){
			case 1:
				System.out.println("Car selected.");
				System.out.println("Number of seats: ");
				int numberOfSeats = input.nextInt();
				System.out.println("Engine capacity: ");
				double engineCapacity = input.nextDouble();
				
				Vehicle cv = new Car(make, model, year, isRented, numberOfSeats, engineCapacity);
				vehicles.add(cv);
				
				break;
			case 2:
				input.nextLine();
				System.out.println("Truck selected");
				System.out.println("Operation load: ");
				String optLoad = input.nextLine();
				
				Vehicle tv = new Truck(make, model, year, isRented, optLoad);
				vehicles.add(tv);
				
				break;
			default:
				System.out.println("Incorrect selection. Please enter either 1 or 2.");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void listVehicles(){
		for(Vehicle v: vehicles){
			System.out.println(v);
		}
	}
	
	private void listAvailable(){
		for(Vehicle v: vehicles){
			if(v.getIsRented() == false){
				System.out.println(v);
			}
		}
	}
	
	private void removeVehicle(){
		Scanner input = null;
		try{
			input = new Scanner(System.in);
			
			//Call list method to display all before prompt.
			listVehicles();
			
			System.out.println("\nEnter ID to remove: ");
			int id = input.nextInt();
			
			Vehicle removed = null;
			
			for(int i = 0; i < vehicles.size(); i++){
				Vehicle v = vehicles.get(i);
				if(id == v.getID()){
					removed = vehicles.remove(i);
					System.out.println("\nRemoved: " + removed);
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void searchForAvailableCar(){
		//Search available cars by make.
		Scanner input = null;
		try{
			input = new Scanner(System.in);
			System.out.println("Enter desired make: ");
			String make = input.nextLine();
			
			for(Vehicle v: vehicles){
				if(v instanceof Car && v.getMake().equalsIgnoreCase(make)){
					System.out.println(v);
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	private void rentVehicle(){
		Scanner input = null;
		try{
			input = new Scanner(System.in);
			
			//Call list method to display all before prompt.
			listAvailable();
			
			System.out.println("\nEnter ID to rent: ");
			int id = input.nextInt();
			
			for(Vehicle v: vehicles){
				if(v.getID() == id){
					v.setIsRented(true);
				}
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void run(){
		Scanner input = null;
		try{
			boolean flag = true;
		
			while(flag){
				System.out.println("\n1. Add  vehicle\n" +
									"2. List all vehicles\n" +
									"3. List available vehicles\n" +
									"4. Remove vehicle by ID\n" +
									"5. Search available cars by make\n" +
									"6. Rent a vehicle\n" +
									"7. Quit");	
				
				input = new Scanner(System.in);
				int choice = 0;
			
				System.out.println("Enter your choice (1 - 7): ");
				choice = input.nextInt();
				
				switch(choice){
				case 1:
					addVehicle();
					break;
				case 2:
					listVehicles();
					break;
				case 3:
					listAvailable();
					break;
				case 4:
					removeVehicle();
					break;
				case 5:
					searchForAvailableCar();
					break;
				case 6:
					rentVehicle();
					break;
				case 7:
					flag = false;
					break;
				default:
					System.out.println("Incorrect input. Please enter a number between 1 and 7.");
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			if(input != null){
				input.close(); //Close scanner.
			}
		}
	}
}
