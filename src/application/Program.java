package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date(dd/MM/yyyy): ");
			Date checkIn = sdt.parse(sc.next());
			System.out.print("Check-out date(dd/MM/yyyy): ");
			Date checkOut = sdt.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation:");
			System.out.print("Check-in date(dd/MM/yyyy): ");
			checkIn = sdt.parse(sc.next());
			System.out.print("Check-out date(dd/MM/yyyy): ");
			checkOut = sdt.parse(sc.next());
			
			reservation.uptadeDates(checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			
		}catch(ParseException e){
			System.out.println("Invalid date format.");
		}catch(DomainExceptions e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		
		sc.close();
	}
}
