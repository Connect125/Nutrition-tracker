package application;

public class Meal {
	
	private String mealName;
	private double mealCalories;
	private double mealSalt;
	private double mealFat;

	/**
	 * TR=he default constructor if no arguments are given
	 */
	public Meal() { //default constructor
	}
	
	/**
	 * The primary constructor used to create a meal object. All values should be entered as strings
	 * @param name The name of the meal consumed
	 * @param calories The number of calories contained by the meal
	 * @param salt The amount of salt contained by the meal
	 * @param fat The amount of fat contained by the meal
	 */
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
	
	/**
	 * Returns the name of the meal object
	 * @return The name of the meal object
	 */
	public String getMealName() {
		return mealName;
	}
	
	/**
	 * Sets the mealName when called
	 * @param name The name of the meal you wish to set
	 */
	public void setMealName(String name) {
		mealName = name;
	}
	
	/**
	 * Returns the number of calories the meal contains as a double
	 * @return A double representing the calories in the meal
	 */
	public double getCalories() {
		return mealCalories;
	}
	/**
	 * Sets the calories when called
	 * @param calories The amount of calories contained by the meal as a double
	 */
	public void setMealName(double calories) {
		mealCalories = calories;
	}
	
	/**
	 * Returns the salt from the meal
	 * @return A double representing the amount of salt contained in the meal
	 */
	public double getSalt() {
		return mealSalt;
	}
	
	/**
	 * Allows the user to set the amount of salt for the meal
	 * @param salt A double representing the amount of salt in the meal
	 */
	public void setSalt(double salt) {
		mealSalt = salt;
	}
	
	/**
	 * Returns the amount of fat from the meal
	 * @return A double representing the amount of fat in the meal
	 */
	public double getFat() {
		return mealFat;
	}
	
	/**
	 * Allows the user to set the amount of fat in the meal
	 * @param fat A double representing the amount of fat in the meal
	 */
	public void setFat(double fat) {
		mealFat = fat;
	}
	
	
	
	

}
