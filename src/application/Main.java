package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(); 
			VBox root = loader.load(new FileInputStream("src/application/MainScreen.fxml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene );
			primaryStage.setTitle("William Spencer's Nutrition Tracker");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
