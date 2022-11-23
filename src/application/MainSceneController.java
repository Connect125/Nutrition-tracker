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


	public void switchToMainScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToNutritionDataEntry(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("NutritionDataEntry.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToNutritionStatistics(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("NutritionStatistics.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void saveData(ActionEvent event) {
		System.out.println("SaveData button works");
		String[] nameList =  new String[5];
		String[] caloriesList =  new String[5];
		String[] saltList =  new String[5];
		String[] fatList =  new String[5];
		
		nameList[0] = breakfastName.getText();
		nameList[1] = lunchName.getText();
		nameList[2] = dinnerName.getText();
		nameList[3] = snack1Name.getText();
		nameList[4] = snack2Name.getText();
		
		caloriesList[0] = breakfastCalories.getText(); 
		System.out.println("" + caloriesList[0]);
		averageCalories.setText(caloriesList[0]);
	}

}
