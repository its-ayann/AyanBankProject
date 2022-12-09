package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * The main file that executes the log in window. 
 * @author Ayan Ahmed
 *
 */
public class Main extends Application {
	
	/** Displays the scene on the primary stage. 
	 * @param asks for which scene to be displayed to thee user.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			//VBox root = loader.load(new FileInputStream("src/application/BankApplicationView.fxml"));
			Parent root = loader.load(new FileInputStream("src/application/BankApplicationView.fxml"));
			BankApplicationLoginController controller = (BankApplicationLoginController) loader.getController();
			controller.applicationStage = primaryStage;
			
			Scene scene = new Scene(root,600,400);
			
			//controller.setMyScene(scene);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login Window");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
