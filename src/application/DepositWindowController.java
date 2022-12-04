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
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class DepositWindowController extends AccountDashboardController{

    @FXML
    private TextField depositAmountTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button depositButton;
    
    @FXML
    private Label amountErrorLabel;
    
    private Parent root;
    
    private Account selectedAccount;
	

    @FXML
    void depositAmount(ActionEvent event) {
    	
    	
    	
    		
    	//return depositAmount;
    	
    	

    }
    
    public void getAccountType(Account account) {
    	selectedAccount = account;
    }
    
    public double getDepositAmount() {
    	boolean validDepositAmount = true;
    	int decimalCounter = 0;
    	
    	if (depositAmountTextField.getText() == null) {
    		amountErrorLabel.setText("Please enter an amount to deposit");
    	}
    	
    	String amount = depositAmountTextField.getText();
    	
    	for (char c: amount.toCharArray()) {
    		
    		// Check if the character is a digit
    		//System.out.println(c);
    		if (!Character.isDigit(c)) {
    			if (c!= '.') {
    				validDepositAmount = false;
        			amountErrorLabel.setText("Do not use " + c + " in a deposit amount. Make sure to enter a number.");
    			} else if (decimalCounter != 0) {
    				validDepositAmount = false;
    				amountErrorLabel.setText("Do not use more than one decimal. Please enter a valid number");
    			} else if (c == '.') {
    				decimalCounter = decimalCounter + 1;
    			}
    		}
    	}
    	
    	double depositAmount =  0;
    	if (validDepositAmount) {
    		depositAmount = Double.parseDouble(amount);
    	}
    	
    	//System.out.println(getChequingSelected());
    	
    	// Check if the number entered by the user is a valid percentage grade
    	// If valid, include it in the grade computation
    	if (depositAmount < 0) {
    		amountErrorLabel.setText("Enter a deposit value above $0.00. ");
    		depositAmount = 0;
    	} else {
    		
    		//System.out.println("before: " + account.getBalance());
    		//account.deposit(depositAmount);
    		//System.out.println("after: " + account.getBalance());
    		
    }
    	return depositAmount;
    }

    @FXML
    void deposit(ActionEvent event) {
    	
    	
    	
    	/*
    	boolean validDepositAmount = true;
    	int decimalCounter = 0;
    	String amount = depositAmountTextField.getText();
    	
    	for (char c: amount.toCharArray()) {
    		
    		// Check if the character is a digit
    		//System.out.println(c);
    		if (!Character.isDigit(c)) {
    			if (c!= '.') {
    				validDepositAmount = false;
        			amountErrorLabel.setText("Do not use " + c + " in a deposit amount. Make sure to enter a number.");
    			} else if (decimalCounter != 0) {
    				validDepositAmount = false;
    				amountErrorLabel.setText("Do not use more than one decimal. Please enter a valid number");
    			} else if (c == '.') {
    				decimalCounter = decimalCounter + 1;
    			}
    		}
    	}
    	*/
    	/*
    	double depositAmount =  0;
    	if (validDepositAmount) {
    		depositAmount = Double.parseDouble(amount);
    	}
    	
    	System.out.println(getChequingSelected());
    	
    	// Check if the number entered by the user is a valid percentage grade
    	// If valid, include it in the grade computation
    	if (depositAmount < 0) {
    		amountErrorLabel.setText("Enter a deposit value above $0.00. ");
    		depositAmount = 0;
    	} else {
    		
    		System.out.println("before: " + account.getBalance());
    		account.deposit(depositAmount);
    		System.out.println("after: " + account.getBalance());
    		
    		*/
    	/*	
    	try {
    			//window.close();
    			FXMLLoader depositWindowLoader = new FXMLLoader();    			
    			Parent root = depositWindowLoader.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
    			Stage window = (Stage) depositButton.getScene().getWindow();
    			window.setScene(new Scene(root,600,400));
    			
    			
    			System.out.println(chequingSelected);
    			
    			//DepositWindowController controller = depositWindowLoader.getController();
    			//controller.getAccountType(account);
    			//Account.selectedAccount = accountTypeComboBox.getValue();
    	
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		*/
    		/*
    	    try {
    	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("src/application/AccountDashboardView.fxml"));
				root = loader.load();
				AccountDashboardController accountDashboard = loader.getController();
	    		accountDashboard.account.deposit(depositAmount);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
        	try {
    			FXMLLoader forgotPasswordLoader = new FXMLLoader();
    			
    			
    			Parent root = forgotPasswordLoader.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
    			
    			Stage window = (Stage) depositButton.getScene().getWindow();
    			window.setScene(new Scene(root,600,400));
    		
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
    void cancel(ActionEvent event) {

    }

}
