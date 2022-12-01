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
	int dayIndex = 1;
	
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
	private Label dayNumberLabel;
	
	@FXML
	private Label dataEntryErrorLabel;
	
	@FXML
	private Label dataEntryErrorLabel2;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	/**
	 * Updates the day number displayed in the top corner
	 * @param dayNumber
	 */
	public void displayDayNumber(String dayNumber) {
		dayNumberLabel.setText(dayNumber);
	}
	
	/**
	 * Tries it's best to generate a new scene for entering data
	 * @param event
	 * from clicking the button "Next Day"
	 * @throws IOException
	 */
	public void nextDay (ActionEvent event) throws IOException{
		System.out.println("dayIndex " + dayIndex);
		
		dayIndex++;
		
		System.out.println("dayIndex " + dayIndex);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionDataEntry.fxml"));
		root = loader.load();
		
		DataEntrySceneController DataEntrySceneController = loader.getController();
		DataEntrySceneController.displayDayNumber("Day #" + dayIndex);
		
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		System.out.println("dayIndex " + dayIndex);
	}
	
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
		if (breakfastCalories.getText().trim().isEmpty() || breakfastSalt.getText().trim().isEmpty() || breakfastFat.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Calories column.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}else {
			try {
				Meal breakfast = new Meal(breakfastName.getText(), breakfastCalories.getText(), breakfastSalt.getText(), breakfastFat.getText());
			}catch(NumericOnlyException e){ // if non-numeric error during creation of Meal inform user, and prompt to fix.
				errorDectected = true;
				dataEntryErrorLabel.setText("Non-numeric value entered in Breakfast Row.");
				dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
				dataEntryErrorLabel.setTextFill(Color.RED);
				dataEntryErrorLabel2.setTextFill(Color.RED);
			}
		}
		
		//Checks for null values and prompts the user to remove them.
		if (lunchCalories.getText().trim().isEmpty() || lunchSalt.getText().trim().isEmpty() || lunchFat.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Lunch Row.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}else {
			try {
				Meal lunch = new Meal(lunchName.getText(), lunchCalories.getText(), lunchSalt.getText(), lunchFat.getText());
			}catch(NumericOnlyException e){ // if non-numeric error during creation of Meal inform user, and prompt to fix.
				errorDectected = true;
				dataEntryErrorLabel.setText("Non-numeric value entered in Lunch Row.");
				dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
				dataEntryErrorLabel.setTextFill(Color.RED);
				dataEntryErrorLabel2.setTextFill(Color.RED);
			}
		}
		
		//Checks for null values and prompts the user to remove them.
		if (dinnerCalories.getText().trim().isEmpty() || dinnerSalt.getText().trim().isEmpty() || dinnerFat.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Dinner Row.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}else {
			try {
				Meal dinner = new Meal(dinnerName.getText(), dinnerCalories.getText(), dinnerSalt.getText(), dinnerFat.getText());
			}catch(NumericOnlyException e){ // if non-numeric error during creation of Meal inform user, and prompt to fix.
				errorDectected = true;
				dataEntryErrorLabel.setText("Non-numeric value entered in Dinner Row.");
				dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
				dataEntryErrorLabel.setTextFill(Color.RED);
				dataEntryErrorLabel2.setTextFill(Color.RED);
			}
		}
		
		//Checks for null values and prompts the user to remove them.
		if (snack1Calories.getText().trim().isEmpty() || snack1Salt.getText().trim().isEmpty() || snack1Fat.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack1 Row.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}else {
			try {
				Meal snack1 = new Meal(snack1Name.getText(), snack1Calories.getText(), snack1Salt.getText(), snack1Fat.getText());
			}catch(NumericOnlyException e){ // if non-numeric error during creation of Meal inform user, and prompt to fix.
				errorDectected = true;
				dataEntryErrorLabel.setText("Non-numeric value entered in Snack1 Row.");
				dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
				dataEntryErrorLabel.setTextFill(Color.RED);
				dataEntryErrorLabel2.setTextFill(Color.RED);
			}
		}
		
		//Checks for null values and prompts the user to remove them.
		if (snack2Calories.getText().trim().isEmpty() || snack2Salt.getText().trim().isEmpty() || snack2Fat.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Snack2 Row.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
		}else {
			try {
				Meal snack2 = new Meal(snack2Name.getText(), snack2Calories.getText(), snack2Salt.getText(), snack2Fat.getText());
			}catch(NumericOnlyException e){ // if non-numeric error during creation of Meal inform user, and prompt to fix.
				errorDectected = true;
				dataEntryErrorLabel.setText("Non-numeric value entered in Snack2 Row.");
				dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
				dataEntryErrorLabel.setTextFill(Color.RED);
				dataEntryErrorLabel2.setTextFill(Color.RED);
			}
		}
		
		//Creating the Meals list
		if (errorDectected == false) {
			Meals dayOne = new Meals("DayOne", breakfast, lunch, dinner, snack1, snack2);
			
			//Getting meal name display info
			mostCommonMealDisplay = dayOne.mostCommonMeal();
			
			//Getting average Display info
			averageCaloriesDisplay = String.valueOf(dayOne.FindAverageCalories());
			averageSaltDisplay = String.valueOf(dayOne.AverageSalt());
			averageFatDisplay = String.valueOf(dayOne.AverageFat());
			
			
			//Getting high display info
			highCaloriesDisplay = String.valueOf(dayOne.FindHighCalories()); 
			highSaltDisplay = String.valueOf(dayOne.FindHighSalt()); 
			highFatDisplay = String.valueOf(dayOne.FindHighFat()); 
			
			//Getting low display info
			lowCaloriesDisplay = String.valueOf(dayOne.FindLowCalories());
			lowSaltDisplay = String.valueOf(dayOne.FindLowSalt());
			lowFatDisplay = String.valueOf(dayOne.FindLowFat());
			
			//Getting total display info
			totalCaloriesDisplay = String.valueOf(dayOne.FindTotalCalories());
			totalSaltDisplay = String.valueOf(dayOne.FindTotalSalt());
			totalFatDisplay = String.valueOf(dayOne.FindTotalFat());
			
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
}
