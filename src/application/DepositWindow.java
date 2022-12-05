package application;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DepositWindow {
	private Stage window;
	
	private TextField amount;
	private Label errorMessage;
	private Account account;
	
	
	
	DepositWindow(Account anAccount) {
		account = anAccount;
	}
	
	public void displayDepositWindow() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Deposit Window");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		
		VBox depositContainer = new VBox();
    	
    	HBox title = new HBox();
    	Label depositTitle = new Label("Deposit Amount");
    	depositTitle.setFont(Font.font("Franklin Gothic Medium", 30));
    	//depositTitle.setPadding(new Insets(10,10,10,10));
    	title.setAlignment(Pos.TOP_LEFT);
    	HBox.setMargin(depositTitle, new Insets(10, 10, 10, 10));
    	
    	HBox money = new HBox();
    	Label dollarSign = new Label("$");
    	dollarSign.setFont(Font.font("Franklin Gothic Medium", 15));
    	//dollarSign.setPadding(new Insets(10,0,10,10));
    	amount = new TextField();
    	amount.setPrefSize(218, 30);
    	//amount.setPadding(new Insets(10,10,10,0));
    	money.setAlignment(Pos.CENTER);
    	HBox.setMargin(dollarSign, new Insets(10, 0, 10, 10));
    	HBox.setMargin(amount, new Insets(10, 10, 10, 0));
    	
    	
    	HBox message = new HBox();
    	errorMessage = new Label(" ");
		//errorMessage.setPadding(new Insets(10,10,10,10));
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
		HBox.setMargin(errorMessage, new Insets(10, 10, 10, 10));
    	
    	
    	HBox buttons = new HBox();
    	Button deposit = new Button("Deposit");
    	Button cancel = new Button("Cancel");
    	buttons.setAlignment(Pos.CENTER);
    	HBox.setMargin(deposit, new Insets(10, 10, 10, 10));
    	HBox.setMargin(cancel, new Insets(10, 10, 10, 10));
    	
    	
    	deposit.setOnAction(depositEvent -> checkDeposit());
    	//deposit.setOnAction(depositEvent -> validDepo(getDepositAmount(amount.getText())));
    	
    	cancel.setOnAction(cancelEvent -> window.close());
    	
    	
    	title.getChildren().addAll(depositTitle);
    	money.getChildren().addAll(dollarSign, amount);
    	message.getChildren().addAll(errorMessage);
    	buttons.getChildren().addAll(deposit,cancel);
    	
    	depositContainer.getChildren().addAll(title,money,message,buttons);
    	
    	Scene scene = new Scene(depositContainer);
    	window.setScene(scene);
    	window.showAndWait();
	}
    
	
	
	public double getDepositAmount(String depositAmountText) {
		boolean validDepositAmount = true;
    	int decimalCounter = 0;
    	depositAmountText = amount.getText();
    	
    	
    	if (depositAmountText.isEmpty()) {
    		errorMessage.setText("sPlease enter an amount to deposit");
    	}
    	
    	
    	for (char c: depositAmountText.toCharArray()) {
    		
    		// Check if the character is a digit
    		//System.out.println(c);
    		if (!Character.isDigit(c)) {
    			if (c!= '.') {
    				validDepositAmount = false;
        			errorMessage.setText("Do not use " + c + " in a deposit amount. Make sure to enter a number.");
    			} else if (decimalCounter != 0) {
    				validDepositAmount = false;
    				errorMessage.setText("Do not use more than one decimal. Please enter a valid number");
    			} else if (c == '.') {
    				decimalCounter = decimalCounter + 1;
    			}
    		}
}
    	
    	double depositAmount =  0;
    	if (validDepositAmount) {
    		depositAmount = Double.parseDouble(depositAmountText);
    	}
    	
    	//System.out.println(getChequingSelected());
    	
    	// Check if the number entered by the user is a valid percentage grade
    	// If valid, include it in the grade computation
    	if (depositAmount <= 0) {
    		errorMessage.setText("Enter a deposit value above $0.00. ");
    		depositAmount = 0;
    	} 
    		
    		//System.out.println("before: " + account.getBalance());
    		//account.deposit(depositAmount);
    		//System.out.println("after: " + account.getBalance());	
    	System.out.print(validDepositAmount);
    	return depositAmount;
    }
		/*
		if (amount.getText().isEmpty()) {
			errorMessage.setText("Please enter an amount to deposit.");
		} 
		
		double depositAmount = Double.parseDouble(amount.getText());
		
		//System.out.println("WWWWWWWW" + account.getBalance());
		
		
		if (depositAmount < 0){
			errorMessage.setText("Please enter a valid amount to deposit");
			
		} else {
			account.deposit(depositAmount);
			window.close();
		}
		*/
	
	public void validDepo(double depositAmount) {
		if (depositAmount <= 0){
			errorMessage.setText("PLease enter a valid amount to deposit");
			
		} else {
			account.deposit(depositAmount);
			window.close();
		}
	}
	
	public void checkDeposit() {
		//System.out.print("TESTING HERE: " + account.getName());
		String depositAmountText = amount.getText();
		//Double.parseDouble();
		//System.out.println("ASASSASASA: "+ depositAmountText);
		boolean validNumericInput = true;
		int decimalCounter = 0;
		
		for (char c: amount.getText().toCharArray()) {
    		
    		// Check if the character is a digit
    		if (!Character.isDigit(c)) {
    			if (c!= '.') {
    				validNumericInput = false;
        			errorMessage.setText("Do not use " + c + " in a deposit amount. Make sure to enter a number.");
    			} else if (decimalCounter != 0) {
    				validNumericInput = false;
    				errorMessage.setText("Do not use more than one decimal. Please enter a valid number");
    			} else if (c == '.') {
    				decimalCounter = decimalCounter + 1;
    			}
    		}
		}
		
		while (validNumericInput) {
			boolean validDepositAmount = true;
			double depositAmount = Double.parseDouble(depositAmountText);
			
			/*
	    	if (validDepositAmount) {
	    		depositAmount = Double.parseDouble(depositAmountText);
	    	}
	    	*/
	    	//System.out.println(getChequingSelected());
	    	
	    	// Check if the number entered by the user is a valid percentage grade
	    	// If valid, include it in the grade computation
	    	if (depositAmount <= 0) {
	    		validDepositAmount = false;
	    		errorMessage.setText("Enter a deposit value above $0.00. ");
	    		depositAmount = 0;
	    	} 
	    	else if (validDepositAmount = true && depositAmount > 0) {
	    		account.deposit(depositAmount);
	        	window.close();
	    	}	
		}
		
		//double depositAmount =  0;
		
		//double depositAmount = Double.parseDouble(depositAmountText);
	
		/*
    	if (validDepositAmount) {
    		depositAmount = Double.parseDouble(depositAmountText);
    	}
    	*/
    	//System.out.println(getChequingSelected());
    	
    	// Check if the number entered by the user is a valid percentage grade
    	// If valid, include it in the grade computation
    	/*
		if (depositAmount <= 0) {
    		errorMessage.setText("Enter a deposit value above $0.00. ");
    		depositAmount = 0;
    	} 
    	if (validDepositAmount = true && depositAmount > 0) {
    		account.deposit(depositAmount);
        	window.close();
    	}	
    	*/
    		//System.out.println("before: " + account.getBalance());
    		//account.deposit(depositAmount);
    		//System.out.println("after: " + account.getBalance());	
    	//System.out.print(depositAmount);
    	System.out.print("TESTING HERE: " + account.getBalance());
    	//account.deposit(depositAmount);
    	//window.close();
    	
    }
}
	
	/*
	public void checkDeposit() {
		if (amount.getText().isEmpty()) {
			errorMessage.setText("Please enter an amount to deposit.");
		} 
		
		double depositAmount = Double.parseDouble(amount.getText());
		
		//System.out.println("WWWWWWWW" + account.getBalance());
		
		
		if (depositAmount < 0){
			errorMessage.setText("Please enter a valid amount to deposit");
			
		} else {
			account.deposit(depositAmount);
			window.close();
		}
	}
	*/
		
	
    


