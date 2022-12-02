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

public class MainSceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
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
    private TextField breakfastCalories;
	
	@FXML
	private Label averageCalories;


	/**
	 * Allows the user to switch scenes to the data entry scene
	 * @param event
	 * Is triggered by clicking the "Enter Nutritional Data" button
	 * @throws IOException
	 */
	public void switchToNutritionDataEntry(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionDataEntry.fxml"));
		root = loader.load();
		
		DataEntrySceneController DataEntrySceneController = loader.getController();
		DataEntrySceneController.displayDayNumber("Day #1");
		
		//root = FXMLLoader.load(getClass().getResource("NutritionDataEntry.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void loadFileSwitchToStatisticsScene(ActionEvent event) throws IOException{
			
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
		
		//Reading the file and setting the new values to their respective string
		
		
		
		//Pass values to Statistics scene and load new scene
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
