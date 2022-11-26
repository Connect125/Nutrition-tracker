package application;

import java.util.Arrays;

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
		double calculatedAverage = 0;
		int index = 0;
		while (index < nutrientList.length) {
			calculatedAverage = calculatedAverage + nutrientList[index];
			index ++;
		}
		calculatedAverage = calculatedAverage/nutrientList.length;
		return calculatedAverage;
		
	}
	/**
	 * This takes a list of doubles and returns the largest value
	 * @param nutrientList
	 * A list of doubles you want the largest value from.
	 * @return
	 * The largest value as a double
	 */
	public double FindHighValue (double[] nutrientList) {
		double highValue = 0;
		int index = 0; //remove
		Arrays.sort(nutrientList);
		
		highValue = nutrientList[nutrientList.length-1]; //setting the high value for returning
		
		System.out.println("nutrientList");
		while (index < nutrientList.length) {
			System.out.println("index " + nutrientList[index]);
			index++;
		}
		
		System.out.println("highValue " + highValue);
		
		return highValue;
	}
	/**
	 * This takes a list of doubles and returns the smallest value
	 * @param nutrientList
	 * A list of doubles you want the smallest value from.
	 * @return
	 * The smallest value as a double
	 */
	public double FindLowValue (double[] nutrientList) {
		double lowValue = 0;
		int index = 0; //remove
		Arrays.sort(nutrientList);
		
		lowValue = nutrientList[0]; //setting the low value for returning
		
		System.out.println("nutrientList");
		while (index < nutrientList.length) {
			System.out.println("index " + nutrientList[index]);
			index++;
		}
		
		System.out.println("lowValue " + lowValue);
		
		return lowValue;
	}
	/**
	 * Takes a list of doubles and returns the total
	 * @param nutrientList
	 * A list of doubles you want the total of
	 * @return
	 * The total of the list as a double
	 */
	public double CalculateTotal (double[] nutrientList) {
		int index = 0;
		double calculatedTotal = 0;
		
		while (index < nutrientList.length) {
			calculatedTotal = calculatedTotal + nutrientList[index];
			index ++;
		}
		System.out.println("calculatedTotal " + calculatedTotal);
		return calculatedTotal;
	}

}
