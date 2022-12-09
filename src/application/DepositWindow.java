package application;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

/**
 * When user clicks on the deposit button from the dash board window
 * display this window which will prompt the user with the amount 
 * the user wants to deposit. Has the option to exit the window.
 * @author Ayan Ahmed
 *
 */
public class DepositWindow {
	private Stage window;
	
	private TextField amount;
	private Label errorMessage;
	private Account account;
	

	
	DepositWindow() {
		
	}
	
	DepositWindow(Account anAccount) {
		account = anAccount;
	}
	
	/**
	 * method that displays the deposit window built through JavaFX.
	 * When the user clicks on the deposit button on this page, 
	 * the value entered in the text field is checked if valid.
	 * //Change font in JavaFX found from StackOverflow: https://stackoverflow.com/questions/32624748/javafx-change-font-and-size-in-a-textfield 
	 * code to change font: (Font.font("Franklin Gothic Medium", 30))
	 */
	public void displayDepositWindow() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
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
    	cancel.setOnAction(cancelEvent -> window.close());

    	title.getChildren().addAll(depositTitle);
    	money.getChildren().addAll(dollarSign, amount);
    	message.getChildren().addAll(errorMessage);
    	buttons.getChildren().addAll(deposit,cancel);
    	
    	depositContainer.getChildren().addAll(title,money,message,buttons);
    	
    	Scene scene = new Scene(depositContainer);
    	window.setScene(scene);
    	window.showAndWait(); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
	}
    
	/**
	 * Check if value entered in deposit text field is a valid number. Shows 
	 * a error message for the respective error in the text field. 
	 */
	public void checkDeposit() {
		String depositAmountText = amount.getText();
		
		boolean validNumericInput = true;
		int decimalCounter = 0;
		
		if (amount.getText().isEmpty()) {
			validNumericInput = false;
			errorMessage.setText("Please enter a amount in the text field to deposit.");
		}
		for (char c: amount.getText().toCharArray()) {
    		
    		// Check if the character entered for input is a digit. Allow only one decimal
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
			boolean validDepositAmount = true;
			double depositAmount = Double.parseDouble(depositAmountText);
			
	    	
	    	// Check if the number entered by the user is a greater than zero (valid deposit amount)
	    	// If valid, deposit amount
	    	if (depositAmount <= 0) {
	    		validDepositAmount = false;
	    		errorMessage.setText("Enter a deposit value above $0.00. ");
	    		depositAmount = 0;
	    	} 
	    	else if (validDepositAmount = true && depositAmount > 0) {
	    		account.deposit(depositAmount);
	    		window.close();
	    		//System.out.print("set name label to: " + account.getName());
	    		
	    	}	
		}
    	
    }
	
	
}
	
	
	
    


