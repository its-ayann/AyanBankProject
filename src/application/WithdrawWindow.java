package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.Scene;

/**
 * When the user clicks the withdraw button from the 
 * account dashboard this window will appear. The window was 
 * made with JavaFX.
 * 
 * @author Ayan Ahmed
 *
 */
public class WithdrawWindow {
	private Stage window;
	
	TextField amount;
	Label errorMessage;
	Account account;

	WithdrawWindow(Account anAccount) {
		account = anAccount;
	}
	
	/**
	 * This method displays the withdraw button. It includes the title
	 * for the window, as well as a text field to specify the amount
	 * to withdraw.
	 * //Change font in JavaFX found from StackOverflow: https://stackoverflow.com/questions/32624748/javafx-change-font-and-size-in-a-textfield 
	 * code to change font: (Font.font("Franklin Gothic Medium", 30))
	 */
	public void displayWithdrawWindow() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
		window.setTitle("Withdraw Window");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		
		VBox withdrawContainer = new VBox();
    	
    	HBox title = new HBox();
    	Label withdrawTitle = new Label("Withdraw Amount");
    	withdrawTitle.setFont(Font.font("Franklin Gothic Medium", 30));
    	title.setAlignment(Pos.TOP_LEFT);
    	HBox.setMargin(withdrawTitle, new Insets(10, 10, 10, 10));
    	
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
    	errorMessage = new Label("");
		//errorMessage.setPadding(new Insets(10,10,10,10));
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
		HBox.setMargin(errorMessage, new Insets(10, 10, 10, 10));
    	
    	
    	HBox buttons = new HBox();
    	Button withdraw = new Button("Withdraw");
    	Button cancel = new Button("Cancel");
    	buttons.setAlignment(Pos.CENTER_RIGHT);
    	HBox.setMargin(withdraw, new Insets(10, 10, 10, 10));
    	HBox.setMargin(cancel, new Insets(10, 10, 10, 10));
    	
   
    	withdraw.setOnAction(withdrawEvent -> checkWithdraw());
    	cancel.setOnAction(cancelEvent -> window.close());
    	
    	
    	title.getChildren().addAll(withdrawTitle);
    	money.getChildren().addAll(dollarSign, amount);
    	message.getChildren().addAll(errorMessage);
    	buttons.getChildren().addAll(withdraw,cancel);
    	
    	withdrawContainer.getChildren().addAll(title,money,message,buttons);
    	
    	Scene scene = new Scene(withdrawContainer);
    	window.setScene(scene);
    	window.showAndWait(); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
	}
    
	/**
	 * This method is used to validate the user input, 
	 * and display an error message depending on 
	 * the input error.
	 */
	public void checkWithdraw() {
		
		String withdrawAmountText = amount.getText();
		boolean validNumericInput = true;
		int decimalCounter = 0;
		
		for (char c: amount.getText().toCharArray()) {
    		
    		// Check if the character entered for withdraw is a digit
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
			boolean validWithdrawAmount = true;
			double withdrawAmount = Double.parseDouble(withdrawAmountText);
			
		
	    	
	    	// Check if the number entered by the user is a valid withdraw amount (greater than 0 and less than account balance)
	    	// If valid, withdraw amount from account balance.
	    	if (withdrawAmount <= 0) {
	    		validWithdrawAmount = false;
	    		errorMessage.setText("Enter a deposit value above $0.00. ");
	    		withdrawAmount = 0;
	    	} 
	    	
	    	else if (withdrawAmount > account.getBalance()) {
	    		validWithdrawAmount = false;
	    		errorMessage.setText("Insufficient Funds. Cannot withdraw more than current balance.");
	    		withdrawAmount = 0;
	    	}
	    	else if (validWithdrawAmount = true) {
	    		account.withdraw(withdrawAmount);
	        	window.close();
	    	}	
		}
		
		
    	
	}


}
	
	
	
	
	
	
    
    	







