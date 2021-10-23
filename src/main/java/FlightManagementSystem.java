import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.Random;
import java.lang.Exception;


class FlightsDetails extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String flight_str;
	String readStr1, readStr2; //Stores the value from the file in them
	//String filepath;
	int flight_count = 0;
	String[][] flightArray;
	int flight_select;
	Scanner in = new Scanner(System.in);
	
	
	public FlightsDetails(String message) {
        super(message);
    }
	
	void creating_dataset(String filepath) {
		Random random = new Random();
		int randomNo;
		int temp;
		try {
			FileWriter fstream = new FileWriter(filepath);
			BufferedWriter be = new BufferedWriter(fstream);
			for(int i = 0;i<100;i++) {
				temp = i+1;
				randomNo = random.nextInt(1000000);
				be.write(temp + "\n" + "100"+ "\n" +randomNo + "\n");
			}
			be.close();
		}catch(Exception ex) {
			System.out.println("File not found! \n");
		}
		
		
	}
	
	
	
	void flights_reading(String filepath) {
		try {
			BufferedReader  ne = new BufferedReader(
					new FileReader(filepath));
			while((flight_str = ne.readLine()) != null) {
				flight_count++;
			}
			
			ne.close();

			flight_count  = flight_count/9;
			flightArray = new String[flight_count][9];
			
			System.out.println("Total Flights "+ flight_count+"\n");
			BufferedReader  rd = new BufferedReader(
					new FileReader(filepath));
			int tmpVar = 0;
			while(tmpVar<flight_count) {
				for(int j = 0; j< 9;j++) {
					flight_str = rd.readLine();
					flightArray [tmpVar][j] = flight_str;
					//System.out.println(flightArray[tmpVar][j] + "\n");
				}
				tmpVar++;
			}
			rd.close();		
		}catch(Exception ex) {
			//System.out.println("File not found!");
			return;
		}	
	}
	
	void file_writing(String filepath) {
		try {
			BufferedWriter  be = new BufferedWriter(
					new FileWriter(filepath));
			//be.write("1");
			int tempVar = 0;
			for(;tempVar<flight_count;) {
				for(int j = 0; j<9;j++ ) {
					System.out.println(flightArray[tempVar][j] + "\n");
					be.write(flightArray[tempVar][j] + "\n");
				}
				tempVar++;
			}
			be.close();
		}catch(Exception ex) {
			return;
		}
	}
	
	void searchbyNo() throws FlightsDetails {
		int temp,tmp;
		System.out.println("Please select the flight from 1 to " + flight_count + "\n");
		flight_select = in.nextInt();
		temp = Integer.valueOf(flightArray[flight_select-1][1]);
		if(flight_select < flight_count && flight_select>0) {
			if(temp == 0) {
				System.out.println("Sorry, no seats available. \n");
			}
			else {
				System.out.print("Flight No: "+flightArray[flight_select-1][0]+"\n");
				System.out.print("Flight ID: "+flightArray[flight_select-1][2]+"\n");
				System.out.print("Available Seats: "+flightArray[flight_select-1][1]+"\n");
				System.out.print("Origin: "+flightArray[flight_select-1][3]+"\n");
				System.out.print("Destination: "+flightArray[flight_select-1][4]+"\n");
				System.out.print("Departure Time: "+flightArray[flight_select-1][5]+"\n");
				System.out.print("Arrival Time: "+flightArray[flight_select-1][6]+"\n");
				tmp = Integer.valueOf(flightArray[flight_select-1][7]);
				if(tmp == 1) {
					System.out.print("Economy Class \n\n");
				}else if(tmp == 2) {
					System.out.print("First Class \n\n");
					
				}else if(tmp == 3) {
					System.out.print("Business Class \n\n");
				}
				System.out.print("Price: "+flightArray[flight_select-1][8]+"\n");
			}
		}else {
			throw new FlightsDetails("There's no flight with this number: " + flight_select + "\n");
		}		
	}
	
	void seachbyDes()  throws FlightsDetails{
		String str;
		int temp,tmp;
		System.out.println("Please enter the destination point: \n");
		str = in.nextLine();
		System.out.println("All flights with the same destination point: \n");
		for(int i = 0; i < flight_count;i++) {
			//System.out.println(flightArray[i][4] + "\n");
			if(flightArray[i][4].equals(str) == true) {
				System.out.print("Flight No: "+flightArray[i][0]+"\n");
				System.out.print("Flight ID: "+flightArray[i][2]+"\n");
				System.out.print("Available Seats: "+flightArray[i][1]+"\n");
				System.out.print("Origin: "+flightArray[i][3]+"\n");
				System.out.print("Destination: "+flightArray[i][4]+"\n");
				System.out.print("Departure Time: "+flightArray[i][5]+"\n");
				System.out.print("Arrival Time: "+flightArray[i][6]+"\n");
				tmp = Integer.valueOf(flightArray[i][7]);
				if(tmp == 1) {
					System.out.print("Economy Class \n\n");
				}else if(tmp == 2) {
					System.out.print("First Class \n\n");
					
				}else if(tmp == 3) {
					System.out.print("Business Class \n\n");
				}
				System.out.print("Price: "+flightArray[i][8]+"\n");
			}else if(i + 1  == flight_count){
				System.out.println("There's no flight with this type of class.\n");
			}
		}
	}
	
	void seachbyOrg()  throws FlightsDetails{
		String str;
		int temp,tmp;
		System.out.println("Please enter the origin point: \n");
		str = in.nextLine();
		System.out.println("All flights with the same orgin point: \n");
		for(int i = 0; i < flight_count;i++) {
			if(flightArray[i][3].equals(str) == true) {
				System.out.print("Flight No: "+flightArray[i][0]+"\n");
				System.out.print("Flight ID: "+flightArray[i][2]+"\n");
				System.out.print("Available Seats: "+flightArray[i][1]+"\n");
				System.out.print("Origin: "+flightArray[i][3]+"\n");
				System.out.print("Destination: "+flightArray[i][4]+"\n");
				System.out.print("Departure Time: "+flightArray[i][5]+"\n");
				System.out.print("Arrival Time: "+flightArray[i][6]+"\n");
				tmp = Integer.valueOf(flightArray[i][7]);
				if(tmp == 1) {
					System.out.print("Economy Class \n\n");
				}else if(tmp == 2) {
					System.out.print("First Class \n\n");
					
				}else if(tmp == 3) {
					System.out.print("Business Class \n\n");
					System.out.print("Price: "+flightArray[i][8]+"\n");
				}
			}else if(i + 1  == flight_count){
				System.out.println("There's no flight with this origin point.\n");
			}
		}
	}
	
	void searchbyclass() throws FlightsDetails{
		int str;
		int temp;
		int tmp;
		System.out.println("Please enter the class of flight: \n");
		System.out.println("1. Economy Class \n");
		System.out.println("2. First Class \n");
		System.out.println("3. Business Class \n");
		str = in.nextInt();
		System.out.println("All flights with the same class: \n");
		for(int i = 0; i < flight_count;i++) {
			tmp = Integer.valueOf(flightArray[i][7]);
			if(tmp == str) {
				System.out.print("Flight No: "+flightArray[i][0]+"\n");
				System.out.print("Flight ID: "+flightArray[i][2]+"\n");
				System.out.print("Available Seats: "+flightArray[i][1]+"\n");
				System.out.print("Origin: "+flightArray[i][3]+"\n");
				System.out.print("Destination: "+flightArray[i][4]+"\n");
				System.out.print("Departure Time: "+flightArray[i][5]+"\n");
				System.out.print("Arrival Time: "+flightArray[i][6]+"\n");
				if(tmp == 1) {
					System.out.print("Economy Class \n\n");
				}else if(tmp == 2) {
					System.out.print("First Class \n\n");
					
				}else if(tmp == 3) {
					System.out.print("Business Class \n\n");
				}
				System.out.print("Price: "+flightArray[i][8]+"\n");
			}else if(i + 1  == flight_count){
				System.out.println("There's no flight with this destinantion point.\n");
			}
		}
	}
	 
	void flDetails() throws FlightsDetails{
		int choice = 0;
		int tmp;
		System.out.println("1. See the details of all flights \n");
		System.out.println("2. Select flight number and see all its details \n");
		choice = in.nextInt();
		if(choice == 2 || choice == 1) {
			if(choice  == 1) {
				for(int i=0;i<flight_count;i++) {
					System.out.print("Flight No: "+flightArray[i][0]+"\n");
					System.out.print("Flight ID: "+flightArray[i][2]+"\n");
					System.out.print("Available Seats: "+flightArray[i][1]+"\n");
					System.out.print("Origin: "+flightArray[i][3]+"\n");
					System.out.print("Destination: "+flightArray[i][4]+"\n");
					System.out.print("Departure Time: "+flightArray[i][5]+"\n");
					System.out.print("Arrival Time: "+flightArray[i][6]+"\n");
					//System.out.print("Arrival Time: "+flightArray[i][7]+"\n\n");
					tmp = Integer.valueOf(flightArray[i][7]);
					if(tmp == 1) {
						System.out.print("Economy Class \n\n");
					}else if(tmp == 2) {
						System.out.print("First Class \n\n");
						
					}else if(tmp == 3) {
						System.out.print("Business Class \n\n");
					}
					System.out.print("Price: "+flightArray[i][8]+"\n");
				}
			}
			else if(choice == 2) {
				System.out.println("Please select the flight from 1 to " + flight_count + "\n");
				flight_select = in.nextInt();
				if(flight_select < flight_count && flight_select > 1) {
				System.out.print("Flight No: "+flightArray[flight_select-1][0]+"\n");
				System.out.print("Flight ID: "+flightArray[flight_select-1][2]+"\n");
				System.out.print("Available Seats: "+flightArray[flight_select-1][1]+"\n");
				System.out.print("Origin: "+flightArray[flight_select-1][3]+"\n");
				System.out.print("Destination: "+flightArray[flight_select-1][4]+"\n");
				System.out.print("Departure Time: "+flightArray[flight_select-1][5]+"\n");
				System.out.print("Arrival Time: "+flightArray[flight_select-1][6]+"\n");
				//System.out.print("Arrival Time: "+flightArray[flight_select-1][7]+"\n\n");
				tmp = Integer.valueOf(flightArray[flight_select-1][7]);
				if(tmp == 1) {
					System.out.print("Economy Class \n\n");
				}else if(tmp == 2) {
					System.out.print("First Class \n\n");
					
				}else if(tmp == 3) {
					System.out.print("Business Class \n\n");
				}
				System.out.print("Price: "+flightArray[flight_select-1][8]+"\n");
				}else {
					throw new FlightsDetails("There's no flight with this number: " + flight_select + "\n");
				}
				
			}
		}else {
			throw new FlightsDetails("You selected the wrong choice: " + choice + "\n");
		}
	}
	
}

