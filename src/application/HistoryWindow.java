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

public class HistoryWindow {
	private Stage window;
	
	
	Label recentName = new Label("old");
	Label recentAccount = new Label(" ");
	Label recentType = new Label("test ");
	Label recentAmount = new Label(" ");
	

	
	
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
	
public void displayHistoryWindow() {
		
	
		window = new Stage();
		//window.initModality(Modality.APPLICATION_MODAL);
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
    	type.setPadding(new Insets(0,50,50,0));
    	
    	Label amount = new Label(" Amount");
		amount.setFont(Font.font("Arial",FontWeight.BOLD,12));
		amount.setUnderline(true);
		amount.setPadding(new Insets(0,0,0,50));
    	
    	headers.setAlignment(Pos.TOP_CENTER);
    	HBox.setMargin(headers, new Insets(10, 10, 10, 10));
    	
    	
    	
    	HBox recentHistory = new HBox();
    	
    	//Label recentName = new Label(" ");
    	
    	System.out.println(recentName.getText() + "s");
    	
    	//recentName.setText(recentName.getText());
    	recentName.setFont(Font.font("Arial", 12));
    	name.setPadding(new Insets(0,50,0,0));
    	//recentName.setFont(Font.font("Franklin Gothic Medium", 15));
    	
    	//Label recentAccount = new Label(" ");
    	recentName.setFont(Font.font("Arial", 12));
    	name.setPadding(new Insets(0,50,50,0));
    	//recentAccount.setFont(Font.font("Franklin Gothic Medium", 30));
    	
    	//Label recentType = new Label(" ");
    	recentName.setFont(Font.font("Arial", 12));
    	name.setPadding(new Insets(0,50,50,0));
    	//recentType.setFont(Font.font("Franklin Gothic Medium", 30));
    	
    	//Label recentAmount = new Label(" ");
    	recentName.setFont(Font.font("Arial", 12));
    	name.setPadding(new Insets(0,0,0,50));
    	//recentAmount.setFont(Font.font("Franklin Gothic Medium", 30));
    	
		HBox.setMargin(recentHistory, new Insets(10, 10, 10, 10));
    	
    	
    	HBox buttons = new HBox();
    	Button cancel = new Button("Back");
    	buttons.setAlignment(Pos.CENTER_RIGHT);
    	HBox.setMargin(cancel, new Insets(10, 10, 10, 10));
    	
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



	public void updateName(String t) {
		recentName.setText(t);
	}

}
