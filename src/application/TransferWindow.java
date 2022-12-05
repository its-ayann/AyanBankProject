package application;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		Label transferTitle = new Label("Transfer");
		HBox.setMargin(transferTitle, new Insets(10,10,10,10));
		
		VBox contents = new VBox();
		String chequingAccount[] = {"CHEQUING ACCOUNT 012432"};
		String savingAccount[] = {"SAVINGS ACCOUNT 84190"};
		accountToComboBox = new ComboBox();
		accountToComboBox.setPrefSize(330,20);
		accountToComboBox.maxHeight(31);
		accountToComboBox.maxWidth(330);
		//System.out.println("1" + account.getAccountType());
		System.out.println("teest1" + accountFrom.getAccountType());
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
		
		
		transfer.setOnAction(transferEvent -> checkTransfer());
		
		title.getChildren().addAll(transferTitle);
		contents.getChildren().addAll(accountToComboBox,amount);
		buttons.getChildren().addAll(transfer,cancel);
		
		transferContainer.getChildren().addAll(title,contents,buttons);
		
		Scene scene = new Scene(transferContainer);
    	window.setScene(scene);
    	window.showAndWait();
		
	}
	
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
			window.close();
		}
		
	}
	

}
