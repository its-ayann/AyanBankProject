package application;

import javafx.scene.layout.VBox;
//import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AccountHistoryWindow {
	private Stage window;
	private TableView<Account> historyTable;
	private ObservableList<Account> a = FXCollections.observableArrayList();
	
	private Account account;
	private String name;
	private String accountType;
	private double amount;
	
	
	private TableColumn <Account, String> typeName;
	private TableColumn <Account, String> typeAccount;
	private TableColumn <Account, String> typeTransaction;
	private TableColumn <Account, String> typeAmount;
	private TableView<Account> tableView;
	
	public TableView<Account> getTable() {
		return tableView;
	}
	
	
	
	public ObservableList<Account> getA() {
		return a;
	}
	
	AccountHistoryWindow() {
		
	}
	AccountHistoryWindow(Account anAccount) {
		account = anAccount;
	}
	
	public void displayAccountHistory() {
		
		window = new Stage();
		//window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Deposit Window");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		VBox history = new VBox();
		
		VBox table = new VBox();
		historyTable = new TableView<Account>();
		
		TableColumn<Account, String> name = new TableColumn<>("Account Name");
		name.setMinWidth(150);
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Account, String> type = new TableColumn<>("Transaction Type");
		type.setMinWidth(150);
		type.setCellValueFactory(new PropertyValueFactory<>("accountType"));
		
		TableColumn<Account, Double> amount = new TableColumn<>("Amount");
		type.setMinWidth(150);
		type.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		historyTable = new TableView<>();
		historyTable.setItems(getAccount(account));
		historyTable.getColumns().addAll(name,type,amount);
		
		//historyTable.setItems(getHistory());
		//historyTable.getColumns().addAll(name,type,amount);
		
		
		
		//historyTable.setItems(getInfo());
		//historyTable.getColumns().addAll(name,type,amount);
		
		
		//a.getColumns().addAll(name,type,amount);
		
		
		//table.getChildren().addAll(historyTable);
		table.getChildren().addAll(historyTable);
		history.getChildren().addAll(table);
		
		Scene scene = new Scene(history);
		window.setScene(scene);
		window.show();
		
		
	}
	
	public void addInfoToTable(String aName, String anAccountType, double anAmount) {
		name = aName;
		accountType = anAccountType;
		amount = anAmount;
		Account transaction = new Account(name, accountType, amount);
		a = historyTable.getItems();
		a.add(transaction);
		historyTable.setItems(a);
		
	}
	
	
	public Account test(String aName, String anAccountType, double anAmount) {
		name = aName;
		accountType = anAccountType;
		amount = anAmount;
		Account transaction = new Account(name, accountType, amount);
		//a = historyTable.getItems();
		//a.add(transaction);
		//historyTable.setItems(a);
		return transaction;
		
	}
	
	public ObservableList<Account> getInfo() {
		return a;
	}
	
	public ObservableList<Account> getAccount(Account account) {
		ObservableList<Account> accounts = FXCollections.observableArrayList();
		accounts.add(account);
		return accounts;
	}
	
	
	public ObservableList<Account> getHistory() {
		ObservableList<Account> history = FXCollections.observableArrayList();
		history.add(new Account());
		return history;
	}

}
