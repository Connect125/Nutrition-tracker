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
	
	@FXML
	private Label averageCaloriesLabel;
	
	@FXML
	private Label averageSaltLabel;
	
	@FXML
	private Label averageFatLabel;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public StatisticsSceneController() {
		// TODO Auto-generated constructor stub
	}
	
	public void switchToMainScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void displayAverages(String averageCaloriesDisplay, String averageSaltDisplay, String averageFatDisplay) {
		averageCaloriesLabel.setText(averageCaloriesDisplay);
		averageSaltLabel.setText(averageSaltDisplay);
		averageFatLabel.setText(averageFatDisplay);
	}
	public void displayHigh(String highCaloriesDisplay, String highSaltDisplay, String highFatDisplay) {
		highCaloriesLabel.setText(highCaloriesDisplay);
		highSaltLabel.setText(highSaltDisplay);
		highFatLabel.setText(highFatDisplay);
	}
	


}
