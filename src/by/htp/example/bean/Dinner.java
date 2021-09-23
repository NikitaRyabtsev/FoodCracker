package by.htp.example.bean;

import java.util.Date;

import by.htp.example.logic.Eating;

public class Dinner implements Eating{

	@Override
	public void addEating(Date date) {
		
		System.out.println("Dinner is ready");
		
	}

}