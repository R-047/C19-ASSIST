package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class popupStage {
	popupStage(){
		
		Stage popstage = new Stage();
		
		Button closeButton = new Button();
        closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
        closeButton.setLayoutX(10);
		closeButton.setLayoutY(10);
		closeButton.setOnAction(e -> {
			popstage.close();
			MainScreen.root.setEffect(null);
		});
		
		Button newPatientButton = new Button("new patient");
        newPatientButton.setStyle("-fx-background-color: #7ADBA2; -fx-background-radius: 25px; -fx-text-fill: #ffffff; -fx-font-size: 16pt; -fx-font-family: \"raleway\";");
        newPatientButton.setPrefHeight(36);
        newPatientButton.setPrefWidth(224);
        newPatientButton.setLayoutX(95);
        newPatientButton.setLayoutY(99);
        newPatientButton.setOnAction(e -> {
        	
			popstage.close();
			MainScreen.mainstage.hide();
        	new EnterScreen();
        	
        });
        
        Button viewPatientButton = new Button("View Patients");
        viewPatientButton.setStyle("-fx-background-color: #7ADBA2; -fx-background-radius: 25px; -fx-text-fill: #ffffff; -fx-font-size: 16pt; -fx-font-family: \"raleway\";");
        viewPatientButton.setPrefHeight(36);
        viewPatientButton.setPrefWidth(224);
        viewPatientButton.setLayoutX(95);
        viewPatientButton.setLayoutY(180);
        viewPatientButton.setOnAction(e -> {
        	//primaryStage.close();
			popstage.close();
			MainScreen.mainstage.hide();
        	new PatientsListScreen();
        	
        });
		
		Pane root = new Pane();
		root.getChildren().addAll(closeButton, newPatientButton, viewPatientButton);
		root.setId("ROOTNODE");
		
		Scene scene = new Scene(root, 413, 336);
		scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("/application/styles.css");
	    
		popstage.initStyle(StageStyle.TRANSPARENT);
		popstage.setScene(scene);
		popstage.show();
	}
}
