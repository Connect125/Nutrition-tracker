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
	public void displayCaloriesAverage(String averageCaloriesDisplay) {
		System.out.println("averageCaloriesDisplay Working " + averageCaloriesDisplay);
		averageCaloriesLabel.setText(averageCaloriesDisplay);
		System.out.println("Label " + averageCaloriesLabel.getText());
	}


}
