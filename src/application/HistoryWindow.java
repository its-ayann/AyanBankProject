package application;

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
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * When user clicks on the history button
 * display this window which will allow the user 
 * view the most recent transaction including 
 * the name under the account, the account type, the type 
 * of transaction and the amount.
 * @author Ayan Ahmed
 *
 */
public class HistoryWindow {
	private Stage window;
	
	
	Label recentName = new Label("");
	Label recentAccount = new Label("");
	Label recentType = new Label("");
	Label recentAmount = new Label("");
	

	
	
	public Label getRecentName() {
		return recentName;
	}
	
	public Label getRecentAccount() {
		return recentAccount;
	}
	
	public Label getRecentType() {
		return recentType;
	}
	
	public Label getRecentAmount() {
		return recentAmount;
	}
	
	
	public void setRecentType(String aRecentType) {
		recentType.setText(aRecentType);
	}
	
	public void setType(String aType) {
		recentType.setText(aType);
	}
	
	public void setRecentAccount(String aRecentAccount) {
		recentAccount.setText(aRecentAccount);
	}
	
	public void setRecentAmount(String aRecentAmount) {
		recentAmount.setText(aRecentAmount);
	}
	
	HistoryWindow(String aRecentName) {
		recentName.setText(aRecentName);
	}
	
	
	
	HistoryWindow() {
		
	}
	
	public void setRecentName(String aRecentName) {
		recentName.setText(aRecentName);
	}
	
	/**
	 * The history window displayed when the user clicks the history button
	 * on the account dashboard window. The window was made with JavaFX. 
	 */
	public void displayHistoryWindow() {
		
	
		window = new Stage();
		window.setTitle("History Window");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		
		
		VBox main = new VBox();
		
		HBox title = new HBox();
    	Label historyTitle = new Label("Account History");
    	historyTitle.setFont(Font.font("Franklin Gothic Medium", 30));
    	title.setAlignment(Pos.TOP_LEFT);
    	HBox.setMargin(historyTitle, new Insets(10, 10, 10, 10));
		
    	
    	HBox headers = new HBox();
    	
    	Label name = new Label("Name ");
    	name.setFont(Font.font("Arial",FontWeight.BOLD, 12));
    	name.setUnderline(true);
    	name.setPadding(new Insets(0,50,0,0));
    	
    	Label account = new Label(" Account ");
    	account.setFont(Font.font("Arial",FontWeight.BOLD, 12));
    	account.setUnderline(true);
    	account.setPadding(new Insets(0,50,50,0));
    	
    	Label type = new Label(" Type ");
    	type.setFont(Font.font("Arial",FontWeight.BOLD, 12));
    	type.setUnderline(true);
    	type.setPadding(new Insets(0,50,0,0));
    	
    	Label amount = new Label(" Amount");
		amount.setFont(Font.font("Arial",FontWeight.BOLD,12));
		amount.setUnderline(true);
		amount.setPadding(new Insets(0,50,0,0));
    	
    	headers.setAlignment(Pos.TOP_CENTER);
    	HBox.setMargin(headers, new Insets(10, 10, 10, 10));
    	
    	
    	
    	HBox recentHistory = new HBox();
    	
    	recentName.setFont(Font.font("Arial", 12));
    	recentName.setPadding(new Insets(0,0,0,50));
    	
    	recentAccount.setFont(Font.font("Arial", 9));
    	recentAccount.setPadding(new Insets(0,0,0,50));

    	recentType.setFont(Font.font("Arial", 12));
    	recentType.setPadding(new Insets(0,0,0,50));
    	
    	recentAmount.setFont(Font.font("Arial", 12));
    	recentAmount.setPadding(new Insets(0,0,0,50));
    	
    	recentHistory.setAlignment(Pos.TOP_CENTER);
		HBox.setMargin(recentHistory, new Insets(10, 10, 10, 10));
    	
    	
    	HBox buttons = new HBox();
    	Button cancel = new Button("Back");
    	buttons.setAlignment(Pos.CENTER_RIGHT);
    	
    	HBox.setMargin(buttons, new Insets(10, 10, 10, 10));
    	
    	cancel.setOnAction(cancelEvent -> window.close());
    	
    	
    	title.getChildren().addAll(historyTitle);
    	headers.getChildren().addAll(name,account,type,amount);
    	recentHistory.getChildren().addAll(recentName, recentAccount,recentType,recentAmount);
    	buttons.getChildren().addAll(cancel);
    	
    	main.getChildren().addAll(title,headers,recentHistory,buttons);
    	
    	
    	Scene scene = new Scene(main);
    	window.setScene(scene);
    	window.showAndWait();
    	
	}


}



















































