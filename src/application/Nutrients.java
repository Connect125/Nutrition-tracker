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
	 * @throws NumericOnlyException 
	 */
	public Nutrients(String breakfast, String lunch, String dinner, String snack1, String snack2) throws NumericOnlyException {
		String encapsulationBreakFast = new String();
		String encapsulationLunch = new String();
		String encapsulationDinner = new String();
		String encapsulationSnack1 = new String();
		String encapsulationSnack2 = new String();
		
		numericOnlyCheck(breakfast);
		numericOnlyCheck(lunch);
		numericOnlyCheck(dinner);
		numericOnlyCheck(snack1);
		numericOnlyCheck(snack2);
		
		encapsulationBreakFast = breakfast;
		encapsulationLunch = lunch;
		encapsulationDinner = dinner;
		encapsulationSnack1 = snack1;
		encapsulationSnack2 = snack2;
		
		breakfastNum = Double.parseDouble(encapsulationBreakFast);
		lunchNum = Double.parseDouble(encapsulationLunch);
		dinnerNum = Double.parseDouble(encapsulationDinner);
		snack1Num = Double.parseDouble(encapsulationSnack1);
		snack2Num = Double.parseDouble(encapsulationSnack2);
		
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
	
	/**
	 * Checks if the string passed to it is actually a number
	 * @param valueAsString
	 * A value stored in a string
	 * @throws NumericOnlyException
	 * If the value is non-numeric or has multiple decimals it throws an NumericOnlyException
	 */
	public void numericOnlyCheck (String valueAsString) throws NumericOnlyException {
		//Code adapting from my own coding challenges originally helped, and inspired by video content created by Nathaly Verwaal
//------------------------------------------------------------------------------------------------------------
		//Check that the user entered a numeric value
    	boolean firstDecimalCheck = true;
    	
    	for (char c : valueAsString.toCharArray()) {
    		//if any character is not a digit, set flag to false: it is not a number
    		if (!Character.isDigit(c) && c != '.') {
    			throw new NumericOnlyException("Non-numeric response");
    		}else if (c == '.' && firstDecimalCheck == true) {
    			firstDecimalCheck = false;
    		}else if (c == '.' && firstDecimalCheck == false) {
    			throw new NumericOnlyException("More than one decimal");
    		}
    	}
//--------------------------------------------------------------------------------------------------------------
	}

}
