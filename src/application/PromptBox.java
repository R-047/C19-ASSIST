package application;

import backend.linkedList;
import backend.report;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PromptBox {
	PromptBox(){
		Stage promptPopup = new Stage();
		
		Button closeButton = new Button();
        closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
        closeButton.setLayoutX(10);
        closeButton.setLayoutY(10);
		closeButton.setOnAction(e -> {
			MainScreen.root.setEffect(null);
			promptPopup.close();
		});
		
		Label pidboxinstruction = new Label("enter the pid of the patient");
		pidboxinstruction.setStyle("-fx-text-fill: #A5B4B1;");
		pidboxinstruction.setFont(new Font("Arial", 18));
		pidboxinstruction.setLayoutX(113);
		pidboxinstruction.setLayoutY(54);
		pidboxinstruction.setVisible(true);
		
		TextField pidtextbox = new TextField();
		pidtextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		pidtextbox.setPrefColumnCount(25);
		pidtextbox.setPrefHeight(50);
		pidtextbox.setLayoutX(103);
		pidtextbox.setLayoutY(39);
		pidtextbox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
			if (newValue) {
		        System.out.println("Focus Gained");
		       pidtextbox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
			}
			
		    else {
		        System.out.println("Focus Lost");
		        pidtextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
		    }
		});
		pidtextbox.setOnKeyTyped(e -> {
			 if(!pidtextbox.getText().isEmpty()) {
				 pidboxinstruction.setVisible(false); 
			 }else {
				 pidboxinstruction.setVisible(true);
			 }
		 	});
		
		
		Button goButton = new Button();
		goButton.setStyle("-fx-background-radius: 10em; -fx-min-width: 60px; -fx-min-height: 60px; -fx-max-width: 60px; -fx-max-height: 60px; -fx-background-color: #8ee4af; -fx-background-insets: 10px; -fx-padding: 10px;");
		Image arrow = new Image("/resources/icons/Right-Arrow-Icon-PNG-300x300.png");
		ImageView arrowimag = new ImageView(arrow);
		arrowimag.setFitHeight(40);
		arrowimag.setFitWidth(40);
		arrowimag.setPreserveRatio(true);
		goButton.setGraphic(arrowimag);
	    goButton.setLayoutX(465);
		goButton.setLayoutY(32);
		goButton.setOnAction(e -> {
			String pid = pidtextbox.getText().trim();
			promptPopup.close();
			new UpdatePopUp(pid);
		});
		
		
		
		Pane root = new Pane();
		root.getChildren().addAll(closeButton, goButton, pidtextbox, pidboxinstruction);
		root.setId("ROOTNODE");
		
		Scene scene = new Scene(root, 569, 127);
		scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("/application/styles.css");
	    
		promptPopup.initStyle(StageStyle.TRANSPARENT);
		promptPopup.setScene(scene);
		promptPopup.show();
	}
}	




class UpdatePopUp {
	UpdatePopUp(String pid){
		Stage popstage = new Stage();
		
		Button closeButton = new Button();
        closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
        closeButton.setLayoutX(10);
		closeButton.setLayoutY(10);
		closeButton.setOnAction(e -> {
			popstage.close();
		});
		
		
		Label patientpid = new Label("Update for PID "+pid);
		patientpid.setStyle("-fx-text-fill: #edf5e1;");
		patientpid.setFont(new Font("Arial", 18));
		patientpid.setLayoutX(105);
		patientpid.setLayoutY(30);
		patientpid.setVisible(true);
		
		
		
		Button newPatientButton = new Button("update status");
        newPatientButton.setStyle("-fx-background-color: #7ADBA2; -fx-background-radius: 25px; -fx-text-fill: #ffffff; -fx-font-size: 16pt; -fx-font-family: \"raleway\";");
        newPatientButton.setPrefHeight(36);
        newPatientButton.setPrefWidth(224);
        newPatientButton.setLayoutX(95);
        newPatientButton.setLayoutY(99);
        newPatientButton.setOnAction(e -> {
        	
        	popstage.close();
        	new StatusUpdateScreen(Integer.parseInt(pid));
        	
        });
        
        Button viewPatientButton = new Button("update result");
        viewPatientButton.setStyle("-fx-background-color: #7ADBA2; -fx-background-radius: 25px; -fx-text-fill: #ffffff; -fx-font-size: 16pt; -fx-font-family: \"raleway\";");
        viewPatientButton.setPrefHeight(36);
        viewPatientButton.setPrefWidth(224);
        viewPatientButton.setLayoutX(95);
        viewPatientButton.setLayoutY(180);
        viewPatientButton.setOnAction(e -> {
        	popstage.close();
        	new ResultUpdateScreen(Integer.parseInt(pid));
        	
        });
		
		
		
		Pane root = new Pane();
		root.getChildren().addAll(closeButton, newPatientButton, viewPatientButton, patientpid);
		root.setId("ROOTNODE");
		
		Scene scene = new Scene(root, 413, 336);
		scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("/application/styles.css");
	    
		popstage.initStyle(StageStyle.TRANSPARENT);
		popstage.setScene(scene);
		popstage.show();
	}
}



