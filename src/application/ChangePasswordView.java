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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangePasswordView {
	Stage window;
	
	private TextField newPasswordTextField;
	private TextField confirmNewPasswordTextField;
	private Label errorMessage;
	
	private String oldPassword;
	private String newPassword;
	private String confirmNewPassword;
	
	BankApplicationLoginController bac = new BankApplicationLoginController();
	
	ChangePasswordView(String anOldPassword) {
		oldPassword = anOldPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public void displayChangePasswordWindow() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Change Password Window");
		window.setMinHeight(300);
		window.setMinWidth(500);
		
		
		VBox passwordContainer = new VBox();
    	
    	VBox contents = new VBox();
    	
    	Label title = new Label("Change Password");
    	title.setFont(Font.font("Franklin Gothic Medium", 30));
    	title.setAlignment(Pos.TOP_LEFT);
    	
    	Label newPassword = new Label("New Password");
    	newPasswordTextField = new TextField();
    	
    	Label confirmPassword = new Label("Confirm New Password");
    	confirmNewPasswordTextField = new TextField();
    	
    	errorMessage = new Label("");
		//errorMessage.setPadding(new Insets(10,10,10,10));
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
    	
    	VBox.setMargin(contents, new Insets(10, 10, 10, 10));
    	
    	HBox buttons = new HBox();
    	
    	Button save = new Button("Save");
    	save.setFont(Font.font("System", 15));
    	
    	Button cancel = new Button("Cancel");
    	save.setFont(Font.font("Franklin Gothic Medium", 15));//dollarSign.setPadding(new Insets(10,0,10,10));
    	
    	HBox.setMargin(buttons, new Insets(10, 10, 10, 10));
    	
    	
    	
    	
    	save.setOnAction(saveEvent -> changePassword());
    	//deposit.setOnAction(depositEvent -> validDepo(getDepositAmount(amount.getText())));
    	
    	cancel.setOnAction(cancelEvent -> window.close());
    	
    	
    	contents.getChildren().addAll(title,newPassword,newPasswordTextField,confirmPassword,confirmNewPasswordTextField, errorMessage);
    	buttons.getChildren().addAll(save, cancel);
    	
    	passwordContainer.getChildren().addAll(contents,buttons);
    	
    	Scene scene = new Scene(passwordContainer);
    	window.setScene(scene);
    	window.showAndWait();
	}

	public void changePassword() {
		System.out.println(bac.getPassword());
    	if (newPasswordTextField.getText().isEmpty() || confirmNewPasswordTextField.getText().isEmpty()) {
    		errorMessage.setText("One or more of the text fields were left blank. Please enter a password to set.");
    	} 
    	
    	else if (!(newPasswordTextField.getText().equals(confirmNewPasswordTextField.getText()))) {
    		errorMessage.setText("Your password entered in both text fields do not match. Try again.");
    	}
    	
    	else if (newPasswordTextField.getText().equals(bac.getPassword())) {
    		errorMessage.setText("You cannot change your new password to your current password. Try again.");
    	} 
    	
    	else {
    		newPassword = newPasswordTextField.getText();
        	confirmNewPassword = confirmNewPasswordTextField.getText();
        	
        	//System.out.println(bac.getPassword());
        	bac.setPassword(newPassword);
        	oldPassword = newPassword;
        	
        	window.close();
    	}
    	
    	
	}
	

}
