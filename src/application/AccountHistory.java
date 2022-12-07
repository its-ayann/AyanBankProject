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


public class AccountHistory {
	private Stage window;
	private TableView<Transaction> historyTable;
	
	
	private Account account;
	private Transaction transaction;
	private String name;
	private String accountType;
	private double amount;
	
	AccountHistory() {
		
	}
	
	AccountHistory(TableView<Transaction> aTable, Transaction aTransaction) {
		historyTable = aTable;
		transaction = aTransaction;
	}
	
	public void displayAccountHistory() {
		
		window = new Stage();
		//window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Deposit Window");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		VBox history = new VBox();
		
		VBox table = new VBox();
		historyTable = new TableView<Transaction>();
		
		TableColumn<Transaction, String> nameColumn = new TableColumn<>("Account Name");
		//nameColumn.setMinWidth(150);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Transaction, String> typeColumn = new TableColumn<>("Transaction Type");
		//typeColumn.setMinWidth(150);
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("accountType"));
		
		TableColumn<Transaction, Double> amountColumn = new TableColumn<>("Amount");
		//amountColumn.setMinWidth(150);
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		historyTable = new TableView<>();
		//historyTable.getColumns().addAll(nameColumn,typeColumn,amountColumn);
		//historyTable.setItems(list);
		
	
		table.getChildren().addAll(historyTable);
		history.getChildren().addAll(table);
		
		Scene scene = new Scene(history);
		window.setScene(scene);
		window.showAndWait();
		
		
	}
	

	//ObservableList<Transaction> list = FXCollections.observableArrayList(new Transaction("hey","hi",0)); 
	
	public void addToTable(TableView<Transaction> table, Transaction transaction) {
		table.getItems().add(transaction);
	}
		
	
	

}
