package application;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TransferWindow {
	private Stage window;
	
	ComboBox accountToComboBox;
	TextField amount;
	Label errorMessage;
	Account account;
	Account accountTo;
	Account accountFrom;
	
	TransferWindow () {
		
	}
	
	
	TransferWindow (Account anAccount) {
		account = anAccount;
	}
	
	TransferWindow (Account anAccountTo, Account anAccountFrom) {
		accountTo = anAccountTo;
		accountFrom = anAccountFrom;
	}
	
	public void displayTransferWindow() {
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Transfer Window");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		VBox transferContainer = new VBox();
		
		HBox title = new HBox();
		Label transferTitle = new Label("Transfer Amount");
		transferTitle.setFont(Font.font("Franklin Gothic Medium", 30));
		transferTitle.setAlignment(Pos.TOP_LEFT);
		HBox.setMargin(transferTitle, new Insets(10,10,10,10));
		
		VBox contents = new VBox();
		String chequingAccount[] = {"CHEQUING ACCOUNT 012432"};
		String savingAccount[] = {"SAVINGS ACCOUNT 84190"};
		accountToComboBox = new ComboBox();
		accountToComboBox.setPrefSize(330,20);
		accountToComboBox.maxHeight(31);
		accountToComboBox.maxWidth(330);
		//System.out.println("1" + account.getAccountType());
		if (accountFrom.getAccountType().equals("Chequing")) {
			accountToComboBox = new ComboBox(FXCollections.observableArrayList(savingAccount));
		} else if (accountFrom.getAccountType().equals("Saving")) {
			accountToComboBox = new ComboBox(FXCollections.observableArrayList(chequingAccount));
		}
		
		amount = new TextField();
		errorMessage = new Label("");
		VBox.setMargin(accountToComboBox, new Insets(10,10,10,10));
		VBox.setMargin(amount, new Insets(10,10,10,10));
		
		HBox buttons = new HBox();
		Button transfer = new Button("Transfer");
		Button cancel = new Button("Cancel");
		HBox.setMargin(transfer, new Insets(10,10,10,10));
		HBox.setMargin(cancel, new Insets(10,10,10,10));
		
		HBox message = new HBox();
    	errorMessage = new Label("");
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
		HBox.setMargin(errorMessage, new Insets(10, 10, 10, 10));
		
		
		
		transfer.setOnAction(transferEvent -> checkTransfer());
		
		title.getChildren().addAll(transferTitle);
		contents.getChildren().addAll(accountToComboBox,amount);
		buttons.getChildren().addAll(transfer,cancel);
		message.getChildren().addAll(errorMessage);
		
		transferContainer.getChildren().addAll(title,contents,buttons,message);
		
		Scene scene = new Scene(transferContainer);
    	window.setScene(scene);
    	window.showAndWait();
		
	}
	
public void checkTransfer() {
		
		String transferAmountText = amount.getText();
		boolean validNumericInput = true;
		int decimalCounter = 0;
		
		if (amount.getText().isEmpty()) {
			errorMessage.setText("Please enter an amount to transfer.");
		} 
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
		
		if (validNumericInput = true) {
			boolean validTransferAmount = true;
			double transferAmount = Double.parseDouble(transferAmountText);
			
		
	    	
	    	// Check if the number entered by the user is a valid percentage grade
	    	// If valid, include it in the grade computation
	    	if (transferAmount <= 0) {
	    		validTransferAmount = false;
	    		errorMessage.setText("Enter an amount to transfer above $0.00. ");
	    		transferAmount = 0;
	    	} 
	    	
	    	else if (transferAmount > accountFrom.getBalance()) {
	    		validTransferAmount = false;
	    		errorMessage.setText("Insufficient Funds. Cannot transfer funds more than current balance.");
	    		transferAmount = 0;
	    	}
	    	else if (validTransferAmount = true) {
	    		accountTo.deposit(transferAmount);
				accountFrom.withdraw1(transferAmount);
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
    	//System.out.print("TESTING HERE: " + account.getBalance());
    	//account.deposit(depositAmount);
    	//window.close();
    	
    }

	
	
	
	
	/*
	public void checkTransfer() {
		//System.out.println(account.getAccountNumber());
		System.out.println(accountToComboBox.getSelectionModel().getSelectedItem().toString());
		
		if (amount.getText().isEmpty()) {
			errorMessage.setText("Please enter an amount to transfer.");
		} 
		
		
		//Account accountFrom = new Account(account.getAccountFrom(), account.getBalance());
		//Account accountToTransfer = new Account();
		
		//String accountTransferTo = accountToComboBox.getSelectionModel().getSelectedItem().toString();
		
		//if (accountTransferTo.equals("SAVINGS ACCOUNT 84190")) {
		
			//accountToTransfer = new Account(accountTransferTo);
			//accountToTransfer.setBalance(500);
			//double accountToBalance = accountToTransfer.getBalance();
			//accountTo = new Account(accountToComboBox.getSelectionModel().getSelectedItem().toString(), accountToBalance);
		//}
		double transferAmount = Double.parseDouble(amount.getText());
		
		//System.out.println("WWWWWWWW" + account.getBalance());
		
		
		if (transferAmount > accountFrom.getBalance()){
			errorMessage.setText("You cannot transfer more than your balance. ");
			
		} else {
			accountTo.deposit(transferAmount);
			accountFrom.withdraw1(transferAmount);
			/*
			if (account.getAccountNumber() == 123) {
				//account.getAccountNumber(accountToComboBox.getSelectionModel().getSelectedItem());
				account.transferTo(accountToTransfer,  account, transferAmount);
			}
			account.getAccountNumber();
			//account.withdraw1(transferAmount);
			*/
			//window.close();
		//}
		
	//}
	
	

}
