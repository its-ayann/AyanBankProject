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


/**
 * When user interacts with the log in window
 * BankApplicationLoginController consists of methods 
 * and controls that will give the user with 
 * what they interact with.
 * @author Ayan Ahmed
 *
 */
public class BankApplicationLoginController {
	
	Stage applicationStage;
	private Stage primaryStage;
	private String password = "abc";
	
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
    
   
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String newPassword) {
    	password = newPassword;
    }
  
    
    /**
     * When the radio button is clicked the password 
     * textfield is revealed with whatever is inside it. 
     * This code to show a password text field was 
     * found from StackOverflow: https://stackoverflow.com/questions/17014012/how-to-unmask-a-javafx-passwordfield-or-properly-mask-a-textfield
     * @param event when radio button is clicked show the string in password text field
     */
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
    
    /**
     * When the forgotPassword hyper link is clicked 
     * the user is prompted a new window where they can change their
     * password or go back to the main log in page.
     * @param event Prompt new window when hyperlink is clicked.
     */

    @FXML
    void forgotPassword(ActionEvent event) {
    	
    	ChangePasswordView cpv = new ChangePasswordView(password);
    	cpv.displayChangePasswordWindow();
    	password = cpv.getNewPassword();
   
    }
    

    /**
     * When sign in button is clicked check if account number text field
     * and password text field is correct. Display error message if not, or show account
     * dashboard if correct credentials are given in text fields.
     * @param event check text field input and display message or new window depending on the user input.
     */

    @FXML
    void signIn(ActionEvent event) {
    	
    	String accountNumber = accountNumberTextField.getText();
    	String passwordGuessed = passwordTextField.getText();
    	if (accountNumber.equals("12-3") && passwordGuessed.equals(password)) {
    		System.out.println("Logged in successfully");

    		try {
    			
    			FXMLLoader loader = new FXMLLoader();
    			Parent root = loader.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
    			AccountDashboardController controller = (AccountDashboardController) loader.getController();
    			controller.applicationStage = primaryStage;
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
    		errorMessage.setText("Your Account Number or Password is incorrect. Try again.");
    		System.out.println("one or more of your info was wrong");
    	}
    	System.out.println("Account Number: " + accountNumber);
    	System.out.println("Password: " + password);
    	
    }

}