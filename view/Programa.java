package fundamentos.excecoes.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import fundamentos.excecoes.model.entities.Reservation;

public class Programa {

	public static void main(String[] args) throws ParseException {

		/*
		 * Exceção é um objeto herdado de classes
		 * 
		 * Exemplo
		 * 
		 * Throwable - Error - OutOfMemoryError - VirtualMachineError - Exception -
		 * IOException - RuntimeException
		 * 
		 * 
		 * try-catch
		 * 
		 * Method Stack
		 * 
		 * Bloclo finally
		 * 
		 * Custom Exception 1-Validação no programa principal 2-Método retornando String
		 * 3-Tratamento de exceções
		 * 
		 */

		// method2();
		// method1();
		// method3();

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in: date (dd/MM/yyyy) ");
		Date check_in = sdf.parse(sc.next());
		System.out.print("Check-out: date (dd/MM/yyyy) ");
		Date check_out = sdf.parse(sc.next());

		if (!check_out.after(check_in)) {
			System.out.println("Error in reservation: Check-out date must be after chek-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, check_in, check_out);
			System.out.println("Reservation: " + reservation);

			System.out.println();

			Date now = new Date();
			
			if (check_in.before(now) || check_out.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future");
			} else if (!check_out.after(check_in)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				System.out.println("Enter data to update the reservation: ");
				System.out.print("Check-in: date (dd/MM/yyyy): ");
				check_in = sdf.parse(sc.next());
				System.out.print("Check-out: date (dd/MM/yyyy): ");
				check_out = sdf.parse(sc.next());		
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
