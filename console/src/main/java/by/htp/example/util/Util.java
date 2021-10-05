package by.htp.example.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Util {

	public static LocalDate scanDate() {
		int year = 0;
		int month = 0;
		int days = 0;
		LocalDate localDate;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Input year : [2000-2030]");
			year = scan.nextInt();
			
			if (year < 2000 | year > 2030) {
				throw new DateTimeException("");
			}
			System.out.println("Input month : [1-12]");
			month = scan.nextInt();
			
			if (month < 1 | month > 12) {
				throw new DateTimeException("");
			}
			System.out.println("Input days : [1-31]");
			days = scan.nextInt();
			
			if (days < 1 | days > 31) {
				throw new DateTimeException("");
			}
			
			localDate = LocalDate.of(year, month, days);
		} catch (DateTimeException e) {
			System.out.println("[Info] Wrong date");
			e.getStackTrace();
		}
		localDate = LocalDate.of(year, month, days);
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

		} catch (DateTimeException e) {
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