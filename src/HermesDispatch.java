//importing all local files
import fxml.*;
import controllers.*;
import objects.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HermesDispatch extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml\\LoginFXML.fxml"));
        primaryStage.setTitle("Hermes Dispatch");
        primaryStage.setScene(new Scene(root, 700,600));
        primaryStage.show();
    }


}

