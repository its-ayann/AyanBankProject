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

public class WithdrawWindow {
	private Stage window;
	
	TextField amount;
	Label errorMessage;
	Account account;
	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("src/application/AccountDashboardView.fxml"));
	//AccountDashboardController acd = loader.getController();
	
	//Account account = new Account();
	AccountDashboardController acd = loader.getController();
	
	
	WithdrawWindow(Account anAccount) {
		account = anAccount;
	}
	
	public void displayWithdrawWindow() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
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
    	window.showAndWait();
	}
    
	
	public void checkWithdraw() {
		
		String withdrawAmountText = amount.getText();
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
		
		if (validNumericInput = true) {
			boolean validWithdrawAmount = true;
			double withdrawAmount = Double.parseDouble(withdrawAmountText);
			
		
	    	
	    	// Check if the number entered by the user is a valid percentage grade
	    	// If valid, include it in the grade computation
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
	    		account.withdraw1(withdrawAmount);
	        	window.close();
	    	}	
		}
		
		
    	
	}


}
	
	
	
	
	
	
    
    	







