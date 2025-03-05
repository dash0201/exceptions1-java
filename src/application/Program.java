package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("room number: ");
		int number = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("error in reservaton: check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reservation);
			System.out.println();
			System.out.println("enter the data to update the reservation:");
			System.out.print("check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				 System.out.println("error in reservation: " + error);
			}
			else {
				System.out.println("reservation: " + reservation);
			}
			

		}
		
		

		sc.close();
	}

}