class passenger extends FlightsDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public passenger(String message) {
		super(message);
	}
	
	String [] pasRecords = new String[15];
	Random random = new Random();
	int randomNo;
	int temp;
	Scanner in = new Scanner(System.in);
	void passengersRecord() {
		randomNo = random.nextInt(1000000);
		pasRecords[0] = String.valueOf(randomNo);
		System.out.println("Enter your first name: ");
		pasRecords[1] = in.nextLine();
		System.out.println("Enter your last name: ");
		pasRecords[2] = in.nextLine();
		System.out.println("Enter your address: ");
		pasRecords[3] = in.nextLine();
		System.out.println("Enter your CNIC: ");
		pasRecords[4] = in.nextLine();
		System.out.println("Enter your flight number: ");
		pasRecords[5] = in.nextLine();
		System.out.println("Enter your seat number: ");
		pasRecords[6] = in.nextLine();
		System.out.println("Enter your age: ");
		pasRecords[7] = in.nextLine();
		System.out.println("Enter your Gender: ");
		pasRecords[13] = in.nextLine();
		System.out.println("Enter your passport no: ");
		pasRecords[8] = in.nextLine();
		System.out.println("Enter your destination point: ");
		pasRecords[9] = in.nextLine();
		System.out.println("Enter your origin point: ");
		pasRecords[14] = in.nextLine();
		System.out.println("Enter type of plane: \n");
		System.out.println("1. Economy Class\n");
		System.out.println("2. First Class\n");
		System.out.println("3. Business Class\n");
		temp = in.nextInt();
		pasRecords[10] = String.valueOf(temp);
		pasRecords[11] = "Reserved at time " + new java.util.Date();
		int tmp1,tmp2,tmp3;
		tmp1 = Integer.valueOf(pasRecords[5]);
		for(int i = 0;i<flight_count;i++) {
			tmp2 = Integer.valueOf(flightArray[i][0]);
			if(tmp1 == tmp2) {
				pasRecords[12] = flightArray[i][8];
				tmp3 = Integer.valueOf(flightArray[i][1]);
				tmp3 = tmp3-1;
				flightArray[i][1] = String.valueOf(tmp3);
			}
		}
	}
	
	void PurTicket(){
		
		//Integer tmp2;
		randomNo = random.nextInt(1000000);
		pasRecords[0] = String.valueOf(randomNo);
		System.out.println("Enter your first name: ");
		pasRecords[1] = in.nextLine();
		System.out.println("Enter your last name: ");
		pasRecords[2] = in.nextLine();
		System.out.println("Enter your address: ");
		pasRecords[3] = in.nextLine();
		System.out.println("Enter your CNIC: ");
		pasRecords[4] = in.nextLine();
		System.out.println("Enter your flight number: ");
		pasRecords[5] = in.nextLine();
		System.out.println("Enter your seat number: ");
		pasRecords[6] = in.nextLine();
		System.out.println("Enter your age: ");
		pasRecords[7] = in.nextLine();
		System.out.println("Enter your Gender: ");
		pasRecords[13] = in.nextLine();
		System.out.println("Enter your passport no: ");
		pasRecords[8] = in.nextLine();
		System.out.println("Enter your destination point: ");
		pasRecords[9] = in.nextLine();
		System.out.println("Enter your origin point: ");
		pasRecords[14] = in.nextLine();
		System.out.println("Enter type of plane: \n");
		System.out.println("1. Economy Class\n");
		System.out.println("2. First Class\n");
		System.out.println("3. Business Class\n");
		temp = in.nextInt();
		pasRecords[10] = String.valueOf(temp);
		pasRecords[11] = "Bought at time " + new java.util.Date();
		//pasRecords[12] = flightArray[i][8];
		int tmp1,tmp2,tmp3;
		tmp1 = Integer.valueOf(pasRecords[5]);
		for(int i = 0;i<flight_count;i++) {
			//System.out.println(flightArray[i][0] + "\n");
			tmp2 = Integer.valueOf(flightArray[i][0]);
			if(tmp1 == tmp2) {
				System.out.println(flightArray[i][0] + "\n");
				pasRecords[12] = flightArray[i][8];
				tmp3 = Integer.valueOf(flightArray[i][1]);
				tmp3 = tmp3-1;
				flightArray[i][1] = String.valueOf(tmp3);
			}
		}
	}
	
	void checkException() throws passenger{
		int tmp1 = Integer.valueOf(pasRecords[5]);
		boolean temp = false;
		for(int i=0;i<13;i++) {
			if(pasRecords[i] == null) {
				temp = true;
				throw new passenger("You gave an invalid input.\n");
			}
		}
		int temp1,temp2;
		for(int i =0 ;i<flight_count;i++) {
			if(flightArray[i][0] == pasRecords[1]) {
				temp1 = Integer.valueOf(flightArray[i][1]);
				if(temp1 < 1) {
					temp = true;
					throw new passenger("There are no seats available.\n");
				}
			}
		}
		for(int i =0 ;i<flight_count;i++) {
			if(flightArray[i][0] == pasRecords[5]) {
				temp1 = Integer.valueOf(flightArray[i][7]);
				temp2 = Integer.valueOf(pasRecords[10]);
				if(temp1 != temp2) {
					temp = true;
					throw new passenger("You entered wrong type of plane.\n");
				}
			}
		}
		temp = false;
		for(int i=0;i<flight_count;i++) {
			if(pasRecords[5].equals(flightArray[i][0]) == true) {
				if(pasRecords[9].equals(flightArray[i][4]) == true) {
					temp = true;
				}
			}else if(i+1 == flight_count && temp == false) {
				throw new passenger("There's no such destination point till now.\n");
			}
		}
		
		temp = false;
		for(int i=0;i<flight_count;i++) {
			if(pasRecords[5].equals(flightArray[i][0]) == true) {
				if(pasRecords[14].equals(flightArray[i][3]) == true) {
					temp = true;
				}
			}else if(i+1 == flight_count && temp == false) {
				throw new passenger("There's no such origin point till now.\n");
			}
		}
		
		temp = false;
		for(int i=0;i<flight_count;i++) {
			if(pasRecords[5].equals(flightArray[i][0]) == true) {
					temp = true;
			}else if(i+1 == flight_count && temp == false) {
				throw new passenger("There's no such flight number till now.\n");
			}
		}
	}
}


