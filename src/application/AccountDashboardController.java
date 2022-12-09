package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class AccountDashboardController {
	
	Stage applicationStage;
	private Stage window;
	
	FXMLLoader dashboard = new FXMLLoader();
	BankApplicationLoginController loginController = dashboard.getController();

    @FXML
    private Button historyButton;

    @FXML
    private Button withdrawButton;

    @FXML
    private Label balanceLabel;

    @FXML
    private Button depositButton;

    @FXML
    private Label nameLabel;
    
    @FXML
    private Button selectAccountButton;
    
    


    @FXML
    private Button transferButton;
 
 
    private String selectedAccount;
   
   
    Account chequingAccount = new Account("Ayan Ahmed", 123, 300.00, "CHEQUING ACCOUNT 012432");
    Account savingAccount = new Account("John Doe", 84190, 800.00, "Saving");
    private double initialBalance;
    private double newAmount;
    private double difference;
    
    private double initialChequingBalance;
    private double initialSavingBalance;
    
    private double newChequingBalance;
    private double newSavingBalance;
    
    private String previous;
    private String previousAmount;
    
    public String getSelectAccountButtonLabel() {
    	if (selectAccountButton.getText() == null) {
    		return null;
    	} else {
    		return selectAccountButton.getText();
    	}
    	
    }
    
    public double getBalance() {
		return account.getBalance();
	}
    
    public void setBalanceLabelText(String balance) {
    	balanceLabel.setText(balance);
    }
 
  
    Account account = new Account();
    

    
    SelectAccountWindow saw = new SelectAccountWindow();
    
    
    
    @FXML
    void selectAccount (ActionEvent event) {
    	saw.selectAccountDisplay();
    	if (saw.getSelectAccountComboBox() != null) {
    		selectAccountButton.setText(saw.getSelectAccountComboBox());
    		if (saw.getSelectAccountComboBox().equals("CHEQUING ACCOUNT 012432")) {
        		System.out.println(saw.getSelectAccountComboBox());
        	
        		initialBalance = account.getBalance();
        		account = chequingAccount;
        		nameLabel.setText(account.getName());
        		
        		balanceLabel.setText("$" + String.valueOf(account.getBalance()));
        		System.out.println("is it working: " + account.getBalance());
        		
        	
        	} else if (saw.getSelectAccountComboBox().equals("SAVINGS ACCOUNT 84190")) {
        		initialBalance = 800.00;
        		account = savingAccount;
        		nameLabel.setText(account.getName());
        		balanceLabel.setText("$" + String.valueOf(account.getBalance()));
        		
        	}
    		
    	}

    }
   
    
    @FXML
    void deposit(ActionEvent event) {
    	
    	if (selectAccountButton.getText().equals("CHEQUING ACCOUNT 012432")) {
    		initialBalance = chequingAccount.getBalance();
    		 DepositWindow dw = new DepositWindow(chequingAccount);
    		 dw.displayDepositWindow();
    		 newAmount = chequingAccount.getBalance();
    		//balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
    		 balanceLabel.setText(String.format("$ %.2f", chequingAccount.getBalance()));
    	} else if (selectAccountButton.getText().equals("SAVINGS ACCOUNT 84190")){
    		initialBalance = savingAccount.getBalance();
    		DepositWindow dw = new DepositWindow(savingAccount);
    		dw.displayDepositWindow();
    		newAmount = savingAccount.getBalance();
    		//balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
    		balanceLabel.setText(String.format("$ %.2f", savingAccount.getBalance()));
    	}
    	
    	
    	
		
		
	System.out.println("chequing: " + chequingAccount.getBalance());
	System.out.println("dispalyed: " + account.getBalance());
    }
    
    
   

    @FXML
    void withdraw(ActionEvent event) {
    	
		if (selectAccountButton.getText().equals("CHEQUING ACCOUNT 012432")) {
			initialBalance = chequingAccount.getBalance();
			WithdrawWindow ww = new WithdrawWindow(chequingAccount);
			ww.displayWithdrawWindow();
			newAmount = chequingAccount.getBalance();
			//difference = initialBalance-newAmount;
			//balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
			balanceLabel.setText(String.format("$ %.2f", chequingAccount.getBalance()));
	} else if (selectAccountButton.getText().equals("SAVINGS ACCOUNT 84190")){
		initialBalance = savingAccount.getBalance();
		WithdrawWindow ww = new WithdrawWindow(savingAccount);
		ww.displayWithdrawWindow();
		newAmount = savingAccount.getBalance();
		//balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
		balanceLabel.setText(String.format("$ %.2f", savingAccount.getBalance()));
	}
    	

    }
    
   
    TransferWindow chequingToSaving = new TransferWindow(savingAccount,chequingAccount);
    TransferWindow savingToChequing = new TransferWindow(chequingAccount,savingAccount);

    @FXML
    void transfer(ActionEvent event) {
    	System.out.println("transfer" + selectAccountButton.getText());
    	if (selectAccountButton.getText().equals("CHEQUING ACCOUNT 012432")) {
    		initialChequingBalance = chequingAccount.getBalance();
    		initialSavingBalance = savingAccount.getBalance();
    		chequingToSaving.displayTransferWindow();
    		newChequingBalance = chequingAccount.getBalance();
    		newSavingBalance = savingAccount.getBalance();
    		//balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
    		balanceLabel.setText(String.format("$ %.2f", chequingAccount.getBalance()));
    	} else if (selectAccountButton.getText().equals("SAVINGS ACCOUNT 84190")){
    		initialSavingBalance = savingAccount.getBalance();
    		initialChequingBalance = chequingAccount.getBalance();
    		savingToChequing.displayTransferWindow();
    		newSavingBalance = savingAccount.getBalance();
    		newChequingBalance = chequingAccount.getBalance();
    		//balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
    		balanceLabel.setText(String.format("$ %.2f", savingAccount.getBalance()));
    	}
    	
    	System.out.println("chequing: " + chequingAccount.getBalance());
    	System.out.println("saving: " + savingAccount.getBalance());
    }

   // DepositWindow dw = new DepositWindow();
    HistoryWindow hw = new HistoryWindow(account.getName());



	
    
    
    @FXML
    void history(ActionEvent event) {
    	
    	System.out.println(initialChequingBalance);
    	System.out.println(newChequingBalance);
    	System.out.println(initialSavingBalance);
    	System.out.println(newSavingBalance);
    	
    	if (initialChequingBalance > newChequingBalance && initialSavingBalance < newSavingBalance) {
    		hw.setRecentName(account.getName());
    		hw.setRecentAccount(account.getAccountType());
    		hw.setRecentType("Transfer to " + savingAccount.getAccountType());
    		previous = "Transfer to " + savingAccount.getAccountType();
        	double amount = initialChequingBalance - newChequingBalance;
        	previousAmount = Double.toString(amount);
        	
        	//hw.setRecentAmount(Double.toString(amount));
        	hw.setRecentAmount(String.format("$ %.2f", amount));
        	//hw.displayHistoryWindow();
    		
    	}
    	
    	else if (initialChequingBalance < newChequingBalance && initialSavingBalance > newSavingBalance) {
    		hw.setRecentName(account.getName());
    		hw.setRecentAccount(account.getAccountType());
    		hw.setRecentType("Transfer to " + chequingAccount.getAccountType());
    		previous = "Transfer to " + chequingAccount.getAccountType();
        	double amount = initialSavingBalance - newSavingBalance;
        	previousAmount = Double.toString(amount);
        	hw.setRecentAmount(String.format("$ %.2f", amount));
        	//hw.setRecentAmount(Double.toString(amount));
        	//hw.displayHistoryWindow();
    		
    	}
    	
    	else if (initialBalance < newAmount) {
    		hw.setRecentName(account.getName());
        	hw.setRecentAccount(account.getAccountType());
        	hw.setRecentType("Deposit");
        	previous = "Deposit";
        	double amount = newAmount-initialBalance;
        	
        	System.out.println(newAmount);
        	System.out.println(initialBalance);
        	
        	previousAmount = Double.toString(amount);
        	
        	//hw.setRecentAmount(Double.toString(amount));
        	hw.setRecentAmount(String.format("$ %.2f", amount));
        	//hw.displayHistoryWindow();
    	} 
    	else if (initialBalance > newAmount) {
    		hw.setRecentName(account.getName());
        	hw.setRecentAccount(account.getAccountType());
        	hw.setRecentType("Withdraw");
        	previous = "Withdraw";
        	double amount = initialBalance-newAmount;
        	System.out.println(difference);
        	previousAmount = Double.toString(amount);
        	hw.setRecentAmount(String.format("$ %.2f", amount));
        	//hw.setRecentAmount(Double.toString(amount));
        	//hw.displayHistoryWindow();
    	}
    	
    	else {
    		previousHistory();
    		
    	}
    	
    	
    	
    	
    	
    	hw.displayHistoryWindow();

    }
    
    void previousHistory() {
    	hw.setRecentName(account.getName());
    	hw.setRecentAccount(account.getAccountType());
    	hw.setRecentType(previous);
    	double amount = initialBalance-newAmount;
    	//System.out.println(difference);
    	previousAmount = Double.toString(amount);
    	hw.setRecentAmount(String.format("$ %.2f", amount));
    	//hw.setRecentAmount(Double.toString(amount));
    }

}
