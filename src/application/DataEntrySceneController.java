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

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void displayDayNumber(String dayNumber) {
		dayNumberLabel.setText(dayNumber);
	}
	
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
	
	public void switchToNutritionStatistics(ActionEvent event) throws IOException{
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
		
		//Creating new Nutrient objects will crash if given empty text
		Nutrients calories = new Nutrients(breakfastCalories.getText(), lunchCalories.getText(), dinnerCalories.getText(), snack1Calories.getText(), snack2Calories.getText());
		Nutrients salt = new Nutrients(breakfastSalt.getText(), lunchSalt.getText(), dinnerSalt.getText(), snack1Salt.getText(), snack2Salt.getText());
		Nutrients fat = new Nutrients(breakfastFat.getText(), lunchFat.getText(), dinnerFat.getText(), snack1Fat.getText(), snack2Fat.getText());
		
		//Creating new MealName object
		MealName meals = new MealName(breakfastName.getText(), lunchName.getText(), dinnerName.getText(), snack1Name.getText(), snack2Name.getText());
		
		//Getting the average value of each list and assigning it to a string
		averageCaloriesDisplay = String.valueOf(calories.CalculateAverage(calories.getList())); 
		averageSaltDisplay = String.valueOf(salt.CalculateAverage(salt.getList())); 
		averageFatDisplay = String.valueOf(fat.CalculateAverage(fat.getList())); 
		
		//Getting the high value of each list and assigning it to a string
		highCaloriesDisplay = String.valueOf(calories.FindHighValue(calories.getList())); 
		highSaltDisplay = String.valueOf(salt.FindHighValue(salt.getList())); 
		highFatDisplay = String.valueOf(fat.FindHighValue(fat.getList())); 
		
		//Getting the low value of each list and assigning it to a string
		lowCaloriesDisplay = String.valueOf(calories.FindLowValue(calories.getList())); 
		lowSaltDisplay = String.valueOf(salt.FindLowValue(salt.getList())); 
		lowFatDisplay = String.valueOf(fat.FindLowValue(fat.getList())); 
		
		//Getting the total value of each list and assigning it to a string
		totalCaloriesDisplay = String.valueOf(calories.CalculateTotal(calories.getList())); 
		totalSaltDisplay = String.valueOf(salt.CalculateTotal(salt.getList())); 
		totalFatDisplay = String.valueOf(fat.CalculateTotal(fat.getList())); 
		
		//Getting meal name info
		mostCommonMealDisplay = meals.mostCommonMeal(meals.getNameList());
		
		//Passes all the data entered to the Statistics scene for display to user.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionStatistics.fxml"));
		root = loader.load();
		
		StatisticsSceneController StatisticsSceneController = loader.getController();
		StatisticsSceneController.displayAverages(averageCaloriesDisplay,averageSaltDisplay,averageFatDisplay);
		StatisticsSceneController.displayHighs(highCaloriesDisplay,highSaltDisplay,highFatDisplay);
		StatisticsSceneController.displayLows(lowCaloriesDisplay,lowSaltDisplay,lowFatDisplay);
		StatisticsSceneController.displayTotals(totalCaloriesDisplay,totalSaltDisplay,totalFatDisplay);
		StatisticsSceneController.displayMealNames(mostCommonMealDisplay);
		
		
		//Below line causes the labels to not update for the Statistics scene
		//root = FXMLLoader.load(getClass().getResource("NutritionStatistics.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