class updateRecords extends passenger{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int passengerCount = 0;
	String str;

	public updateRecords(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	void writingPasDetails(String filepath) {
		try {
			  FileWriter fstream = new FileWriter(filepath,true);
			  BufferedWriter br = new BufferedWriter(fstream);
			  for(int i =0 ;i<15;i++) {
				  br.write(pasRecords[i]+"\n");
			  }
			  br.close();
			  
		}catch(Exception ex) {
			System.out.println("Unable to find the file. \n");
		}
	}
	String [][] pasDet; 
	void countPasDetails(String filepath) {
		try {
			BufferedReader  je = new BufferedReader(
					new FileReader(filepath));
				while((flight_str = je.readLine()) != null) {
					System.out.println(flight_str +"\n");
					passengerCount++;
				}
			  passengerCount = passengerCount/15;
			  System.out.println(passengerCount +"\n");
			  pasDet = new String[passengerCount][15];
			  je.close();
			  
		}catch(Exception ex) {
			System.out.println("Unable to find the file. \n");
		}
	}
	
	void readPasDetails(String filepath) {
		try {
			int tempVar1= 0,tempVar2=0;
			String str1;
			BufferedReader  le = new BufferedReader(
					new FileReader(filepath));
				while((flight_str = le.readLine()) != null) {
					pasDet[tempVar1][tempVar2] = flight_str;
					if(tempVar2 == 14) {
						tempVar2 = 0;
						tempVar1++;
					}else {
						tempVar2++;
					}
					//for(int i=0;i<13;i++) {
					//	str1 = je.readLine();
						//pasDet[tempVar][i] = str1;
					//}
					//tempVar++;
				}
			  //passengerCount = passengerCount/13;
			  
			  le.close();
			  
		}catch(Exception ex) {
			System.out.println("Unable to find the file. \n");
		}
	}
	
	void cancelTicket() throws updateRecords {
		
		int tickID;
		int temp;
		boolean tmp = false;
		int pasNo = 0;
		System.out.println("Enter ticket ID: ");
		tickID  = in.nextInt();
		for(int i = 0; i < passengerCount;i++) {
			temp = Integer.valueOf(pasDet[i][0]);
			if(temp == tickID) {
				pasNo = i;
				pasDet[i][11] = "Cancelled at time " + new java.util.Date();
				tmp = true;
			}
			
			if(i+1 == passengerCount && tmp == false) {
				throw new updateRecords("There's no ticket ID like this. Please check again.");
			}
		}
		int tmp1,tmp2,tmp3;
		tmp1 = Integer.valueOf(pasDet[pasNo][5]);
		for(int i = 0;i<flight_count;i++) {
			tmp2 = Integer.valueOf(flightArray[i][0]);
			if(tmp1 == tmp2) {
				tmp3 = Integer.valueOf(flightArray[i][1]);
				tmp3 = tmp3+1;
				flightArray[i][1] = String.valueOf(tmp3);
			}
		}
	}
	
	void updateAfterCancel(String filepath) {
		try {
			BufferedWriter  btw = new BufferedWriter(new FileWriter(filepath));
			int tmpVar = 0;
			while(tmpVar != passengerCount) {
				for(int i =0 ;i<15;i++) {
					btw.write(pasDet[tmpVar][i]+"\n");
				}
				tmpVar++;
			}
			btw.close();	
		}catch(Exception ex) {
			System.out.println("Unable to find the file.\n");
		}
	}
	
	void print_ticket() {
		int tmp1=0,tmp2=0,tmp3=0;
		System.out.println("Enter ticket ID: ");
		tmp1 = in.nextInt();
		for(int i = 0; i<passengerCount;i++) {
			tmp2 = Integer.valueOf(pasDet[i][0]);
			if(tmp1 == tmp2) {
				System.out.println("Ticket ID: "+pasDet[i][0] + "\n");
				System.out.println("Passenger Name: "+pasDet[i][1] + " "+ pasDet[i][2] +"\n");
				System.out.println("Address: "+pasDet[i][3] + "\n");
				System.out.println("CNIC: "+pasDet[i][4] + "\n");
				System.out.println("Flight Number: "+pasDet[i][5] + "\n");
				System.out.println("Seat No: "+pasDet[i][6] + "\n");
				System.out.println("Age: "+pasDet[i][7] + "\n");
				System.out.println("Gender: "+pasDet[i][3] + "\n");
				System.out.println("Passport No: "+pasDet[i][8] + "\n");
				System.out.println("Destination: "+pasDet[i][9] + "\n");
				System.out.println("Origin: "+pasDet[i][14] + "\n");
				//System.out.println("Seat No: "+pasDet[i][11] + "\n");
				tmp3 = Integer.valueOf(pasDet[i][10]);
				if(tmp3 == 1) {
					System.out.println("Type of class: Economy\n");
				}else if(tmp3 == 2) {
					System.out.println("Type of class: First\n");
				}else if(tmp3 == 3) {
					System.out.println("Type of class: Business\n");
				}
				System.out.println(pasDet[i][11] + "\n");
				System.out.println(pasDet[i][12] +"\n");
			}
			
		}
	}
	
	
	
}



public class FlightManagementSystem {

