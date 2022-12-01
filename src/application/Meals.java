package application;

import java.util.ArrayList;

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
	
	public double AverageCalories() {
		double totalCalories = 0;
		double averageCalories = 0;
		
		totalCalories = TotalCalories(); //using the Totalcalories method to find total calories
		
		averageCalories = totalCalories/Meals.size(); //Divide total calories by Meals list size to find the average per daily meal
		
		return averageCalories;
	}
	
	public double HighCalories() {
		
		return 0;
	}
	
	public double LowCalories() {
		return 0;
	}
	
	public double TotalCalories() {
		double totalCalories = 0;
		double averageCalories = 0;
		
		double caloriesBreakfast = Meals.get(0).getCalories();
		double caloriesLunch = Meals.get(1).getCalories();
		double caloriesDinner = Meals.get(2).getCalories();
		double caloriesSnack1 = Meals.get(3).getCalories();
		double caloriesSnack2 = Meals.get(4).getCalories();
		
		totalCalories = caloriesBreakfast + caloriesLunch + caloriesDinner + caloriesSnack1 + caloriesSnack2; //add all calories from throughout the day together to find the total
		
		return totalCalories;
	}

}
