package controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import objects.DatabaseConnection;


public class CloseAppController {
	@FXML
	private Button yesButton;
	@FXML
	private Button noButton;
	Stage primaryStage;
	Stage parentStage;
	DatabaseConnection database;
	static boolean answer;
	
	public CloseAppController() {
		
	}
	
	@FXML
	public boolean initialize(Stage stage) {
		this.primaryStage = stage;
		yesButton.setOnAction(e -> {
			answer = true;
			primaryStage.close();
		});
		
		noButton.setOnAction(e -> {
			answer = false;
			primaryStage.close();
		});
		
		return answer;
		
	}
	
}
