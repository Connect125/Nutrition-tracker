package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DataEntrySceneController {
	
	@FXML
	private TextField breakfastCalories; 
	
	@FXML
	private TextField lunchCalories;
	
	@FXML
	private TextField dinnerCalories;

	@FXML
	private TextField snack1Calories;
	
	@FXML
	private TextField snack2Calories;
	
	@FXML
	private TextField breakfastSalt; 
	
	@FXML
	private TextField lunchSalt;
	
	@FXML
	private TextField dinnerSalt;

	@FXML
	private TextField snack1Salt;
	
	@FXML
	private TextField snack2Salt;
	
	@FXML
	private TextField breakfastFat; 
	
	@FXML
	private TextField lunchFat;
	
	@FXML
	private TextField dinnerFat;

	@FXML
	private TextField snack1Fat;
	
	@FXML
	private TextField snack2Fat;
	
	@FXML
	private TextField breakfastName; 
	
	@FXML
	private TextField lunchName;
	
	@FXML
	private TextField dinnerName;

	@FXML
	private TextField snack1Name;
	
	@FXML
	private TextField snack2Name;
	
	@FXML
	private Label dataEntryErrorLabel;
	
	@FXML
	private Label dataEntryErrorLabel2;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	/**
	 * Gathers all the data from the DataEntryScene checks for errors and if none are found switches to the StatisticsScene
	 * @param event
	 * This is the trigger from clicking on the "Done" button
	 * @throws IOException
	 */
	public void switchToNutritionStatistics(ActionEvent event) throws IOException{
		boolean errorDectected = false;
		
		//Strings for averages
		String averageCaloriesDisplay = new String("NA");
		String averageSaltDisplay = new String("NA");
		String averageFatDisplay = new String("NA");
		
		//Strings for highs
		String highCaloriesDisplay = new String("NA");
		String highSaltDisplay = new String("NA");
		String highFatDisplay = new String("NA");
		
		//Strings for lows
		String lowCaloriesDisplay = new String("NA");
		String lowSaltDisplay = new String("NA");
		String lowFatDisplay = new String("NA");
		
		//Strings for Totals
		String totalCaloriesDisplay = new String("NA");
		String totalSaltDisplay = new String("NA");
		String totalFatDisplay = new String("NA");
		
		//String for Most Common Meal Name
		String mostCommonMealDisplay = new String("NA");
		
		
		//Checks for null values and prompts the user to remove them.
		if (snack2Calories.getText().trim().isEmpty() || snack2Salt.getText().trim().isEmpty() || snack2Fat.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack2 Row.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		//Error Checking on textfields before making Meal objects and custom error messages
		try {
			numericOnlyCheck(breakfastCalories.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Breakfast Calories.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(breakfastSalt.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Breakfast Salt.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(breakfastFat.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Breakfast Fat.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(lunchCalories.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Lunch Calories.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(lunchSalt.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Lunch Salt.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(lunchFat.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Lunch Fat.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(dinnerCalories.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Dinner Calories.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(dinnerSalt.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Dinner Salt.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(dinnerFat.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Dinner Fat.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(snack1Calories.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack 1 Calories.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(snack1Salt.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack 1 Salt.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(snack1Fat.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack 1 Fat.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(snack2Calories.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack 2 Calories.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(snack2Salt.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack 2 Salt.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		try {
			numericOnlyCheck(snack2Fat.getText());
		} catch (NumericOnlyException e) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack 2 Fat.");
			dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}
		
		if (errorDectected == false) {
			//Creating all the meal objects
			Meal breakfast = new Meal(breakfastName.getText(), breakfastCalories.getText(), breakfastSalt.getText(), breakfastFat.getText());
			Meal lunch = new Meal(lunchName.getText(), lunchCalories.getText(), lunchSalt.getText(), lunchFat.getText());
			Meal dinner = new Meal(dinnerName.getText(), dinnerCalories.getText(), dinnerSalt.getText(), dinnerFat.getText());
			Meal snack1 = new Meal(snack1Name.getText(), snack1Calories.getText(), snack1Salt.getText(), snack1Fat.getText());
			Meal snack2 = new Meal(snack2Name.getText(), snack2Calories.getText(), snack2Salt.getText(), snack2Fat.getText());
			
			//Creating the Meals object
			Meals dayOne = new Meals(breakfast, lunch, dinner, snack1, snack2);
			
			//Getting meal name display info
			mostCommonMealDisplay = dayOne.mostCommonMeal();
			
			//Getting average Display info
			averageCaloriesDisplay = String.valueOf(dayOne.findAverageCalories());
			averageSaltDisplay = String.valueOf(dayOne.averageSalt());
			averageFatDisplay = String.valueOf(dayOne.averageFat());
			
			
			//Getting high display info
			highCaloriesDisplay = String.valueOf(dayOne.findHighCalories()); 
			highSaltDisplay = String.valueOf(dayOne.findHighSalt()); 
			highFatDisplay = String.valueOf(dayOne.findHighFat()); 
			
			//Getting low display info
			lowCaloriesDisplay = String.valueOf(dayOne.findLowCalories());
			lowSaltDisplay = String.valueOf(dayOne.findLowSalt());
			lowFatDisplay = String.valueOf(dayOne.findLowFat());
			
			//Getting total display info
			totalCaloriesDisplay = String.valueOf(dayOne.findTotalCalories());
			totalSaltDisplay = String.valueOf(dayOne.findTotalSalt());
			totalFatDisplay = String.valueOf(dayOne.findTotalFat());
			
			//Passes all the data entered to the Statistics scene for display to user.
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionStatistics.fxml"));
			root = loader.load();
			
			StatisticsSceneController StatisticsSceneController = loader.getController();
			StatisticsSceneController.displayAverages(averageCaloriesDisplay,averageSaltDisplay,averageFatDisplay);
			StatisticsSceneController.displayHighs(highCaloriesDisplay,highSaltDisplay,highFatDisplay);
			StatisticsSceneController.displayLows(lowCaloriesDisplay,lowSaltDisplay,lowFatDisplay);
			StatisticsSceneController.displayTotals(totalCaloriesDisplay,totalSaltDisplay,totalFatDisplay);
			StatisticsSceneController.displayMealNames(mostCommonMealDisplay);
			
			
			stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
		}
			
		/**
		 * Takes a String that represents a value and checks throws an error if it is not.
		 * @param valueAsString
		 * A string you want to check if it contains a value
		 * @return 
		 * @throws NumericOnlyException
		 */
		public void numericOnlyCheck (String valueAsString) throws NumericOnlyException {
			//Code adapting from my own coding challenges originally helped, and inspired by video content created by Nathaly Verwaal
			//------------------------------------------------------------------------------------------------------------
			//Check that the user entered a numeric value
	    	boolean firstDecimalCheck = true;
	    	if (valueAsString == "") throw new NumericOnlyException("No Value");
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
