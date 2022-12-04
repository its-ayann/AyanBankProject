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
    	withdrawTitle.setPadding(new Insets(10,10,10,10));
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
    	Button withdraw = new Button("Withdraw");
    	withdraw.setPadding(new Insets(10,10,10,10));
    	Button cancel = new Button("Cancel");
    	cancel.setPadding(new Insets(10,10,10,10));
    	buttons.setAlignment(Pos.CENTER_RIGHT);
    	
    	//withdraw.setOnAction(withdrawEvent -> account.withdraw1(Double.parseDouble(amount.getText())));
    	withdraw.setOnAction(withdrawEvent -> checkWithdraw());
    	//deposit1.setOnAction(depositEvent -> account.deposit(Double.parseDouble(amount.getText())));
    	
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
		if (amount.getText().isEmpty()) {
			errorMessage.setText("Please enter an amount to withdraw.");
		} 
		
		double withdrawAmount = Double.parseDouble(amount.getText());
		
		System.out.println("WWWWWWWW" + account.getBalance());
		
		
		if (withdrawAmount > account.getBalance()){
			errorMessage.setText("You cannot withdraw more than your balance. ");
			
		} else {
			account.withdraw1(withdrawAmount);
			
			window.close();
		}
		
	}
    
    	

	}


