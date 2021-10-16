//package by.htp.example.util;
//
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.Scanner;
//
//public class Util {
//
//	public static void scanData() {
//		Scanner scan = new Scanner(System.in);
//		String userChoose = null;
//		Calendar cal = new GregorianCalendar();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
//		Date date;
//	
//		while (!scan.hasNext("^[0-3]?\\d.[0-1]?\\d1.[\\d]{4}$")) {
//			scan = new Scanner(System.in);
//			userChoose = scan.nextLine();
//			try {
//				date = dateFormat.parse(userChoose);
//				cal.setTime(date);
//				System.out.println(date);
//			} catch (ParseException e) {
//				
//				System.out.println(">>> Wrong choose");
//				e.printStackTrace();
//			}
//
//		}
//	}
//	public static void scanTime() {
//		Scanner scan = new Scanner(System.in);
//		while (!scan.hasNext("^[0-3]?\\d.[0-1]?\\d1.[\\d]{4}$")) {
//			//scan.close();
//			System.out.println("Try again");
//			scan = new Scanner(System.in);
//		}
//		scan.close();
//	}
//}
