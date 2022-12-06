package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Meals extends Meal {
	private ArrayList<Meal> Meals = new ArrayList<Meal>();
	
	/**
	 * Standard Constructor for Meals
	 * @param breakfast The meal you had first in the day
	 * @param lunch The noon meal of the day
	 * @param dinner The end of day meal
	 * @param snack1 First lesser meal of the day
	 * @param snack2 Second lesser meal of the day
	 */
	public Meals(Meal breakfast, Meal lunch, Meal dinner, Meal snack1, Meal snack2) {
		
		//creating new variables for encapsulation purposes
		Meal breakfastMeal = new Meal();
		Meal lunchMeal = new Meal();
		Meal dinnerMeal = new Meal();
		Meal snack1Meal = new Meal();
		Meal snack2Meal = new Meal();
		
		//assigning encapsulation variables
		breakfastMeal = breakfast;
		lunchMeal = lunch;
		dinnerMeal = dinner;
		snack1Meal = snack1;
		snack2Meal = snack2;
		
		//assigning instance variables
		Meals.add(breakfastMeal);
		Meals.add(lunchMeal);
		Meals.add(dinnerMeal);
		Meals.add(snack1Meal);
		Meals.add(snack2Meal);
	}
	
	/**
	 * Creates a list of all calories from the meals list
	 * @return
	 * Returns a list of all calories from the separate meals.
	 */
	public String[] getNameList() {
		//get all calories from the Meals list
		String nameBreakfast = Meals.get(0).getMealName();
		String nameLunch = Meals.get(1).getMealName();
		String nameDinner = Meals.get(2).getMealName();
		String nameSnack1 = Meals.get(3).getMealName();
		String nameSnack2 = Meals.get(4).getMealName();
		
		String[] nameList = new String[5];
		
		//Add all calories to the list
		nameList[0] = nameBreakfast;
		nameList[1] = nameLunch;
		nameList[2] = nameDinner;
		nameList[3] = nameSnack1;
		nameList[4] = nameSnack2;
		
		return nameList;
	}
	
	/**
	 * Creates a list of all calories from the meals list
	 * @return
	 * Returns a list of all calories from the separate meals.
	 */
	public double[] getCaloriesList() {
		//get all calories from the Meals list
		double caloriesBreakfast = Meals.get(0).getCalories();
		double caloriesLunch = Meals.get(1).getCalories();
		double caloriesDinner = Meals.get(2).getCalories();
		double caloriesSnack1 = Meals.get(3).getCalories();
		double caloriesSnack2 = Meals.get(4).getCalories();
		
		double[] caloriesList = new double[5];
		
		//Add all calories to the list
		caloriesList[0] = caloriesBreakfast;
		caloriesList[1] = caloriesLunch;
		caloriesList[2] = caloriesDinner;
		caloriesList[3] = caloriesSnack1;
		caloriesList[4] = caloriesSnack2;
		
		return caloriesList;
	}
	
	/**
	 * Creates a list of all salt from the meals list
	 * @return
	 * Returns a list of all salt from the separate meals.
	 */
	public double[] getSaltList() {
		//get all salt from the Meals list
		double saltBreakfast = Meals.get(0).getSalt();
		double saltLunch = Meals.get(1).getSalt();
		double saltDinner = Meals.get(2).getSalt();
		double saltSnack1 = Meals.get(3).getSalt();
		double saltSnack2 = Meals.get(4).getSalt();
		
		double[] saltList = new double[5];
		
		//Add all salt to the list
		saltList[0] = saltBreakfast;
		saltList[1] = saltLunch;
		saltList[2] = saltDinner;
		saltList[3] = saltSnack1;
		saltList[4] = saltSnack2;
		
		return saltList;
	}
	
	/**
	 * Creates a list of all fat from the meals list
	 * @return
	 * Returns a list of all fat from the separate meals.
	 */
	public double[] getFatList() {
		//get all fat from the Meals list
		double fatBreakfast = Meals.get(0).getFat();
		double fatLunch = Meals.get(1).getFat();
		double fatDinner = Meals.get(2).getFat();
		double fatSnack1 = Meals.get(3).getFat();
		double fatSnack2 = Meals.get(4).getFat();
		
		double[] fatList = new double[5];
		
		//Add all fat to the list
		fatList[0] = fatBreakfast;
		fatList[1] = fatLunch;
		fatList[2] = fatDinner;
		fatList[3] = fatSnack1;
		fatList[4] = fatSnack2;
		
		return fatList;
	}
	
	/**
	 * Find the average number of calories consumed per meal throughout the day
	 * @return
	 * The value for the average calories per meal
	 */
	public double findAverageCalories() {
		double totalCalories = 0;
		double averageCalories = 0;
		
		totalCalories = findTotalCalories(); //using the FindTotalCalories method to find total calories
		
		averageCalories = totalCalories/Meals.size(); //Divide total calories by Meals list size to find the average per daily meal
		
		return averageCalories;
	}
	
	/**
	 * Finds the meal the largest number of calories consumed
	 * @return
	 * the largest calorie value
	 */
	public double findHighCalories() {
		double highCalories = 0;
		
		double[] list = new double[5];
		
		list = getCaloriesList();
		Arrays.sort(list);
		
		highCalories = list[list.length-1]; //setting the high value for returning
		
		return highCalories;
	}
	
	/**
	 * Finds the the meal with the lowest number of calories
	 * @return
	 * the lowest calorie value
	 */
	public double findLowCalories() {
		double lowCalories = 0;
		
		double[] list = new double[5];
		
		list = getCaloriesList();
		Arrays.sort(list);
		
		lowCalories = list[0]; //setting the low value for returning
		
		return lowCalories;
	}
	
	/**
	 * Find the total amount of calories consumed in a day
	 * @return
	 * Returns the total number of calories
	 */
	public double findTotalCalories() {
		double totalCalories = 0;
		
		double caloriesBreakfast = Meals.get(0).getCalories();
		double caloriesLunch = Meals.get(1).getCalories();
		double caloriesDinner = Meals.get(2).getCalories();
		double caloriesSnack1 = Meals.get(3).getCalories();
		double caloriesSnack2 = Meals.get(4).getCalories();
		
		totalCalories = caloriesBreakfast + caloriesLunch + caloriesDinner + caloriesSnack1 + caloriesSnack2; //add all calories from throughout the day together to find the total
		
		return totalCalories;
	}
	
	/**
	 * Find the average number of Salt consumed per meal throughout the day
	 * @return
	 * The value for the average Salt per meal
	 */
	public double averageSalt() {
		double totalSalt = 0;
		double averageSalt = 0;
		
		totalSalt = findTotalSalt(); //using the FindTotalSalt method to find total Salt
		
		averageSalt = totalSalt/Meals.size(); //Divide total Salt by Meals list size to find the average per daily meal
		
		return averageSalt;
	}
	
	/**
	 * Finds the meal the largest number of Salt consumed
	 * @return
	 * the largest Salt value
	 */
	public double findHighSalt() {
		double highSalt = 0;
		
		double[] list = new double[5];
		
		list = getSaltList();
		Arrays.sort(list);
		
		highSalt = list[list.length-1]; //setting the high value for returning
		
		return highSalt;
	}
	
	/**
	 * Finds the the meal with the lowest number of salt
	 * @return
	 * the lowest salt value
	 */
	public double findLowSalt() {
		double lowSalt = 0;
		
		double[] list = new double[5];
		
		list = getSaltList();
		Arrays.sort(list);
		
		lowSalt = list[0]; //setting the low value for returning
		
		return lowSalt;
	}
	
	/**
	 * Find the total amount of salt consumed in a day
	 * @return
	 * Returns the total number of salt
	 */
	public double findTotalSalt() {
		double totalSalt = 0;
		
		double saltBreakfast = Meals.get(0).getSalt();
		double saltLunch = Meals.get(1).getSalt();
		double saltDinner = Meals.get(2).getSalt();
		double saltSnack1 = Meals.get(3).getSalt();
		double saltSnack2 = Meals.get(4).getSalt();
		
		totalSalt = saltBreakfast + saltLunch + saltDinner + saltSnack1 + saltSnack2; //add all salt from throughout the day together to find the total
		
		return totalSalt;
	}
	
	/**
	 * Find the average number of fat consumed per meal throughout the day
	 * @return
	 * The value for the average fat per meal
	 */
	public double averageFat() {
		double totalFat = 0;
		double averageFat = 0;
		
		totalFat = findTotalFat(); //using the FindTotalfat method to find total fat
		
		averageFat = totalFat/Meals.size(); //Divide total fat by Meals list size to find the average per daily meal
		
		return averageFat;
	}
	
	/**
	 * Finds the meal the largest number of fat consumed
	 * @return
	 * the largest fat value
	 */
	public double findHighFat() {
		double highFat = 0;
		
		double[] list = new double[5];
		
		list = getFatList();
		Arrays.sort(list);
		
		highFat = list[list.length-1]; //setting the high value for returning
		
		return highFat;
	}
	
	/**
	 * Finds the the meal with the lowest number of fat
	 * @return
	 * the lowest fat value
	 */
	public double findLowFat() {
		double lowFat = 0;
		
		double[] list = new double[5];
		
		list = getFatList();
		Arrays.sort(list);
		
		lowFat = list[0]; //setting the low value for returning
		
		return lowFat;
	}
	
	/**
	 * Find the total amount of fat consumed in a day
	 * @return
	 * Returns the total number of fat
	 */
	public double findTotalFat() {
		double totalFat = 0;
		
		double fatBreakfast = Meals.get(0).getFat();
		double fatLunch = Meals.get(1).getFat();
		double fatDinner = Meals.get(2).getFat();
		double fatSnack1 = Meals.get(3).getFat();
		double fatSnack2 = Meals.get(4).getFat();
		
		totalFat = fatBreakfast + fatLunch + fatDinner + fatSnack1 + fatSnack2; //add all fat from throughout the day together to find the total
		
		return totalFat;
	}
	
	/**
	 * Looks through the list of Meals and returns the most common name not case sensitive 
	 * @param mealNames
	 * A list of strings containing five meal names
	 * @return
	 * a string containing the most common meal name
	 */
	public String mostCommonMeal() {
		//Setting up local variables
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		
		int occurrences0 = 0;
		int occurrences1 = 0;
		int occurrences2 = 0;
		int occurrences3 = 0;
		int occurrences4 = 0;
		
		String[] mealNames = new String[5];
		
		mealNames = getNameList();
		
		ArrayList<String> names = new ArrayList<String>();
		
		
		//Adds the the names from mealNames array to names ArrayList
		while (index3 < mealNames.length) {
			names.add(mealNames[index3].toUpperCase());
			index3++;
		}
		
		//Each if statement is for a different name(5 different names total). The loop counts the number of occurrences each name has within it's own list
		while (index2 < mealNames.length) {
			while (index1 < mealNames.length) {
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 0){
					occurrences0 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 1){
					occurrences1 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 2){
					occurrences2 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 3){
					occurrences3 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 4){
					occurrences4 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				index1++;
			}
			index1 = 0;
			index2++;
		}
		
		//Creates a new list with the values from the previous loop in the same order as the names occurred.
		int[] mealOccurrences = new int[5];
		
		mealOccurrences[0] = occurrences0;
		mealOccurrences[1] = occurrences1;
		mealOccurrences[2] = occurrences2;
		mealOccurrences[3] = occurrences3;
		mealOccurrences[4] = occurrences4;
		
		int largest = 0;
		for (int i = 1; i < mealOccurrences.length; i++) { //Searches for the index of the largest value in the list
			if (mealOccurrences[i] > largest) largest = i;
		}
				
		//returns the String from the location the largest number of occurrences was found in the previous for loop.
		return mealNames[largest];
	}

}
