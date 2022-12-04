package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SelectAccountWindow {
	
	private Stage window;
	private ComboBox selectAccountComboBox;
	private Label errorMessage;
	
	
	public String getSelectAccountComboBox() {
		if (selectAccountComboBox.getSelectionModel().getSelectedItem() != null) {
			return selectAccountComboBox.getSelectionModel().getSelectedItem().toString();
		}
		else {
			return null;
		}
	}
	
	public void selectAccountDisplay() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Select Account");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		
		VBox main = new VBox();
		
		VBox contents = new VBox();
		Label message = new Label("Select Account");
		message.setFont(Font.font("Franklin Gothic Medium", 30));
		message.setPadding(new Insets(10,10,10,10));
		message.setAlignment(Pos.TOP_LEFT);
		
		String accounts[] = {"CHEQUING ACCOUNT 012432", "SAVINGS ACCOUNT 84190"};
		selectAccountComboBox = new ComboBox(FXCollections.observableArrayList(accounts));
		selectAccountComboBox.setPadding(new Insets(10,10,10,10));
		selectAccountComboBox.setPrefSize(218,30);
		//selectAccountComboBox.getItems().addAll("CHEQUING ACCOUNT 012432", "SAVINGS ACCOUNT 84190");
		selectAccountComboBox.setPromptText("Select Account");
		selectAccountComboBox.maxHeight(31);
		selectAccountComboBox.maxWidth(330);
		
		errorMessage = new Label("");
		errorMessage.setPadding(new Insets(10,10,10,10));
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
		
		HBox buttons = new HBox();
		Button select = new Button("Select");
		select.setPadding(new Insets(10,10,10,10));
		Button cancel = new Button("Cancel");
		cancel.setPadding(new Insets(10,10,10,10));
		buttons.setAlignment(Pos.CENTER_RIGHT);
		cancel.setOnAction(e -> window.close());
		
	
			
		

		
		select.setOnAction(e -> checkInput());
		
		
		contents.getChildren().addAll(message, selectAccountComboBox, errorMessage);
		buttons.getChildren().addAll(select, cancel);
		
		main.getChildren().addAll(contents,buttons);
		
		Scene scene = new Scene(main);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	public void checkInput() {
		if (selectAccountComboBox.getSelectionModel().getSelectedItem() == null) {
			errorMessage.setText("Please enter an account to continue.");
			
		} else {
			window.close();
		}
		
	}
	

	
}
