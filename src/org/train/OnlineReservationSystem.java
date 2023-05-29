package org.train;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

	public class OnlineReservationSystem {
	    private static Scanner scanner = new Scanner(System.in);
	    private static Map<String, Reservation> reservations = new HashMap<>();

	    public static void main(String[] args) {
	        boolean loggedIn = false;
	        while (!loggedIn) {
	            System.out.print("Enter Login ID: ");
	            String loginId = scanner.nextLine();
	            System.out.print("Enter Password: ");
	            String password = scanner.nextLine();

	            if (isValidCredentials(loginId, password)) {
	                loggedIn = true;
	            } else {
	                System.out.println("Invalid login credentials. Please try again.");
	            }
	        }

	        boolean exit = false;
	        while (!exit) {
	            displayMenu();
	            int choice = getIntInput("Enter your choice: ");

	            switch (choice) {
	                case 1:
	                    makeReservation();
	                    break;
	                case 2:
	                    cancelReservation();
	                    break;
	                case 3:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	        System.out.println("Thank you for using the Online Reservation System. Goodbye!");
	    }

	    private static boolean isValidCredentials(String loginId, String password) {
	       
	        return loginId.equals("admin") && password.equals("admin123");
	    }

	    private static void displayMenu() {
	        System.out.println("=== Online Reservation System ===");
	        System.out.println("1. Make a Reservation");
	        System.out.println("2. Cancel a Reservation");
	        System.out.println("3. Exit");
	    }

	    private static void makeReservation() {
	        System.out.print("Enter Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter Train Number: ");
	        String trainNumber = scanner.nextLine();
	        System.out.print("Enter Class Type: ");
	        String classType = scanner.nextLine();
	        System.out.print("Enter Date of Journey: ");
	        String dateOfJourney = scanner.nextLine();
	        System.out.print("Enter From (Place): ");
	        String from = scanner.nextLine();
	        System.out.print("Enter Destination: ");
	        String to = scanner.nextLine();
	        Reservation reservation = new Reservation(name, trainNumber, classType, dateOfJourney, from, to);
	        reservations.put(generatePNR(), reservation);

	      
	    }

	    private static void cancelReservation() {
	        System.out.print("Enter PNR Number: ");
	        String pnr = scanner.nextLine();

	        Reservation reservation = reservations.get(pnr);
	        if (reservation != null) {
	            System.out.println("=== Reservation Details ===");
	            System.out.println("Name: " + reservation.getName());
	            System.out.println("Train Number: " + reservation.getTrainNumber());
	            System.out.println("Class Type: " + reservation.getClassType());
	            System.out.println("Date of Journey: " + reservation.getDateOfJourney());
	            System.out.println("From: " + reservation.getFrom());
	            System.out.println("To: " + reservation.getTo());

	            System.out.print("Are you sure you want to cancel this reservation? (Y/N): ");
	            String confirm = scanner.nextLine();
	            if (confirm.equalsIgnoreCase("Y")) {
	                reservations.remove(pnr);
	                System.out.println("Reservation canceled successfully.");
	            } else {
	                System.out.println("Reservation cancellation aborted.");
	            }
	        } else {
	            System.out.println("Invalid PNR Number. Please try again.");
	        }
	    }

	    private static String generatePNR() {
	       	        return "PNR123456";
	    }

	    private static int getIntInput(String message) {
	        int input = -1;
	        boolean validInput = false;
	        while (!validInput) {
	            try {
	                System.out.print(message);
	                input = Integer.parseInt(scanner.nextLine());
	                validInput = true;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a valid number.");
	            }
	        }
	        return input;
	    }
	}



