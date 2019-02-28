package controllers;
import objects.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class JobController {
	@FXML
	private URL location;
	
	@FXML
	private ResourceBundle resources;
	
	@FXML 
	private TextField phoneNum;
	@FXML 
	private TextField date;
	@FXML 
	private TextField time;
	@FXML 
	private TextField driver;
	@FXML 
	private TextField customer;
	@FXML
	private TextField price;
	
	@FXML 
	private TextArea pickUp;
	
	@FXML 
	private TextArea dropOff;
	
	@FXML
	private TextArea notes;
	
	@FXML
	private Button saveButton;
	
	DatabaseConnection database;
	LocalDateTime ldt;
	Stage primaryStage;
	
	public JobController() {
		
	}
	
	@FXML
	public void initialize(Stage stage, DatabaseConnection db) {
		this.primaryStage = stage;
		this.database = db;
		ldt = LocalDateTime.now();
		String day = DateTimeFormatter.ofPattern("MM/dd/yyy", Locale.ENGLISH).format(ldt);
		String hour = DateTimeFormatter.ofPattern("hh:mm", Locale.ENGLISH).format(ldt);
		date.setText(day);
		time.setText(hour);
	}
	
	@FXML
	public void onSaveButtonClicked() {
		
		
		int jobNum = database.getNumOfJobs() + 1;
		
		String pickU = pickUp.getText();
		
		String dropO = dropOff.getText();
		
		String pNum = phoneNum.getText();
		
		String customerName = customer.getText();
		
		Double p = Double.parseDouble(price.getText());
		
		String day = DateTimeFormatter.ofPattern("MM/dd/yyy", Locale.ENGLISH).format(ldt);
		
		int complete = 0;
		
		int driverNum = Integer.parseInt(driver.getText());
		
		String jobNotes = notes.getText();
		
		
		database.addJob(jobNum, pickU, dropO, pNum, customerName, p, day, complete, driverNum);
		
		
		primaryStage.close();

	}
}
