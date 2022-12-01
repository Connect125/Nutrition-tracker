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
		
		//Creating new Nutrient object for calories, finding the average value, high value, low value, and total value. Each will then be assigned to a string
		//for updating the display
		//if statement checks for null values and prompts the user to remove them.
		if (breakfastCalories.getText().trim().isEmpty() || lunchCalories.getText().trim().isEmpty() || dinnerCalories.getText().trim().isEmpty() 
				|| snack1Calories.getText().trim().isEmpty() || snack2Calories.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Calories column.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
			}else {
				try {
					Nutrients calories = new Nutrients(breakfastCalories.getText(), lunchCalories.getText(), dinnerCalories.getText(), snack1Calories.getText(), snack2Calories.getText());
					averageCaloriesDisplay = String.valueOf(calories.CalculateAverage(calories.getList())); 
					highCaloriesDisplay = String.valueOf(calories.FindHighValue(calories.getList())); 
					lowCaloriesDisplay = String.valueOf(calories.FindLowValue(calories.getList())); 
					totalCaloriesDisplay = String.valueOf(calories.CalculateTotal(calories.getList())); 
				}catch(NumericOnlyException e) {
					errorDectected = true;
					dataEntryErrorLabel.setText("Non-numeric value entered in Calories column.");
					dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
					dataEntryErrorLabel.setTextFill(Color.RED);
					dataEntryErrorLabel2.setTextFill(Color.RED);
				}
			}
		
		//Creating new Nutrient object for calories, finding the average value, high value, low value, and total value. Each will then be assigned to a string
		//for updating the display
		//if statement checks for null values and prompts the user to remove them.
		if (breakfastSalt.getText().trim().isEmpty() || lunchSalt.getText().trim().isEmpty() || dinnerSalt.getText().trim().isEmpty() 
				|| snack1Salt.getText().trim().isEmpty() || snack2Salt.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Salt column.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
			}else {
				try {
					Nutrients salt = new Nutrients(breakfastSalt.getText(), lunchSalt.getText(), dinnerSalt.getText(), snack1Salt.getText(), snack2Salt.getText());
					averageSaltDisplay = String.valueOf(salt.CalculateAverage(salt.getList())); 
					highSaltDisplay = String.valueOf(salt.FindHighValue(salt.getList())); 
					lowSaltDisplay = String.valueOf(salt.FindLowValue(salt.getList())); 
					totalSaltDisplay = String.valueOf(salt.CalculateTotal(salt.getList())); 
				}catch(NumericOnlyException e) {
					errorDectected = true;
					dataEntryErrorLabel.setText("Non-numeric value entered in Salt column.");
					dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
					dataEntryErrorLabel.setTextFill(Color.RED);
					dataEntryErrorLabel2.setTextFill(Color.RED);
				}
			}
		//Creating new Nutrient object for calories, finding the average value, high value, low value, and total value. Each will then be assigned to a string
		//for updating the display
		//if statement checks for null values and prompts the user to remove them.
		if (breakfastFat.getText().trim().isEmpty() || lunchFat.getText().trim().isEmpty() || dinnerFat.getText().trim().isEmpty() 
				|| snack1Fat.getText().trim().isEmpty() || snack2Fat.getText().trim().isEmpty()) {
			errorDectected = true;
			dataEntryErrorLabel.setText("Non-numeric value entered in Fat column.");
			dataEntryErrorLabel2.setText("Please enter a use 0 instead of leaving the cell empty.");
			dataEntryErrorLabel.setTextFill(Color.RED);
			dataEntryErrorLabel2.setTextFill(Color.RED);
			}else {
				try {
					Nutrients fat = new Nutrients(breakfastFat.getText(), lunchFat.getText(), dinnerFat.getText(), snack1Fat.getText(), snack2Fat.getText());
					averageFatDisplay = String.valueOf(fat.CalculateAverage(fat.getList())); 
					highFatDisplay = String.valueOf(fat.FindHighValue(fat.getList())); 
					lowFatDisplay = String.valueOf(fat.FindLowValue(fat.getList())); 
					totalFatDisplay = String.valueOf(fat.CalculateTotal(fat.getList())); 
				}catch(NumericOnlyException e) {
					errorDectected = true;
					dataEntryErrorLabel.setText("Non-numeric value entered in Fat column.");
					dataEntryErrorLabel2.setText("Please enter a numeric value with only one decimal.");
					dataEntryErrorLabel.setTextFill(Color.RED);
					dataEntryErrorLabel2.setTextFill(Color.RED);
				}
			}
		
		//Creating new MealName object
		MealName meals = new MealName(breakfastName.getText(), lunchName.getText(), dinnerName.getText(), snack1Name.getText(), snack2Name.getText());
		
		//Getting meal name info
		mostCommonMealDisplay = meals.mostCommonMeal(meals.getNameList());
		
		//Passes all the data entered to the Statistics scene for display to user. If statement checks if an error has occurred and skips changing scene if so.
		if (errorDectected == false) {
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
}}