	public static void main(String[] args) throws FlightsDetails {
		FlightsDetails F = new FlightsDetails(null);
		passenger p = new passenger(null);
		updateRecords pas = new updateRecords(null);
		pas.flights_reading("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
		pas.file_writing("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
	//	/*
		int choice = 0, chk = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("1. Search Flights\n");
		System.out.println("2. Reserve or Buy or Cancel Ticket\n");
		System.out.println("3. Print bought ticket\n");
		System.out.println("4. See System Details\n");
		choice = in.nextInt();
		if(choice == 1) {
			System.out.println("1. See all flight details\n");
			System.out.println("2. Search by flight number\n");
			System.out.println("3. Search by destination\n");
			System.out.println("4. Search by origin\n");
			System.out.println("5. Search by type of plane\n");
			chk = in.nextInt();
			if(chk == 1) {
				//pas.flights_reading("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
				pas.flDetails();
			}else if(chk == 3) {
				//pas.flights_reading("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
				pas.seachbyDes();
			}else if(chk==4) {
				//pas.flights_reading("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
				pas.seachbyOrg();
			}else if(chk == 5) {
				//pas.flights_reading("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
				pas.searchbyclass();
			}else if(chk == 2) {
				//pas.flights_reading("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
				pas.searchbyNo();
			}
			
		}else if(choice == 2) {
			System.out.println("1. Purchase ticket\n");
			System.out.println("2. Reserve ticket\n");
			System.out.println("3. Cancel Ticket\n");
			chk = in.nextInt();
			if(chk == 1) {
				pas.PurTicket();
				//pas.writingPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
				pas.checkException();
				pas.writingPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
				pas.file_writing("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
			}else if(chk == 2) {
				pas.passengersRecord();
				pas.checkException();
				pas.file_writing("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Allflights.txt");
				pas.writingPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
			}else if(chk == 3) {
				pas.countPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
				pas.readPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
				pas.cancelTicket();
				pas.writingPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
				pas.updateAfterCancel("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
			}
		}else if(choice == 3) {
			pas.countPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
			pas.readPasDetails("C:\\Users\\Abdul Samie\\eclipse-workspace\\FlightManagementSystem\\Passenger_Records.txt");
			pas.print_ticket();
		}else if(choice == 4) {
			System.out.println("This is flight management system where you can check for flights, and get youur ticket.\n");
		}
	//	*/
	}

}