class StatusUpdateScreen {
	StatusUpdateScreen(int pid){
		Stage updateStatusScreen = new Stage();
		
		Button closeButton = new Button();
        closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
        closeButton.setLayoutX(10);
        closeButton.setLayoutY(10);
		closeButton.setOnAction(e -> {
			MainScreen.root.setEffect(null);
			updateStatusScreen.close();
			
		});
		
		
		
		
		linkedList.node pointer = linkedList.patientListHead;
		String name = "";
		while(pointer != null) {
			if(pid == pointer.PID) {
				name = pointer.name;
			}
			pointer = pointer.link;
		}
		
		Label patientpid = new Label("PID: "+pid);
		patientpid.setStyle("-fx-text-fill: #edf5e1;");
		patientpid.setFont(new Font("Arial", 21));
		patientpid.setLayoutX(20);
		patientpid.setLayoutY(100);
		patientpid.setVisible(true);
		
		Label patientname = new Label("Patient name: "+name);
		patientname.setStyle("-fx-text-fill: #edf5e1;");
		patientname.setFont(new Font("Arial", 21));
		patientname.setLayoutX(20);
		patientname.setLayoutY(125);
		patientname.setVisible(true);
		
		Label instruction = new Label("Select the status");
		instruction.setStyle("-fx-text-fill: #edf5e1;");
		instruction.setFont(new Font("Arial", 28));
		instruction.setLayoutX(20);
		instruction.setLayoutY(200);
		instruction.setVisible(true);
		
		
		RadioButton expired = new RadioButton("Expired");
		expired.setLayoutX(30);
		expired.setLayoutY(250);
	
		RadioButton recovered = new RadioButton("Recovered");
		recovered.setLayoutX(30);
		recovered.setLayoutY(300);
		
		final ToggleGroup group = new ToggleGroup();
		expired.setToggleGroup(group);
		recovered.setToggleGroup(group);
		
		 Button updateButton = new Button("update");
	        updateButton.setStyle("-fx-background-color: #7ADBA2; -fx-background-radius: 25px; -fx-text-fill: #ffffff; -fx-font-size: 16pt; -fx-font-family: \"raleway\";");
	        updateButton.setPrefHeight(40);
	        updateButton.setPrefWidth(150);
	        updateButton.setLayoutX(110);
	        updateButton.setLayoutY(400);
	        updateButton.setOnAction(e -> {
	        	RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
		        String in_status = selectedRadioButton.getText().trim();
	        	linkedList.node pointer2 = linkedList.patientListHead;
	    		while(pointer2 != null) {
	    			if(pid == pointer2.PID) {
						pointer2.status = in_status;
						if(in_status.equals("Expired")){
							pointer2.expiryDateTime = java.time.LocalDateTime.now();
						}
						else{
							pointer2.recoveryDateTime = java.time.LocalDateTime.now();
						}
					}
	    			pointer2 = pointer2.link;
				}

				report re = new report();
				re.Summary();
				MainScreen.root.setEffect(null);
	        	updateStatusScreen.close();
	        	
	        });
		
		
	
		
		
		
		Pane root = new Pane();
		root.getChildren().addAll(closeButton, patientpid, patientname, instruction, expired, recovered, updateButton);
		root.setId("ROOTNODE");
		
		Scene scene = new Scene(root, 368, 524);
		scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("/application/RADIO.css");
	    
		updateStatusScreen.initStyle(StageStyle.TRANSPARENT);
		updateStatusScreen.setScene(scene);
		updateStatusScreen.show();
	}
	
}


	


