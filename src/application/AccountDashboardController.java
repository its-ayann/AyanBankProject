package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AccountDashboardController {
	Stage applicationStage;
	
	
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

    //@FXML
   // private ChoiceBox<String> accountTypeChoiceBox;

    @FXML
    private Button transferButton;
    
    @FXML
     ComboBox<String> accountTypeComboBox;
    
    
   //private String selectedAccount;
    private String selectedAccount;
    /*
     		System.out.println("SSSSSSS: " + account.getBalance());
    		account.setName("Ayan");
    		account.setAccountNumber(012432);
    		account.setBalance(300);
    		account.setAccountType("Chequing");
    		System.out.println("SSSSSSS: " + account.getBalance());
    		System.out.println(accoutType);
    		account = new Account("Ayan", 84190, 800, "Saving");
    	
     */
   
    Account chequingAccount = new Account("Ayan Ahmed", 123, 300.00, "Chequing");
    Account savingAccount = new Account("John Doe", 84190, 800.00, "Saving");
    
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
    
    
    public String getAccountTypeComboBox() {
    	return accountTypeComboBox.getValue();
    }
    
    public void setAccountTypeComboBox(String accountType) {
    	selectedAccount = accountType;
    }
    //Account account = null;
    Account account = new Account();
    
    boolean chequingSelected = false;
    
    public boolean getChequingSelected() {
    	return chequingSelected;
    }
    
    SelectAccountWindow saw = new SelectAccountWindow();
    
    @FXML
    void accountTypeComboBox (ActionEvent event) {
    	saw.selectAccountDisplay();
    	
    	String accoutType = accountTypeComboBox.getValue();
    	balanceLabel.setText("$" + String.valueOf(account.getBalance()));
    	
    	if (accoutType.equals("CHEQUING ACCOUNT 012432")) {
    		System.out.println(accoutType);
    		chequingSelected = true;
    		
    		//accountTypeComboBox.setValue(Account.selectedAccount);
    		
    		//account = new Account("Ayan", 123, 300);
    		
    		System.out.println("SSSSSSS: " + account.getBalance());
    		account.setName("Ayan");
    		account.setAccountNumber(012432);
    		account.setBalance(300);
    		account.setAccountType("Chequing");
    		System.out.println("SSSSSSS: " + account.getBalance());
    		
    		//balanceLabel.setText("$" + String.valueOf(account.getBalance()));
    		balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
    	
    	} else if (accoutType.equals("SAVINGS ACCOUNT 84190")) {
    		
    		System.out.println(accoutType);
    		account = new Account("Ayan", 84190, 800, "Saving");
    		//balanceLabel.setText("$" + String.valueOf(account.getBalance()));
    		balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
    		
    	} else {
    		balanceLabel.setText("");
    	}
    	
    }
    
    
    @FXML
    void selectAccount (ActionEvent event) {
    	saw.selectAccountDisplay();
    	if (saw.getSelectAccountComboBox() != null) {
    		selectAccountButton.setText(saw.getSelectAccountComboBox());
    		if (saw.getSelectAccountComboBox().equals("CHEQUING ACCOUNT 012432")) {
        		System.out.println(saw.getSelectAccountComboBox());
        		//chequingSelected = true;
        		account = chequingAccount;
        		nameLabel.setText(account.getName());
        		//accountTypeComboBox.setValue(Account.selectedAccount);
        		
        		//account = new Account("Ayan", 123, 300);
        		/*
        		System.out.println("SSSSSSS: " + account.getBalance());
        		account.setName("Ayan");
        		account.setAccountNumber(123);
        		account.setBalance(300);
        		account.setAccountType("Chequing");
        		nameLabel.setText(account.getName());
        		System.out.println("SSSSSSS: " + account.getBalance());
        		*/
        		balanceLabel.setText("$" + String.valueOf(account.getBalance()));
        		System.out.println("is it working: " + account.getBalance());
        		//balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
        	
        	} else if (saw.getSelectAccountComboBox().equals("SAVINGS ACCOUNT 84190")) {
        		account = savingAccount;
        		nameLabel.setText(account.getName());
        		balanceLabel.setText("$" + String.valueOf(account.getBalance()));
        		//balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
        		/*
        		System.out.println(saw.getSelectAccountComboBox());
        		account = new Account("Ayan", 123, 800, "Saving");
        		balanceLabel.setText("$" + String.valueOf(account.getBalance()));
        		*/
        	}
    		
    	}
    	
    	
    	
    }
    public void chequingAccount() {
    	//account = accountTypeComboBox.getsele
    	accountTypeComboBox.getSelectionModel().select(0);
    }
    
    public void returnToDashboard(Button deposit) {
    	try {
			FXMLLoader afterDep = new FXMLLoader();
			
			//VBox root = forgotPasswordLoader.load(new FileInputStream("src/application/ForgotPasswordView.fxml"));
			
			Parent root = afterDep.load(new FileInputStream("src/application/AccountDashboardView.fxml"));
			
			Stage dashboardWindow = (Stage) deposit.getScene().getWindow();
			dashboardWindow.setScene(new Scene(root,600,400));
			
			//Scene forgotPassword = new Scene(root, 600,400);
    		
			//applicationStage.setScene(forgotPassword);
    		//applicationStage.setTitle("Reset Password");
			
			//nextSceneController = forgotPasswordLoader.getController();
			//nextSceneController.setPrimaryStage(primaryStage);
			//nextSceneController.setMyScene(new Scene(root));
			//nextSceneController.setNextController(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void selectedAccountDashboard(Scene mainScene) {
    	applicationStage.setScene(mainScene);
    	
    	
    }
   
 
    //DepositWindow dw = new DepositWindow(account);

    @FXML
    void deposit(ActionEvent event) {
    	
    	if (selectAccountButton.getText().equals("CHEQUING ACCOUNT 012432")) {
    		 DepositWindow dw = new DepositWindow(chequingAccount);
    		 dw.displayDepositWindow();
    		balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
    	} else if (selectAccountButton.getText().equals("SAVINGS ACCOUNT 84190")){
    		DepositWindow dw = new DepositWindow(savingAccount);
    		dw.displayDepositWindow();
    		balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
    	}
    	/*
    	System.out.println("going in " + account.getBalance());
    	dw.displayDepositWindow();
    	balanceLabel.setText("$" + String.valueOf(account.getBalance()));
    	*/
    	//balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
    	
    	//Scene mainScene = depositButton.getScene();
    	
    	//account.deposit(50);
    	/*
    	DepositWindowController deposit = new DepositWindowController();
    	try {
			FXMLLoader depositWindowLoader = new FXMLLoader();
			
			//VBox root = forgotPasswordLoader.load(new FileInputStream("src/application/ForgotPasswordView.fxml"));
			
			Parent root = depositWindowLoader.load(new FileInputStream("src/application/DepositView.fxml"));
			
			Stage window = (Stage) depositButton.getScene().getWindow();
			window.setScene(new Scene(root,600,400));
			
			//Scene forgotPassword = new Scene(root, 600,400);
    		
			//applicationStage.setScene(forgotPassword);
    		//applicationStage.setTitle("Reset Password");
			
			//nextSceneController = forgotPasswordLoader.getController();
			//nextSceneController.setPrimaryStage(primaryStage);
			//nextSceneController.setMyScene(new Scene(root));
			//nextSceneController.setNextController(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/
    	/*
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
    	TextField amount = new TextField();
    	amount.setPrefSize(218, 30);
    	//amount.setPadding(new Insets(10,10,10,0));
    	money.setAlignment(Pos.CENTER);
    	
    	HBox buttons = new HBox();
    	Button deposit1 = new Button("Deposit");
    	deposit1.setPadding(new Insets(10,10,10,10));
    	Button cancel = new Button("Cancel");
    	cancel.setPadding(new Insets(10,10,10,10));
    	buttons.setAlignment(Pos.CENTER_RIGHT);
    	
    	title.getChildren().addAll(depositTitle);
    	money.getChildren().addAll(dollarSign, amount);
    	buttons.getChildren().addAll(deposit1,cancel);
    	
    	depositContainer.getChildren().addAll(title,money,buttons);
    	
    	deposit1.setOnAction(doneEvent -> selectedAccountDashboard(mainScene));
    	
    	Scene depositMenu = new Scene(depositContainer);
    	
    	applicationStage.setScene(depositMenu);
    	*/
    	
    	/*
		Scene scene = new Scene(depositContainer, 400,200);
		Stage window = (Stage) depositButton.getScene().getWindow();
		window.setScene(scene);
		window.setTitle("Deposit Window");
		//applicationStage.setScene(scene);
		//applicationStage.setTitle("Deposit Window");
		 * */
		 
		
		
		
		//deposit1.setOnAction(depositEvent -> account.deposit(Double.parseDouble(amount.getText())));
		/*
    	String amountEntered = amount.getText();
		int decimalCounter = 0;
		boolean validInput = true;
		
		for (char c: amountEntered.toCharArray()) {
    		
    		// Check if the character is a digit
    		//System.out.println(c);
    		if (!Character.isDigit(c) || Character.isWhitespace(c)) {
    			if (c!= '.') {
        			System.out.println("Do not use " + c + " in a project grade. Make sure to enter a number.");
        			validInput = false;
    			} else if (decimalCounter != 0) {
    				System.out.println("Do not use more than one decimal. Please enter a valid number");
    				validInput = false;
    			} else if (c == '.') {
    				decimalCounter = decimalCounter + 1;
    			}
    			
    			
    		}
		}
		
		
		 if (validInput = true) {
 			returnToDashboard(deposit1);
 		}
		*/
		//deposit1.setOnAction(depositEvent -> account.deposit(Double.parseDouble(amountEntered)));
		//Scene dashboard = loginController.getDashboard(deposit1);
		//deposit1.setOnAction(depositEvent -> window.setScene(scene));
		//balanceLabel.setText("$" + String.valueOf(account.getBalance()));
		
			
		
		//balanceLabel.setText("$" + String.valueOf(account.getBalance()));
		
		
	System.out.println("chequing: " + chequingAccount.getBalance());
	System.out.println("dispalyed: " + account.getBalance());
	//System.out.println("saving: " + savingAccount.getBalance());
    }
    
    
    //WithdrawWindow ww = new WithdrawWindow(account);

    @FXML
    void withdraw(ActionEvent event) {
    	
		if (selectAccountButton.getText().equals("CHEQUING ACCOUNT 012432")) {
			WithdrawWindow ww = new WithdrawWindow(chequingAccount);
			ww.displayWithdrawWindow();
			balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
	} else if (selectAccountButton.getText().equals("SAVINGS ACCOUNT 84190")){
		WithdrawWindow ww = new WithdrawWindow(savingAccount);
		ww.displayWithdrawWindow();
		balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
	}
    	/*
    	ww.displayWithdrawWindow();
    	balanceLabel.setText("$" + String.valueOf(account.getBalance()));
    	System.out.println("chequing: " + chequingAccount.getBalance());
    	System.out.println("saving: " + savingAccount.getBalance());
    	*/

    }
    
   // TransferWindow tw = new TransferWindow(account);
    //TransferWindow t = new TransferWindow();
    TransferWindow chequingToSaving = new TransferWindow(savingAccount,chequingAccount);
    TransferWindow savingToChequing = new TransferWindow(chequingAccount,savingAccount);

    @FXML
    void transfer(ActionEvent event) {
    	System.out.println("transfer" + selectAccountButton.getText());
    	if (selectAccountButton.getText().equals("CHEQUING ACCOUNT 012432")) {
    		//TransferWindow t = new TransferWindow(savingAccount,chequingAccount);
    		chequingToSaving.displayTransferWindow();
    		balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
    	} else if (selectAccountButton.getText().equals("SAVINGS ACCOUNT 84190")){
    		//TransferWindow t = new TransferWindow(chequingAccount,savingAccount);
    		savingToChequing.displayTransferWindow();
    		balanceLabel.setText("$" + String.valueOf(savingAccount.getBalance()));
    	}
    	//tw.displayTransferWindow();
    	//t.displayTransferWindow();
    	//balanceLabel.setText("$" + String.valueOf(chequingAccount.getBalance()));
    	System.out.println("chequing: " + chequingAccount.getBalance());
    	System.out.println("saving: " + savingAccount.getBalance());
    }

    @FXML
    void history(ActionEvent event) {

    }

}
