package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    	

    }


    @FXML
    void signIn(ActionEvent event) {
    	String accountNumber = accountNumberTextField.getText();
    	String password = passwordTextField.getText();
    	if (accountNumber.equals("12-3") && password.equals("abc")) {
    		System.out.println("Logged in successfully");
    		
    		
    		try {
    			FXMLLoader accountDashboardLoader = new FXMLLoader();
    			VBox root = accountDashboardLoader.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
    			Scene accountDashboard = new Scene(root, 600,400);
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
    		System.out.println("one or more of your info was wrong");
    	}
    	System.out.println("Account Number: " + accountNumber);
    	System.out.println("Password: " + password);
    	
    }

}