class ResultUpdateScreen {
	
	ResultUpdateScreen(int pid){
		Stage updateResultScreen = new Stage();
		
		Button closeButton = new Button();
        closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
        closeButton.setLayoutX(10);
        closeButton.setLayoutY(10);
		closeButton.setOnAction(e -> {
			MainScreen.root.setEffect(null);
			updateResultScreen.close();
			
		});
		
		
		
		
		linkedList.node pointer = linkedList.patientListHead;
		String name = "";
		while(pointer != null) {
			if(pid == pointer.PID) {
				name = pointer.name;
			}
			pointer = pointer.link;
		}
		
		Label patientpid = new Label("PID: "+pid);
		patientpid.setStyle("-fx-text-fill: #edf5e1;");
		patientpid.setFont(new Font("Arial", 21));
		patientpid.setLayoutX(20);
		patientpid.setLayoutY(100);
		patientpid.setVisible(true);
		
		Label patientname = new Label("Patient name: "+name);
		patientname.setStyle("-fx-text-fill: #edf5e1;");
		patientname.setFont(new Font("Arial", 21));
		patientname.setLayoutX(20);
		patientname.setLayoutY(125);
		patientname.setVisible(true);
		
		Label instruction = new Label("Select the result");
		instruction.setStyle("-fx-text-fill: #edf5e1;");
		instruction.setFont(new Font("Arial", 28));
		instruction.setLayoutX(20);
		instruction.setLayoutY(200);
		instruction.setVisible(true);
		
		
		RadioButton expired = new RadioButton("Positive");
		expired.setLayoutX(30);
		expired.setLayoutY(250);
	
		RadioButton recovered = new RadioButton("Negative");
		recovered.setLayoutX(30);
		recovered.setLayoutY(300);
		
		final ToggleGroup group = new ToggleGroup();
		expired.setToggleGroup(group);
		recovered.setToggleGroup(group);
		
		 Button updateButton = new Button("update");
	        updateButton.setStyle("-fx-background-color: #7ADBA2; -fx-background-radius: 25px; -fx-text-fill: #ffffff; -fx-font-size: 16pt; -fx-font-family: \"raleway\";");
	        updateButton.setPrefHeight(40);
	        updateButton.setPrefWidth(150);
	        updateButton.setLayoutX(110);
	        updateButton.setLayoutY(400);
	        updateButton.setOnAction(e -> {
	        	RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
		        String result = selectedRadioButton.getText().trim();
	        	linkedList.node pointer2 = linkedList.patientListHead;
	    		while(pointer2 != null) {
	    			if(pid == pointer2.PID) {
	    				if(result.equals("Positive")) {
	    		        	pointer2.result = true;
	    		        	pointer2.status = "Active";
	    		        }
	    		        else {
	    		        	pointer2.result = false;
						}
						pointer2.resultDateTime = java.time.LocalDateTime.now();
	    		}
	    			pointer2 = pointer2.link;
			}
				report re = new report();
				re.Summary();
				MainScreen.root.setEffect(null);
	        	updateResultScreen.close();
	        	
	        });
		
		
		
		
		
		
		Pane root = new Pane();
		root.getChildren().addAll(closeButton, patientpid, patientname, instruction, expired, recovered, updateButton);
		root.setId("ROOTNODE");
		
		Scene scene = new Scene(root, 368, 524);
		scene.setFill(Color.TRANSPARENT);
		scene.getStylesheets().add("/application/RADIO.css");
	    
		updateResultScreen.initStyle(StageStyle.TRANSPARENT);
		updateResultScreen.setScene(scene);
		updateResultScreen.show();
	}
	
}


