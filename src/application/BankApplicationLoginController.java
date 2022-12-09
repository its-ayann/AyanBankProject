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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankApplicationLoginController {
	Stage applicationStage;
	
	
	private Stage primaryStage;
	private Scene myScene;
	//private ForgotPasswordController nextSceneController;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

    @FXML
    private CheckBox rememberMeCheckBox;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private RadioButton showPasswordRadioButton;

    @FXML
    private TextField accountNumberTextField;
    
    @FXML
    private TextField showPasswordTextField;

    @FXML
    private Hyperlink forgotPasswordHyperLink;

    @FXML
    private Button signInButton;
    
    @FXML
    private Label errorMessage;
    
    private String password = "abc";
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String newPassword) {
    	password = newPassword;
    }
  
    
    @FXML
    void showPassword(ActionEvent event) {
    	if (showPasswordRadioButton.isSelected()) {
	    	showPasswordTextField.setText(passwordTextField.getText());
	    	showPasswordTextField.setVisible(true);
	    	passwordTextField.setVisible(false);
	    	return;
    	} 
    	passwordTextField.setText(showPasswordTextField.getText());
    	passwordTextField.setVisible(true);
    	showPasswordTextField.setVisible(false);
    	

    }

    @FXML
    void forgotPassword(ActionEvent event) {
    	
    	ChangePasswordView cpv = new ChangePasswordView(password);
    	cpv.displayChangePasswordWindow();
    	
    	password = cpv.getNewPassword();
   
    	
    	/*
    	try {
    		
    		FXMLLoader forgotPasswordLoader = new FXMLLoader();
			Parent root = FXMLLoader.load(getClass().getResource("ChangePasswordView.fxml"));
			//VBox root = forgotPasswordLoader.load(new FileInputStream("src/application/ForgotPasswordView.fxml"));
			Stage window = (Stage) forgotPasswordHyperLink.getScene().getWindow();
			window.setScene(new Scene(root, 600, 400));
			
			
			//Parent root = forgotPasswordLoader.load(new FileInputStream("src/application/ChangePasswordView.fxml"));
			
			//Stage window = (Stage) forgotPasswordHyperLink.getScene().getWindow();
			//window.setScene(new Scene(root,600,400));
			
			//Scene forgotPassword = new Scene(root, 600,400);
    		
			//applicationStage.setScene(forgotPassword);
    		//applicationStage.setTitle("Reset Password");
			
			//nextSceneController = forgotPasswordLoader.getController();
			//nextSceneController.setPrimaryStage(primaryStage);
			//nextSceneController.setMyScene(new Scene(root));
			//nextSceneController.setNextController(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

    }
    


    @FXML
    void signIn(ActionEvent event) {
    	String accountNumber = accountNumberTextField.getText();
    	String passwordGuessed = passwordTextField.getText();
    	if (accountNumber.equals("12-3") && passwordGuessed.equals(password)) {
    		System.out.println("Logged in successfully");
    		
    		
    		try {
    			//FXMLLoader accountDashboardLoader = new FXMLLoader();
    			FXMLLoader loader = new FXMLLoader();
    			//VBox root = accountDashboardLoader.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
    			
    			//Parent root = accountDashboardLoader.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
    			Parent root = loader.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
    			AccountDashboardController controller = (AccountDashboardController) loader.getController();
    			
    			controller.applicationStage = primaryStage;
    			Scene accountDashboard = new Scene(root, 600,400);
    			
    			
        		//Stage window = (Stage) signInButton.getScene().getWindow();
        		//window.setScene(new Scene(root,600,400));
        		
    			
    			applicationStage.setScene(accountDashboard);
        		applicationStage.setTitle("Account Dashboard");
    			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	} else {
    		errorMessage.setText("Your Account Number or Password is incorrect. Try again.");
    		System.out.println("one or more of your info was wrong");
    	}
    	System.out.println("Account Number: " + accountNumber);
    	System.out.println("Password: " + password);
    	
    }

}