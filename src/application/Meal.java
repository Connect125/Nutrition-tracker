package application;

public class Meal {
	
	private String mealName;
	private double mealCalories;
	private double mealSalt;
	private double mealFat;

	public Meal() {
		
	}
	public Meal(String name, String calories, String salt, String fat) throws NumericOnlyException {
		//Creates new strings to break references
		String encapsulationMealName = new String();
		String encapsulationCalories = new String();
		String encapsulationSalt = new String();
		String encapsulationFat = new String();
		
		//checks if the strings that repersent values are actually values if not throws NumericOnlyException
		numericOnlyCheck(calories);
		numericOnlyCheck(salt);
		numericOnlyCheck(fat);
		
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
	 * Takes a String that represents a value and checks throws an error if it is not.
	 * @param valueAsString
	 * A string you want to check if it contains a value
	 * @throws NumericOnlyException
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
