package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public DataEntrySceneController() {
		// TODO Auto-generated constructor stub
	}
	
	public void switchToNutritionStatistics(ActionEvent event) throws IOException{
		int index = 0;
		String averageCaloriesDisplay = new String();
		
		Nutrients calories = new Nutrients(breakfastCalories.getText(), lunchCalories.getText(), dinnerCalories.getText(), snack1Calories.getText(), snack2Calories.getText());
		
		System.out.println("Created new Nutrient");
		
		averageCaloriesDisplay = String.valueOf(calories.CalculateAverage(calories.getList())); 
		
		System.out.println("Calculated Average");
		/**
		double[] caloriesList = new double[5];
		caloriesList[0] = Double.parseDouble(breakfastCalories.getText());
		caloriesList[1] = Double.parseDouble(lunchCalories.getText());
		caloriesList[2] = Double.parseDouble(dinnerCalories.getText());
		caloriesList[3] = Double.parseDouble(snack1Calories.getText());
		caloriesList[4] = Double.parseDouble(snack2Calories.getText());
		
		String averageCaloriesDisplay = new String();
		double averageCaloriesCalc = 0;
		
		while (index < caloriesList.length) {
			
			averageCaloriesCalc = averageCaloriesCalc + caloriesList[index];
			index ++;
			
			System.out.println("index " + index);
			
			if (index >= caloriesList.length) {
				averageCaloriesCalc = averageCaloriesCalc/caloriesList.length;
				averageCaloriesDisplay = String.valueOf(averageCaloriesCalc);
			}
		}*/
		
		
		System.out.println("Working " + breakfastCalories.getText());

		FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionStatistics.fxml"));
		root = loader.load();
		
		StatisticsSceneController StatisticsSceneController = loader.getController();
		StatisticsSceneController.displayCaloriesAverage(averageCaloriesDisplay);
		
		//Below line causes the labels to not update for the Statistics scene
		//root = FXMLLoader.load(getClass().getResource("NutritionStatistics.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
