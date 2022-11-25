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

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public DataEntrySceneController() {
		// TODO Auto-generated constructor stub
	}
	
	public void switchToNutritionStatistics(ActionEvent event) throws IOException{
		String averageCaloriesDisplay = new String();
		String averageSaltDisplay = new String();
		String averageFatDisplay = new String();
		
		Nutrients calories = new Nutrients(breakfastCalories.getText(), lunchCalories.getText(), dinnerCalories.getText(), snack1Calories.getText(), snack2Calories.getText());
		Nutrients salt = new Nutrients(breakfastSalt.getText(), lunchSalt.getText(), dinnerSalt.getText(), snack1Salt.getText(), snack2Salt.getText());
		Nutrients fat = new Nutrients(breakfastFat.getText(), lunchFat.getText(), dinnerFat.getText(), snack1Fat.getText(), snack2Fat.getText());
		
		//Getting the average value of each list and assigning it to a string
		averageCaloriesDisplay = String.valueOf(calories.CalculateAverage(calories.getList())); 
		averageSaltDisplay = String.valueOf(salt.CalculateAverage(salt.getList())); 
		averageFatDisplay = String.valueOf(fat.CalculateAverage(fat.getList())); 


		FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionStatistics.fxml"));
		root = loader.load();
		
		StatisticsSceneController StatisticsSceneController = loader.getController();
		StatisticsSceneController.displayAverages(averageCaloriesDisplay,averageSaltDisplay,averageFatDisplay);
		
		//Below line causes the labels to not update for the Statistics scene
		//root = FXMLLoader.load(getClass().getResource("NutritionStatistics.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
