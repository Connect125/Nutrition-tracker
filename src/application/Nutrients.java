package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Nutrients {
	
	private double breakfastNum;
	private double lunchNum;
	private double dinnerNum;
	private double snack1Num;
	private double snack2Num;

	
	/**
	 * 
	 * @param breakfast
	 * A string representing a number for amount of nutrients consumed during breakfast
	 * @param lunch
	 * A string representing a number for amount of nutrients consumed during lunch
	 * @param dinner
	 * A string representing a number for amount of nutrients consumed during dinner
	 * @param snack1
	 * A string representing a number for amount of nutrients consumed during snack1
	 * @param snack2
	 * A string representing a number for amount of nutrients consumed during snack2
	 */
	public Nutrients(String breakfast, String lunch, String dinner, String snack1, String snack2) {
		breakfastNum = Double.parseDouble(breakfast);
		lunchNum = Double.parseDouble(lunch);
		dinnerNum = Double.parseDouble(dinner);
		snack1Num = Double.parseDouble(snack1);
		snack2Num = Double.parseDouble(snack2);
		
	}
	/**
	 * Makes a list of doubles from the nutrient amounts.
	 * @return
	 * Returns the list created
	 */
	public double[] getList() {
		System.out.println("Making a list");
		double[] nutrientList = new double[5];
		
		nutrientList[0] = breakfastNum;
		nutrientList[1] = lunchNum;
		nutrientList[2] = dinnerNum;
		nutrientList[3] = snack1Num;
		nutrientList[4] = snack2Num;
		
		return nutrientList;
	}

	
	/**
	 * Takes a list of Doubles and returns the average
	 * @param nutrientList
	 * A list of type double
	 * @return
	 * Returns the average value of the list as a double
	 */
	public double CalculateAverage(double[] nutrientList) {
		System.out.println("Calculating Average");
		double calculatedAverage = 0;
		int index = 0;
		System.out.println("b4 list");
		while (index < nutrientList.length) {
			System.out.println("in list + index " + index);
			calculatedAverage = calculatedAverage + nutrientList[index];
			index ++;
		}
		System.out.println("after list");
		calculatedAverage = calculatedAverage/nutrientList.length;
		return calculatedAverage;
		
	}

}
