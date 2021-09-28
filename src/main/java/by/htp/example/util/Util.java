package by.htp.example.util;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Util {

	public static LocalDate scanData() {
		int year = 0;
		int month = 0;
		int days = 0;
		Scanner scan = new Scanner(System.in);
		try{
	
		System.out.println("Input year : [yyyy]");
		year = scan.nextInt();
		System.out.println("Input month : [1-12]");
		month = scan.nextInt();
		System.out.println("Input days : [1-31]");
		days = scan.nextInt();
	
		}catch(DateTimeException e) {
		e.getStackTrace();
		}
		LocalDate localDate = LocalDate.of(year,month, days);
		return localDate;

		
	}

	public static LocalTime scanTime() {
		Scanner scan = new Scanner(System.in);
		int hours = 0;
		int minutes = 0;
	try {
		System.out.println("Input hours : [1-23]");
		hours = scan.nextInt();
		System.out.println("Input minutes : [1-59]");
		minutes = scan.nextInt();

		}catch(DateTimeException e) {
			e.getStackTrace();
		}
		LocalTime localTime = LocalTime.of(hours, minutes);
		return localTime;
	}
	
	public static double scanDouble() {
		
		double userChoose = 0;
		Scanner scan = new Scanner(System.in);
		userChoose = scan.nextDouble();	

		return userChoose;
		
	}
	public static int scanInt() {
		int userChoose = 0;
		Scanner scan = new Scanner(System.in);
		userChoose = scan.nextInt();
		return userChoose;
	}

}