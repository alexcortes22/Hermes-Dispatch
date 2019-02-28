package controllers;
import objects.*;
import fxml.*;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;

public class MainWindowController{
	@FXML
	private TableView jobTable;
	
	@FXML
	private TableColumn idColumn;
	@FXML
	private TableColumn pickUpColumn;
	@FXML
	private TableColumn dropOffColumn;
	@FXML
	private TableColumn phoneColumn;
	@FXML
	private TableColumn timeColumn;
	@FXML
	private TableColumn driverColumn;
	@FXML
	private TableColumn completedColumn;
	
	@FXML
	private URL location;
	
	@FXML
	private ResourceBundle resources;
	DatabaseConnection db;
	
	public MainWindowController() {
		
	}
	
	
	public void initialize(Stage primaryStage, DatabaseConnection dataBase) {
		this.db = dataBase;
		dataBase.getNumOfJobs();
		System.out.println("Access Allowed.");
		Scene currentScene = primaryStage.getScene();
		
		KeyCombination newJ = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);

		currentScene.getAccelerators().put(newJ, () -> {
				Stage window = new Stage();
				
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JobFXML.fxml"));
					Parent root = (Parent) loader.load();
					JobController jobController = (JobController)loader.getController();
					
					Scene jobScene = new Scene(root, 600, 500);
					window.setScene(jobScene);
					jobController.initialize(window, dataBase);
				}catch(IOException exception) {
					System.out.println("Job Controller FXML file not found.");
				}
				
				window.initModality(Modality.APPLICATION_MODAL);
				window.showAndWait();
				updateTable();
		});
		
		updateTable();
		
		
		primaryStage.setOnCloseRequest(e -> {
			Stage checkWindow = new Stage();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("closeAppFXML.fxml"));
				Parent root = (Parent) loader.load();
				CloseAppController closeApp = (CloseAppController)loader.getController();
				Scene closeAppScene = new Scene(root, 200, 200);
				checkWindow.setScene(closeAppScene);
				boolean answer = closeApp.initialize(checkWindow);
				if(answer == true) {
					e.consume();
					primaryStage.close();	
				}
			}catch(IOException exception) {
				System.out.println("Close Window FXML File not found.");
			}
			checkWindow.initModality(Modality.APPLICATION_MODAL);
			checkWindow.showAndWait();
		});
	}

	public void updateTable() {
		jobTable.setItems(getJobs(db));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("jobNum"));
		pickUpColumn.setCellValueFactory(new PropertyValueFactory<>("pickUp"));
		dropOffColumn.setCellValueFactory(new PropertyValueFactory<>("dropOff"));
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
		completedColumn.setCellValueFactory(new PropertyValueFactory<>("complete"));
		driverColumn.setCellValueFactory(new PropertyValueFactory<>("jobDriver"));
	}
	
	public ObservableList<Job> getJobs(DatabaseConnection dataBase){
		ObservableList<Job> jobs = FXCollections.observableArrayList();
		ResultSet rs = dataBase.showJobs();
		try {
			while(rs.next()) {
				int jobNumber = rs.getInt("jobNum");
				String pickUpAddress = rs.getString("pickUp");
				String dropOffAddress = rs.getString("dropOff");
				String phoneNumber = rs.getString("phoneNum");
				String customerName = rs.getString("customer");
				double price = rs.getDouble("price");
				String time = rs.getString("time");
				Boolean complete = rs.getBoolean("complete");
				int driver = rs.getInt("driver");
				
				Job newJob = new Job(jobNumber, pickUpAddress, dropOffAddress, phoneNumber,
									customerName, price, time, complete, driver);
				jobs.add(newJob);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jobs;
	}
}
