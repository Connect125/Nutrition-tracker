package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class MainSceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private TextField fileReadName;
	
	@FXML
    private Label fileNameErrorLabel;


	/**
	 * Allows the user to switch scenes to the data entry scene
	 * @param event
	 * Is triggered by clicking the "Enter Nutritional Data" button
	 * @throws IOException
	 */
	public void switchToNutritionDataEntry(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionDataEntry.fxml"));
		root = loader.load();
		
		//root = FXMLLoader.load(getClass().getResource("NutritionDataEntry.fxml"));
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	/**
	 * This method reads a specified file, and changes to the StatisticsScene to display the file
	 * @param event This is from clicking the load file button
	 * @throws IOException
	 */
	public void loadFileSwitchToStatisticsScene(ActionEvent event) throws IOException{
			
		//String for custom file name
		String fileName = new String();
		
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
		
		//Setting File name and checking if it exists if not prompt the user.
		File f = new File(fileReadName.getText() + ".txt");
		if (f.exists()) {
			fileName = fileReadName.getText();
			
			//Reading the file and setting the new values to their respective string
			BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
			
			//Skip first 2 lines nothing important
			reader.readLine();
			reader.readLine();

			String line = reader.readLine();
			
			//looks for a character pattern that matches the specified pattern then if found assigns the values
			Pattern caloriesPattern = Pattern.compile("(\t)(.*?)(\t)(.*?)(\t)(.*?)(\t)(.*?)(\t)");
			Matcher m1 = caloriesPattern.matcher(line);
			if (m1.find()) {
				averageCaloriesDisplay = m1.group(2);
				highCaloriesDisplay = m1.group(4);
				lowCaloriesDisplay = m1.group(6);
				totalCaloriesDisplay = m1.group(8);
			}
			
			//Setting salt strings for display
			Pattern saltFatPattern = Pattern.compile("(\t)(\t)(.*?)(\t)(.*?)(\t)(.*?)(\t)(.*?)(\t)");
			line = reader.readLine();
			m1 = saltFatPattern.matcher(line);
			if (m1.find()) {
				averageSaltDisplay = m1.group(3);
				highSaltDisplay = m1.group(5);
				lowSaltDisplay = m1.group(7);
				totalSaltDisplay = m1.group(9);
			}
			
			//Setting Fat strings for display
			line = reader.readLine();
			m1 = saltFatPattern.matcher(line);
			if (m1.find()) {
				averageFatDisplay = m1.group(3);
				highFatDisplay = m1.group(5);
				lowFatDisplay = m1.group(7);
				totalFatDisplay = m1.group(9);
			}
			
			//Setting Common Name string for display
			line = reader.readLine();
			Pattern namePattern = Pattern.compile("(: )(.*?)(\t)");
			m1 = namePattern.matcher(line);
			if (m1.find()) {
				mostCommonMealDisplay = m1.group(2);
			}
			reader.close();
			
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
		}else {
			//Provides error message to the user if file cannot be found
			fileNameErrorLabel.setText("No file named " + fileReadName.getText() + ".txt" + " could be found.");
			fileNameErrorLabel.setTextFill(Color.RED);
		}
	}
	
	

}
