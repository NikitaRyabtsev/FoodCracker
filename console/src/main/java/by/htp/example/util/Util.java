package by.htp.example.util;

import javax.ejb.Stateless;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Util {

	public static LocalDate scanDate() throws DateTimeException {
		int year = 0;
		int month = 0;
		int days = 0;
		LocalDate localDate;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Input year : [2000-2030]");
			year = scan.nextInt();
			if (year < 2000 | year > 2030) {
				System.out.println("Input month : [1-12]");
				month = scan.nextInt();
				System.out.println("Input days : [1-31]");
				days = scan.nextInt();
				localDate = LocalDate.of(year, month, days);
			}else{
				System.out.println("Не верно введена дата");
			}
		} catch (DateTimeException e) {
			System.out.println("[Info] Wrong date");
			throw new DateTimeException("");
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