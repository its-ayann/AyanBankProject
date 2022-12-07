package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

//Correct spelling for branch name

public class Main extends Application {
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
