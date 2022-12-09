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

/**
 * When the user clicks on the transfer button then this window will appear. 
 * The option to select to which account to transfer to is displayed as well
 * as a text field to write the amount to transfer. 
 * @author Ayan Ahmed
 *
 */
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
	
	/**
	 * This method displays the transfer window. This window was made with JavaFX.
	 * //Change font in JavaFX found from StackOverflow: https://stackoverflow.com/questions/32624748/javafx-change-font-and-size-in-a-textfield 
	 * code to change font: (Font.font("Franklin Gothic Medium", 30))
	 */
	public void displayTransferWindow() {
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
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
		if (accountFrom.getAccountType().equals("CHEQUING ACCOUNT 012432")) {
			accountToComboBox = new ComboBox(FXCollections.observableArrayList(savingAccount));
		} else if (accountFrom.getAccountType().equals("SAVINGS ACCOUNT 84190")) {
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
    	window.showAndWait(); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
		
	}
	
	/**
	 * This method is used to validate the user input for the amount 
	 * to transfer in the text field.
	 */
	public void checkTransfer() {
		
		String transferAmountText = amount.getText();
		boolean validNumericInput = true;
		int decimalCounter = 0;
		
		if (amount.getText().isEmpty()) {
			errorMessage.setText("Please enter an amount to transfer.");
		} 
		for (char c: amount.getText().toCharArray()) {
    		
    		// Check if the character entered for transfer amount is a digit. Allow only one decimal.
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
			
		
	    	
	    	// Check if the number entered by the user is a transfer amount (greater than zero and at most equal to account balance)
	    	// If valid, transfer amount
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
				accountFrom.withdraw(transferAmount);
	        	window.close();
	    	}	
		}
		
    	
    }


}
