package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForgotPasswordController {
	
	private Stage primaryStage;
	private Scene myScene;
	private BankApplicationLoginController nextController;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void setNextController(BankApplicationLoginController next) {
		nextController = next;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

    @FXML
    private Button nextButton;

    @FXML
    private Button cancelButton;
    
    @FXML
    private TextField codeTextField;

    @FXML
    void next(ActionEvent event) {
    	String code = codeTextField.getText();
    	if (code.equals("111111")) {
    		try {
        		FXMLLoader changePasswordLoader = new FXMLLoader();
    			Parent root = changePasswordLoader.load(new FileInputStream("src/application/ChangePasswordView.fxml"));
    			Stage window = (Stage) nextButton.getScene().getWindow();
    			window.setScene(new Scene(root,600,400));
    			
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
    	} else {
    		System.out.println("code was wrong");
    	}

    }

    @FXML
    void cancel(ActionEvent event) {
    	
    	
    	try {
    		FXMLLoader changePasswordLoader = new FXMLLoader();
			Parent root = changePasswordLoader.load(new FileInputStream("src/application/BankApplicationView.fxml"));
			Stage window = (Stage) cancelButton.getScene().getWindow();
			window.setScene(new Scene(root,600,400));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//nextSceneController.takeFocus();
    	/*
    	if (nextController != null) {
    		nextController.takeFocus();
    	} else {
    		
    	}
    	*/
    	
    	/*
    	try {
			FXMLLoader changePasswordLoader = new FXMLLoader();
			VBox root = changePasswordLoader.load(new FileInputStream("src/application/BankApplicationView.fxml"));
			//Scene changePassword = new Scene(root, 600,400);
			//nextSceneController = changePasswordLoader.getController();
    		//nextSceneController.setPrimaryStage(primaryStage);
    		//nextSceneController.setMyScene(new Scene(root));
    		//nextSceneController.setNextController(this);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/

    }

}
