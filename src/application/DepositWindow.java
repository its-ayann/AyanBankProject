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
	
	TextField amount;
	Label errorMessage;
	Account account;
	
	
	
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
    	depositTitle.setPadding(new Insets(10,10,10,10));
    	title.setAlignment(Pos.TOP_LEFT);
    	
    	HBox money = new HBox();
    	Label dollarSign = new Label("$");
    	dollarSign.setFont(Font.font("Franklin Gothic Medium", 15));
    	dollarSign.setPadding(new Insets(10,0,10,10));
    	amount = new TextField();
    	amount.setPrefSize(218, 30);
    	//amount.setPadding(new Insets(10,10,10,0));
    	money.setAlignment(Pos.CENTER);
    	
    	HBox message = new HBox();
    	errorMessage = new Label("");
		errorMessage.setPadding(new Insets(10,10,10,10));
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
    	
    	
    	HBox buttons = new HBox();
    	Button deposit = new Button("Deposit");
    	deposit.setPadding(new Insets(10,10,10,10));
    	Button cancel = new Button("Cancel");
    	cancel.setPadding(new Insets(10,10,10,10));
    	buttons.setAlignment(Pos.CENTER_RIGHT);
    	
    	
    	deposit.setOnAction(depositEvent -> checkDeposit());
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
    
	
	
	public void checkDeposit() {
		if (amount.getText().isEmpty()) {
			errorMessage.setText("Please enter an amount to deposit.");
		} 
		
		double depositAmount = Double.parseDouble(amount.getText());
		
		System.out.println("WWWWWWWW" + account.getBalance());
		
		
		if (depositAmount < 0){
			errorMessage.setText("Please enteer a valid amount to deposit");
			
		} else {
			account.deposit(depositAmount);
			window.close();
		}
		
	}
    

}
