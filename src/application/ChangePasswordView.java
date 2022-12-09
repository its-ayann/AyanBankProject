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


/**
 * When user clicks on the forgot password
 * hyperlink display this window which will allow the user 
 * to change their password or go back to the main log in page
 * @author Ayan Ahmed
 *
 */
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
	
	
	/**
	 * The change password window that is made from JavaFX. When the user 
	 * selects the save button a method will run to verify the new password. 
	 * //Change font in JavaFX found from StackOverflow: https://stackoverflow.com/questions/32624748/javafx-change-font-and-size-in-a-textfield 
	 * code to change font: (Font.font("Franklin Gothic Medium", 30))
	 */
	public void displayChangePasswordWindow() {
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
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
		errorMessage.setFont(Font.font("Franklin Gothic Medium", 12));
		errorMessage.setTextFill(Color.color(1, 0, 0));
    	
    	VBox.setMargin(contents, new Insets(10, 10, 10, 10));
    	
    	HBox buttons = new HBox();
    	
    	Button save = new Button("Save");
    	save.setFont(Font.font("System", 15));
    	
    	Button cancel = new Button("Cancel");
    	save.setFont(Font.font("Franklin Gothic Medium", 15));
    	
    	HBox.setMargin(buttons, new Insets(10, 10, 10, 10));
    	
   
    	save.setOnAction(saveEvent -> changePassword());
    	cancel.setOnAction(cancelEvent -> window.close());
    	
    	
    	contents.getChildren().addAll(title,newPassword,newPasswordTextField,confirmPassword,confirmNewPasswordTextField, errorMessage);
    	buttons.getChildren().addAll(save, cancel);
    	passwordContainer.getChildren().addAll(contents,buttons);
    	
    	Scene scene = new Scene(passwordContainer);
    	window.setScene(scene);
    	window.showAndWait(); //Pop-up box line found from StackOverflow: https://stackoverflow.com/questions/31046945/javafx-stage-modality
	}

	/**
	 * method that will validate the user input from the text field through 3 ways. 
	 * 1. make sure the user entered something in both text fields and not left blank 
	 * 2. make sure both rext fields match each other to confirm the input incase there was a typo
	 * 3. make sure the new password doesn't match the current password
	 */
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
