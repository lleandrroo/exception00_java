package fundamentos.excecoes.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import fundamentos.excecoes.model.entities.Reservation;
import fundamentos.excecoes.model.exception.DomainException;

public class Programa {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in: date (dd/MM/yyyy) ");
			Date check_in = sdf.parse(sc.next());
			System.out.print("Check-out: date (dd/MM/yyyy) ");
			Date check_out = sdf.parse(sc.next());

			Reservation reserve = new Reservation(roomNumber, check_in, check_out);
			System.out.println("Reservation: " + reserve);
	
			System.out.print("Do you want to change the dates (Y/N): ");
			if (sc.next().toUpperCase().charAt(0) == 'Y') {
				System.out.print("Check-in: date (dd/MM/yyyy) ");
				check_in = sdf.parse(sc.next());
				System.out.print("Check-out: date (dd/MM/yyyy) ");
				check_out = sdf.parse(sc.next());
				reserve.updateDate3(check_in, check_out);

				System.out.println("Reservation: " + reserve);
			}
		} catch (ParseException e) {
			System.out.println("Ivalid date Format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} 
		sc.close();
		
		// method1();
		// method2();
		// method3();
		// reservationOne(roomNumber, check_in, check_out);
		// Reservation reserve = (Reservation) reservationTwo(roomNumber, check_in,
		// check_out);
		// System.out.print("Do you want to change the dates (Y/N): ");
		// reservationTwoUpDate(reserve);
		
		
	}
}

/*
	private static void reservationTwoUpDate(Reservation reserve) throws ParseException {
		sc = new Scanner(System.in);
		Date check_in;
		Date check_out;
		if (!(sc.next().toUpperCase().charAt(0) == 'N')) {
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in: date (dd/MM/yyyy): ");
			check_in = sdf.parse(sc.next());
			System.out.print("Check-out: date (dd/MM/yyyy): ");
			check_out = sdf.parse(sc.next());

			String error = reserve.updateDate2(check_in, check_out);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reserve);
			}
		}
	}

	private static Object reservationTwo(int roomNumber, Date check_in, Date check_out) {
		if (!check_out.after(check_in)) {
			return "Error in reservation: Check-out date must be after chek-in date";
		} else {
			Reservation reservation = new Reservation(roomNumber, check_in, check_out);
			return reservation;
		}
	}

	private static void reservationOne(int roomNumber, Date check_in, Date check_out) {
		if (!check_out.after(check_in)) {
			System.out.println("Error in reservation: Check-out date must be after chek-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, check_in, check_out);
			System.out.println("Reservation: " + reservation);
			Date now = new Date();

			if (check_in.before(now) || check_out.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future");
			} else if (check_out.after(check_in)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				System.out.println("Enter data to update the reservation: ");
				System.out.print("Check-in: date (dd/MM/yyyy): ");
				try {
					check_in = sdf.parse(sc.next());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.print("Check-out: date (dd/MM/yyyy): ");
				try {
					check_out = sdf.parse(sc.next());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				reservation.updateDate(check_in, check_out);
				System.out.println("Reservation: " + reservation);
			}
		}
	}

	public static void method1() {
		System.out.println("****MethodOne Start****");
		method2();
		System.out.println("****MethodOne End****");
	}

	public static void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("****MethodTwo Start****");
		try {
			System.out.print("String: ");
			String[] vect = sc.nextLine().split("");
			System.out.print("Number: ");
			int position = sc.nextInt();
			System.out.println("Value in position: " + vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!");
			e.printStackTrace();
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Input error");
		}

		System.out.println("End of program");
		System.out.println("****MethodTwo End****");

		sc.close();
	}

	public static void method3() {
		File file = new File("C:\\Temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
*/