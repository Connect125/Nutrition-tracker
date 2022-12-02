package application;

public class Meal {
	
	private String mealName;
	private double mealCalories;
	private double mealSalt;
	private double mealFat;

	public Meal() { //default constructor
	}
	
	public Meal(String name, String calories, String salt, String fat) { //main constructor
		//Creates new strings to break references
		String encapsulationMealName = new String();
		String encapsulationCalories = new String();
		String encapsulationSalt = new String();
		String encapsulationFat = new String();
		
		//assign all inputs to an encapsulation variable
		encapsulationMealName = name;
		encapsulationCalories = calories;
		encapsulationSalt = salt;
		encapsulationFat = fat;
		
		//Assign all values to an instance variable
		mealCalories = Double.parseDouble(encapsulationCalories);
		mealSalt = Double.parseDouble(encapsulationSalt);
		mealFat = Double.parseDouble(encapsulationFat);
		mealName = encapsulationMealName;
	}
	
	public String getMealName() {
		return mealName;
	}
	
	public void setMealName(String name) {
		mealName = name;
	}
	
	public double getCalories() {
		return mealCalories;
	}
	
	public void setMealName(double calories) {
		mealCalories = calories;
	}
	
	public double getSalt() {
		return mealSalt;
	}
	
	public void setSalt(double salt) {
		mealSalt = salt;
	}
	
	public double getFat() {
		return mealFat;
	}
	
	public void setFat(double fat) {
		mealFat = fat;
	}
	
	
	
	

}
