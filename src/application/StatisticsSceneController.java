package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StatisticsSceneController {
	
	//FXML imports
	@FXML
	private Label averageCaloriesLabel;
	
	@FXML
	private Label averageSaltLabel;
	
	@FXML
	private Label averageFatLabel;
	
	@FXML
	private Label highCaloriesLabel;
	
	@FXML
	private Label highSaltLabel;
	
	@FXML
	private Label highFatLabel;
	
	@FXML
	private Label lowCaloriesLabel;
	
	@FXML
	private Label lowSaltLabel;
	
	@FXML
	private Label lowFatLabel;
	
	@FXML
	private Label totalCaloriesLabel;
	
	@FXML
	private Label totalSaltLabel;
	
	@FXML
	private Label totalFatLabel;
	
	@FXML
	private Label mostCommonMealLabel;
	
	
	//Instance Variables
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	/**
	 * After a clicking a the "Return to Main" button returns the user to the main screen.
	 * @param event
	 * The trigger from clicking on the "Return to Main"
	 * @throws IOException
	 */
	public void switchToMainScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * This updates the labels in the average row to the values from the DataEntryScene
	 * @param averageCaloriesDisplay
	 * A string containing the average calories for the day
	 * @param averageSaltDisplay
	 * A string containing the average salt for the day
	 * @param averageFatDisplay
	 * A string containing the average fat for the day
	 */
	public void displayAverages(String averageCaloriesDisplay, String averageSaltDisplay, String averageFatDisplay) {
		averageCaloriesLabel.setText(averageCaloriesDisplay);
		averageSaltLabel.setText(averageSaltDisplay);
		averageFatLabel.setText(averageFatDisplay);
	}
	
	/**
	 * This updates the labels in the high row to the values from the DataEntryScene 
	 * @param highCaloriesDisplay
	 * A string containing the high calories for the day
	 * @param highSaltDisplay
	 * A string containing the high salt for the day
	 * @param highFatDisplay
	 * A string containing the high fat for the day
	 */
	public void displayHighs(String highCaloriesDisplay, String highSaltDisplay, String highFatDisplay) {
		highCaloriesLabel.setText(highCaloriesDisplay);
		highSaltLabel.setText(highSaltDisplay);
		highFatLabel.setText(highFatDisplay);
	}
	
	/**
	 * This updates the labels in the low row to the values from the DataEntryScene 
	 * @param lowCaloriesDisplay
	 * A string containing the low calories for the day
	 * @param lowSaltDisplay
	 * A string containing the low salt for the day
	 * @param lowFatDisplay
	 * A string containing the low fat for the day
	 */
	public void displayLows(String lowCaloriesDisplay, String lowSaltDisplay, String lowFatDisplay) {
		lowCaloriesLabel.setText(lowCaloriesDisplay);
		lowSaltLabel.setText(lowSaltDisplay);
		lowFatLabel.setText(lowFatDisplay);
	}
	
	/**
	 * This updates the labels in the total row to the values from the DataEntryScene 
	 * @param totalCaloriesDisplay
	 * A string containing the total calories for the day
	 * @param totalSaltDisplay
	 * A string containing the total salt for the day
	 * @param totalFatDisplay
	 * A string containing the total fat for the day
	 */
	public void displayTotals(String totalCaloriesDisplay, String totalSaltDisplay, String totalFatDisplay) {
		totalCaloriesLabel.setText(totalCaloriesDisplay);
		totalSaltLabel.setText(totalSaltDisplay);
		totalFatLabel.setText(totalFatDisplay);
	}
	
	/**
	 * This updates the mostCommonMeal label
	 * @param mostCommonMeal
	 * A string containing the most common meal consumed for the day
	 */
	public void displayMealNames(String mostCommonMeal) {
		mostCommonMealLabel.setText(mostCommonMeal);
	}
	


}
