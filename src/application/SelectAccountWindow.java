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

/**
 * When the user clicks on the button select account
 * from the account dashboard this window will pop-up.
 * It will ask to choose account from the options given.
 * @author Ayan Ahmed
 *
 */
public class SelectAccountWindow {
	
	private Stage window;
	private ComboBox selectAccountComboBox;
	private Label errorMessage;
	
	
	public String getSelectAccountComboBox() {
		if (selectAccountComboBox.getSelectionModel().getSelectedItem() != null) {
			return selectAccountComboBox.getSelectionModel().getSelectedItem().toString(); //to find the selected choice in combobox I used StackOverflow: https://stackoverflow.com/questions/32329547/return-the-choice-of-a-combobox-javafx
		}
		else {
			return null;
		}
	}
	
	/**
	 * When the user clicks on the button from the account dashboard to select an account
	 * this method will display the window. The window was made with JavaFX.
	 * //Change font in JavaFX found from StackOverflow: https://stackoverflow.com/questions/32624748/javafx-change-font-and-size-in-a-textfield 
	 * code to change font: (Font.font("Franklin Gothic Medium", 30))
	 */
	public void selectAccountDisplay() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
		window.setTitle("Select Account");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		
		VBox main = new VBox();
		
		VBox contents = new VBox();
		Label message = new Label("Select Account");
		message.setFont(Font.font("Franklin Gothic Medium", 30));
		//message.setPadding(new Insets(10,10,10,10));
		message.setAlignment(Pos.TOP_LEFT);
		HBox.setMargin(message, new Insets(10, 10, 10, 10));
		
		String accounts[] = {"CHEQUING ACCOUNT 012432", "SAVINGS ACCOUNT 84190"};
		selectAccountComboBox = new ComboBox(FXCollections.observableArrayList(accounts)); //to fill a combox with choices I used StackedOverflow: https://stackoverflow.com/questions/23067256/populate-choicebox-defined-in-fxml
		//selectAccountComboBox.setPadding(new Insets(10,10,10,10));
		selectAccountComboBox.setPrefSize(330,20);
		//selectAccountComboBox.getItems().addAll("CHEQUING ACCOUNT 012432", "SAVINGS ACCOUNT 84190");
		selectAccountComboBox.setPromptText("Select Account");
		selectAccountComboBox.maxHeight(31);
		selectAccountComboBox.maxWidth(330);
		
		errorMessage = new Label("");
		//errorMessage.setPadding(new Insets(10,10,10,10));
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
		
		HBox.setMargin(selectAccountComboBox, new Insets(10, 10, 10, 10));
		HBox.setMargin(errorMessage, new Insets(10, 10, 10, 10));
		
		HBox buttons = new HBox();
		Button select = new Button("Select");
		//select.setPadding(new Insets(10,10,10,10));
		Button cancel = new Button("Cancel");
		//cancel.setPadding(new Insets(10,10,10,10));
		buttons.setAlignment(Pos.CENTER_RIGHT);
		HBox.setMargin(select, new Insets(10, 10, 10, 10));
		HBox.setMargin(cancel, new Insets(10, 10, 10, 10));
		
		
		cancel.setOnAction(e -> window.close());
		select.setOnAction(e -> checkInput());
		
		
		contents.getChildren().addAll(message, selectAccountComboBox, errorMessage);
		buttons.getChildren().addAll(select, cancel);
		
		main.getChildren().addAll(contents,buttons);
		
		Scene scene = new Scene(main);
		window.setScene(scene);
		window.showAndWait(); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
	}
	
	
	/**
	 * This method will make sure that the user selects an account from the window. If no 
	 * account is selected a message will be displayed.
	 */
	public void checkInput() {
		if (selectAccountComboBox.getSelectionModel().getSelectedItem() == null) { //to find the selected choice in combobox I used StackOverflow: https://stackoverflow.com/questions/32329547/return-the-choice-of-a-combobox-javafx
			errorMessage.setText("Please enter an account to continue.");
			
		} else {
			window.close();
		}
		
	}
	

	
}
