package application;

import java.util.ArrayList;
import java.util.Arrays;

public class Meals extends Meal {
	private String name;
	private ArrayList<Meal> Meals = new ArrayList<Meal>();
	
	
	public Meals(String aName, Meal breakfast, Meal lunch, Meal dinner, Meal snack1, Meal snack2) {
		
		//creating new variables for encapsulation purposes
		String mealsName = new String();
		Meal breakfastMeal = new Meal();
		Meal lunchMeal = new Meal();
		Meal dinnerMeal = new Meal();
		Meal snack1Meal = new Meal();
		Meal snack2Meal = new Meal();
		
		//assigning encapsulation variables
		mealsName = aName;
		breakfastMeal = breakfast;
		lunchMeal = lunch;
		dinnerMeal = dinner;
		snack1Meal = snack1;
		snack2Meal = snack2;
		
		//assigning instance variables
		name = mealsName;
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
	public double FindAverageCalories() {
		double totalCalories = 0;
		double averageCalories = 0;
		
		totalCalories = FindTotalCalories(); //using the FindTotalCalories method to find total calories
		
		averageCalories = totalCalories/Meals.size(); //Divide total calories by Meals list size to find the average per daily meal
		
		return averageCalories;
	}
	
	/**
	 * Finds the meal the largest number of calories consumed
	 * @return
	 * the largest calorie value
	 */
	public double FindHighCalories() {
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
	public double FindLowCalories() {
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
	public double FindTotalCalories() {
		double totalCalories = 0;
		
		double caloriesBreakfast = Meals.get(0).getCalories();
		double caloriesLunch = Meals.get(1).getCalories();
		double caloriesDinner = Meals.get(2).getCalories();
		double caloriesSnack1 = Meals.get(3).getCalories();
		double caloriesSnack2 = Meals.get(4).getCalories();
		
		totalCalories = caloriesBreakfast + caloriesLunch + caloriesDinner + caloriesSnack1 + caloriesSnack2; //add all calories from throughout the day together to find the total
		
		return totalCalories;
	}

}