package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.model.Order;
import com.model.Route;
import com.model.User;
import com.service.JourneyService;
import com.service.UserService;

public class Main {
	private static List<User> users = new ArrayList<>();
	private static List<Route> routes = new ArrayList<>();
	private static List<Order> orders = new ArrayList<>();
	private static Map<String, Integer> userInvalidLoginAttempt = new HashMap<>();
	private static UserService userservice = new UserService(users, userInvalidLoginAttempt);
	private static JourneyService journeyservice = new JourneyService(routes,orders);
	
	public static void main(String[] args) {
		//pre-populate the services with some data if necessary
		initializeRoutes();
		
		if(displaycompanyLogo()) {
			showMenuOptions();
		} else {
			System.out.println("Failed to load company logo Exiting......");
		}
	}
	
	private static boolean displaycompanyLogo() {
		try(BufferedReader reader = new BufferedReader(new FileReader("C:\\textfile\\New folder\\testout2.txt"))) {
			String line;
			while((line = reader.readLine())!= null) {
				System.out.println(line);
			}
			return true;  //Logo loaded successfully
		} catch(IOException e) {
			System.err.println("Error reading company logo file: "+e.getMessage());
			return false; //Logo loading failed
		}
	}
	
	private static void initializeRoutes() {
		routes.add(new Route(1, "Kurnool", "Hyderabad", LocalDate.parse("2024-07-17", DateTimeFormatter.ISO_LOCAL_DATE), 1000, 40));
		routes.add(new Route(2, "Kurnool", "Hyderabad", LocalDate.parse("2024-07-18", DateTimeFormatter.ISO_LOCAL_DATE), 1000, 30));
		routes.add(new Route(3, "Nandyal", "Bangalore", LocalDate.parse("2024-07-19", DateTimeFormatter.ISO_LOCAL_DATE), 900, 45));
		routes.add(new Route(4, "Hyderabad","Goa",      LocalDate.parse("2024-07-20", DateTimeFormatter.ISO_LOCAL_DATE), 900, 20));
		routes.add(new Route(5, "Vizag",   "Kochi",     LocalDate.parse("2024-07-21", DateTimeFormatter.ISO_LOCAL_DATE), 1500, 50));
		routes.add(new Route(6, "Kerala",  "Tirupathi", LocalDate.parse("2024-07-22", DateTimeFormatter.ISO_LOCAL_DATE), 500, 34));
	
	}
	private static void showMenuOptions() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		boolean running = true;
		
		while(running) {
			System.out.println("\n Menu Options: ");
			System.out.println("1. New Admin User Registration");
			System.out.println("2. Login");
			System.out.println("3. Plan Journey");
			System.out.println("4. ReScheduling Booking Date");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(scanner.nextLine());
			switch(choice) {
			case 1:
				userservice.registerNewAdmin();
				break;
			case 2:
				userservice.login();
				break;
			case 3:
				journeyservice.planJourney();
				break;
			case 4:
				journeyservice.reScheduleJourney();
				break;
			case 5:
				System.out.println("Exiting...");
                running = false;
                break;
            default:
                System.out.println("Invalid choice. Please enter a correct option.");
                break;
			}
		}
		scanner.close();  // Close the scanner when we're done with it
	}
}