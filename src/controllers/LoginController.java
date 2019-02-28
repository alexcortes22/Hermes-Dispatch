package controllers;
import objects.*;
import fxml.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.fxml.*;


public class LoginController{
	@FXML
	private Label error;
	
	@FXML
	private TextField userIn;
	
	@FXML 
	private TextField passIn;
	
	@FXML
	private URL location;
	
	@FXML
	private ResourceBundle resources;
	
	DatabaseConnection database;
	
	//No args constructor
	public LoginController() {
		
	}
	@FXML
	public void initialize() {
		System.out.println("Waiting for validation......");
		database = new DatabaseConnection();
		database.startDB();
	}

	public void onButtonClicked(ActionEvent event) throws IOException {
		//Getting window and scene
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainFXML.fxml"));
		Parent root = (Parent) loader.load();
		MainWindowController controller = (MainWindowController)loader.getController();
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		
		Scene mainPage = new Scene(root, 700, 600);
		
		
		String username = userIn.getText();
		String password = passIn.getText();
		boolean access = database.searchDB(username, password);
		if(access == false) {
			error.setVisible(true);
		}else {
			stage.setScene(mainPage);
			controller.initialize(stage, database);
			stage.show();
		}
	}
}