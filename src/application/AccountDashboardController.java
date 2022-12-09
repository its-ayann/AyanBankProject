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


/**
 * When user interacts with the Account Dashboard window, 
 * AccountDashboardController consists of methods and controls
 * that will give what the user wants from their input.
 * @author Ayan Ahmed
 *
 */

public class AccountDashboardController {
	
	Stage applicationStage;
	private Stage window;
	
	//FXMLLoader dashboard = new FXMLLoader();
	//BankApplicationLoginController loginController = dashboard.getController();

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
 
 
    //private String selectedAccount;
   
   
    Account chequingAccount = new Account("Ayan Ahmed", 123, 300.00, "CHEQUING ACCOUNT 012432");
    Account savingAccount = new Account("John Doe", 84190, 800.00, "SAVINGS ACCOUNT 84190");
   
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
    
    
    
    /**
     * When user clicks the button to select an account, 
     * a pop-up window is brought up. Depending on the
     * account they choose a different name and 
     * balance will be shown on the dash board.
     * @param event show pop-up window when button is clicked.
     */
    
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
    
    
   /**
    * When deposit button is clicked a deposit window is prompted.
    * @param event display deposit window when button is clicked. 
    */
    
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
    
    
   
    /**
     * When withdraw button is clicked a withdraw window is prompted.
     * @param event display withdraw window when button is clicked. 
     */

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

    /**
     * When transfer button is clicked a transfer window is prompted.
     * Depending on the selected account, the option to transfer to
     * the other account will show. 
     * @param event display transfer window when button is clicked. 
     */
    
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

    
    
 
    HistoryWindow hw = new HistoryWindow(account.getName());
    
    
    /**
     * When history button is clicked, display
     * there previous most recent transaction
     * by name on account, account type, type
     * of transaction, and the amount.
     * @param event display history window when button is clicked.
     */
    @FXML
    void history(ActionEvent event) {
    	
    	System.out.println(initialChequingBalance);
    	System.out.println(newChequingBalance);
    	System.out.println(initialSavingBalance);
    	System.out.println(newSavingBalance);
    	
    	// Transfer from chequing account to saving account
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
    	
    	// transfer from saving account to chequing account
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
    	
    	//deposit 
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
    	//withdraw
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
    
    /**
     * Used to store the previous transaction 
     * and display until another transaction is made.
     */
    
    public void previousHistory() {
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
