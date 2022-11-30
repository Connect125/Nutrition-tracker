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
	
	

}
